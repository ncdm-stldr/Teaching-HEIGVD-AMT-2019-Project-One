/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.presentation;

import ch.heigvd.amt.affinitiesnetwork.model.CenterOfInterest;
import ch.heigvd.amt.affinitiesnetwork.model.User;
import ch.heigvd.amt.affinitiesnetwork.services.UsersServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class MeServlet extends HttpServlet {
    
    @EJB
    private UsersServiceLocal us;

    
    Long userId(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null) return null;
        return (Long) session.getAttribute("user_id");
        
    }

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
        Long id = userId(request);
        if(id == null) {
            HttpSession session = request.getSession();
            session.setAttribute("HTTP_REFERER", request.getRequestURL());
            response.sendRedirect("./sign_in_up");
            return;
        } else {
            User u = us.getUser(id);
            List<CenterOfInterest> centerOfInterests = us.getUserCenterOfInterests(u.getId());
            request.setAttribute("user", u);
            request.setAttribute("centerOfInterests", centerOfInterests);
            request.getRequestDispatcher("WEB-INF/pages/me.jsp")
                    .forward(request, response);
            return;
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
        Long id = userId(request);
        if(id == null) {
            HttpSession session = request.getSession();
            session.setAttribute("HTTP_REFERER", request.getRequestURL());
            response.sendRedirect("./sign_in_up");
            return;
        } else {
            //TODO add an affinity between user and center of interest
            User u = us.getUser(id);
            List<CenterOfInterest> centerOfInterests = us.getUserCenterOfInterests(u.getId());
            request.setAttribute("user", u);
            request.setAttribute("centerOfInterests", centerOfInterests);
            request.getRequestDispatcher("WEB-INF/pages/me.jsp")
                    .forward(request, response);
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
