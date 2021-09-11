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
public class OsModel {
    private String dataInicial;
    private String dataFinal;
    private Double total;
    private int fk_cli_id;
    private String fk_vei_id;
    private String vei_combo;
    private String cli_combo;
    private String ser_combo;
    private int idServico;

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }
    
    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getFk_cli_id() {
        return fk_cli_id;
    }

    public void setFk_cli_id(int fk_cli_id) {
        this.fk_cli_id = fk_cli_id;
    }

    public String getFk_vei_id() {
        return fk_vei_id;
    }

    public void setFk_vei_id(String fk_vei_id) {
        this.fk_vei_id = fk_vei_id;
    }

    public String getVei_combo() {
        return vei_combo;
    }

    public void setVei_combo(String vei_combo) {
        this.vei_combo = vei_combo;
    }

    public String getCli_combo() {
        return cli_combo;
    }

    public void setCli_combo(String cli_combo) {
        this.cli_combo = cli_combo;
    }

    public String getSer_combo() {
        return ser_combo;
    }

    public void setSer_combo(String ser_combo) {
        this.ser_combo = ser_combo;
    }
    
    
    public OsModel() {
        dataInicial = new String();
        dataFinal = new String();
        total = 0.0;
        fk_cli_id = 0;
        fk_vei_id = new String();
        vei_combo = new String();
        cli_combo = new String();
        ser_combo = new String();
        idServico = 0;
    }

    public OsModel(String dataInicial, String dataFinal, Double total, int fk_cli_id, String fk_vei_id, String vei_combo,
            String cli_combo, String ser_combo, int idServico) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.total = total;
        this.fk_cli_id = fk_cli_id;
        this.fk_vei_id = fk_vei_id;
        this.vei_combo = vei_combo;
        this.cli_combo = cli_combo;
        this.ser_combo = ser_combo;
        this.idServico = idServico;
    }
    
}
