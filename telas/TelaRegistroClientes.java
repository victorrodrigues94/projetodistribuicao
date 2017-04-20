package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.RegistroClientesModel;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 17/04/2017
 * @version 1.0
 *
 */

public class TelaRegistroClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtId;
	private JLabel lblCdigo;
	private JTextField txtNome;
	private JLabel lblNome;
	private JButton btnPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRegistroClientes frame = new TelaRegistroClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaRegistroClientes() {
		
		RegistroClientesModel rcc = new RegistroClientesModel();
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1356, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 74, 1320, 562);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(DbUtils.resultSetToTableModel(rcc.popularTabela()));
		
		txtId = new JTextField();
		txtId.setBounds(20, 36, 155, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(20, 21, 46, 14);
		contentPane.add(lblCdigo);
		
		txtNome = new JTextField();
		txtNome.setBounds(201, 36, 184, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(201, 21, 46, 14);
		contentPane.add(lblNome);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(TelaRegistroClientes.class.getResource("/imagens/icon_pesq.png")));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id   = txtId.getText();
				String nome = txtNome.getText();
				
				if (id.equals("") && nome.equals("")){
					table.setModel(DbUtils.resultSetToTableModel(rcc.popularTabela()));
				}else{
					table.setModel(DbUtils.resultSetToTableModel(rcc.pesquisarCliente(id, nome)));
				}
				
			}
		});
		btnPesquisar.setBounds(395, 30, 46, 33);
		contentPane.add(btnPesquisar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaCadCliente frameCadCli = new TelaCadCliente();
					frameCadCli.setLocationRelativeTo(null);
					frameCadCli.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel.setIcon(new ImageIcon(TelaRegistroClientes.class.getResource("/imagens/icon_addicionar.png")));
		lblNewLabel.setBounds(1292, 47, 22, 23);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(DbUtils.resultSetToTableModel(rcc.popularTabela()));
				txtId.setText("");
				txtNome.setText("");
			}
		});
		label.setIcon(new ImageIcon(TelaRegistroClientes.class.getResource("/imagens/icon_refresh.png")));
		label.setBounds(1318, 47, 22, 23);
		contentPane.add(label);
	}
}
