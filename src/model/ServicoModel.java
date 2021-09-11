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
public class ServicoModel {
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }
    
    private int idServico;
    private double valor;
    private String descricao;
    private String nomeServico;

    public ServicoModel() {
        idServico = 0;
        valor = 0;
        descricao = new String();
        nomeServico = new String();
    }

    public ServicoModel(int idServico, double valor, String descricao, String nomeServico) {
        this.idServico = idServico;
        this.valor = valor;
        this.descricao = descricao;
        this.nomeServico = nomeServico;
    }
}
