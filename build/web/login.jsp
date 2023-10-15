<%-- 
    Document   : login
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
     <link rel="stylesheet" type="text/css" href="css/login.css"  >
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
    
    
   <div class="login-container">
        <h3>Login</h3>
        <form action="LoginServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            
<!--         <label for="role">Role:</label>
        <select id="role" name="role" required>
            <option value="buyer">Buyer</option>
            <option value="seller">Seller</option>
        </select><br><br>-->
            <input type="submit" value="Login">
        </form>
    </div>
    
    <footer>
    <p>&copy; 2023 SweetHome Real Estate</p>
</footer>
    
    
</body>
</html>
