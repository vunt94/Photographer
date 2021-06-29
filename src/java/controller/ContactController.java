/*
 * Copyright(C) 2021,  vunthe141507.
 * J3.L.P0017
 * Java Web
 *
 * Record of change:
 * DATE                Version           AUTHOR            DESCRIPTION
 * 16/6/2021             1.0              VuNT           Fix variable name
 * 21/6/2021             2.0              VuNT      Fix package dao and dao.impl
 * 23/6/2021             3.0              VuNT           Answer the question
 */
package controller;

import dao.ContactDAO;
import dao.GalleryDAO;
import dao.impl.ContactDAOImpl;
import dao.impl.GalleryDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains a method to load top 3 Galleries and contact to Contact.jsp
 * When system is error or an unannounced error, the class will redirect to an  
 * error page.
 * <p>
 * Bugs: None
 *
 * @author Nguyen Tuan Vu
 */
public class ContactController extends HttpServlet {

    /**
     * Load top 3 Galleries and Contact to Contact.jsp through class 
     * <code>ContactDAOImpl</code>. When system is error or unknown error, Error 
     * page will be delivered with error message how on that pages
     *
     * @param request stores attributes: top3, contact, active, error to send to JSP.
     * It is a <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. It is
     * a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            ContactDAO contactDAO = new ContactDAOImpl();
            GalleryDAO galleryDAO = new GalleryDAOImpl();
            // set top 3 gallery
            request.setAttribute("top3", galleryDAO.getTopGallery(3));
            // set contact infor
            request.setAttribute("contact", contactDAO.getContact());
            request.setAttribute("active", 4);
            request.getRequestDispatcher("Contact.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            // when system is errors or unknown errors, Error page will be display     
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request provides important information about a client request to a servlet. 
     * It is a <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. 
     * It is a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request provides important information about a client request to a servlet. 
     * It is a <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response response respond to an HTTP Request to the browser. 
     * It is a <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
