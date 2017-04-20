package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.LoginModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 08/04/2017
 * @version 1.0
 *
 */

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JLabel lblEntreComSuas;
	private JPasswordField ftxtPassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio ");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsurio.setBounds(58, 82, 84, 14);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(58, 129, 46, 14);
		contentPane.add(lblSenha);
		
		txtUser = new JTextField();
		txtUser.setForeground(new Color(0, 0, 0));
		txtUser.setBounds(119, 75, 190, 31);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		ftxtPassword = new JPasswordField();
		ftxtPassword.setBounds(119, 122, 190, 31);
		contentPane.add(ftxtPassword);
		
		JButton btnLogar = new JButton("");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user     = txtUser.getText();
				@SuppressWarnings("deprecation")
				String password = ftxtPassword.getText();
				
				LoginModel logar = new LoginModel();
				logar.acessarSistema(user, password);
				dispose();
				
			}
		});
		btnLogar.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/btnEntrar.png")));
		btnLogar.setBounds(126, 192, 143, 40);
		contentPane.add(btnLogar);
		
		lblEntreComSuas = new JLabel(" Entre com suas informa\u00E7\u00F5es");
		lblEntreComSuas.setForeground(new Color(100, 149, 237));
		lblEntreComSuas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEntreComSuas.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/info.png")));
		lblEntreComSuas.setBounds(70, 23, 291, 27);
		contentPane.add(lblEntreComSuas);
		
		
	}
}
