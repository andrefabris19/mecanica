/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ClienteModel;
import model.VeiculoModel;

/**
 *
 * @author andre
 */
public class VeiculoData extends Conexao {

    public VeiculoData() throws Exception {

    }

    public boolean incluir(VeiculoModel obj) throws Exception {
        //System.out.println("aaaa" + obj.getFk_cli_id());
        //obj.setFk_cli_id(ClienteData.carregaNome(obj.getNome()));
        String sql = "Insert into Veiculo (chassi,modelo,placa,ano_veiculo,fk_cli_id) values (?,?,?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getChassi());
        ps.setString(2, obj.getModelo());
        ps.setString(3, obj.getPlaca());
        ps.setInt(4, obj.getAno_veiculo_veiculo());
        ps.setInt(5, obj.getFk_cli_id());
        return ps.executeUpdate() > 0;
    }

    public boolean editar(VeiculoModel obj) throws Exception {
        String sql = "Update Veiculo set chassi=?,modelo=?,placa=?,ano_veiculo=? where chassi=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getChassi());
        ps.setString(2, obj.getModelo());
        ps.setString(3, obj.getPlaca());
        ps.setInt(4, obj.getAno_veiculo_veiculo());
        ps.setString(5, obj.getChassi());
        return ps.executeUpdate() > 0;
    }

    public boolean excluir(String id) throws Exception {
        String sql = "Delete from Veiculo where chassi=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, id);
        return ps.executeUpdate() > 0;
    }

    public ArrayList<VeiculoModel> pesquisar(String pesq) throws Exception {
        ArrayList<VeiculoModel> listaveiculos = new ArrayList<>();
        String sql = "Select v.chassi,v.modelo,v.placa,v.ano_veiculo,c.nome,v.fk_cli_id from Veiculo v JOIN Cliente c ON (c.idCliente = v.fk_cli_id)"
                + " where chassi like '" + pesq + "%' order by chassi";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            VeiculoModel obj = new VeiculoModel(rs.getString("chassi"), rs.getString("modelo"),
                    rs.getString("placa"), rs.getInt("ano_veiculo"), rs.getInt("fk_cli_id"), rs.getString("nome"));
            listaveiculos.add(obj);
        }
        return listaveiculos;
    }
    
    public ArrayList<VeiculoModel> carregaVeiculo() throws Exception {
        ArrayList<VeiculoModel> listaveiculos = new ArrayList<>();
        String sql = "Select * from Cliente order by idCliente";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            VeiculoModel obj = new VeiculoModel(rs.getString("chassi"), rs.getString("modelo"),
                    rs.getString("placa"), rs.getInt("ano_veiculo"), rs.getInt("fk_cli_id"), rs.getString("nome"));
            listaveiculos.add(obj);
        }
        return listaveiculos;
    }
    
    public ArrayList<VeiculoModel> carregaVeiculoOS(int id) throws Exception {
        ArrayList<VeiculoModel> listaveiculos = new ArrayList<>();
        String sql = "Select v.chassi,v.modelo,v.placa,v.ano_veiculo,v.fk_cli_id,c.nome from Veiculo v JOIN Cliente c "
                + "ON (c.idCliente = v.fk_cli_id) where fk_cli_id=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
      
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            VeiculoModel obj = new VeiculoModel(rs.getString("chassi"), rs.getString("modelo"),
                    rs.getString("placa"), rs.getInt("ano_veiculo"), rs.getInt("fk_cli_id"), rs.getString("nome"));
            listaveiculos.add(obj);
        }
        return listaveiculos;
    }
    
}
