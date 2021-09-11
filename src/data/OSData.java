/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.OS_ServicoModel;
import model.OsModel;

/**
 *
 * @author andre
 */
public class OSData extends Conexao {

    public OSData() throws Exception {

    }

    public int incluirOS(OsModel obj) throws Exception {
        int idOS;
        int ret = 0;
        String sql = "Insert into Ordem_Servico (data_final,data_inicial,total,fk_cli_id,fk_vei_id) values (?,?,?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, obj.getDataFinal());
        ps.setString(2, obj.getDataInicial());
        ps.setDouble(3, .0);
        ps.setInt(4, obj.getFk_cli_id());
        ps.setString(5, obj.getFk_vei_id());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            idOS = rs.getInt(1);
            OS_ServicoData OS_ServicoData = new OS_ServicoData();
            OS_ServicoModel obj2 = new OS_ServicoModel();
            obj2.setFk_os_id(idOS);
            obj2.setFk_ser_id(obj.getIdServico());
            boolean ret2 = OS_ServicoData.incluir(obj2);
            if (ret2) {
                ret = idOS;
            } else {
                ret = 0;
            }
        }
        return ret;
    }
    
    public boolean editar(OsModel obj) throws Exception {
        String sql = "Update Ordem_Servico set data_final=?,data_inicial=?,total=?,fk_cli_id=?,fk_vei_id=? where idOs=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getDataFinal());
        ps.setString(2, obj.getDataInicial());
        ps.setDouble(3, obj.getTotal());
        ps.setInt(4, obj.getFk_cli_id());
        ps.setString(5, obj.getFk_vei_id());
        return ps.executeUpdate() > 0;
    }

    public boolean excluir(int id) throws Exception {
        String sql = "Delete from Ordem_Servico where idOS=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }

//    public ArrayList<OsModel> pesquisar(String pesq) throws Exception {
//        ArrayList<OsModel> listaOS = new ArrayList<>();
//        String sql = "Select o.idOs, o.data_final, o.data_inicial, o.total from Ordem_Servico o"
//                + " where idOs like '" + pesq + "%' order by idOs";
//        PreparedStatement ps = getConexao().prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            OsModel obj = new OsModel(rs.getString("data_final"),
//                    rs.getString("data_inicial"),
//                    rs.getDouble("total"), rs.getInt("fk_cli_id"), rs.getString("fk_vei_id"), rs.getString("vei_combo"),
//                    rs.getString("cli_combo"), rs.getString("ser_combo"));
//            listaOS.add(obj);
//        }
//        return listaOS;
//    }

    public int carregaNomeServico(String nomeServico) throws Exception {
        int num = 0;
        String sql = "Select * from Servico where nome = " + nomeServico;
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            num = rs.getInt("idServico");
        }
        return num;
    }

    public int carregaNomeVeiculo(String nomeVeiculo) throws Exception {
        int num = 0;
        String sql = "Select * from veiculo where nome = " + nomeVeiculo;
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            num = rs.getInt("chassi");
        }
        return num;
    }

    public int carregaNomeCliente(String nomeCliente) throws Exception {
        int num = 0;
        String sql = "Select * from Cliente where nome = " + nomeCliente;
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            num = rs.getInt("idCliente");
        }
        return num;
    }

}
