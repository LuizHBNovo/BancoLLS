/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAO.ClienteDAO;
import java.sql.SQLException;


/**
 *
 * @author USER
 */
public class teste {
    public static void main(String[] args) throws SQLException {
        ClienteDAO cliente = new ClienteDAO();
        Cliente cli = new Cliente();
        
        String name = "luiz";
        String senha = "132";
        
        cliente.verificarCredenciais(name, senha);
        
       /*for(Cliente c: cliente.getCliente()){
           
           System.out.println(c.getNome());
           
       }*/
    }
}
