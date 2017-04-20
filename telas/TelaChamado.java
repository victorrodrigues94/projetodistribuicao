package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ChamadoModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 08/04/2017
 * @version 1.0
 *
 */

public class TelaChamado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCli;
	private JTextField txtFun;
	private JTextField txtDtChamado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaChamado frame = new TelaChamado();
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
	public TelaChamado() throws ParseException {
		
		ChamadoModel cc = new ChamadoModel();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 681, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("C\u00F3digo Cliente");
		lblCliente.setBounds(24, 69, 94, 14);
		contentPane.add(lblCliente);
		
		JComboBox<Object> cbCliente = new JComboBox<Object>();
		cbCliente.setModel(new DefaultComboBoxModel<Object>(cc.popularComboBoxCliente().toArray()));
		cbCliente.setBounds(114, 66, 101, 20);
		contentPane.add(cbCliente);
		
		JLabel lblFuncionrio = new JLabel("C\u00F3digo Atendente");
		lblFuncionrio.setBounds(10, 161, 117, 14);
		contentPane.add(lblFuncionrio);
		
		JComboBox<Object> cbAtendente = new JComboBox<Object>();
		cbAtendente.setModel(new DefaultComboBoxModel<Object>(cc.popularComboBoxAtendente().toArray()));
		cbAtendente.setBounds(114, 160, 101, 20);
		contentPane.add(cbAtendente);
		
		JLabel lblProblema = new JLabel("Motivo");
		lblProblema.setBounds(255, 293, 46, 14);
		contentPane.add(lblProblema);
		
		JTextArea taDescricao = new JTextArea();
		taDescricao.setBounds(24, 387, 600, 133);
		contentPane.add(taDescricao);
		
		JComboBox<Object> cbMotivo = new JComboBox<Object>();
		cbMotivo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Instala\u00E7\u00E3o", "Problemas"}));
		cbMotivo.setBounds(308, 290, 99, 20);
		contentPane.add(cbMotivo);
		
		JLabel lblDataDoChamado = new JLabel("Data");
		lblDataDoChamado.setBounds(458, 293, 39, 14);
		contentPane.add(lblDataDoChamado);
		
		JLabel lblAtendimento = new JLabel("Atendimento");
		lblAtendimento.setBounds(23, 293, 88, 14);
		contentPane.add(lblAtendimento);
		
		JComboBox<Object> cbAtendimento = new JComboBox<Object>();
		cbAtendimento.setModel(new DefaultComboBoxModel<Object>(new String[] {"Online", "Telefone"}));
		cbAtendimento.setBounds(101, 287, 99, 20);
		contentPane.add(cbAtendimento);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String idCliente   = cbCliente.getSelectedItem().toString();
				String atendente   = cbAtendente.getSelectedItem().toString();
				String atendimento = cbAtendimento.getSelectedItem().toString();
				String dtChamado   = txtDtChamado.getText();
				String motivo      = cbMotivo.getSelectedItem().toString();
				String descricao   = taDescricao.getText();
			
				cc.InsereDados(idCliente, atendente, atendimento, dtChamado, motivo, descricao);
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaChamado.class.getResource("/imagens/btnAbrir.png")));
		btnNewButton.setBounds(140, 531, 138, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Confirm = JOptionPane.showConfirmDialog(null,"Encerrar?","sim ou nao", JOptionPane.YES_NO_OPTION);
			    if (Confirm == JOptionPane.YES_OPTION) {
			    	dispose();
			    } 
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(TelaChamado.class.getResource("/imagens/btnCancelar.png")));
		btnNewButton_1.setBounds(320, 531, 138, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblAbrirChamando = new JLabel("Abrir chamando");
		lblAbrirChamando.setForeground(new Color(30, 144, 255));
		lblAbrirChamando.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAbrirChamando.setBounds(255, 11, 188, 38);
		contentPane.add(lblAbrirChamando);
		
		JLabel lblDescrioDoProblema = new JLabel("Descri\u00E7\u00E3o");
		lblDescrioDoProblema.setBounds(24, 363, 164, 14);
		contentPane.add(lblDescrioDoProblema);
		
		JLabel lblVerTodos = new JLabel("Ver todos ");
		lblVerTodos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaAtendimento frameAtendimento = new TelaAtendimento();
				frameAtendimento.setLocationRelativeTo(null);
				frameAtendimento.setVisible(true);
				dispose();
			}
		});
		lblVerTodos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVerTodos.setForeground(new Color(30, 144, 255));
		lblVerTodos.setBounds(567, 591, 88, 14);
		contentPane.add(lblVerTodos);
		
		txtCli = new JTextField();
		txtCli.setEnabled(false);
		txtCli.setBounds(114, 94, 101, 20);
		contentPane.add(txtCli);
		txtCli.setColumns(10);
		
		txtFun = new JTextField();
		txtFun.setEnabled(false);
		txtFun.setColumns(10);
		txtFun.setBounds(114, 188, 101, 20);
		contentPane.add(txtFun);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFun.setText(cc.preencherTextFieldFun(cbAtendente.getSelectedItem().toString()));
			}
		});
		btnPesquisar.setBounds(225, 171, 119, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnPesquisar_1 = new JButton("Pesquisar");
		btnPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCli.setText(cc.preencherTextFieldCli(cbCliente.getSelectedItem().toString()));
			}
		});
		btnPesquisar_1.setBounds(225, 78, 117, 23);
		contentPane.add(btnPesquisar_1);		
		
		txtDtChamado = new JTextField();
		txtDtChamado.setEnabled(false);
		txtDtChamado.setBounds(491, 290, 86, 20);
		contentPane.add(txtDtChamado);
		txtDtChamado.setColumns(10);
		
		Date hoje = new Date();
		SimpleDateFormat df;
		df = new SimpleDateFormat("dd/MM/yyyy");
		txtDtChamado.setText(df.format(hoje));
		
		JLabel lblNomeAtendente = new JLabel("Nome Atendente");
		lblNomeAtendente.setBounds(20, 194, 94, 14);
		contentPane.add(lblNomeAtendente);
		
		JLabel lblNomeCliente = new JLabel("Nome Cliente");
		lblNomeCliente.setBounds(34, 97, 77, 14);
		contentPane.add(lblNomeCliente);
		
		JButton btnNewButton_2 = new JButton("Ver Todos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRegistroClientes frameRegCli = new TelaRegistroClientes();
				frameRegCli.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(352, 78, 127, 23);
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton("Ver Todos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRegistroFuncionarios frameRegFun = new TelaRegistroFuncionarios();
				frameRegFun.setVisible(true);
			}
		});
		button.setBounds(354, 171, 127, 23);
		contentPane.add(button);
		
	}
}
