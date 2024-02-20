/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;
import model.Conexao;
import model.Conta;

/**
 *
 * @author USER
 */
public class OperacaoDAO {
    
        Conexao connexao = new Conexao();
        Cliente c = new Cliente();
        Conta conta = new Conta();
        public void depositar(float cliente){
            String sql = "INSERT INTO SALDO (SALDO) VALUES (?)";

            PreparedStatement ps = null;
            
            conta.depositar(cliente);

            try {
               ps= connexao.getConnection().prepareStatement(sql);
               ps.setFloat(1, conta.getSaldo());
               ps.execute();
               ps.close();
            } catch (SQLException e) {
                System.out.println("Falha ao inserir o saldo");
            }
        }
}
