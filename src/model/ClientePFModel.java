/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author andre
 */
public class ClientePFModel extends ClienteModel{
    
    String CPF;
    String RG;
    
    public ClientePFModel() {
        super();
        this.CPF = new String();
        this.RG = new String();
    }
    
    public ClientePFModel(int idCliente, String nome, String endereco, String telefone, String RG, String CPF) {
        super(idCliente, nome, endereco, telefone);
        this.CPF = CPF;
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
}
