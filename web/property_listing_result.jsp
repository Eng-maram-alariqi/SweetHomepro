<%-- 
    Document: register
    Author: hp
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.net.URLDecoder" %>

<!DOCTYPE html>
<html>
<head>
    <title>Property Listings</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
    <link rel="stylesheet" type="text/css" href="css/property_listing_result.css">
    
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-4">
        
        <h1 class="text-center">Property Listings</h1>
        <form action="propertyListing.jsp" method="post" enctype="multipart/form-data">
       
            <button class="btn btn-info">Insert</button>
        </form>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>City</th>
                    <th>Location</th>
                    <th>Price</th>
                    <th>Bedrooms</th>
                    <th>Bathrooms</th>
                    <th>Property Type</th>
                    <th>Extra Facilities</th>
                    <th>Transport Modes</th>
                    <th>Furniture</th>
                    <th>Images</th>
                    <th>Payment Mode</th>
                    <th>Contact Details</th>
                    <th>Transaction Type</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${propertyListings}" var="property">
                    <tr>
                        <td>${property.propertyId}</td>
                        <td>${property.city}</td>
                        <td>${property.location}</td>
                        <td>${property.price}</td>
                        <td>${property.bedrooms}</td>
                        <td>${property.bathrooms}</td>
                        <td>${property.propertyType}</td>
                        <td>${property.extraFacilities}</td>
                        <td>${property.transportModes}</td>
                        <td>${property.furniture}</td>
                        <td>
                            <a href="images.jsp?imagePaths=${property.imagePaths}">
                                <button class="btn btn-primary">View images</button>
                            </a>
                        </td>
                        <td>${property.paymentMode}</td>
                        <td>${property.contactDetails}</td>
                        <td>
                            
                            
                            <!-- Update Button -->
                            <form action="update_property.jsp" method="get" enctype="multipart/form-data">
                                                            <div class="button-container" style="display: none; visibility: hidden;">

                                <input type="hidden"  name="propertyId" value="${property.propertyId}">
            <input type="hidden"  name="city" value="${property.city}">
            <input type="hidden" name="location" value="${property.location}">
              <input type="hidden" name="price" value="${property.price}"><br>
              <input type="hidden" name="bedrooms" value="${property.bedrooms}">
               <input type="hidden" name="bathrooms" value="${property.bathrooms}">
                       <input type="hidden" name="propertyType" value="${property.propertyType}">

               <input type="hidden" name="extraFacilities" value="${property.extraFacilities}">
               
       

<select name="transportModes" required>
    <option value="Residential Land" <%= "Residential Land".equals(request.getParameter("transportModes")) ? "selected" : "" %>>Residential Land</option>
    <option value="Commercial" <%= "Commercial".equals(request.getParameter("transportModes")) ? "selected" : "" %>>Commercial</option>
    <option value="Condominium" <%= "Condominium".equals(request.getParameter("transportModes")) ? "selected" : "" %>>Condominium</option>
    <option value="Townhouse" <%= "Townhouse".equals(request.getParameter("transportModes")) ? "selected" : "" %>>Townhouse</option>
    <option value="Multi-unit dwelling" <%= "Multi-unit dwelling".equals(request.getParameter("transportModes")) ? "selected" : "" %>>Multi-unit dwelling</option>
</select><br>

        
           <input type="hidden" name="furniture" value="${property.furniture}">
           
           <input type="hidden" name="image" value="${property.imagePaths}">
             
             <input type="hidden" name="paymentMode" value="${property.paymentMode}">
                          <input type="hidden" name="contactDetails" value="${property.contactDetails}">
      </div>
                                <!-- Add other hidden fields as needed -->
                                <button class="btn btn-success">Update</button>
                            </form>
                            <!-- Delete Button -->
                            <form id="deleteForm" action="PropertyListingsServlet" method="get" enctype="multipart/form-data" onsubmit="return confirmDelete()">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="propertyId" value="${property.propertyId}">
                                <button class="btn btn-danger">Delete</button>
                            </form>
                          
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:if test="${empty propertyListings}">
            <p>No property listings found.</p>
        </c:if>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <!-- Add Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>








<%
    String message = (String) request.getSession().getAttribute("message");
    if (message != null) {
%>
    <script>
        Swal.fire({
            title: 'Success',
            text: '<%= message %>',
            icon: 'success'
        });
    </script>
    <%-- Remove the success message from the session --%>
    <% request.getSession().removeAttribute("message"); %>
<%
    }
%>


<script>
    function confirmDelete() {
        Swal.fire({
            title: 'Are you sure?',
            text: 'Delete this property listing.',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                // Submit the "Delete" form
                document.getElementById('deleteForm').submit();
            }
        });

        // Prevent the form from submitting immediately
        return false;
    }
</script>


</body>
</html>
