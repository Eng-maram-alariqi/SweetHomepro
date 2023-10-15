<%-- 
    Document   : register
    Author     : hp
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Property Listing Form</title>
    <link rel="stylesheet" type="text/css" href="css/property.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

</head>
<body>
    
    <form action="PropertyListingsServlet" method="post" enctype="multipart/form-data">
        <h1>Property Listing</h1>
        
        
         <input type="hidden" name="action" value="insert"> <!-- Set the action to "insert" -->
<!--                <input type="hidden" name="propertyId" value="${property.propertyId}">-->

        <label>City:</label>
        <input type="text" name="city" required><br>

        <label>Location/Area in the City:</label>
        <input type="text" name="location" required><br>
        
        <label>Price:</label>
        <input type="text" name="price" required><br>
        
        <label>Number of Bedrooms:</label>
        <input type="number" name="bedrooms" required><br>
        
        <label>Number of Bathrooms:</label>
        <input type="number" name="bathrooms" required><br>
        
        <label>Type:</label>
        <select name="propertyType">
            <option value="Residential Land">Residential Land</option>
            <option value="Commercial">Commercial</option>
            <option value="Condominium">Condominium</option>
            <option value="Townhouse">Townhouse</option>
            <option value="Multi-unit dwelling">Multi-unit dwelling</option>
        </select><br>
        
        <label>Extra Facilities:</label>
        <input type="text" name="extraFacilities"><br>
        
        <label>Convenient Modes of Transport:</label>
        <input type="text" name="transportModes"><br>
        
        <label>With or Without Furniture/Interiors:</label>
        <input type="radio" name="furniture" value="With" checked> With
        <input type="radio" name="furniture" value="Without"> Without<br><br>
        
        <label>Upload an Image:</label>
        <input type="file" name="image" accept="image/*" multiple><br>
        
        <label>Mode of Payment:</label>
        <input type="text" name="paymentMode"><br>
        
        <label>Contact Details:</label>
        <input type="text" name="contactDetails" required><br>
        
        <input type="submit" value="Submit">
    </form>
    
<footer>
    <p>&copy; 2023 SweetHome Real Estate</p>
</footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>
