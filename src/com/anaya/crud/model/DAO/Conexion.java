package com.anaya.crud.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    String user = "root";
    String pass = "admin";
    String dbName = "crud";
    String url ="";

    Connection conn = null;


    public Connection openConnection() throws Exception {

            url = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&use"
            + "JDBCCompliantTimezoneShift=true&useLegacyDateTimeCode=false&" + "serverTimezone=UTC";

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, pass);

            if(conn != null){
                System.out.println("Se conectó correctamente");
            }
            return conn;
     
    }

    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        Conexion conne = new Conexion();
        try {
            conne.openConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
}
