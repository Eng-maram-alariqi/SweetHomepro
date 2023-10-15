<%-- 
    Document   : register
    Author     : hp
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Us</title>
    <link rel="stylesheet" type="text/css" href="css/contact_us.css">
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
   
    
    <form action="process_contact.jsp" method="post">
         <h1>Contact Us</h1>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        
        <div class="form-group">
            <label for="message">Message:</label>
            <textarea id="message" name="message" rows="4" required></textarea>
        </div>
        
        <button type="submit">Submit</button>
    </form>
    
    
    <footer>
    <p>&copy; 2023 SweetHome Real Estate</p>
</footer>
</body>
</html>
