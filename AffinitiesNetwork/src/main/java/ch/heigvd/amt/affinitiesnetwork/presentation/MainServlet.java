/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.presentation;

import ch.heigvd.amt.affinitiesnetwork.model.CenterOfInterest;
import ch.heigvd.amt.affinitiesnetwork.services.CentersOfInterestService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NS
 */
public class MainServlet extends HttpServlet {
    //quickstart mocked database (will be removed later)
    static final Collection<CenterOfInterest> centersOfInterest = new ArrayList<CenterOfInterest>();
    static {
        centersOfInterest.add(new CenterOfInterest(1, "wejhvcdgwj", "jdch wsjdcvs jdxsvh"));
        centersOfInterest.add(new CenterOfInterest(2, "cdbhdj", "jidzcg jdxsvh"));
        centersOfInterest.add(new CenterOfInterest(3, "wefdgwj", "jdch wsjdcvs jdxsvh"));
        centersOfInterest.add(new CenterOfInterest(4, "wejfwj", "jdc37467293vs jdxsvh"));
    }
    
    @EJB
    private CentersOfInterestService cOIS;


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
        request.setAttribute("centersOfInterest", cOIS.getNRandomCentersOfInterest(10));
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp")
                .forward(request, response);
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
