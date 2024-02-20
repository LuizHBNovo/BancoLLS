/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;
import model.Conexao;

/**
 *
 * @author USER
 */
public class EnderecoDAO {
    Conexao connexao = new Conexao();
    
    public void cadastroEndereço(Cliente cliente){
        
        String sql = "INSERT INTO ENDEREÇO (RUA, CIDADE, ESTADO, PAIS) VALUES (?, ?, ?, ?)";
        
        PreparedStatement ps = null;
        
        try {
           ps= connexao.getConnection().prepareStatement(sql);
           ps.setString(1, cliente.getRua());
           ps.setString(2, cliente.getCidade());
           ps.setString(3, cliente.getEstado());
           ps.setString(4, cliente.getPais());
           
           ps.execute();
           ps.close();
        } catch (SQLException e) {
            System.out.println("Falha ao inserir informações");
        }
    }
}
