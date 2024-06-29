package com.rideease.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.rideease.model.BookingBean;

public class BookingDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/rideease1";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Chamika1999";

    private static final String INSERT_BOOKING_SQL = "INSERT INTO bookings" +
        " (name, date, phone_number, vehicle_type, passenger_count) VALUES " +
        " (?, ?, ?, ?, ?);";

    private static final String SELECT_ALL_BOOKINGS = "SELECT * FROM bookings";
    private static final String SELECT_BOOKING_BY_ID = "SELECT * FROM bookings WHERE id = ?";
    private static final String UPDATE_BOOKING_SQL = "UPDATE bookings SET name = ?, date = ?, phone_number = ?, vehicle_type = ?, passenger_count = ? WHERE id = ?";
    private static final String DELETE_BOOKING_SQL = "DELETE FROM bookings WHERE id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertBooking(BookingBean booking) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING_SQL)) {
            preparedStatement.setString(1, booking.getName());
            preparedStatement.setDate(2, booking.getDate());
            preparedStatement.setString(3, booking.getPhoneNumber());
            preparedStatement.setString(4, booking.getVehicleType());
            preparedStatement.setInt(5, booking.getPassengerCount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List<BookingBean> selectAllBookings() {
        List<BookingBean> bookings = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKINGS);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date date = rs.getDate("date");
                String phoneNumber = rs.getString("phone_number");
                String vehicleType = rs.getString("vehicle_type");
                int passengerCount = rs.getInt("passenger_count");
                bookings.add(new BookingBean(id, name, date, phoneNumber, vehicleType, passengerCount));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bookings;
    }

    public BookingBean selectBooking(int id) {
        BookingBean booking = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Date date = rs.getDate("date");
                String phoneNumber = rs.getString("phone_number");
                String vehicleType = rs.getString("vehicle_type");
                int passengerCount = rs.getInt("passenger_count");
                booking = new BookingBean(id, name, date, phoneNumber, vehicleType, passengerCount);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return booking;
    }

    public boolean updateBooking(BookingBean booking) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKING_SQL);) {
            statement.setString(1, booking.getName());
            statement.setDate(2, booking.getDate());
            statement.setString(3, booking.getPhoneNumber());
            statement.setString(4, booking.getVehicleType());
            statement.setInt(5, booking.getPassengerCount());
            statement.setInt(6, booking.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteBooking(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BOOKING_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}