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

public class FuncionarioModel {
	
	//método inserir informações no banco de dados
	public String InsereDados(String nome, String data, String cpf, String rg, String endereco, String bairro, String cidade, String estado, String cep, String email, String telefone, String user, String funcao, String senha){
		BancoDeDados banco = new BancoDeDados();
		String retorno = "erro";
		
		try{
			Connection ExConn = banco.conectar();
			Statement stmt = ExConn.createStatement();
			String sql = "INSERT INTO tb_funcionario (nome_fun, dtnasc_fun, cpf_fun, rg_fun, end_fun, bairro_fun, cidade_fun, estado_fun, cep_fun, email_fun, tel_fun, user_fun, funcao_fun, senha_fun) "
					+ "VALUES (\""+nome+"\", \""+data+"\",\""+cpf+"\", \""+rg+"\", \""+endereco+"\", \""+bairro+"\", \""+cidade+"\", \""+estado+"\", \""+cep+"\", \""+email+"\", \""+telefone+"\", \""+user+"\", \""+funcao+"\", \""+senha+"\");";
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
