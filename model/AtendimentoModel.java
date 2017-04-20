package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import conexao.BancoDeDados;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 15/04/2017
 * @version 1.0
 *
 */

public class AtendimentoModel {
	
	//Metodo popular jtable Atendimentos
	@SuppressWarnings("finally")
	public ResultSet popularTabela(){
		BancoDeDados conn = new BancoDeDados();
		ResultSet resultset = null;
		
		try{
			Connection ExConn = conn.conectar();
			Statement stmt = ExConn.createStatement();
			String sql = "SELECT cm.id_chamado \" Código do chamado\",c.nome_cli \"Nome Cliente\", f.nome_fun \"Nome funcionário\", "
					+ "cm.atendimento_chamado \" Atendimento\", cm.data_inicio_chamado \"Inicio do chamado\", cm.data_encerramento_chamado \"Data encerramento\", cm.motivo_chamado \" Motivo do chamado\", "
					+ "cm.desc_chamado \"Descrição\", cm.status_chamado \"Status\" FROM tb_chamado AS cm "
					+ "inner join tb_cliente as c on cm.id_cli = c.id_cliente "
					+ "inner join tb_funcionario as f on cm.id_fun = f.id_fun ORDER BY cm.status_chamado DESC; ";
			resultset = stmt.executeQuery(sql);
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			return resultset;
		}

	}
	
	
	//Atualiza banco tabela chamado
	public String atualizaDados(String id, String status){
		BancoDeDados banco = new BancoDeDados();
		String retorno = "erro";
				
		Date hoje = new Date();
		SimpleDateFormat df;
		df = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			Connection ExConn = banco.conectar();
			Statement stmt = ExConn.createStatement();
			String sql = "UPDATE tb_chamado SET status_chamado =\" "+status+"\", data_encerramento_chamado = \""+df.format(hoje)+ "\" WHERE id_chamado = \""+id+"\"";
			System.out.println(sql);
			stmt.execute(sql);
			
			JOptionPane.showMessageDialog(null,"Status modificado com sucesso");
			stmt.close();
			banco.fecharConexao();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Status ser alterados com sucesso");
		}finally{
			banco.fecharConexao();
		}
		
		return retorno;
	}
	
	//Excluir chamado
	public String excluirDados(String id){
		BancoDeDados banco = new BancoDeDados();
		String retorno = "erro";
		
		try{
			Connection ExConn = banco.conectar();
			Statement stmt = ExConn.createStatement();
			String sql = "DELETE FROM tb_chamado WHERE id_chamado = \""+id+"\"";
			stmt.execute(sql);
			
			JOptionPane.showMessageDialog(null,"Status excluido com sucesso");
			stmt.close();
			banco.fecharConexao();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao excluir status: " + e);
		}finally{
			banco.fecharConexao();
		}
		
		return retorno;
	}
	
	//Metodo pesquisar chamados
	@SuppressWarnings("finally")
	public ResultSet pesquisarChamado(String id, String nome){
		BancoDeDados conn = new BancoDeDados();
		ResultSet resultset = null;
		
		try{
			Connection ExConn = conn.conectar();
			Statement stmt = ExConn.createStatement();
			String sql = "SELECT cm.id_chamado \" Código do chamado\",c.nome_cli \"Nome Cliente\", f.nome_fun \"Nome funcionário\", "
					+ "cm.atendimento_chamado \" Atendimento\",cm.data_inicio_chamado \"Inicio do chamado\", cm.data_encerramento_chamado \"Data encerramento\", cm.motivo_chamado \" Motivo do chamado\", "
					+ "cm.desc_chamado \"Descrição\", cm.status_chamado \"Status\" FROM tb_chamado AS cm "
					+ "inner join tb_cliente as c on cm.id_cli = c.id_cliente "
					+ "inner join tb_funcionario as f on cm.id_fun = f.id_fun "
					+ "WHERE cm.id_chamado = \""+id+"\" OR nome_cli =  \""+nome+"\";";
			resultset = stmt.executeQuery(sql);
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			return resultset;
		}

	}
	
	
	

}
