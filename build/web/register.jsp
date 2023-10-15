<%-- 
    Document   : register
    Created on : Oct 1, 2023, 7:18:26 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>

</head>
<body>
    
    
 
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
  <div class="form-container"> <!-- Apply the form container style -->
      <h3 class="h2re">Registration</h3>
        <form action="RegistrationServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
    
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
    
            <label for="role">Role:</label>
            <select id="role" name="role" required>
                <option value="buyer">Buyer</option>
                <option value="seller">Seller</option>
            </select><br><br>
    
            <!-- Add more registration fields as needed -->
    
            <input type="submit" value="Register">
        </form>
    </div>

    
 <footer>
    <p>&copy; 2023 SweetHome Real Estate</p>
</footer>
</body>
</html>

