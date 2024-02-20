/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import view.Saldo;

/**
 *
 * @author USER
 */
public class Conta {
    private TipoConta tipoConta;
    private String numero;
    private float saldo;

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public String abrirConta(String numero){
        return this.numero = numero;    
    }  
     
    public String tipoDaConta(TipoConta tipoConta){
        if(tipoConta == TipoConta.CONTADEPÓSITO){
            return "Conta depósito";
        }
        else if(tipoConta == TipoConta.CONTAPAGAMENTOS){
            return "Conta pagamento";
        }
        else if(tipoConta == TipoConta.CONTASALARIO){
            return "Conta salário";
        }else{
        return null;
        }
    }
    
    public void depositar(float valor){
        if (valor <= 0){
            throw new IllegalArgumentException("O valor deve ser maior que zero para depósito");
        }
        setSaldo(getSaldo() + valor);
        
    } 
    
    public void sacar(float valor){
        if (valor <= 0 || getSaldo() < valor){
          throw new IllegalArgumentException("Valor inválido para saque");
      }
        this.setSaldo(getSaldo()-valor);
    }
}
