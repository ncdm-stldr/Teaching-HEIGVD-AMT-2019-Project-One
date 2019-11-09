/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.presentation;

import ch.heigvd.amt.affinitiesnetwork.model.User;
import ch.heigvd.amt.affinitiesnetwork.services.UsersService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.rmi.runtime.Log;

/**
 *
 * @author NS
 */
public class UserServlet extends HttpServlet {
    
    @EJB
    private UsersService us;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        if(idString == null) {response.sendError(404); return;}
        try{
            Long id = Long.parseLong(idString);
            User u = us.getUser(id);
            if(u == null) {response.sendError(404); return;}
            request.setAttribute("user", u);
            request.getRequestDispatcher("/WEB-INF/pages/user_profile.jsp").
                    forward(request, response);
        } catch(NumberFormatException e){
            response.sendError(404);
        }
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
