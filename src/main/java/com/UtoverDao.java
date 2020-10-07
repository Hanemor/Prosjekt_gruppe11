package com;

import java.sql.*;

public class UtoverDao {

    public  static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/Roprosjekt?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "adminroot";
        String query = "SELECT utover.uID, kjonn.kjonntype, klubb.klubbNavn, roKlasse.klasseType, utover.fornavn, utover.etternavn, utover.fodt\n" +
                "from utover utover\n" +
                "join kjonn kjonn\n" +
                "\ton utover.kjonnID = kjonn.kjonnID\n" +
                "join klubb klubb\n" +
                "\ton utover.klubbID = klubb.klubbID\n" +
                "join roKlasse roKlasse\n" +
                "\ton utover.klasseID = roKlasse.klasseID";

        try {
            Connection myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();
           // ResultSet rs = myStmt.executeQuery("SELECT * FROM Roprosjekt.utover;");
            ResultSet rs = myStmt.executeQuery(query);

            while(rs.next()){
                int UtøverID = (rs.getInt(1));
                String Kjonn = (rs.getString(2));
                String Roklubb = (rs.getString(3));
                String Roklasse =  (rs.getString(4));
                String Fornavn = (rs.getString(5));
                String Etternavn = (rs.getString(6));
                int fodt = (rs.getInt(7));

                System.out.print(Fornavn);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}