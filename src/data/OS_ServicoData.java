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
public class OS_ServicoData extends Conexao {

    public OS_ServicoData() throws Exception {

    }

    public boolean incluir(OS_ServicoModel obj) throws Exception {
        String sql = "Insert into OS_Servico (fk_os_id,fk_ser_id) values (?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, obj.getFk_os_id());
        ps.setInt(2, obj.getFk_ser_id());
        return ps.executeUpdate() > 0;
    }

    public boolean editar(OS_ServicoModel obj) throws Exception {
        String sql = "Update OS_Servico set fk_os_id=?,fk_ser_id=? where idOs=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, obj.getFk_os_id());
        ps.setInt(2, obj.getFk_ser_id());
        //ps.setInt(3, obj.getidOS());
        return ps.executeUpdate() > 0;
    }

    public boolean excluir(int id) throws Exception {
        String sql = "Delete from OS_Servico where idServico=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }

    public ArrayList<OsModel> DadosOsServico(String pesq) throws Exception {
        ArrayList<OsModel> listaosServico = new ArrayList<>();
        //String sql = "Select * from Cliente where idCliente like '" + pesq + "%' order by idCliente";
        String sql = "Select os.fk_os_id,os.fk_ser_id,s.descricao,s.idServico,s.nomeServico,s.valor from OS_Servico os "
                + "JOIN Servico s ON (s.idServico = os.fk_os_id)"
                + " where nome like '%" + pesq + "%' order by nome";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            OsModel obj = new OsModel(rs.getString("dataInicial"),
                    rs.getString("datafinal"), rs.getDouble("total"),
                    rs.getInt("fk_cli_id"), rs.getString("fk_vei_id"),
                    rs.getString("vei_combo"), rs.getString("cli_combo"),rs.getString("ser_combo"),
                    rs.getInt("idServico"));
            listaosServico.add(obj);
        }
        return listaosServico;

//    public ArrayList<OsModel> pesquisar(String pesq) throws Exception {
//        ArrayList<OsModel> listaOS = new ArrayList<>();
//        String sql = "Select o.idOs, o.data_final, o.data_inicial, o.total from OS_Servico o"
//                + " where idOs like '" + pesq + "%' order by idOs";
//        PreparedStatement ps = getConexao().prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            OsModel obj = new OsModel
//                    (rs.getString("data_final"),
//                    rs.getString("data_inicial"),
//                    rs.getDouble("total"), rs.getInt("fk_cli_id"), rs.getInt("fk_vei_id"),rs.getString("vei_combo"),
//                    rs.getString("cli_combo"),rs.getString("ser_combo"));
//            listaOS.add(obj);
//        }
//        return listaOS;
//    }
//
//    public int carregaNomeServico(String nomeServico) throws Exception {
//        int num = 0;
//        String sql = "Select * from Servico where nome = " + nomeServico;
//        PreparedStatement ps = getConexao().prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            num = rs.getInt("idServico");
//        }
//        return num;
//    }
//
//    public int carregaNomeVeiculo(String nomeVeiculo) throws Exception {
//        int num = 0;
//        String sql = "Select * from veiculo where nome = " + nomeVeiculo;
//        PreparedStatement ps = getConexao().prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            num = rs.getInt("chassi");
//        }
//        return num;
//    }
//
//    public int carregaNomeCliente(String nomeCliente) throws Exception {
//        int num = 0;
//        String sql = "Select * from Cliente where nome = " + nomeCliente;
//        PreparedStatement ps = getConexao().prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            num = rs.getInt("idCliente");
//        }
//        return num;
//    }
    }
}
