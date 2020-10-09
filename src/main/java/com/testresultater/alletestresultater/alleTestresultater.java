package com.testresultater.alletestresultater;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class alleTestresultater {
    private Connection connection;
    private alleresultatParameter alleresparam;

    public Connection createConnection(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Roprosjekt?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "adminroot");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }


public List<testresultat> listOppAlleTestresultater(List<testresultat> parameter) throws SQLException {
        List<testresultat> testresultater = new ArrayList<>();

        testresultat testres = parameter.get(0);


        try {

            String query = "select\n" +
                    "testresultater.uID,\n" +
                    "år,\n" +
                    "uke,\n" +
                    "roklasse.klasseType,\n" +
                    "score,\n" +
                    "watt_60,\n" +
                    "bevegelighet,\n" +
                    "watt_5000_m,\n" +
                    "tid_5000_m,\n" +
                    "watt_2000_m,\n" +
                    "tid_2000_m,\n" +
                    "prosent_ligg_ro,\n" +
                    "kilo_ligg_ro,\n" +
                    "prosent_knebøy,\n" +
                    "kilo_knebøy,\n" +
                    "cm_Sargeant,\n" +
                    "sek_3000_m,\n" +
                    "min_3000_m,\n" +
                    "antall_Kr_hev,\n" +
                    "_3000_løp,\n" +
                    "utover.fornavn,\n" +
                    "utover.etternavn\n" +
                    "from testresultater testresultater\n" +
                    "join roKlasse roklasse\n" +
                    "on testresultater.klasseID = roklasse.klasseID\n" +
                    "join utover utover\n" +
                    "on testresultater.uID = utover.uID\n" +
                    "where år = ? and uke = ? and klasseType = ? ";
            Connection connection = createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, testres.getÅr());
            preparedStatement.setInt(2, testres.getUke());
            preparedStatement.setString(3, testres.getKlasseID());
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int uID = (rs.getInt("uID"));
                int år = (rs.getInt("år"));
                int uke = (rs.getInt("uke"));
                String klasseID = (rs.getString("klasseType"));
                float watt_60 = (rs.getFloat("watt_60"));
                int bevegelighet = (rs.getInt("bevegelighet"));
                float watt_5000_m = (rs.getFloat("watt_5000_m"));
                String tid_5000_m = (rs.getString("tid_5000_m"));
                float watt_2000_m = (rs.getFloat("watt_2000_m"));
                String tid_2000_m = (rs.getString("tid_2000_m"));
                float prosent_ligg_ro = (rs.getFloat("prosent_ligg_ro"));
                float kilo_ligg_ro = (rs.getFloat("kilo_ligg_ro"));
                float prosent_knebøy = (rs.getFloat("prosent_knebøy"));
                float kilo_knebøy = (rs.getFloat("kilo_knebøy"));
                float Cm_Sargeant = (rs.getFloat("cm_Sargeant"));
                float sek_3000_m = (rs.getFloat("sek_3000_m"));
                String min_3000_m = (rs.getString("min_3000_m"));
                int antall_Kr_hev = (rs.getInt("antall_Kr_hev"));
                String _3000_løp = (rs.getString("_3000_løp"));
                float score = (rs.getFloat("score"));
                String fornavn = (rs.getString("fornavn"));
                String etternavn = (rs.getString("etternavn"));
                testresultater.add(new testresultat(uID, år, uke, klasseID, watt_60, bevegelighet, watt_5000_m, tid_5000_m, watt_2000_m, tid_2000_m, prosent_ligg_ro, kilo_ligg_ro, prosent_knebøy, kilo_knebøy, Cm_Sargeant, sek_3000_m, min_3000_m, antall_Kr_hev, _3000_løp, score, fornavn, etternavn));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testresultater;
}

}
