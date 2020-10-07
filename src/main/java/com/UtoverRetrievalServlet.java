package com;

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

    public Connection createConnection(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Roprosjekt?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "adminroot");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int utøverID = Integer.parseInt(request.getParameter("uID"));

        try {
            //String query = "select * from utover";
            String query = "SELECT utover.uID, kjonn.kjonntype, klubb.klubbNavn, roKlasse.klasseType, utover.fornavn, utover.etternavn, utover.fodt\n" +
                    "from utover utover\n" +
                    "join kjonn kjonn\n" +
                    "\ton utover.kjonnID = kjonn.kjonnID\n" +
                    "join klubb klubb\n" +
                    "\ton utover.klubbID = klubb.klubbID\n" +
                    "join roKlasse roKlasse\n" +
                    "\ton utover.klasseID = roKlasse.klasseID\n" +
                    "where uid = '" + utøverID + "' ";
            connection = createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                int UtøverID = (rs.getInt(1));
                String Kjonn = (rs.getString(2));
                String Roklubb = (rs.getString(3));
                String Roklasse =  (rs.getString(4));
                String Fornavn = (rs.getString(5));
                String Etternavn = (rs.getString(6));
                int Fodt = (rs.getInt(7));


                request.setAttribute("utoverid", UtøverID);
                request.setAttribute("kjonn", Kjonn);
                request.setAttribute("roklubb", Roklubb);
                request.setAttribute("roklasse", Roklasse);
                request.setAttribute("fornavn", Fornavn);
                request.setAttribute("etternavn", Etternavn);
                request.setAttribute("fodt", Fodt);
                request.getRequestDispatcher("Retrieval.jsp").forward(request, response);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            destroy();
        }

    }

    public void destroy(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
