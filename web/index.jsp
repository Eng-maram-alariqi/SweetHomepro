<%-- 
    Document   : index
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Real Estate Home</title>
     <link rel="stylesheet"  type="text/css" href="css/index.css">
</head>
<body>
        <div class="background"></div> <!-- Add a new div for the background -->

  <nav>
      
  <div class="content">
      <h2>SweetHome</h2>
      <h2>SweetHome</h2> 
  </div>
 <div class="contact_us">
 <a href="contact_us.jsp">Contact us</a>
 
  <a href="about-us.jsp">About us</a>

  </div>
      
 
      
    <div class="spacer"></div>
    <a href="register.jsp">Register</a>
    <a href="login.jsp">Login</a>
    
</nav>
    

    <div class="container">
        <!-- Display featured properties or other information -->
       
      <form action="SearchServlet" method="GET"  class="search-form">
<!--        <label for="location">Location:</label>-->
 <input type="text" id="location" name="location" placeholder="Location , price">
    <button type="submit">Search</button></span
    </form>
    </div>
    
    
    
    
    
    
    
    
    
     
     
   <footer>
    <p>&copy; 2023 SweetHome Real Estate</p>
</footer>
  
     
</body>
</html>

