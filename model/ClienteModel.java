package model;

import java.sql.Connection;

import java.sql.Statement;

import javax.swing.JOptionPane;

import conexao.BancoDeDados;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 09/04/2017
 * @version 1.0
 *
 */

public class ClienteModel {
	
	//método inserir informações no banco de dados
	public String InsereDados(String nome, String data, String cpf, String rg, String endereco, String bairro, String cidade, String estado, String cep, String email, String telefone){
		BancoDeDados banco = new BancoDeDados();
		String retorno = "erro";
		
		try{
			Connection ExConn = banco.conectar();
			Statement stmt = ExConn.createStatement();
			String sql = "INSERT INTO tb_cliente (nome_cli, dt_cli, cpf_cli, rg_cli, end_cli, bairro_cli, cidade_cli, estado_cli, cep_cli, email_cli, tel_cli) "
					+ "VALUES (\""+nome+"\", \""+data+"\",\""+cpf+"\", \""+rg+"\", \""+endereco+"\", \""+bairro+"\", \""+cidade+"\", \""+estado+"\", \""+cep+"\", \""+email+"\", \""+telefone+"\")";
			System.out.println(sql);
			boolean res = stmt.execute(sql);
			
			JOptionPane.showMessageDialog(null, (!res)?"Dados cadastrados com sucesso":"" + "Dados não puderam ser inseridos");
			stmt.close();
			banco.fecharConexao();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Dados não puderam ser inseridos");
		}
		
		return retorno;
	}
}
