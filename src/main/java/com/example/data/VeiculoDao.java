package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.model.Veiculo;

public class VeiculoDao {

    final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    final String USER = "pf1389";
    final String PASS = "fiap23";

    public void inserir(Veiculo veiculo) throws SQLException{

        var conexao = DriverManager.getConnection(URL, USER, PASS);

        var sql = "INSERT INTO veiculos (marca, modelo, ano, valor) VALUES (?, ?, ?, ?) ";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1, veiculo.getMarca());
        comando.setString(2, veiculo.getModelo());
        comando.setInt(3, veiculo.getAno());
        comando.setBigDecimal(4, veiculo.getValor());
        comando.executeUpdate();

        conexao.close();
        
    }
    
}
