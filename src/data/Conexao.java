/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class Conexao {
    private Connection conn;
    public Connection getConexao(){
        return conn;
    }
    public Conexao() throws SQLException, ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/mecanica_LP1?zeroDateTimeBehavior=convertToNull";
        String driver="com.mysql.jdbc.Driver";
        Class.forName(driver);
        conn = DriverManager.getConnection(url, "andre", "123");
    }
}