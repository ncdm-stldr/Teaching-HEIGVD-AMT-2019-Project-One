/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.affinitiesnetwork.presentation;

import ch.heigvd.amt.affinitiesnetwork.model.User;
import ch.heigvd.amt.affinitiesnetwork.services.UsersService;
import ch.heigvd.amt.affinitiesnetwork.services.UsersServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Simon
 */
public class TestServlet extends HttpServlet {

    @EJB
    private UsersServiceLocal usersService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("users", usersService.getAllUsers());
        request.getRequestDispatcher("/WEB-INF/pages/test.jsp")
            .forward(request, response);
    }
}
