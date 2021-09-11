/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.MecanicoModel;

/**
 *
 * @author andre
 */
public class MecanicoData extends Conexao {

    public MecanicoData() throws Exception {
    }

    public boolean incluir(MecanicoModel obj) throws Exception {
        String sql = "Insert into Mecanico (nome,especialidade,usuario,senha) values (?,?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getEspecialidade());
        ps.setString(3, obj.getUsuario());
        ps.setString(4, obj.getSenha());
        return ps.executeUpdate() > 0;
    }

    public boolean editar(MecanicoModel obj) throws Exception {
        String sql = "Update Mecanico set nome=?,especialidade=?, usuario=?, senha=? where idMec=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getEspecialidade());
        ps.setString(3, obj.getUsuario());
        ps.setString(4, obj.getSenha());
        ps.setInt(5, obj.getIdMec());
        return ps.executeUpdate() > 0;
    }

    public boolean excluir(int id) throws Exception {
        String slq = "Delete from Mecanico where idMec=?";
        PreparedStatement ps = getConexao().prepareStatement(slq);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }

    public ArrayList<MecanicoModel> pesquisar(String pesq) throws Exception {
        ArrayList<MecanicoModel> listamecanico = new ArrayList<>();
        String sql = "Select * from Mecanico where nome like '" + pesq + "%' order by nome";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            MecanicoModel obj = new MecanicoModel(rs.getInt("idMec"), rs.getString("nome"),
                    rs.getString("especialidade"), rs.getString("usuario"), rs.getString("senha"));
            listamecanico.add(obj);
        }
        return listamecanico;
    }
    
    public MecanicoModel validarUsuario(String usuario, String senha) throws Exception {
        String sql = "select * from Mecanico where usuario=? and senha =?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            MecanicoModel obj = new MecanicoModel();
            obj.setIdMec(rs.getInt("idMec"));
            obj.setNome(rs.getString("nome"));
            obj.setEspecialidade(rs.getString("especialidade"));
            obj.setUsuario(rs.getString("usuario"));
            obj.setSenha(rs.getString("senha"));
            return obj;
        } else {
            return null;
        }
    }
}
