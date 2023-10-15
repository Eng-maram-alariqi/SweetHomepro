<%-- 
    Document   : register
    Author     : hp
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Property Images</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: url('image/hero-image.jpg') no-repeat center center fixed;
            background-size: cover;
        }

        body::before {
            content: '';
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(5, 0, 0, 0.9); /* Adjust the opacity (last value) as needed */
        }

        .header {
            background-color: transparent; /* Header background should be transparent */
            color: #ddd;
            text-align: center;
            padding: 20px;
        }

        .image-slider-container {
            width: 80%; /* Adjust the width as needed */
            max-width: 800px;
            margin: 8% auto;
            position: relative;
            background-color: rgba(0, 0, 0, 0.5); /* Adjust the opacity (last value) as needed */
            border: 1px solid #ddd;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .image-slider {
            display: flex;
            overflow: hidden;
        }

        .image-slide {
            flex: 0 0 auto;
            width: 100%; /* Full-width images */
            height: 300px; /* Adjust the height as needed */
            text-align: center;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .image-slide img {
            max-width: 100%;
            max-height: 100%;
            object-fit: contain;
            cursor: pointer; /* Add cursor pointer for images */
        }

        .prev, .next {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            font-size: 24px;
            background-color: #333;
            color: #fff;
            padding: 10px 15px;
            border-radius: 50%;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .prev:hover, .next:hover {
            background-color: #555;
        }

        .prev {
            left: 10px;
        }

        .next {
            right: 10px;
        }

        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            padding-top: 20px;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.9);
        }

        .modal-content {
            display: block;
            margin: 0 auto;
            max-width: 80%;
            max-height: 80%;
        }

        .close {
            position: absolute;
            top: 10px;
            right: 20px;
            color: #fff;
            font-size: 30px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Property Images</h1>
    </div>

    <div class="image-slider-container">
        <div class="image-slider">
            <c:forEach items="${fn:split(param.imagePaths, ',')}" var="imagePath">
                <c:set var="cleanedImagePath" value="${fn:replace(imagePath, '[', '')}" />
                <c:set var="cleanedImagePath" value="${fn:replace(cleanedImagePath, ']', '')}" />
                <div class="image-slide" onclick="openModal('${request.contextPath}${cleanedImagePath}')">
                    <img src="${request.contextPath}${cleanedImagePath}" alt="Property Image">
                </div>
            </c:forEach>
        </div>
        <div class="prev" onclick="plusSlides(-1)">&#10094;</div>
        <div class="next" onclick="plusSlides(1)">&#10095;</div>
    </div>

    <div id="imageModal" class="modal">
        <span class="close" onclick="closeModal()">&times;</span>
        <img id="modalImage" class="modal-content" alt="Property Image">
    </div>

    
    <footer>
    <p>&copy; 2023 SweetHome Real Estate</p>
</footer>
    
    <script>
        let slideIndex = 1;

        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        function showSlides(n) {
            let slides = document.getElementsByClassName("image-slide");
            if (n > slides.length) {
                slideIndex = 1;
            }
            if (n < 1) {
                slideIndex = slides.length;
            }
            for (let i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            slides[slideIndex - 1].style.display = "block";
        }

        function openModal(imageUrl) {
            const modal = document.getElementById("imageModal");
            const modalImage = document.getElementById("modalImage");

            modal.style.display = "block";
            modalImage.src = imageUrl;
        }

        function closeModal() {
            const modal = document.getElementById("imageModal");
            modal.style.display = "none";
        }

        showSlides(slideIndex);
    </script>
</body>
</html>
