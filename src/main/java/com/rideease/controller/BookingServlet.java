package com.rideease.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rideease.dao.BookingDAO;
import com.rideease.model.BookingBean;

@WebServlet("/")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookingDAO bookingDAO;

    public void init() {
        bookingDAO = new BookingDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertBooking(request, response);
                    break;
                case "/delete":
                    deleteBooking(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateBooking(request, response);
                    break;
                default:
                    listBookings(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBookings(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<BookingBean> listBookings = bookingDAO.selectAllBookings();
        request.setAttribute("listBookings", listBookings);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewdetails.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BookingBean existingBooking = bookingDAO.selectBooking(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-booking.jsp");
        request.setAttribute("booking", existingBooking);
        dispatcher.forward(request, response);
    }

    private void insertBooking(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        Date date = Date.valueOf(request.getParameter("date"));
        String phoneNumber = request.getParameter("phoneNumber");
        String vehicleType = request.getParameter("vehicleType");
        int passengerCount = Integer.parseInt(request.getParameter("passengerCount"));
        BookingBean newBooking = new BookingBean(0, name, date, phoneNumber, vehicleType, passengerCount);
        bookingDAO.insertBooking(newBooking);
        response.sendRedirect("list");
    }

    private void updateBooking(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date date = Date.valueOf(request.getParameter("date"));
        String phoneNumber = request.getParameter("phoneNumber");
        String vehicleType = request.getParameter("vehicleType");
        int passengerCount = Integer.parseInt(request.getParameter("passengerCount"));

        BookingBean booking = new BookingBean(id, name, date, phoneNumber, vehicleType, passengerCount);
        bookingDAO.updateBooking(booking);
        response.sendRedirect("list");
    }

    private void deleteBooking(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookingDAO.deleteBooking(id);
        response.sendRedirect("list");
    }
}