/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knyr4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcell
 */
public class Kapcsolat {

    private static Connection conn = null;

    private static void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/knyr?zeroDateTimeBehavior=convertToNull", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Kapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    public boolean login(String user, String jelszo) {
//        createConnection();
//        try {
//            Statement stmt = conn.createStatement();
////            stmt.execute();
//            String sql = "SELECT NEV, ADMINE, SZERKESZTHET FROM USER "
//                    + "WHERE JELSZO='" + jelszo + "' "
//                    + "and NEV='" + user + "'";
//            System.out.println(sql);
//            ResultSet rs = stmt.executeQuery(sql);
//            ResultSetMetaData rsmd = rs.getMetaData();
//            System.out.println("lekérdezés");
//            while (rs.next()) {
//                felhasznalok = new Felhasznalok(rs.getString(1),
//                        Integer.parseInt(rs.getString(2)) == 1,
//                        Integer.parseInt(rs.getString(3)) == 1);
//            }
//            return felhasznalok != null;
//        } catch (SQLException ex) {
//            Logger.getLogger(Kapcsolat.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            closeConnection();
//        }
//        return false;
//    }
    public void adatbazisbaInsertalas(String sql) throws SQLException {
        createConnection();

        Statement stmt = conn.createStatement();
//            stmt.execute();
        System.out.println(sql);
        stmt.executeUpdate(sql);
//            stmt.executeQuery(sql);
        System.out.println("lekérdezés");

    }
    public ResultSet adatbazisReport(String sql) throws SQLException { //metódus sql selecthez
        createConnection();

        Statement stmt = conn.createStatement();
//            stmt.execute();
        System.out.println(sql);
        //stmt.executeUpdate(sql);
           ResultSet rs = stmt.executeQuery(sql);
           System.out.println("lekérdezés");
           return rs;
        
    }
}
