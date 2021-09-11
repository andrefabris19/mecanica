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
public class PFModel extends ClienteModel{
    int CPF;
    String RG;

    public PFModel(String RG, int CPF) {
        RG = new String();
        CPF = 0;
    }
    
    public PFModel(int CPF, String RG) {
        this.CPF = CPF;
        this.RG = RG;
    }
    
    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
}
