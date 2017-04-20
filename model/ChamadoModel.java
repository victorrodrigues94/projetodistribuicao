package model;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.BancoDeDados;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 15/04/2017
 * @version 1.0
 *
 */

public class ChamadoModel {
	
	//função popular combobox cliente 
	public List<String> popularComboBoxCliente(){
		BancoDeDados conn = new BancoDeDados();
		ResultSet resultset = null;
		List<String> strList = new ArrayList<String>();
		
		try{
			Connection ExConn = conn.conectar();
			Statement stmt = ExConn.createStatement();
			String sql = "SELECT id_cliente FROM tb_cliente ORDER BY nome_cli;";
			resultset = stmt.executeQuery(sql);
			
			while(resultset.next()){
				strList.add(resultset.getString("id_cliente"));
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			conn.fecharConexao();
		}
		return strList;
	}
	
	
	//função popular combobox atendente
		public List<String> popularComboBoxAtendente(){
			BancoDeDados conn = new BancoDeDados();
			ResultSet resultset = null;
			List<String> strList = new ArrayList<String>();
			
			try{
				Connection ExConn = conn.conectar();
				Statement stmt = ExConn.createStatement();
				String sql = "SELECT id_fun FROM tb_funcionario WHERE funcao_fun = 'Atendente' ORDER BY nome_fun;";
				resultset = stmt.executeQuery(sql);
				
				while(resultset.next()){
					strList.add(resultset.getString("id_fun"));
				}
			}catch(SQLException e){
				System.out.println(e);
			}finally{
				conn.fecharConexao();
			}
			return strList;
		}
		
		//Buscar nome do cliente por Id		
		public String preencherTextFieldCli(String id){
			BancoDeDados conn = new BancoDeDados();
			ResultSet resultset = null;
			String result = null;
			
			try {
				Connection ExConn = conn.conectar();
				Statement stmt = ExConn.createStatement();
				String sql = "SELECT nome_cli FROM tb_cliente WHERE id_cliente = \""+id+"\" ORDER BY id_cliente;";
				resultset = stmt.executeQuery(sql);
				resultset.first();
				result = resultset.getString("nome_cli");
				
			}catch(SQLException e){
				System.out.println(e);
			}
			
			return result;
		}
		
		//Buscar nome do atendente por Id		
		public String preencherTextFieldFun(String id){
			BancoDeDados conn = new BancoDeDados();
			ResultSet resultset = null;
			String result = null;
			
			try {
				Connection ExConn = conn.conectar();
				Statement stmt = ExConn.createStatement();
				String sql = "SELECT nome_fun FROM tb_funcionario WHERE id_fun = \""+id+"\";";
				resultset = stmt.executeQuery(sql);
				resultset.first();
				result = resultset.getString("nome_fun");
				
			}catch(SQLException e){
				System.out.println(e);
			}
			
			return result;
		}
		
		
		//Método inserir dados do formulário de chamados
		public String InsereDados(String idCliente, String idAtendente, String atendimento, String data, String motivo, String descricao){
			BancoDeDados banco = new BancoDeDados();
			String retorno = "erro";
			
			try{
				Connection ExConn = banco.conectar();
				Statement stmt = ExConn.createStatement();
				String sql = "INSERT INTO tb_chamado (id_cli, id_fun, atendimento_chamado, data_inicio_chamado, motivo_chamado, desc_chamado) "
						+ "VALUES (\""+idCliente+"\", \""+idAtendente+"\",\""+atendimento+"\", \""+data+"\", \""+motivo+"\", \""+descricao+"\");";
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
