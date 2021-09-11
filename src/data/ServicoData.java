/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ServicoModel;

/**
 *
 * @author andre
 */
public class ServicoData extends Conexao {

    public ServicoData() throws Exception {
    }

    public boolean incluir(ServicoModel obj) throws Exception {
        String sql = "Insert into Servico (valor,descricao,nomeServico) values (?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setDouble(1, obj.getValor());
        ps.setString(2, obj.getDescricao());
        ps.setString(3, obj.getNomeServico());
        return ps.executeUpdate() > 0;
    }

    public boolean editar(ServicoModel obj) throws Exception {
        String sql = "Update Servico set descricao=?,nomeServico=?,valor=? where idServico=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getDescricao());
        ps.setString(2, obj.getNomeServico());
        ps.setDouble(3, obj.getValor());
        ps.setInt(4, obj.getIdServico());
        return ps.executeUpdate() > 0;
    }

    public boolean excluir(int id) throws Exception {
        String slq = "Delete from Servico where idServico=?";
        PreparedStatement ps = getConexao().prepareStatement(slq);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }

    public ArrayList<ServicoModel> pesquisar(String pesq) throws Exception {
        ArrayList<ServicoModel> listaservicos = new ArrayList<>();
        String sql = "Select * from Servico where nomeServico like '" + pesq + "%' order by nomeServico";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ServicoModel obj = new ServicoModel(rs.getInt("idServico"), rs.getInt("valor"),
                    rs.getString("descricao"), rs.getString("nomeServico"));
            listaservicos.add(obj);
        }
        return listaservicos;
    }

    public ArrayList<ServicoModel> carregaVeiculo() throws Exception {
        ArrayList<ServicoModel> listaservicos = new ArrayList<>();
        String sql = "Select * from Servico order by idServico";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ServicoModel obj = new ServicoModel(rs.getInt("idServico"), rs.getDouble("valor"),
                    rs.getString("descricao"), rs.getString("nome_servico"));
            listaservicos.add(obj);
        }
        return listaservicos;
    }
    
    public ArrayList<ServicoModel> carregaServicoOS() throws Exception {
        ArrayList<ServicoModel> listaservicos = new ArrayList<>();
        String sql = "Select * from Servico order by idServico";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ServicoModel obj = new ServicoModel(rs.getInt("idServico"), rs.getDouble("valor"),
                    rs.getString("descricao"), rs.getString("nomeServico"));
            listaservicos.add(obj);
        }
        return listaservicos;
    }
}
