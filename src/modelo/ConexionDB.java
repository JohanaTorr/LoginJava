/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
/**
 *
 * @author Lenovo
 */
public class ConexionDB {
    
    private static final String URL = "jdbc:mysql://localhost:3306/app_login?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "AnaPau1706";

    public static Connection getConexion(){
        try{
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(Exception e){
            throw new RuntimeException("Error conexion", e);
        }
    }
}
