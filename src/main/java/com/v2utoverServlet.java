package com;

import com.utover.alleutovere.alleUtovere;
import com.utover.alleutovere.Utover;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "v2utoverServlet", urlPatterns = {"/v2utoverServlet", "/alleutovere", "/test11" })
public class v2utoverServlet extends HttpServlet {
    private alleUtovere alleutovere;

    public void init(){
        alleutovere = new alleUtovere();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getServletPath();

        try {
            switch (action) {
                case "/alleutovere":
                    Listalleutovere(request, response);
                    break;
                case "/test11":
                    tests(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException();
        }
    }



        private void Listalleutovere(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
            List<Utover> listUtover = alleutovere.listOppAlleUtovere();
            request.setAttribute("listUtovere", listUtover);
            RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
            dispatcher.forward(request, response);

    }

    public void tests(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("Switch case fungerer:)");
    }

}
