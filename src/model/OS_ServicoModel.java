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
public class OS_ServicoModel {
    private int fk_os_id;
    private int fk_ser_id;
    
    public OS_ServicoModel() {
        fk_os_id = 0;
        fk_ser_id = 0;
    }

    public OS_ServicoModel(int fk_os_id, int fk_ser_id) {
        this.fk_os_id = fk_os_id;
        this.fk_ser_id = fk_ser_id;
    }
    
    public int getFk_os_id() {
        return fk_os_id;
    }

    public void setFk_os_id(int fk_os_id) {
        this.fk_os_id = fk_os_id;
    }

    public int getFk_ser_id() {
        return fk_ser_id;
    }

    public void setFk_ser_id(int fk_ser_id) {
        this.fk_ser_id = fk_ser_id;
    }
    
    
}
