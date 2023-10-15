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
@MultipartConfig

(
    fileSizeThreshold = 1024 * 1024 * 2,  // 2 MB
    maxFileSize = 1024 * 1024 * 10,      // 10 MB
    maxRequestSize = 1024 * 1024 * 50    // 50 MB
)


public class PropertyListingsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        


        String action = request.getParameter("action");
        
        if (action == null) {
            // Default behavior (e.g., display a list of property listings)
            displayPropertyListings(request, response);
        } else if (action.equals("insert")) {
            // Handle the insert operation
//            response.sendRedirect("propertyListing.jsp");
            handleInsert(request, response);
        } else if (action.equals("update")) {
//            handleUpdate(request, response);

//           response.sendRedirect("update_property.jsp");
            handleUpdate(request, response);
        } else if (action.equals("delete")) {
            // Handle the delete operation
            handleDelete(request, response);
        }


        
        
    }

    
    //start select operation////
    
    private void displayPropertyListings(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
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
          request.getRequestDispatcher("property_listing_result.jsp").forward(request, response);

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

    
    
    
    
  ///////end select operation////////

    
    
    
    
    /////start update operation//////////////
  private boolean handleUpdate(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {





    
    String city = request.getParameter("city");
    
        System.out.println("city: " + city); // Debug statement

    String location = request.getParameter("location");
        System.out.println("location: " + location); // Debug statement

   
    String priceParameter = request.getParameter("price");
     double price = 0.0;
        System.out.println("priceParameter: " + priceParameter); // Debug statement

    // Default value in case the parameter is missing or invalid
    if (priceParameter != null && !priceParameter.isEmpty()) {
        try {
            price = Double.parseDouble(priceParameter);
        } catch (NumberFormatException e) {
            // Handle the case where the "price" parameter is present but not a valid number
            // You can log an error, display an error message, or take appropriate action.
            // For simplicity, we'll just set it to 0.0 here.
            price = 0.0;
        }
    }
    
    String bedroomsParameter = request.getParameter("bedrooms");
    int bedrooms = 0; // Default value in case the parameter is missing or invalid
    System.out.println("bedroomsParameter: " + bedroomsParameter); // Debug statement
    if (bedroomsParameter != null && !bedroomsParameter.isEmpty()) {
        try {
            bedrooms = Integer.parseInt(bedroomsParameter);
        } catch (NumberFormatException e) {
            // Handle the case where the "bedrooms" parameter is present but not a valid integer
            // You can log an error, display an error message, or take appropriate action.
            // For simplicity, we'll just set it to 0 here.
            bedrooms = 0;
        }
    }
    
    String bathroomsParameter = request.getParameter("bathrooms");
    int bathrooms = 0; // Default value in case the parameter is missing or invalid
    System.out.println("bathroomsParameter: " + bathroomsParameter); // Debug statement
    if (bathroomsParameter != null && !bathroomsParameter.isEmpty()) {
        try {
            bathrooms = Integer.parseInt(bathroomsParameter);
        } catch (NumberFormatException e) {
            // Handle the case where the "bathrooms" parameter is present but not a valid integer
            // You can log an error, display an error message, or take appropriate action.
            // For simplicity, we'll just set it to 0 here.
            bathrooms = 0;
        }
    }
    
    String propertyType = request.getParameter("propertyType");
    
        System.out.println("propertyType: " + propertyType); // Debug statement

    
    String extraFacilities = request.getParameter("extraFacilities");
    
        System.out.println("extraFacilities: " + extraFacilities); // Debug statement

    String transportModes = request.getParameter("transportModes");
   System.out.println("transportModes: " + transportModes); // Debug statement

    
    String furniture = request.getParameter("furniture");
        System.out.println("furniture: " + furniture); // Debug statement

   
List<Part> imageParts = request.getParts()
        .stream()
        .filter(part -> part.getName().startsWith("image"))
        .collect(Collectors.toList());

String[] imagePaths = new String[imageParts.size()];
for (int i = 0; i < imageParts.size(); i++) {
            Part imagePart = imageParts.get(i);
            String imagePath = saveImage(imagePart);
            imagePaths[i] = imagePath;
        }
String concatenatedImagePaths = String.join(",",imagePaths);
    
   
    
    
    String paymentMode = request.getParameter("paymentMode");
    
        System.out.println("paymentMode: " + paymentMode); // Debug statement

    String contactDetails = request.getParameter("contactDetails");
        System.out.println("contactDetails: " + contactDetails); // Debug statement


    // Save the image to a directory and get its file path
//     String   imagePath = saveImage(imagePart ,request);
  


 String propertyIdParameter = request.getParameter("propertyId");
int propertyId = 0; // Default value in case the parameter is missing or invalid
    System.out.println("propertyIdParameter: " + propertyIdParameter); // Debug statement

if (propertyIdParameter != null && !propertyIdParameter.isEmpty()) {
    try {
        propertyId = Integer.parseInt(propertyIdParameter);
    } catch (NumberFormatException e) {
        // Handle the case where the "propertyId" parameter is present but not a valid integer
        // You can log an error, display an error message, or take appropriate action.
        // For simplicity, we'll just set it to 0 here.
        propertyId = 0;
    }
}
 
    // Update the property listing data in the database
    Connection con = null;
    PreparedStatement preparedStatement = null;
   boolean rowsAffected = false ;
    try {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Sweethome;encrypt=false;trustServerCertificate=false;";
        String username = "sa";
        String password = "123";

        // Establish a database connection
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, username, password);
con.setAutoCommit(false);
        // SQL query to update property listing data in the database
       String sql = "UPDATE dbo.PropertyListings SET City=?, Location=?, Price=?, Bedrooms=?, Bathrooms=?, " +
                "PropertyType=?, ExtraFacilities=?, TransportModes=?, Furniture=?, ImagePaths=?, PaymentMode=?, " +
                "ContactDetails=?  WHERE PropertyID=?";

            
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, city);
        preparedStatement.setString(2, location);
        preparedStatement.setDouble(3, price);
        preparedStatement.setInt(4, bedrooms);
        preparedStatement.setInt(5, bathrooms);
        preparedStatement.setString(6, propertyType);
        preparedStatement.setString(7, extraFacilities);
        preparedStatement.setString(8, transportModes);
        preparedStatement.setString(9, furniture);
        preparedStatement.setString(10, concatenatedImagePaths);
        preparedStatement.setString(11, paymentMode);
        preparedStatement.setString(12, contactDetails);
        preparedStatement.setInt(13, propertyId); // Set the property ID for the WHERE clause


   System.out.println(sql);
        // Execute the SQL query to update data
 
rowsAffected = preparedStatement.executeUpdate()>0;

 if (!con.getAutoCommit()) {
      con.commit();
   }



System.out.println("Rows affected: " + rowsAffected);
        // Redirect to a success page or display a success message
response.sendRedirect("PropertyListingsServlet");

        
    } catch (ClassNotFoundException e) {
// Handle database errors or validation errors
    // Redirect to an error page or display an error message
             
             
    } finally {
        
        try {
            
            
          
            if (preparedStatement != null) {
                preparedStatement.close();
            }
           
        } 
        
     
        catch (SQLException e) {
        }
    return  rowsAffected;
    }
}

  ///end update operation////////////
  
  ///start delete operation/////////
  
  private void handleDelete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
    int propertyId = Integer.parseInt(request.getParameter("propertyId")); // Assuming you have a parameter to identify the property to delete
    // Redirect to a success page or display an error message
String message = "Property listing deleted successfully.";

    // Delete the property listing data from the database
    Connection con = null;
    PreparedStatement preparedStatement = null;
    try {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Sweethome;encrypt=false;trustServerCertificate=false;";
        String username = "sa";
        String password = "123";

        // Establish a database connection
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, username, password);

        // SQL query to delete property listing data from the database
        String sql = "DELETE FROM dbo.PropertyListings WHERE PropertyID=?";
            
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, propertyId); // Set the property ID for the WHERE clause

        // Execute the SQL query to delete data
        preparedStatement.executeUpdate();
        
        
        
        System.out.println("propertyId: "+propertyId);
        
        
        // Redirect to a success page or display a success message
    response.sendRedirect("PropertyListingsServlet?message=" + URLEncoder.encode(message, "UTF-8"));    
    
    request.getSession().setAttribute("message", "Property listing deleted successfully.");



    
    } catch (ClassNotFoundException e) {
        // Handle database errors or validation errors
        // Redirect to an error page or display an error message

    } catch (SQLException e) {
    e.printStackTrace(); // Print the exception for debugging
    String errorMessage = "Error deleting property listing: " + e.getMessage();
    response.sendRedirect("PropertyListingsServlet?message=" + URLEncoder.encode(errorMessage, "UTF-8"));
}
    finally {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

  ///end delete operation///////////
    
 
    ////start Insert operation///////////////////////////////////////////

    private void handleInsert(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
        String propertyIdParameter = request.getParameter("propertyId");
int propertyId = 0; // Default value in case the parameter is missing or invalid
if (propertyIdParameter != null && !propertyIdParameter.isEmpty()) {
    try {
        propertyId = Integer.parseInt(propertyIdParameter);
    } catch (NumberFormatException e) {
        // Handle the case where the "propertyId" parameter is present but not a valid integer
        // You can log an error, display an error message, or take appropriate action.
        // For simplicity, we'll just set it to 0 here.
        propertyId = 0;
    }
}  
    String city = request.getParameter("city");
    String location = request.getParameter("location");
    double price = 0.0;
    String priceParameter = request.getParameter("price");
    
    // Default value in case the parameter is missing or invalid
    if (priceParameter != null && !priceParameter.isEmpty()) {
        try {
            price = Double.parseDouble(priceParameter);
        } catch (NumberFormatException e) {
            // Handle the case where the "price" parameter is present but not a valid number
            // You can log an error, display an error message, or take appropriate action.
            // For simplicity, we'll just set it to 0.0 here.
            price = 0.0;
        }
    }
    
    
       String bedroomsParameter = request.getParameter("bedrooms");
int bedrooms = 0; // Default value in case the parameter is missing or invalid

if (bedroomsParameter != null && !bedroomsParameter.isEmpty()) {
    try {
        bedrooms = Integer.parseInt(bedroomsParameter);
    } catch (NumberFormatException e) {
        // Handle the case where the "bedrooms" parameter is present but not a valid integer
        // You can log an error, display an error message, or take appropriate action.
    }
}



       String bathroomsParameter = request.getParameter("bathrooms");
int bathrooms = 0; // Default value in case the parameter is missing or invalid

if (bathroomsParameter != null && !bathroomsParameter.isEmpty()) {
    try {
        bathrooms = Integer.parseInt(bathroomsParameter);
    } catch (NumberFormatException e) {
        // Handle the case where the "bathrooms" parameter is present but not a valid integer
        // You can log an error, display an error message, or take appropriate action.
    }
}
    
    String propertyType = request.getParameter("propertyType");
    String extraFacilities = request.getParameter("extraFacilities");
    String transportModes = request.getParameter("transportModes");
    String furniture = request.getParameter("furniture");
    
    String paymentMode = request.getParameter("paymentMode");
    String contactDetails = request.getParameter("contactDetails");
    
    
    

List<Part> imageParts = request.getParts()
        .stream()
        .filter(part -> part.getName().startsWith("image"))
        .collect(Collectors.toList());

String[] imagePaths = new String[imageParts.size()];
for (int i = 0; i < imageParts.size(); i++) {
            Part imagePart = imageParts.get(i);
            String imagePath = saveImage(imagePart);
            imagePaths[i] = imagePath;
        }
String concatenatedImagePaths = String.join(",",imagePaths);

    // Save the image to a directory and get its file path
// String imagePath = saveImage(imagePart ,request);

    // Store the property listing data in the database
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Sweethome;encrypt=false;trustServerCertificate=false;";
        String username = "sa";
        String password = "123";

        // Establish a database connection
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, username, password);

        // SQL query to insert property listing data into the database
        String sql = "INSERT INTO dbo.PropertyListings (City, Location, Price, Bedrooms, Bathrooms, PropertyType, " +
                "ExtraFacilities, TransportModes, Furniture, ImagePaths, PaymentMode, ContactDetails) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
         preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, city);
            preparedStatement.setString(2, location);
            preparedStatement.setDouble(3, price);
            preparedStatement.setInt(4, bedrooms);
            preparedStatement.setInt(5, bathrooms);
            preparedStatement.setString(6, propertyType);
            preparedStatement.setString(7, extraFacilities);
            preparedStatement.setString(8, transportModes);
            preparedStatement.setString(9, furniture);
            preparedStatement.setString(10, concatenatedImagePaths);
            preparedStatement.setString(11, paymentMode);
            preparedStatement.setString(12, contactDetails);

        // Execute the SQL query to insert data
        preparedStatement.executeUpdate();
        
        
        
response.sendRedirect("PropertyListingsServlet");
//                response.sendRedirect("index.jsp");

        // Redirect to a success page or display a success message
    } catch (ClassNotFoundException e) {
        // Handle database errors or validation errors
        // Redirect to an error page or display an error message
        e.printStackTrace();
    }
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
        }
   
}
    
    
    //////end insert operation////////////////




    
//    // Method to save an image to a directory and return its file path
//private String saveImage(Part imagePart ,HttpServletRequest request) throws IOException {
//    String imagePath = null; // Declare imagePath variable outside the if block
//    
//    if (imagePart != null && imagePart.getSize() > 0) {
//        String uploadedFileName = imagePart.getSubmittedFileName();
//        
//        
//         String appPath = request.getServletContext().getRealPath("/").replace("\\", "/");
//         
//         
//           String imageDirectory =  "image/";
//           
//           File directory = new File(appPath, imageDirectory);
//if (!directory.exists()) {
//    directory.mkdirs(); // Create the directory if it doesn't exist
//}
////imagePath = directory + File.separator + uploadedFileName;
//            imagePath = appPath + imageDirectory + uploadedFileName;
////        imagePath = "C:/Users/lenovo/Documents/NetBeansProjects/SweetHomepro/web/image/" + uploadedFileName; // Adjust the path as needed
// System.out.println(imagePath);
//        try {
//            FileOutputStream fos = new FileOutputStream(imagePath);
//            InputStream is = imagePart.getInputStream();
//            
//            byte[] data = new byte[is.available()];
//            System.out.println("Available bytes in input stream: " + is.available());
//
//            is.read(data);
//            fos.write(data);
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    return imagePath; // Return imagePath outside of the if block
//}

//// Method to save an image to a directory and return its file path
//// Method to save an image to a directory and return its file path
// Method to save an image to a directory and return its file path
//private String saveImage(Part imagePart) throws IOException {
//    String imagePath = null; // Declare imagePath variable outside the if block
//    
//    if (imagePart != null && imagePart.getSize() > 0) {
//        String uploadedFileName = imagePart.getSubmittedFileName();
//        imagePath = "image/" + uploadedFileName; // Adjust the path as needed
//
//        try {
//            FileOutputStream fos = new FileOutputStream(imagePath);
//            InputStream is = imagePart.getInputStream();
//            
//            byte[] data = new byte[is.available()];
//            is.read(data);
//            fos.write(data);
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    return imagePath; // Return imagePath outside of the if block
//}



// Method to save an image to a directory and return its file path
  private String saveImage(Part imagePart) throws IOException {
        String imagePath = null;

        if (imagePart != null && imagePart.getSize() > 0) {
            String uploadedFileName = imagePart.getSubmittedFileName();
            imagePath = "image/" + uploadedFileName ; // Adjust the path as needed

            // Save the image to the directory
//            String appPath = getServletContext().getRealPath("/").replace("\\", "/");
            String imageDirectory =  "C:/Users/lenovo/Documents/NetBeansProjects/SweetHomepro/web/image/";
            File directory = new File(imageDirectory);
            if (!directory.exists()) {
                directory.mkdirs(); // Create the directory if it doesn't exist
            }
            String fullPath = imageDirectory + uploadedFileName;

            try (InputStream is = imagePart.getInputStream();
                 OutputStream os = new FileOutputStream(fullPath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
            }
        }

        return imagePath ;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PropertyListingsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PropertyListingsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
