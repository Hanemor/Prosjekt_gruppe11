package com.utover.alleutovere;

//import com.utover.alleutovere;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "alleutovereServlet", urlPatterns = {"/alleutovereServlet"})
public class alleutovereServlet extends HttpServlet {
    private alleUtovere alleutovere;

    public void init(){
        alleutovere = new alleUtovere();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String action = request.getServletPath();

        try {
            switch (action) {
                case "/alleutovereServlet":
                    Listalleutovere(request, response);
                    break;
            }
        }catch (SQLException e){
            throw new ServletException();
        }

    }

   private void Listalleutovere(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
           List<utover> listUtover = alleutovere.listOppAlleUtovere();
           request.setAttribute("listUtovere", listUtover);
           RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
           dispatcher.forward(request, response);
   }


}
