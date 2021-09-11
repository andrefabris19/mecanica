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
public class MecanicoModel {
    private int idMec;
    private String nome;
    private String especialidade;
    private String usuario;
    private String senha;

    public MecanicoModel() {
        idMec = 0;
        nome = new String();
        especialidade = new String();
        usuario = new String();
        senha = new String();
    }

    public MecanicoModel(int idMec, String nome, String especialidade, String usuario, String senha) {
        this.idMec = idMec;
        this.nome = nome;
        this.especialidade = especialidade;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdMec() {
        return idMec;
    }

    public void setIdMec(int idMec) {
        this.idMec = idMec;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
