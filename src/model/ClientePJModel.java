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
public class ClientePJModel extends ClienteModel {

    String CNPJ;
    String IE;
    int fk_cli_id;

    public ClientePJModel() {
        super();
        this.CNPJ = new String();
        this.IE = new String();
        this.fk_cli_id = 0;

    }

    public ClientePJModel(int idCliente, String nome, String endereco, String telefone, String CNPJ, String IE, int fk_cli_id) {
        super(idCliente, nome, endereco, telefone);
        this.CNPJ = CNPJ;
        this.IE = IE;
        this.fk_cli_id = fk_cli_id;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public int getFk_cli_id() {
        return fk_cli_id;
    }

    public void setFk_cli_id(int fk_cli_id) {
        this.fk_cli_id = fk_cli_id;
    }

}
