package com.utover.alleutovere;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class alleUtovere {
    private Connection connection;
    //private int UID;

    private String QUERY1 = "SELECT utover.uID, kjonn.kjonntype, klubb.klubbNavn, roKlasse.klasseType, utover.fornavn, utover.etternavn, utover.fodt\n" +
            "from utover utover\n" +
            "join kjonn kjonn\n" +
            "\ton utover.kjonnID = kjonn.kjonnID\n" +
            "join klubb klubb\n" +
            "\ton utover.klubbID = klubb.klubbID\n" +
            "join roKlasse roKlasse\n" +
            "\ton utover.klasseID = roKlasse.klasseID order by uID";

    private String QUERY2 = "insert into utover values (?,?,?,?,?,?,?)";

    /*private String QUERY3 = "SELECT utover.uID, kjonn.kjonntype, klubb.klubbNavn, roKlasse.klasseType, utover.fornavn, utover.etternavn, utover.fodt\n" +
            "from utover utover\n" +
            "join kjonn kjonn\n" +
            "\ton utover.kjonnID = kjonn.kjonnID\n" +
            "join klubb klubb\n" +
            "\ton utover.klubbID = klubb.klubbID\n" +
            "join roKlasse roKlasse\n" +
            "\ton utover.klasseID = roKlasse.klasseID\n" +
            "where uid = '" + UID + "' ";*/

    /*public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }*/

    public Connection createConnection(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Roprosjekt?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "adminroot");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }


    public List <Utover> listOppAlleUtovere(){
        List<Utover> utovere = new ArrayList<>();
        try {
            Connection connection = createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY1);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int Uid = (rs.getInt(1));
                String Kjonnid = (rs.getString(2));
                String Klubbid = (rs.getString(3));
                String Klasseid = (rs.getString(4));
                String Fornavn = (rs.getString(5));
                String Etternavn = (rs.getString(6));
                int Fodt = (rs.getInt(7));
                utovere.add(new Utover(Uid, Kjonnid, Klubbid, Klasseid, Fornavn, Etternavn, Fodt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utovere;
    }

    public void insertUtover(utoveri utoverparam){
        try {
            Connection connection = createConnection();
            PreparedStatement statement = connection.prepareStatement(QUERY2);
            statement.setInt(1, utoverparam.getuID());
            statement.setInt(2, utoverparam.getKjonnID());
            statement.setInt(3, utoverparam.getKlubbID());
            statement.setInt(4, utoverparam.getKlasseID());
            statement.setString(5, utoverparam.getFornavn());
            statement.setString(6, utoverparam.getEtternavn());
            statement.setInt(7, utoverparam.getFodt());
            statement.execute();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            destroy();
        }

    }
    public Utover hentEn(Utover dummy) {
        Utover utover = null;

        try {
           // int id = (dummy.getuID());
            connection = createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT utover.uID, kjonn.kjonntype, klubb.klubbNavn, roKlasse.klasseType, utover.fornavn, utover.etternavn, utover.fodt\n" +
                    "from utover utover\n" +
                    "join kjonn kjonn\n" +
                    "\ton utover.kjonnID = kjonn.kjonnID\n" +
                    "join klubb klubb\n" +
                    "\ton utover.klubbID = klubb.klubbID\n" +
                    "join roKlasse roKlasse\n" +
                    "\ton utover.klasseID = roKlasse.klasseID\n" +
                    "where uid = '" + dummy.getuID() + "' ");

            while (rs.next()) {
                int uID = (rs.getInt(1));
                String kjonnID = (rs.getString(2));
                String klubbID = (rs.getString(3));
                String klasseID = (rs.getString(4));
                String fornavn = (rs.getString(5));
                String etternavn = (rs.getString(6));
                int fodt = (rs.getInt(7));
                utover = new Utover(uID, kjonnID, klubbID, klasseID, fornavn, etternavn, fodt);

            } } catch(SQLException e){
                e.printStackTrace();
            }




        return utover;

    }

    public void destroy () {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

