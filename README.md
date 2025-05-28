# RideEase

A web application for booking rides. Users can create, view, edit, and delete bookings.

## Features

*   Book a new ride with details like name, date, phone number, vehicle type, and passenger count.
*   View all existing bookings.
*   Edit the details of an existing booking.
*   Delete a booking.

## Technologies Used

*   **Frontend:** HTML, CSS, JavaScript, JSP, Bootstrap
*   **Backend:** Java, Servlets
*   **Database:** MySQL
*   **IDE/Build:** Eclipse (uses standard Eclipse project structure and settings)
*   **Server:** Apache Tomcat (or any other Java Servlet container)

## Setup and Installation

1.  **Database Setup:**
    *   Ensure you have a MySQL server running.
    *   Create a new database named `rideease1`.
    *   Import the `rideease1_DB.sql` file (located in the project root) into your `rideease1` database. This will create the necessary tables and sample data.
    *   Open `src/main/java/com/rideease/dao/BookingDAO.java`. The default database password in the provided code is `"Chamika1999"`. Update the database connection details (URL, username, and especially the password) if they differ for your environment:
        ```java
        private String jdbcURL = "jdbc:mysql://localhost:3306/rideease1";
        private String jdbcUsername = "root";
        private String jdbcPassword = "your_password"; // Update this line to your MySQL root password or a dedicated user's password
        ```

2.  **Project Setup (Eclipse IDE):**
    *   Clone this repository or download the source code.
    *   Open Eclipse IDE.
    *   Click on `File` > `Import...`.
    *   Choose `General` > `Existing Projects into Workspace` and click `Next`.
    *   Browse to the root directory of the cloned/downloaded project and click `Finish`.
    *   The project should now be imported into your workspace.

3.  **Deployment:**
    *   Ensure you have Apache Tomcat (or another compatible servlet container) installed and configured in Eclipse.
    *   Right-click on the project in the `Project Explorer` (e.g., `RideEase`).
    *   Select `Run As` > `Run on Server`.
    *   Choose your configured server and click `Finish`.
    *   The application should be deployed and typically opened in a web browser.

## Usage

1.  Once the application is deployed, it can usually be accessed at `http://localhost:8080/{YourProjectName}/` (e.g., `http://localhost:8080/RideEase/` if your project is named `RideEase` in Eclipse). The exact URL might vary based on your server configuration and the project's context path.
2.  **Booking a Ride:**
    *   The homepage (`index.jsp` or the root URL) displays a form to book a new ride.
    *   Fill in your name, desired date, phone number, preferred vehicle type, and the number of passengers.
    *   Click "Submit".
3.  **Viewing Bookings:**
    *   On the homepage, click the "View Details" button.
    *   This will take you to a page (`viewdetails.jsp`) displaying all current bookings in a table.
4.  **Editing a Booking:**
    *   In the "View Details" page, each booking will have an "Edit" link.
    *   Clicking "Edit" will take you to a form (`edit-booking.jsp`) pre-filled with the booking's current details.
    *   Modify the necessary information and click "Submit" (or "Update").
5.  **Deleting a Booking:**
    *   In the "View Details" page, each booking will have a "Delete" link.
    *   Clicking "Delete" will remove the booking from the system.
