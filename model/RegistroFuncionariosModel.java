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

public class RegistroFuncionariosModel {

		//Metodo popular jtable Registro de Funcionarios
		@SuppressWarnings("finally")
		public ResultSet popularTabela(){
			BancoDeDados conn = new BancoDeDados();
			ResultSet resultset = null;
			
			try{
				Connection ExConn = conn.conectar();
				Statement stmt = ExConn.createStatement();
				String sql = "SELECT `id_fun` 'Código', `nome_fun` 'Nome', `cpf_fun` 'CPF', `rg_fun`'RG', `dtnasc_fun` 'Data Nascimento', `end_fun` 'Endereço', `bairro_fun` 'Bairro', `cidade_fun` 'Cidade', `estado_fun` 'Estado', `cep_fun` 'CEP', `email_fun` 'Email', `tel_fun` 'Telefone', `user_fun` 'Usuario', `funcao_fun` 'Função' FROM `tb_funcionario`;";
				resultset = stmt.executeQuery(sql);
			}catch(SQLException e){
				System.out.println(e);
			}finally{
				return resultset;
			}

		}
		
		//Metodo Pesquisa
		@SuppressWarnings("finally")
		public ResultSet pesquisarFuncionario(String id, String nome){
			BancoDeDados conn = new BancoDeDados();
			ResultSet resultset = null;
			
			try{
				Connection ExConn = conn.conectar();
				Statement stmt = ExConn.createStatement();
				String sql = "SELECT `id_fun` 'Código', `nome_fun` 'Nome', `cpf_fun` 'CPF', `rg_fun`'RG', `dtnasc_fun` 'Data Nascimento', `end_fun` 'Endereço', `bairro_fun` 'Bairro', `cidade_fun` 'Cidade', `estado_fun` 'Estado', `cep_fun` 'CEP', `email_fun` 'Email', `tel_fun` 'Telefone', `user_fun` 'Usuario', `funcao_fun` 'Função' FROM `tb_funcionario` WHERE id_fun = \""+id+"\" OR nome_fun =  \""+nome+"\";";
				resultset = stmt.executeQuery(sql);
			}catch(SQLException e){
				System.out.println(e);
			}finally{
				return resultset;
			}

		}
}
