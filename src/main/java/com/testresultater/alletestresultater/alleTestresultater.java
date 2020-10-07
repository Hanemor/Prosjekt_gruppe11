package com.testresultater.alletestresultater;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class alleTestresultater {
    private Connection connection;

    public Connection createConnection(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Roprosjekt?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "adminroot");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }


public List<testresultat> listOppAlleTestresultater() throws SQLException {
        List<testresultat> testresultater = new ArrayList<>();
        try {
            //String query = "SELECT * FROM Roprosjekt.testresultater";
            String query = "select\n" +
                    "uiD,\n" +
                    "år,\n" +
                    "uke,\n" +
                    "roKlasse.klasseType,\n" +
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
                    "_3000_løp\n" +
                    "from testresultater testresultater\n" +
                    "inner join roKlasse roKlasse\n" +
                    "\ton testresultater.klasseID = roKlasse.klasseID";
            Connection connection = createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int uID = (rs.getInt(1));
                int år = (rs.getInt(2));
                int uke = (rs.getInt(3));
                String klasseID = (rs.getString(4));
                float watt_60 = (rs.getFloat(5));
                int bevegelighet = (rs.getInt(6));
                float watt_5000_m = (rs.getFloat(7));
                String tid_5000_m = (rs.getString(8));
                float watt_2000_ = (rs.getFloat(9));
                String tid_2000_m = (rs.getString(10));
                float prosent_ligg_ro = (rs.getFloat(11));
                float kilo_ligg_ro = (rs.getFloat(12));
                float prosent_knebøy = (rs.getFloat(13));
                float kilo_knebøy = (rs.getFloat(14));
                float Cm_Sargeant = (rs.getFloat(15));
                float sek_2000_m = (rs.getFloat(16));
                String min_2000_m = (rs.getString(17));
                int antall_Kr_hev = (rs.getInt(18));
                String _3000_løp = (rs.getString(19));
                testresultater.add(new testresultat(uID, år, uke, klasseID, watt_60, bevegelighet, watt_5000_m, tid_5000_m, watt_2000_, tid_2000_m, prosent_ligg_ro, kilo_ligg_ro, prosent_knebøy, kilo_knebøy, Cm_Sargeant, sek_2000_m, min_2000_m, antall_Kr_hev, _3000_løp));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testresultater;
}

}
