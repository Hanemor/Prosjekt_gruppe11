package com.utover.alleutovere;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class alleUtovere {
    private Connection connection;

    public Connection createConnection(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Roprosjekt?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "adminroot");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }


    public List <utover> listOppAlleUtovere(){
        List<utover> utovere = new ArrayList<>();
        try {
            //String query = "SELECT * FROM Roprosjekt.utover";
            String query = "SELECT utover.uID, kjonn.kjonntype, klubb.klubbNavn, roKlasse.klasseType, utover.fornavn, utover.etternavn, utover.fodt\n" +
                    "from utover utover\n" +
                    "join kjonn kjonn\n" +
                    "\ton utover.kjonnID = kjonn.kjonnID\n" +
                    "join klubb klubb\n" +
                    "\ton utover.klubbID = klubb.klubbID\n" +
                    "join roKlasse roKlasse\n" +
                    "\ton utover.klasseID = roKlasse.klasseID";
            Connection connection = createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int Uid = (rs.getInt(1));
                String Kjonnid = (rs.getString(2));
                String Klubbid = (rs.getString(3));
                String Klasseid = (rs.getString(4));
                String Fornavn = (rs.getString(5));
                String Etternavn = (rs.getString(6));
                int Fodt = (rs.getInt(7));
                utovere.add(new utover(Uid, Kjonnid, Klubbid, Klasseid, Fornavn, Etternavn, Fodt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utovere;
    }
}
