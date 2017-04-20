package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 08/04/2017
 * @version 1.0
 *
 */

public class BancoDeDados {
	private Connection connection = null;
	public Statement statement = null;
	public ResultSet resultset = null;
	
	//função para conectar com o banco
	public Connection conectar(){
		String servidor = "jdbc:mysql://localhost:3306/bd_projeto?useSSL=false"; // ?useSSL=false tira o warning 
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.jdbc.Driver";
		
		try{
			//conexão com o banco de dados mysql
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			System.out.println("Conectado com sucesso");
		}catch(Exception e){
			System.out.println(("Erro: " + e.getMessage()));
		}
		return connection;
	}
	
	public boolean estaConectado(){
		if(this.connection != null){
			return true;
		}else{
			return false;
		}
	}
	
	//função para fechar o banco
	public void fecharConexao(){
		try{
			this.connection.close();
			System.out.println("Conexão fechada com sucesso");
		}catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
}
