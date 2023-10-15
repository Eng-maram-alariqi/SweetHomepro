/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author hp
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 50 // 50 MB
)

@WebServlet("/productList") // Adjust the URL mapping to include the subfolder
public class ProductListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        // Default behavior (e.g., display a list of property listings)
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Call the method to retrieve property listings
        List<PropertyListing> propertyListings = new ArrayList<>();
        // Connect to the database and fetch data
        Connection conn = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Sweethome;encrypt=false;trustServerCertificate=false;";
            String username = "sa";
            String password = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM dbo.PropertyListings";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                PropertyListing property = new PropertyListing();

                property.setPropertyId(resultSet.getInt("PropertyID"));
                property.setCity(resultSet.getString("City"));
                property.setLocation(resultSet.getString("Location"));
                property.setPrice(resultSet.getDouble("Price"));

                property.setBedrooms(resultSet.getInt("Bedrooms"));
                property.setBathrooms(resultSet.getInt("Bathrooms"));
                property.setPropertyType(resultSet.getString("PropertyType"));
                property.setExtraFacilities(resultSet.getString("ExtraFacilities"));
                property.setTransportModes(resultSet.getString("TransportModes"));
                property.setFurniture(resultSet.getString("Furniture"));
                property.setPaymentMode(resultSet.getString("PaymentMode"));
                property.setContactDetails(resultSet.getString("ContactDetails"));

                String imagePathsString = resultSet.getString("ImagePaths");
                if (imagePathsString != null && !imagePathsString.isEmpty()) {
                    List<String> imagePathsList = Arrays.asList(imagePathsString.split(","));
                    property.setImagePaths(imagePathsList);
                }

                // Set the absolute image path
                propertyListings.add(property);
            }

            // Set the property listings as an attribute in the request
            request.setAttribute("propertyListings", propertyListings);

            // Forward the request to another resource (e.g., JSP)
            request.getRequestDispatcher("/productList.jsp").forward(request, response);

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Your displayPropertyListings method here
}
