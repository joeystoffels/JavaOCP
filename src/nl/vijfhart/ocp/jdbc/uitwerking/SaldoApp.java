package nl.vijfhart.ocp.jdbc.uitwerking;

/*
Maak een applicatie SaldoApp waarin de mutaties uit J_SALDOMUTATIE worden verwerkt
in J_KLANTEN: de mutaties worden opgeteld bij het opensaldo van de betreffende klanten.
Geef in J_SALDOMUTATIE uitgevoerd de waarde 1 als het gelukt is.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SaldoApp {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;

        try {
            conn = MijnConnectie.connect();
            Statement stMut = conn.createStatement();
            ResultSet rsMut = stMut.executeQuery
                    ("select id, klantnr, mutatie, " +
                            "uitgevoerd from j_saldomutatie");
            Statement stKlan = conn.createStatement();
            Statement stMut2 = conn.createStatement();

            while (rsMut.next()) {
                final String sKlan =
                        "update j_klanten set opensaldo = opensaldo + " +
                                rsMut.getInt(3) + " where klantnr = " +
                                rsMut.getInt(2);
                if (stKlan.executeUpdate(sKlan) > 0) {
                    final String sMut =
                            "update j_saldomutatie set uitgevoerd= 1 where id = " +
                                    rsMut.getInt(1);
                    stMut2.executeUpdate(sMut);
                }
            }
            conn.commit();
        } finally {
            if (conn != null)
                conn.close();
        }

//        Alternatief
//        Connection conn=null;
//        try {
//            conn = MijnConnectie.connect();
//            Statement stMut = conn.createStatement();
//            ResultSet rsMut = stMut.executeQuery
//                    ("select id, klantnr, mutatie, uitgevoerd from j_saldomutatie");
//            PreparedStatement psKlan = conn.prepareStatement
//                    ("update j_klanten set opensaldo=opensaldo + ? where klantnr=?");
//            PreparedStatement psMut = conn.prepareStatement
//                    ("update j_saldomutatie set uitgevoerd=1 where id = ? ");
//            while(rsMut.next()){
//                psKlan.setInt(1,rsMut.getInt(3));
//                psKlan.setInt(2,rsMut.getInt(2));
//                if(psKlan.executeUpdate()>0){
//                    psMut.setInt(1,rsMut.getInt(1));
//                    psMut.executeUpdate();
//                }
//            }
//            conn.commit();
//        }
//        finally{
//            if(conn!=null) conn.close();
//        }

    }
}

