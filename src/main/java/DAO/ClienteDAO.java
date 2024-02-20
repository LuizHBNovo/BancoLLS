/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Conexao;

/**
 *
 * @author USER
 */
public class ClienteDAO {
    
    Conexao connexao = new Conexao();
    
    public void informacoesConta(Cliente cliente){
        
        String sql = "INSERT INTO CLIENTE (NUMEROCONTA, NOME, ESTADOCIVIL, SENHA) VALUES (?, ?, ?, ?)";
        
        PreparedStatement ps = null;
        
        try {
           ps= connexao.getConnection().prepareStatement(sql);
           ps.setString(1, cliente.getNumeroConta());
           ps.setString(2, cliente.getNome());
           ps.setString(3, cliente.getEstadoCivil());
           ps.setString(4, cliente.getSenha());
           
           ps.execute();
           ps.close();
        } catch (SQLException e) {
            System.out.println("Falha ao inserir informações");
        }   
    }
    
    public List<Cliente> getCliente(){
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<Cliente>();
        PreparedStatement ps = null;
        ResultSet result = null;
        
        try {
           ps= connexao.getConnection().prepareStatement(sql);
           result = ps.executeQuery();
     
           while(result.next()){
               Cliente cliente = new Cliente();
               cliente.setNome(result.getString("nome"));
               cliente.setSenha(result.getString("senha"));          
               clientes.add(cliente);  
           }
        }catch(SQLException e){
            System.out.println("DAO");
        }
        return clientes;
    }
    
    public boolean verificarCredenciais(String nome, String senha) throws SQLException {
    
        String sql = "SELECT * FROM cliente WHERE nome = ? AND senha = ?";
            try (PreparedStatement declaracao = connexao.getConnection().prepareStatement(sql)) {
                declaracao.setString(1, nome);
                declaracao.setString(2, senha);
                
                try (ResultSet resultado = declaracao.executeQuery()) {
                    if (resultado.next()) {
                       
                        System.out.println("Nome de usuário: " + resultado.getString("nome"));
                        System.out.println("Senha: " + resultado.getString("senha"));
                        return true;
                    } else {
                        System.out.println("Usuário não encontrado.");
                        return false;
                    }
                }
            }   
    }
}
