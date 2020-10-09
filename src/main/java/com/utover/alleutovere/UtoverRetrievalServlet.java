package com.utover.alleutovere;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "UtoverRetrievalServlet", urlPatterns = "/HentUt")
public class UtoverRetrievalServlet extends HttpServlet {
    private Connection connection;
    private alleUtovere alleutv;

    public void init(){
        alleutv = new alleUtovere();
    }

    public Connection createConnection() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Roprosjekt?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "adminroot");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int utøverID = Integer.parseInt(request.getParameter("uID"));

        Utover utv = new Utover(utøverID);
        utv = alleutv.hentEn(utv);


        int UtøverID = utv.getuID();
        String Kjonn = utv.getKjonnID();
        String Roklubb = utv.getKlubbID();
        String Roklasse = utv.getKlasseID();
        String Fornavn = utv.getFornavn();
        String Etternavn = utv.getEtternavn();
        int Fodt = utv.getFodt();


        request.setAttribute("utoverid", UtøverID);
        request.setAttribute("kjonn", Kjonn);
        request.setAttribute("roklubb", Roklubb);
        request.setAttribute("roklasse", Roklasse);
        request.setAttribute("fornavn", Fornavn);
        request.setAttribute("etternavn", Etternavn);
        request.setAttribute("fodt", Fodt);
        request.getRequestDispatcher("Retrieval.jsp").forward(request, response);


    }
}
