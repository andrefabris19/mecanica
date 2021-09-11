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
public class VeiculoModel {

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno_veiculo_veiculo() {
        return ano_veiculo_veiculo;
    }

    public void setAno_veiculo_veiculo(int ano_veiculo_veiculo) {
        this.ano_veiculo_veiculo = ano_veiculo_veiculo;
    }
    
    public int getFk_cli_id() {
        return fk_cli_id;
    }

    public void setFk_cli_id(int fk_cli_id) {
        this.fk_cli_id = fk_cli_id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String chassi;
    private String modelo;
    private String placa;
    private int ano_veiculo_veiculo;
    private int fk_cli_id;
    private String nome;

    public VeiculoModel() {
        chassi = new String();
        modelo = new String();
        placa = new String();
        ano_veiculo_veiculo = 0;
        fk_cli_id = 0;
        nome = new String();
    }

    public VeiculoModel(String chassi, String modelo, String placa, int ano_veiculo_veiculo, int fk_cli_id, String nome) {
        this.chassi = chassi;
        this.modelo = modelo;
        this.placa = placa;
        this.ano_veiculo_veiculo = ano_veiculo_veiculo;
        this.fk_cli_id = fk_cli_id;
        this.nome = nome;
    }

    
}
