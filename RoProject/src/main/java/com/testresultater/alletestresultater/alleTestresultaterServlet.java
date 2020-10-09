package com.testresultater.alletestresultater;

import com.utover.alleutovere.utover;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "alleTestresultaterServlet", urlPatterns = {"/alleTestresultaterServlet"})
public class alleTestresultaterServlet extends HttpServlet {
    private alleTestresultater alletestresultater;

    public void init() {alletestresultater = new alleTestresultater();}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* String action = request.getServletPath();

        try {
            switch (action) {
                case "/alleTestresultaterServlet":
                    Listalletestresultater(request, response);
                    break;
                default:
                    Listalletestresultater(request, response);
            }
        }catch (SQLException e){
            throw new ServletException();
        }*/
        try {
            Listalletestresultater(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    private void Listalletestresultater(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<testresultat> listTestresultat = alletestresultater.listOppAlleTestresultater();
        request.setAttribute("listTestresultater", listTestresultat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultTestresultater.jsp");
        dispatcher.forward(request, response);
    }
}
