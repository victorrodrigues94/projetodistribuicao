package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.RegistroFuncionariosModel;
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

public class TelaRegistroFuncionarios extends JFrame {

	/**
	 * 
	 * @author Victor Augusto Rodrigues
	 * @since 17/04/2017
	 * @version 1.0
	 *
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtId;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRegistroFuncionarios frame = new TelaRegistroFuncionarios();
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
	public TelaRegistroFuncionarios() {
		
		RegistroFuncionariosModel rfc = new RegistroFuncionariosModel();
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1231, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 92, 1195, 559);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(DbUtils.resultSetToTableModel(rfc.popularTabela()));
		scrollPane.setViewportView(table);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(83, 50, 155, 20);
		contentPane.add(txtId);
		
		JLabel label = new JLabel("C\u00F3digo");
		label.setBounds(83, 34, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Nome");
		label_1.setBounds(266, 34, 46, 14);
		contentPane.add(label_1);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(266, 50, 184, 20);
		contentPane.add(txtNome);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(TelaRegistroFuncionarios.class.getResource("/imagens/icon_pesq.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id   = txtId.getText();
				String nome = txtNome.getText();
				
				if (id.equals("") && nome.equals("")){
					table.setModel(DbUtils.resultSetToTableModel(rfc.popularTabela()));
				}else{
					table.setModel(DbUtils.resultSetToTableModel(rfc.pesquisarFuncionario(id, nome)));
				}
			}
		});
		button.setBounds(453, 42, 46, 36);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaCadFunc frameCadFun = new TelaCadFunc();
					frameCadFun.setLocationRelativeTo(null);
					frameCadFun.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		label_2.setIcon(new ImageIcon(TelaRegistroFuncionarios.class.getResource("/imagens/icon_addicionar.png")));
		label_2.setBounds(1230, 67, 22, 23);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtId.setText("");
				txtNome.setText("");
				table.setModel(DbUtils.resultSetToTableModel(rfc.popularTabela()));
			}
		});
		label_3.setIcon(new ImageIcon(TelaRegistroFuncionarios.class.getResource("/imagens/icon_refresh.png")));
		label_3.setBounds(1256, 67, 22, 23);
		contentPane.add(label_3);
	}

}
