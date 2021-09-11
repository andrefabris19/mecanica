/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


import data.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class TesteConexao {
    public static void main(String[] args){
        try {
            Conexao c = new Conexao();
            System.out.println("conectado");
            String sql = "insert into Cliente (cli_cpf,cli_nome,cli_telefone,cli_endereco) values ('524178963','pedro','87458522','Rua 7, 58714')";
            PreparedStatement ps = c.getConexao().prepareStatement(sql);
            if(ps.executeUpdate()>0){
                System.out.println("Registro salvo com sucesso!");
            } else {
                System.out.println("Erro ao salvar.");
            }
        } catch (Exception ex) {
            System.out.println("erro"+ex.getMessage());
        }
    }
}
