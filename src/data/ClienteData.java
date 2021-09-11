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
import model.ClientePFModel;
import model.ClientePJModel;

/**
 *
 * @author andre
 */
public class ClienteData extends Conexao {

    public ClienteData() throws Exception {

    }

    public boolean incluir(ClienteModel obj) throws Exception {
        getConexao().setAutoCommit(false);
        int idCliente = 0;
        String sql = "Insert into Cliente (nome,endereco,telefone) values (?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getEndereco());
        ps.setString(3, obj.getTelefone());
        ps.executeUpdate();
//        ResultSet rs = ps.executeUpdate();
//        if (rs.next()) {
//            idCliente = rs.getInt("idCliente");
//        }
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            idCliente = rs.getInt(1);
        }
        //System.out.println("");

        if (obj instanceof ClientePFModel) {
            String sql2 = "Insert into Cliente_Fisico (CPF, RG, fk_cli_id) values (?,?,?)";
            PreparedStatement ps2 = getConexao().prepareStatement(sql2);
            ps2.setString(1, ((ClientePFModel) obj).getCPF());
            ps2.setString(2, ((ClientePFModel) obj).getRG());
            ps2.setInt(3, idCliente);
            if (ps2.executeUpdate() > 0) {
                getConexao().commit();
                return true;
            } else {
                getConexao().rollback();
            }
        } else {
            String sql2 = "Insert into Cliente_Juridico (CNPJ, IE, fk_cli_id) values (?,?,?)";
            PreparedStatement ps2 = getConexao().prepareStatement(sql2);
            ps2.setString(1, ((ClientePJModel) obj).getCNPJ());
            ps2.setString(2, ((ClientePJModel) obj).getIE());
            ps2.setInt(3, idCliente);
            if (ps2.executeUpdate() > 0) {
                getConexao().commit();
                return true;
            } else {
                getConexao().rollback();
            }
        }
        return false;
    }

    public boolean editar(ClienteModel obj) throws Exception {
        getConexao().setAutoCommit(false);
        String sql = "Update Cliente set nome=?,telefone=?,endereco=? where idCliente=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getTelefone());
        ps.setString(3, obj.getEndereco());
        ps.setInt(4, obj.getIdCliente());
        ps.executeUpdate();

        if (ps.executeUpdate() > 0) {
            if (obj instanceof ClientePJModel) {
                String sql2 = "Update Cliente_Juridico set CNPJ=?,IE=? where fk_cli_id=?";
                PreparedStatement ps2 = getConexao().prepareStatement(sql2);
                ps2.setString(1, ((ClientePJModel) obj).getCNPJ());
                ps2.setString(2, ((ClientePJModel) obj).getIE());
                ps2.setInt(3, obj.getIdCliente());
                if (ps2.executeUpdate() > 0) {
                    getConexao().commit();
                    return true;
                } else {
                    getConexao().rollback();
                }
            } else {
                if (obj instanceof ClientePFModel) {
                    String sql2 = "Update Cliente_Fisico set CPF=?,RG=? where fk_cli_id=?";
                    PreparedStatement ps2 = getConexao().prepareStatement(sql2);
                    ps2.setString(1, ((ClientePFModel) obj).getCPF());
                    ps2.setString(2, ((ClientePFModel) obj).getRG());
                    ps2.setInt(3, obj.getIdCliente());
                    if (ps2.executeUpdate() > 0) {
                        getConexao().commit();
                        return true;
                    } else {
                        getConexao().rollback();
                    }
                } else {
                    getConexao().commit();
                    return true;
                }
            }
        }
        return false;

    }

    public boolean excluir(ClienteModel obj, int id) throws Exception {
        getConexao().setAutoCommit(false);
        String sql = "";
        
        if (obj instanceof ClientePFModel) {
            sql = "Delete from Cliente_Fisico where fk_cli_id=?";
        } else if (obj instanceof ClientePJModel) {
            sql = "Delete from Cliente_Juridico where fk_cli_id=?";
        }
        System.out.println(id);
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);

        if (ps.executeUpdate() > 0) {
            String sql2 = "Delete from Cliente where idCliente=?";
            PreparedStatement ps2 = getConexao().prepareStatement(sql2);
            ps2.setInt(1, id);
            if (ps2.executeUpdate() > 0) {
                getConexao().commit();
                return true;
            } else {
                getConexao().rollback();
            }
        }
        return false;
    }

    public ArrayList<ClientePJModel> pesquisarClientePJ(String pesq) throws Exception {
        ArrayList<ClientePJModel> listaclientesjuridico = new ArrayList<>();
        //String sql = "Select * from Cliente where idCliente like '" + pesq + "%' order by idCliente";
        String sql = "Select pj.CNPJ, pj.IE, pj.fk_cli_id, c.nome, c.IdCliente, c.endereco,c.telefone from Cliente_Juridico pj "
                + "JOIN Cliente c ON (c.idCliente = pj.fk_cli_id)"
                + " where nome like '%" + pesq + "%' order by nome";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ClientePJModel obj = new ClientePJModel(rs.getInt("IdCliente"), rs.getString("nome"),
                    rs.getString("endereco"), rs.getString("telefone"), rs.getString("CNPJ"),
                    rs.getString("IE"), rs.getInt("Fk_cli_id"));
            listaclientesjuridico.add(obj);
        }
        return listaclientesjuridico;
    }

    public ArrayList<ClientePFModel> pesquisarClientePF(String pesq) throws Exception {
        ArrayList<ClientePFModel> listaclientesfisico = new ArrayList<>();
        //String sql = "Select * from Cliente where idCliente like '" + pesq + "%' order by idCliente";
        String sql = "Select pf.CPF, pf.RG, pf.fk_cli_id, c.nome, c.IdCliente, c.endereco,c.telefone from Cliente_Fisico pf "
                + "JOIN Cliente c ON (c.idCliente = pf.fk_cli_id)"
                + " where nome like '%" + pesq + "%' order by nome";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ClientePFModel obj = new ClientePFModel(rs.getInt("IdCliente"), rs.getString("nome"),
                    rs.getString("endereco"), rs.getString("telefone"), rs.getString("RG"), rs.getString("CPF"));
            listaclientesfisico.add(obj);
        }
        return listaclientesfisico;
    }

    public ArrayList<ClienteModel> carregaCliente() throws Exception {
        ArrayList<ClienteModel> listaclientes = new ArrayList<>();
        String sql = "Select * from Cliente order by idCliente";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ClienteModel obj = new ClienteModel(rs.getInt("IdCliente"), rs.getString("nome"),
                    rs.getString("endereco"), rs.getString("telefone"));
            listaclientes.add(obj);
        }
        return listaclientes;
    }

    public int carregaNome(String nome) throws Exception {
        int num = 0;
        String sql = "Select * from Cliente where nome = " + nome;
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            num = rs.getInt("idCliente");
        }
        return num;
    }

}
