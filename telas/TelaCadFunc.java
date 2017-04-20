package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.FuncionarioModel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 08/04/2017
 * @version 1.0
 *
 */

public class TelaCadFunc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField pSenha;
	private JTextField txtUser;
	private JTextField txtEmail;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtNome;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadFunc frame = new TelaCadFunc();
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
	 * @throws ParseException 
	 */
	public TelaCadFunc() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 771, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Telefone ");
		label.setBounds(468, 274, 52, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Fun\u00E7\u00E3o");
		label_1.setBounds(468, 323, 46, 14);
		contentPane.add(label_1);
		
		JFormattedTextField ftxtData = new JFormattedTextField();
		MaskFormatter       maskData = new MaskFormatter( "##/##/####" );
		maskData.install(ftxtData);
		ftxtData.setBounds(561, 139, 106, 20);
		contentPane.add(ftxtData);
		
		JFormattedTextField ftxtCPF = new JFormattedTextField();
		MaskFormatter       maskCPF = new MaskFormatter( "###.###.###-##" );
		maskCPF.install(ftxtCPF);
		ftxtCPF.setBounds(128, 139, 158, 20);
		contentPane.add(ftxtCPF);
		
		JFormattedTextField ftxtRG = new JFormattedTextField();
		MaskFormatter       maskRG = new MaskFormatter( "##.###.###-#" );
		maskRG.install(ftxtRG);
		ftxtRG.setBounds(337, 139, 141, 20);
		contentPane.add(ftxtRG);
		
		JFormattedTextField ftxtCEP = new JFormattedTextField();
		MaskFormatter       maskCEP = new MaskFormatter( "#####-###" );
		maskCEP.install(ftxtCEP);
		ftxtCEP.setBounds(521, 224, 146, 20);
		contentPane.add(ftxtCEP);
		
		JFormattedTextField ftxtTelefone  = new JFormattedTextField();
		MaskFormatter       maskTelefone = new MaskFormatter( "(##)#####-####" );
		maskTelefone.install(ftxtTelefone);
		ftxtTelefone.setBounds(521, 271, 146, 20);
		contentPane.add(ftxtTelefone);
		
		JComboBox<Object> cbFuncao = new JComboBox<Object>();
		cbFuncao.setModel(new DefaultComboBoxModel<Object>(new String[] {"Atendente", "T\u00E9cnico", "Desenvolvedor"}));
		cbFuncao.setBounds(521, 320, 146, 20);
		contentPane.add(cbFuncao);
		
		JComboBox<Object> cbEstado = new JComboBox<Object>();
		cbEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "PA\t ", "PB\t ", "PR\t ", "PE\t ", "PI\t ", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbEstado.setBounds(371, 224, 47, 20);
		contentPane.add(cbEstado);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int Confirm = JOptionPane.showConfirmDialog(null,"Encerrar?","sim ou nao", JOptionPane.YES_NO_OPTION);
			    if (Confirm == JOptionPane.YES_OPTION) {
			    	dispose();
			    } 
			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaCadFunc.class.getResource("/imagens/btnCancelar.png")));
		btnCancelar.setBounds(468, 437, 129, 36);
		contentPane.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome     = txtNome.getText();
				String cpf      = ftxtCPF.getText();
				String rg       = ftxtRG.getText();
				String cep      = ftxtCEP.getText();
				String endereco = txtEndereco.getText();
				String cidade   = txtCidade.getText();
				String email    = txtEmail.getText();
				String telefone = ftxtTelefone.getText();
				String bairro   = txtBairro.getText();
				String data     = ftxtData.getText();
				String estado   = cbEstado.getSelectedItem().toString();
				String funcao   = cbFuncao.getSelectedItem().toString();
				String user     = txtUser.getText();
				@SuppressWarnings("deprecation")
				String senha    = pSenha.getText();
				
				if(nome.equals("") || cpf.equals("") || rg.equals("") || cep.equals("") || endereco.equals("") || cidade.equals("") || email.equals("") || telefone.equals("") || bairro.equals("") || data.equals("") || txtUser.equals("") || pSenha.equals("")){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				}else{
					FuncionarioModel insere = new FuncionarioModel();
					insere.InsereDados (nome, data, cpf, rg, endereco, bairro, cidade, estado, cep, email, telefone, user, funcao, senha );
					txtNome.setText("");
					txtEndereco.setText("");
					txtBairro.setText("");
					txtCidade.setText("");
					txtEmail.setText("");
					txtEmail.setText("");
					txtUser.setText("");
					pSenha.setText("");
					ftxtTelefone.setText("");
					ftxtCEP.setText("");
					ftxtRG.setText("");
					ftxtCPF.setText("");
					ftxtData.setText("");
				}
			}
		});
		btnCadastrar.setIcon(new ImageIcon(TelaCadFunc.class.getResource("/imagens/btnCadastrar.png")));
		btnCadastrar.setBounds(146, 437, 138, 36);
		contentPane.add(btnCadastrar);
		
		pSenha = new JPasswordField();
		pSenha.setBounds(128, 368, 290, 20);
		contentPane.add(pSenha);
		
		JLabel label_2 = new JLabel("Senha");
		label_2.setBounds(84, 371, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Usu\u00E1rio");
		label_3.setBounds(84, 323, 46, 14);
		contentPane.add(label_3);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(128, 320, 290, 20);
		contentPane.add(txtUser);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(128, 271, 290, 20);
		txtEmail.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String email = txtEmail.getText().trim();
				Pattern p = Pattern.compile(".+@.@\\.[a-z]+");
				Matcher m = p.matcher(email);
				boolean matchFound = m.matches();
				
				if(matchFound){
					System.out.println("Valido");
				}else{
					System.out.println("Invalido");
				}
				
			}
			
		});
		contentPane.add(txtEmail);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setBounds(94, 274, 46, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Cidade");
		label_5.setBounds(84, 227, 46, 14);
		contentPane.add(label_5);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(128, 224, 181, 20);
		contentPane.add(txtCidade);
		
		JLabel label_6 = new JLabel("Estado");
		label_6.setBounds(327, 227, 46, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("CEP");
		label_7.setBounds(485, 227, 46, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Bairro");
		label_8.setBounds(474, 182, 46, 14);
		contentPane.add(label_8);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(521, 179, 146, 20);
		contentPane.add(txtBairro);
		
		JLabel label_9 = new JLabel("RG");
		label_9.setBounds(313, 142, 46, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Data nasc");
		label_10.setBounds(501, 142, 61, 14);
		contentPane.add(label_10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(128, 103, 539, 20);
		contentPane.add(txtNome);
		
		JLabel label_11 = new JLabel("Nome");
		label_11.setBounds(84, 106, 46, 14);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("CPF");
		label_12.setBounds(93, 145, 26, 14);
		contentPane.add(label_12);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(128, 179, 293, 20);
		contentPane.add(txtEndereco);
		
		JLabel label_13 = new JLabel("Endere\u00E7o");
		label_13.setBounds(69, 182, 85, 14);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("Cadastro de funcionarios/usu\u00E1rios");
		label_14.setForeground(new Color(30, 144, 255));
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_14.setBounds(230, 23, 312, 36);
		contentPane.add(label_14);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtEndereco.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				txtEmail.setText("");
				txtEmail.setText("");
				txtUser.setText("");
				pSenha.setText("");
				ftxtTelefone.setText("");
				ftxtCEP.setText("");
				ftxtRG.setText("");
				ftxtCPF.setText("");
				ftxtData.setText("");
				
			}
		});
		btnLimpar.setIcon(new ImageIcon(TelaCadFunc.class.getResource("/imagens/btnLimpar.png")));
		btnLimpar.setBounds(313, 437, 129, 36);
		contentPane.add(btnLimpar);
		
		JLabel label_15 = new JLabel("Ver todos ");
		label_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaRegistroFuncionarios frameRegistroFun = new TelaRegistroFuncionarios();
				frameRegistroFun.setLocationRelativeTo(null);
				frameRegistroFun.setVisible(true);                                                                         	
			}
		});
		label_15.setForeground(new Color(30, 144, 255));
		label_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_15.setBounds(660, 490, 85, 14);
		contentPane.add(label_15);
	}
}
