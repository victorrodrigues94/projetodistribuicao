package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.ClienteModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
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

public class TelaCadCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtBairro;
	private JTextField txtEnd;
	private JTextField txtCidade;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadCliente frame = new TelaCadCliente();
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
	public TelaCadCliente() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 648, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeClientes = new JLabel("Cadastro de clientes");
		lblCadastroDeClientes.setForeground(new Color(30, 144, 255));
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastroDeClientes.setBounds(217, 27, 188, 38);
		contentPane.add(lblCadastroDeClientes);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 112, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 188, 85, 14);
		contentPane.add(lblEndereo);
		
		JLabel lblNewLabel = new JLabel("CNPJ/CPF");
		lblNewLabel.setBounds(10, 151, 61, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIerg = new JLabel("RG");
		lblIerg.setBounds(268, 154, 46, 14);
		contentPane.add(lblIerg);
		
		JLabel lblDataNasc = new JLabel("Data nasc");
		lblDataNasc.setBounds(468, 154, 61, 14);
		contentPane.add(lblDataNasc);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(415, 188, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(25, 233, 46, 14);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(268, 233, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(426, 233, 46, 14);
		contentPane.add(lblCep);
		
		JLabel lblTelefoneResidncial = new JLabel("Telefone ");
		lblTelefoneResidncial.setBounds(409, 280, 52, 14);
		contentPane.add(lblTelefoneResidncial);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(35, 280, 46, 14);
		contentPane.add(lblEmail);
		
		txtNome = new JTextField();
		txtNome.setBounds(69, 109, 539, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(462, 185, 146, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JComboBox<Object> cbEstado = new JComboBox<Object>();
		cbEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "PA\t ", "PB\t ", "PR\t ", "PE\t ", "PI\t ", "RJ\t ", "RN\t ", "RS\t ", "RO\t ", "RR\t ", "SC\t ", "SP\t ", "SE\t ", "TO"}));
		cbEstado.setBounds(312, 230, 47, 20);
		contentPane.add(cbEstado);
		
		txtEnd = new JTextField();
		txtEnd.setBounds(69, 185, 293, 20);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(69, 230, 181, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(69, 277, 245, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JFormattedTextField ftxtData = new JFormattedTextField();
		MaskFormatter       maskData = new MaskFormatter( "##/##/####" );
		maskData.install(ftxtData);
		ftxtData.setBounds(530, 151, 78, 20);
		contentPane.add(ftxtData);
		
		JFormattedTextField ftxtRG = new JFormattedTextField();
		MaskFormatter       maskRG = new MaskFormatter( "##.###.###-#" );
		maskRG.install(ftxtRG);
		ftxtRG.setBounds(290, 151, 146, 20);
		contentPane.add(ftxtRG);
		
		JFormattedTextField ftxtCPF = new JFormattedTextField();
		MaskFormatter       maskCPF = new MaskFormatter( "###.###.###-##" );
		maskCPF.install(ftxtCPF);
		ftxtCPF.setBounds(69, 148, 146, 20);
		contentPane.add(ftxtCPF);
		
		JFormattedTextField ftxtCEP = new JFormattedTextField();
		MaskFormatter       maskCEP = new MaskFormatter( "#####-###" );
		maskCEP.install(ftxtCEP);
		ftxtCEP.setBounds(462, 230, 146, 20);
		contentPane.add(ftxtCEP);
		
		JFormattedTextField ftxtTel = new JFormattedTextField();
		MaskFormatter       maskTel = new MaskFormatter( "(##)#####-####" );
		maskTel.install(ftxtTel);
		ftxtTel.setBounds(462, 277, 146, 20);
		contentPane.add(ftxtTel);
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome     = txtNome.getText();
				String cpf      = ftxtCPF.getText();
				String rg       = ftxtRG.getText();
				String cep      = ftxtCEP.getText();
				String endereco = txtEnd.getText();
				String cidade   = txtCidade.getText();
				String email    = txtEmail.getText();
				String telefone = ftxtTel.getText();
				String bairro   = txtBairro.getText();
				String data     = ftxtData.getText();
				String estado   = cbEstado.getSelectedItem().toString();
				
				if(nome.equals("") || cpf.equals("") || rg.equals("") || cep.equals("") || endereco.equals("") || cidade.equals("") || email.equals("") || telefone.equals("") || bairro.equals("") || data.equals("")){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				}else{
					ClienteModel insere = new ClienteModel();
					insere.InsereDados (nome, data, cpf, rg, endereco, bairro, cidade, estado, cep, email, telefone );
					txtNome.setText("");
					ftxtData.setText("");
					ftxtCPF.setText("");
					ftxtRG.setText("");
					ftxtCEP.setText("");
					txtEnd.setText("");
					txtCidade.setText("");
					txtEmail.setText("");
					ftxtTel.setText("");
					txtBairro.setText("");
				}

			}
		});
		btnCadastrar.setIcon(new ImageIcon(TelaCadCliente.class.getResource("/imagens/btnCadastrar.png")));
		btnCadastrar.setBounds(79, 346, 138, 36);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Confirm = JOptionPane.showConfirmDialog(null,"Encerrar?","sim ou nao", JOptionPane.YES_NO_OPTION);
			    if (Confirm == JOptionPane.YES_OPTION) {
			    	dispose();
			    } 
			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaCadCliente.class.getResource("/imagens/btnCancelar.png")));
		btnCancelar.setBounds(403, 346, 129, 36);
		contentPane.add(btnCancelar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				ftxtData.setText("");
				ftxtCPF.setText("");
				ftxtRG.setText("");
				ftxtCEP.setText("");
				txtEnd.setText("");
				txtCidade.setText("");
				txtEmail.setText("");
				ftxtTel.setText("");
				txtBairro.setText("");
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaCadCliente.class.getResource("/imagens/btnLimpar.png")));
		btnNewButton.setBounds(242, 346, 138, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblVerTodos = new JLabel("Ver todos ");
		lblVerTodos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaRegistroClientes frameRegistroCli = new TelaRegistroClientes();
				frameRegistroCli.setVisible(true);
			}
		});
		lblVerTodos.setForeground(new Color(30, 144, 255));
		lblVerTodos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVerTodos.setBounds(537, 403, 85, 14);
		contentPane.add(lblVerTodos);
		
	}
	
	public void limpaCampos(){
		
	}
}
