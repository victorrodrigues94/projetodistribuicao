package model;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.BancoDeDados;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 17/04/2017
 * @version 1.0
 *
 */

public class RegistroClientesModel {
	
	//Metodo popular jtable Registro de Clientes
	@SuppressWarnings("finally")
	public ResultSet popularTabela(){
		BancoDeDados conn = new BancoDeDados();
		ResultSet resultset = null;
		
		try{
			Connection ExConn = conn.conectar();
			Statement stmt = ExConn.createStatement();
			String sql = "SELECT `id_cliente` 'Código', `nome_cli` 'Nome', `dt_cli` 'Data Nascimento', `cpf_cli` 'CPF', `rg_cli` 'CPF', `end_cli` 'Endereço', `bairro_cli` 'Bairro', `cidade_cli` 'Cidade', `estado_cli`'Estado', `cep_cli` 'CEP', `email_cli` 'Email', `tel_cli` 'Telefone' FROM `tb_cliente`;";
			resultset = stmt.executeQuery(sql);
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			return resultset;
		}

	}
	
	//Metodo Pesquisa
	@SuppressWarnings("finally")
	public ResultSet pesquisarCliente(String id, String nome){
		BancoDeDados conn = new BancoDeDados();
		ResultSet resultset = null;
		
		try{
			Connection ExConn = conn.conectar();
			Statement stmt = ExConn.createStatement();
			String sql = "SELECT `id_cliente` 'Código', `nome_cli` 'Nome', `dt_cli` 'Data Nascimento', `cpf_cli` 'CPF', `rg_cli` 'CPF', `end_cli` 'Endereço', `bairro_cli` 'Bairro', `cidade_cli` 'Cidade', `estado_cli`'Estado', `cep_cli` 'CEP', `email_cli` 'Email', `tel_cli` 'Telefone' FROM `tb_cliente` WHERE id_cliente = \""+id+"\" OR nome_cli =  \""+nome+"\";";
			resultset = stmt.executeQuery(sql);
			System.out.println(sql);
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			return resultset;
		}

	}
		
	
}
