package com.testresultater.alletestresultater;

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
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "alleTestresultaterServlet", urlPatterns = {"/parameter"})
public class alleTestresultaterServlet extends HttpServlet {






    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<testresultat> testresparam = new ArrayList<>();
        testresparam.add(new testresultat(Integer.parseInt(request.getParameter("år")), Integer.parseInt(request.getParameter("uke")), request.getParameter("klasse")));


        List<testresultat> listTestresultat = null;
        try {

            alleTestresultater alletestresultater = new alleTestresultater();
            listTestresultat = alletestresultater.listOppAlleTestresultater(testresparam);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("listTestresultater", listTestresultat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultTestresultater.jsp");
        dispatcher.forward(request, response);






        /*String action = request.getServletPath();

        try {
            switch (action) {
                case "/alleTestresultaterServlet":
                    Listalletestresultater(request, response);
                    break;
                case "/test1":
                    test1(request, response);
                    break;
                case "/herlig":
                    herligmetode(request, response);
                    break;
                case "/fantastisk":
                    fantastiskmetode(request, response);
                    break;

                default:
                    Listalletestresultater(request, response);
            }
        }catch (SQLException e){
            throw new ServletException();
        }

        /*try {
            Listalletestresultater(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


    }
    /*private void Listalletestresultater(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<testresultat> listTestresultat = alletestresultater.listOppAlleTestresultater();
        request.setAttribute("listTestresultater", listTestresultat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultTestresultater.jsp");
        dispatcher.forward(request, response);
    }*/

    public void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("Test av case test1");
    }
    public void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("Test av case test2 DET FUNKET <3");
    }
    public void herligmetode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out1 = response.getWriter();
        out1.println("Denne funket også");
    }

    public void fantastiskmetode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out2 = response.getWriter();
        out2.println("Fantastisk");
    }
}

