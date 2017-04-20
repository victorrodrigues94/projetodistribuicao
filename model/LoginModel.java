package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import conexao.BancoDeDados;
import telas.TelaPrincipal;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 09/04/2017
 * @version 1.0
 *
 */

public class LoginModel {
	public void acessarSistema(String user, String password){
		BancoDeDados conn = new BancoDeDados();
		ResultSet resultset = null;
		
		try {
			Connection ExConn = conn.conectar();
			Statement stmt = ExConn.createStatement();
			String sql = "SELECT * FROM tb_funcionario WHERE user_fun = " +"\""+user+"\";";
			resultset = stmt.executeQuery(sql);
			resultset.first();
			System.out.println(sql);
			
			if(resultset.getString("senha_fun").equals(password)){
				TelaPrincipal framPrincipal = new TelaPrincipal();
				framPrincipal.setLocationRelativeTo(null);
				framPrincipal.setVisible(true);
				JOptionPane.showMessageDialog(null, "Bem vindo ao sistema, "+ user);
			}else{
				JOptionPane.showMessageDialog(null, "Senha ou usuario invalido");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Senha ou usuario invalido!! ");
		}
	}
}
