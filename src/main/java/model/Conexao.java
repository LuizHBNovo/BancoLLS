/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class Conexao {
    
    Connection conn = null;
    
    public Connection getConnection()  {
            
            
            try{
                String url = "jdbc:mysql://localhost:3307/bancoteste?user=root&passoword=";
                conn = DriverManager.getConnection(url);
                System.out.println("sucesso");
                return conn;
            }catch(SQLException e){
                System.out.println("Driver do banco de dados não localizado");
            }
            return conn;
}
    
    
    
    /*public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3307/bancoteste", "root", "");
            System.out.println("conectado com sucesso");
        } catch (SQLException e) {
            System.out.println("Driver do banco de dados não localizado");
        }
    }*/
}
