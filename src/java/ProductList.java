import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product_list")
public class ProductList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<PropertyListing> propertyListings = fetchDataFromDatabase();
        request.setAttribute("propertyListings", propertyListings);
        request.getRequestDispatcher("product_list.jsp").forward(request, response);
    }

    private List<PropertyListing> fetchDataFromDatabase() {
        List<PropertyListing> propertyListings = new ArrayList<>();
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
                PropertyListing property = new PropertyListing(); // Create a new PropertyListing object for each row
                property.setPropertyId(resultSet.getInt("PropertyID"));
                property.setCity(resultSet.getString("City"));
                property.setContactDetails(resultSet.getString("ContactDetails"));
                property.setLocation(resultSet.getString("Location"));
                property.setPrice(resultSet.getDouble("Price"));
                // Set other properties as well...
                
                String imagePathsString = resultSet.getString("ImagePaths");
                if (imagePathsString != null && !imagePathsString.isEmpty()) {
                    List<String> imagePathsList = Arrays.asList(imagePathsString.split(","));
                    property.setImagePaths(imagePathsList);
                }
                propertyListings.add(property);
            }
            
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
        
        return propertyListings;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
