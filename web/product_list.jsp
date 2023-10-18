<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.net.URLDecoder" %>


<html>
    <head>
        <title>Home Page</title>
    </head>
    <body>
        <jsp:include page="common/header.jsp" />

        <div class="container">
            <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                    <button class="btn btn-outline-success me-2" onclick="openFilterModal()" type="button">Filter</button>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>

        <div class="container">

            <div class="row row-cols-1 row-cols-md-4 g-4">

                <c:forEach items="${propertyListings}" var="property">
                    <c:set var="defaultImagePath" value="https://peoplevine.blob.core.windows.net/media/72/e86f3854-ebcf-4025-ae66-220b51f77ec2/image_not_available.png" />
                    <c:set var="firstImagePath" value="${not empty property.imagePaths ? property.imagePaths[0] : defaultImagePath}" />

                    <c:choose>
                        <c:when test="${empty property.imagePaths || property.imagePaths == null}">
                            <c:set var="imagePaths" value="['${defaultImagePath}']" />
                        </c:when>
                        <c:otherwise>
                            <c:set var="imagePaths" value="${property.imagePaths}" />
                        </c:otherwise>
                    </c:choose>

                    <div class="col">
                        <div class="col">
                            <div class="card" onclick="openCardModal('${property.city}', '${property.imagePaths}', '${property.contactDetails}')">
                                <img src="${firstImagePath}" class="card-img-top" alt="..." height="200">
                                <div class="card-body">
                                    <h5 class="card-title max-lines-1">Build your dream home</h5>
                                    <p class="card-text max-lines-2">${property.contactDetails}</p>
                                </div>
                            </div>
                        </div>

                    </div>
                </c:forEach>
            </div>
        </div>
        <script>
            // Function to check if an image URL exists
            function checkImageURL(url, callback) {
                var img = new Image();
                img.onload = function () {
                    callback(true);
                };
                img.onerror = function () {
                    callback(false);
                };
                img.src = url;
            }

            // Check each image URL and update it if it's not valid
            var imageElements = document.querySelectorAll('.card-img-top');
            imageElements.forEach(function (imgElement, index) {
                checkImageURL(imgElement.src, function (exists) {
                    if (!exists) {
                        // If the image doesn't exist, set it to the default image
                        imgElement.src = '${defaultImagePath}';
                        // You can also update the imagePaths array if needed
                        imagePaths[index] = '${defaultImagePath}';
                    }
                });
            });
        </script>






        <jsp:include page="products/product_details_modal.jsp" />
        <jsp:include page="products/filter_modal.jsp" />
        <jsp:include page="common/footer.jsp" />
        <script>
            // JavaScript to open the modal and set content
            function openCardModal(title, images, details) {
    // Remove '[' and ']' characters from the images string
    images = images.replace(/\[|\]/g, '');

    // Now, images doesn't contain '[' and ']' characters
    var arr = images.split(',');

                console.log(arr);
                var modal = $('#productDetailsModal');


                // Set the modal title
                modal.find('.modal-title').text(title);

                // Create carousel indicators and images
                var carouselIndicators = modal.find('#carouselIndicators');
                var carouselImages = modal.find('#carouselImages');
                carouselIndicators.empty();
                carouselImages.empty();

                    for (var i = 0; i < arr.length; i++) {
                        var activeClass = i === 0 ? 'active' : '';
                        carouselIndicators.append('<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="' + i + '" class="' + activeClass + '" aria-label="Slide ' + (i + 1) + '"></button>');
                        carouselImages.append('<div class="carousel-item ' + activeClass + '"><img src="' + arr[i] + '" class="d-block w-100" alt="..." height="400"></div>');
                    }

                // Set the modal details
                modal.find('#modalDetails').text(details);

                // Show the modal
                modal.modal('show');
            
            }

            function openFilterModal() {
                var modal = $('#filterModal');
                // Show the modal
                modal.modal('show');
            }
        </script>



    </body>
</html>