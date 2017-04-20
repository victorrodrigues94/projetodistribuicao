package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.AtendimentoModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 08/04/2017
 * @version 1.0
 *
 */

public class TelaAtendimento extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AtendimentoModel ac = new AtendimentoModel();
	List<String> tabela = new ArrayList<String>();
	
	private JPanel contentPane;
	private JTextField txtIdChamado;
	private JTextField txtNomeCli;
	private JTable table;
	private JTextField txtPesqIdChamado;
	private JTextField txtPesqNomeCli;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtendimento frame = new TelaAtendimento();
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
	public TelaAtendimento() {
		
		AtendimentoModel ac = new AtendimentoModel();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1116, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoChamado = new JLabel("C\u00F3digo chamado");
		lblCdigoChamado.setBounds(10, 66, 95, 14);
		contentPane.add(lblCdigoChamado);
		
		JLabel lblNomeCliente = new JLabel("Nome cliente");
		lblNomeCliente.setBounds(126, 66, 85, 14);
		contentPane.add(lblNomeCliente);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(490, 66, 46, 14);
		contentPane.add(lblStatus);
		
		txtIdChamado = new JTextField();
		txtIdChamado.setEnabled(false);
		txtIdChamado.setBounds(10, 87, 95, 20);
		contentPane.add(txtIdChamado);
		txtIdChamado.setColumns(10);
		
		txtNomeCli = new JTextField();
		txtNomeCli.setEnabled(false);
		txtNomeCli.setBounds(126, 87, 338, 20);
		contentPane.add(txtNomeCli);
		txtNomeCli.setColumns(10);
		
		JComboBox<Object> cbStatus = new JComboBox<Object>();
		cbStatus.setModel(new DefaultComboBoxModel<Object>(new String[] {"Em andamento", "Concluido"}));
		cbStatus.setBounds(490, 87, 143, 20);
		contentPane.add(cbStatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 1080, 344);
		contentPane.add(scrollPane);
		
		table= new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for (int i = 0; i < table.getRowCount(); i++){
					if(table.isRowSelected(i)){
						String valorId = table.getValueAt(i, 0).toString();
						txtIdChamado.setText(valorId);
						String valorNome = table.getValueAt(i, 1).toString();
						
						txtNomeCli.setText(valorNome);
						String valorStatus = table.getValueAt(i, 8).toString();
						cbStatus.setSelectedItem(valorStatus);
					}
				}
			}
		});
		
		scrollPane.setViewportView(table);
		table.setModel(DbUtils.resultSetToTableModel(ac.popularTabela()));
		
		JButton btnAtualiza = new JButton("");
		btnAtualiza.setIcon(new ImageIcon(TelaAtendimento.class.getResource("/imagens/btnAtualizar.png")));
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id     = txtIdChamado.getText();
				String status = cbStatus.getSelectedItem().toString();
				if (status.equals("Concluido")){
					ac.atualizaDados(id, status);
					table.setModel(DbUtils.resultSetToTableModel(ac.popularTabela()));
				}
				
				
			}
		});
		btnAtualiza.setBounds(416, 134, 85, 23);
		contentPane.add(btnAtualiza);
		
		JButton btnExcluirChamado = new JButton("");
		btnExcluirChamado.setIcon(new ImageIcon(TelaAtendimento.class.getResource("/imagens/btnExcluir.png")));
		btnExcluirChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Confirm = JOptionPane.showConfirmDialog(null,"Deseja excluir esse chamado?","sim ou nao", JOptionPane.YES_NO_OPTION);
			    if (Confirm == JOptionPane.YES_OPTION) {
			    	String id = txtIdChamado.getText();
			    	ac.excluirDados(id);
			    	table.setModel(DbUtils.resultSetToTableModel(ac.popularTabela()));
			    	
			    } 
			}
		});
		btnExcluirChamado.setBounds(321, 134, 85, 23);
		contentPane.add(btnExcluirChamado);
		
		txtPesqIdChamado = new JTextField();
		txtPesqIdChamado.setColumns(10);
		txtPesqIdChamado.setBounds(10, 30, 95, 20);
		contentPane.add(txtPesqIdChamado);
		
		JLabel lblCdigoDoChamado = new JLabel("C\u00F3digo chamado ");
		lblCdigoDoChamado.setBounds(10, 9, 95, 14);
		contentPane.add(lblCdigoDoChamado);
		
		JLabel lblNomeCliente_1 = new JLabel("Nome Cliente");
		lblNomeCliente_1.setBounds(126, 9, 74, 14);
		contentPane.add(lblNomeCliente_1);
		
		txtPesqNomeCli = new JTextField();
		txtPesqNomeCli.setColumns(10);
		txtPesqNomeCli.setBounds(126, 30, 338, 20);
		contentPane.add(txtPesqNomeCli);
		
		JButton btnPesq = new JButton("");
		btnPesq.setIcon(new ImageIcon(TelaAtendimento.class.getResource("/imagens/icon_pesq.png")));
		btnPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id     = txtPesqIdChamado.getText();
				String nome   = txtPesqNomeCli.getText();
				
				if (id.equals("") && nome.equals("")){
					table.setModel(DbUtils.resultSetToTableModel(ac.popularTabela()));
				}else{
					table.setModel(DbUtils.resultSetToTableModel(ac.pesquisarChamado(id, nome)));
				}
			}
		});
		btnPesq.setBounds(489, 22, 46, 33);
		contentPane.add(btnPesq);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(DbUtils.resultSetToTableModel(ac.popularTabela()));
			}
		});
		lblNewLabel.setIcon(new ImageIcon(TelaAtendimento.class.getResource("/imagens/icon_refresh.png")));
		lblNewLabel.setBounds(786, 144, 22, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaChamado frameChamado = null;
				try {
					frameChamado = new TelaChamado();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frameChamado.setVisible(true);			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(TelaAtendimento.class.getResource("/imagens/icon_addicionar.png")));
		lblNewLabel_1.setBounds(761, 144, 22, 23);
		contentPane.add(lblNewLabel_1);
		
		
		}
}
