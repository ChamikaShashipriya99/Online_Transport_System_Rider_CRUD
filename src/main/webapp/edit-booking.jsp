<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RideEase - Edit Booking</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    
    	body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        nav {
            background-color: #2563eb;
            padding: 1rem;
        }
        nav .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            max-width: 1200px;
            margin: 0 auto;
        }
        nav .logo {
            color: white;
            font-size: 1.5rem;
            font-weight: bold;
        }
        nav ul {
            list-style-type: none;
            display: flex;
            gap: 1rem;
        }
        nav a {
            color: white;
            text-decoration: none;
        }
        nav a:hover {
            text-decoration: underline;
        }
        .get-started {
            background-color: #22c55e;
            color: white;
            padding: 0.5rem 1rem;
            border-radius: 9999px;
            text-decoration: none;
            display: inline-flex;
            align-items: center;
        }
        .get-started:hover {
            background-color: #16a34a;
        }
        main {
            flex-grow: 1;
            max-width: 1200px;
            margin: 0 auto;
            padding: 2rem;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 1rem;
        }
        th, td {
            border: 1px solid #e5e7eb;
            padding: 0.5rem;
            text-align: left;
        }
        th {
            background-color: #f3f4f6;
        }
        .pay-now {
            background-color: #3b82f6;
            color: white;
            padding: 0.5rem 1rem;
            border: none;
            border-radius: 0.25rem;
            cursor: pointer;
        }
        .pay-now:hover {
            background-color: #2563eb;
        }
        footer {
            background-color: #1f2937;
            color: white;
            padding: 2rem;
        }
        .footer-content {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 2rem;
            max-width: 1200px;
            margin: 0 auto;
        }
        .footer-section h3 {
            font-size: 1.25rem;
            margin-bottom: 0.5rem;
        }
        .footer-section ul {
            list-style-type: none;
            padding: 0;
        }
        .footer-section a {
            color: white;
            text-decoration: none;
        }
        .footer-section a:hover {
            text-decoration: underline;
        }
        .social-icons {
            display: flex;
            gap: 1rem;
            margin-top: 0.5rem;
        }
        .social-icons a {
            color: white;
            text-decoration: none;
        }
        .copyright {
            text-align: center;
            margin-top: 2rem;
        }
        
        h1 {
            color: #2c3e50;
            font-weight: bold;
            margin-bottom: 2rem;
        }
        .vehicle-card {
            transition: transform 0.3s, box-shadow 0.3s;
            border: none;
            border-radius: 15px;
            overflow: hidden;
        }
        .vehicle-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.1);
        }
        .card-body {
            background-color: #ffffff;
        }
        .card-title {
            color: #3498db;
            font-weight: bold;
        }
        .card-text {
            color: #7f8c8d;
        }
        .btn-primary {
            background-color: #3498db;
            border-color: #3498db;
            transition: background-color 0.3s;
        }
        .btn-primary:hover {
            background-color: #2980b9;
            border-color: #2980b9;
        }
        .btn-success {
            background-color: #2ecc71;
            border-color: #2ecc71;
            transition: background-color 0.3s;
            padding: 12px 24px;
            font-size: 1.1rem;
        }
        .btn-success:hover {
            background-color: #27ae60;
            border-color: #27ae60;
        }
    </style>
</head>
<body>
    <nav>
        <div class="container">
            <span class="logo">RideEase</span>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Book a Ride</a></li>
                <li><a href="#">My Bookings</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="#" class="get-started">Get Started</a></li>
            </ul>
        </div>
    </nav>

    <main class="container mt-5">
	    <h1 class="text-center mb-4">Edit Booking</h1>
	    <form action="update" method="post" onsubmit="return validateForm()">
	        <input type="hidden" name="id" value="<c:out value='${booking.id}' />" />
	        
	        <div class="mb-3">
	            <label for="name" class="form-label">Name</label>
	            <input type="text" class="form-control" id="name" name="name" value="<c:out value='${booking.name}' />" required>
	        </div>
	        
	        <div class="mb-3">
	            <label for="date" class="form-label">Date</label>
	            <input type="date" class="form-control" id="date" name="date" value="<c:out value='${booking.date}' />" required>
	        </div>
	        
	        <div class="mb-3">
	            <label for="phoneNumber" class="form-label">Phone Number</label>
	            <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" value="<c:out value='${booking.phoneNumber}' />" pattern="^\d{10}$" required>
	            <small class="text-muted">Enter a 10-digit phone number.</small>
	        </div>
	        
	        <div class="mb-3">
	            <label for="vehicleType" class="form-label">Vehicle Type</label>
	            <select class="form-select" id="vehicleType" name="vehicleType" required>
	                <option value="Sedan" <c:if test="${booking.vehicleType == 'Sedan'}">selected</c:if>>Sedan</option>
	                <option value="SUV" <c:if test="${booking.vehicleType == 'SUV'}">selected</c:if>>SUV</option>
	                <option value="Van" <c:if test="${booking.vehicleType == 'Van'}">selected</c:if>>Van</option>
	            </select>
	        </div>
	        
	        <div class="mb-3">
	            <label for="passengerCount" class="form-label">Passenger Count</label>
	            <input type="number" class="form-control" id="passengerCount" name="passengerCount" value="<c:out value='${booking.passengerCount}' />" min="1" max="10" required>
	            <small class="text-muted">Enter a value between 1 and 10.</small>
	        </div>
	        
	        <div class="d-grid gap-2">
	            <button type="submit" class="btn btn-primary">Update Booking</button>
	            <a href="list" class="btn btn-secondary">Cancel</a>
	        </div>
	    </form>
	</main>

    <footer>
        <div class="footer-content">
            <div class="footer-section">
                <h3>RideEase</h3>
                <p>Your trusted partner for comfortable and reliable transportation.</p>
            </div>
            <div class="footer-section">
                <h3>Quick Links</h3>
                <ul>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Services</a></li>
                    <li><a href="#">Terms of Service</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                </ul>
            </div>
            <div class="footer-section">
                <h3>Connect With Us</h3>
                <div class="social-icons">
                    <a href="#">Facebook</a>
                    <a href="#">Twitter</a>
                    <a href="#">Instagram</a>
                </div>
                <p>Email: info@rideease.com</p>
                <p>Phone: (555) 123-4567</p>
            </div>
        </div>
        <div class="copyright">
            <p>&copy; 2024 RideEase. All rights reserved.</p>
        </div>
    </footer>
    
    <script>
	    function validateForm() {
	        const phoneNumber = document.getElementById('phoneNumber').value;
	        const passengerCount = document.getElementById('passengerCount').value;
	
	        // Check for 10-digit phone number
	        const phonePattern = /^\d{10}$/;
	        if (!phonePattern.test(phoneNumber)) {
	            alert('Phone number must be a 10-digit number.');
	            return false;
	        }
	
	        // Check for passenger count between 1 and 10
	        if (passengerCount < 1 || passengerCount > 10) {
	            alert('Passenger count must be between 1 and 10.');
	            return false;
	        }
	
	        return true;
	    }
	</script>
    

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>