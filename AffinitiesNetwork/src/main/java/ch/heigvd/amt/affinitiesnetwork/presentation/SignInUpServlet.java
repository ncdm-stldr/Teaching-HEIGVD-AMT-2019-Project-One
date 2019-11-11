/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.presentation;

import ch.heigvd.amt.affinitiesnetwork.services.UsersServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NS
 */
public class SignInUpServlet extends HttpServlet {

    
    @EJB
    private UsersServiceLocal us;

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
        request.getRequestDispatcher("/WEB-INF/pages/sign_up_in.jsp")
                .forward(request, response);
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
        //TODO check if username and password are correct
        //TODO if they are not redirect to login again and with a warning message
        HttpSession session = request.getSession(false);
        if(session == null) {session = request.getSession();}
        //if bad login
        String username = request.getParameter("username");
        String psw = request.getParameter("psw");
        Long id = null;
        if(username == null || psw == null || !us.checkCredentials(id, username, psw)){
            request.setAttribute("badLogin", true);
            request.getRequestDispatcher("/WEB-INF/pages/sign_up_in.jsp")
                    .forward(request, response);
            return;
        } else {
            //we are authenticated!
            session.setAttribute("authenticated", "true");
            session.setAttribute("user_id", id);
        }
        if(session.getAttribute("HTTP_REFERER") != null){
            response.sendRedirect(session.getAttribute("HTTP_REFERER").toString());
            session.removeAttribute("HTTP_REFERER");
            return;
        } else {
            response.sendRedirect("./index");
            return;
        }
        
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
