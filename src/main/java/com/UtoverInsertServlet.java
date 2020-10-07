package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet( name = "UtoverInsertServlet", urlPatterns = {"/LeggTil"})
public class UtoverInsertServlet extends HttpServlet {
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

        int  Utøverid = Integer.parseInt(request.getParameter("uID"));
        int Kjonnid = Integer.parseInt(request.getParameter("kjonnID"));
        int Klubbid = Integer.parseInt(request.getParameter("klubbID"));
        int Klasseid = Integer.parseInt(request.getParameter("klasseID"));
        String Fornavn = request.getParameter("fornavn");
        String Etternavn = request.getParameter("etternavn");
        int Fodt = Integer.parseInt(request.getParameter("fodt"));


        try {
            String query = "insert into utover values (?,?,?,?,?,?,?)";
            connection = createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Utøverid);
            statement.setInt(2, Kjonnid);
            statement.setInt(3, Klubbid);
            statement.setInt(4, Klasseid);
            statement.setString(5, Fornavn);
            statement.setString(6, Etternavn);
            statement.setInt(7, Fodt);
            statement.execute();
            PrintWriter out = response.getWriter();
            out.println("<H1>Ny bruker opprettet:-)</H1>");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
