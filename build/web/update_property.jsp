<!DOCTYPE html>
<html>
<head>
    <title>Update Property Listing</title>
        <link rel="stylesheet" type="text/css" href="css/property.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

</head>
<body>
   <form id="updateForm" action="PropertyListingsServlet" method="post" enctype="multipart/form-data">
    <h1>Update Property Listing</h1>


        <input type="hidden" name="action" value="update">
           <!--to fetch the property_Id from the URL parameter and populate the hidden input field with it-->

         <input type="hidden" name="propertyId" value="<%= request.getParameter("propertyId") %>"> 
        
        <!-- Display existing property details -->
        <label for="city">City:</label>
        <input type="text" name="city" value="<%= request.getParameter("city") %>" required><br>
        
        <label for="location">Location:</label>
        <input type="text" name="location" value="<%= request.getParameter("location") %>" required><br>
        
        <label for="price">Price:</label>
        <input type="text" name="price" value="<%= request.getParameter("price") %>" required><br>
        
        <label for="bedrooms">Bedrooms:</label>
        <input type="number" name="bedrooms" value="<%= request.getParameter("bedrooms") %>" required><br>
        
        <label for="bathrooms">Bathrooms:</label>
        <input type="number" name="bathrooms" value="<%= request.getParameter("bathrooms") %>" required><br>
        
        <label for="propertyType">Property Type:</label>
        <input type="text" name="propertyType" value="<%= request.getParameter("propertyType") %>" required><br>
        
        <label for="extraFacilities">Extra Facilities:</label>
        <input type="text" name="extraFacilities" value="<%= request.getParameter("extraFacilities") %>" required><br>
        
        <label for="transportModes">Transport Modes:</label>
        <select name="transportModes" required>
            <option value="Residential Land" ${property.transportModes == 'Residential Land' ? 'selected' : ''}>Residential Land</option>
            <option value="Commercial" ${property.transportModes == 'Commercial' ? 'selected' : ''}>Commercial</option>
            <option value="Condominium" ${property.transportModes == 'Condominium' ? 'selected' : ''}>Condominium</option>
            <option value="Townhouse" ${property.transportModes == 'Townhouse' ? 'selected' : ''}>Townhouse</option>
            <option value="Multi-unit dwelling" ${property.transportModes == 'Multi-unit dwelling' ? 'selected' : ''}>Multi-unit dwelling</option>
        </select><br>
        
        <label for="furniture">Furniture:</label>
        <input type="text" name="furniture" value="<%= request.getParameter("furniture") %>" required><br>
        
        <label for="image">Image:</label>
        <input type="file" multiple name="image" value="<%= request.getParameter("image") %>"><br>
        
        <label for="paymentMode">Payment Mode:</label>
        <input type="text" name="paymentMode" value="<%= request.getParameter("paymentMode") %>" required><br>
        
        <label for="contactDetails">Contact Details:</label>
        <input type="text" name="contactDetails" value="<%= request.getParameter("contactDetails") %>" required><br>
        
        
              <!-- Debugging statement to print propertyId -->

<button  onclick="confirmUpdate()" class="btn btn-success">Update</button>


        
    </form>
        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
    <script>
        function confirmUpdate() {
            Swal.fire({
                title: 'Confirm Update',
                text: 'Are you sure you want to update this property?',
                icon: 'question',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, update it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    // Proceed with the update by submitting the form
                    document.getElementById('updateForm').submit();
                }
            });
        }
    </script>
</body>
</html>
