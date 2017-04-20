package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Victor Augusto Rodrigues
 * @since 08/04/2017
 * @version 1.0
 *
 */

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Tela principal");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 857, 342);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Alerta antes de sair do sistema
		addWindowListener(new WindowAdapter() {  
            public void windowClosing(java.awt.event.WindowEvent e) {  
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {  
                    int selectedOption = JOptionPane.showConfirmDialog(null,"Deseja sair do sistema?", "Sair",JOptionPane.YES_NO_OPTION);  
                    if (selectedOption == JOptionPane.YES_OPTION) {  
                        System.exit(0);  
                    }  
                }  
            }  
        });  

		JPanel panel = new JPanel();
		panel.setBounds(72, 65, 685, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCadCliente = new JButton("");
		btnCadCliente.setBounds(0, 0, 307, 54);
		panel.add(btnCadCliente);
		btnCadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadCliente frameCli;
				try {
					frameCli = new TelaCadCliente();
					frameCli.setLocationRelativeTo(null);
					frameCli.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCadCliente.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/btnCadCliente.png")));
		
		JButton btnCadUsuario = new JButton("");
		btnCadUsuario.setBounds(0, 65, 307, 54);
		panel.add(btnCadUsuario);
		btnCadUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadFunc frameCadFun;
				try {
					frameCadFun = new TelaCadFunc();
					frameCadFun.setLocationRelativeTo(null);
					frameCadFun.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCadUsuario.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/btnCadFuncionarios.png")));
		
		JButton btnChamado = new JButton("");
		btnChamado.setBounds(378, 0, 307, 54);
		panel.add(btnChamado);
		btnChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaChamado frameChamado;
				try {
					frameChamado = new TelaChamado();
					frameChamado.setLocationRelativeTo(null);
					frameChamado.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnChamado.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/btnChamados.fw.png")));
		
		JButton btnAtendimento = new JButton("");
		btnAtendimento.setBounds(378, 65, 307, 54);
		panel.add(btnAtendimento);
		btnAtendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtendimento frameAtendimento = new TelaAtendimento();
				frameAtendimento.setLocationRelativeTo(null);
				frameAtendimento.setVisible(true);
			}
		});
		btnAtendimento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/btnAtendimentos.fw.png")));
		
		JButton btnSair = new JButton("");
		btnSair.setBounds(186, 130, 307, 54);
		panel.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Confirm = JOptionPane.showConfirmDialog(null,"Deseja sair do sistema?","sim ou nao", JOptionPane.YES_NO_OPTION);
			    if (Confirm == JOptionPane.YES_OPTION) {
			    	dispose();
			    } 
				
			}
		});
		btnSair.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/btnSair.png")));	    
	    
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 2560, 21);
		contentPane.add(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadCliente frameCli;
				try {
					frameCli = new TelaCadCliente();
					frameCli.setLocationRelativeTo(null);
					frameCli.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnCadastro.add(mntmClientes);
		
		JMenuItem mntmFuncionarios = new JMenuItem("Funcion\u00E1rios");
		mntmFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadFunc frameCadFun;
				try {
					frameCadFun = new TelaCadFunc();
					frameCadFun.setLocationRelativeTo(null);
					frameCadFun.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnCadastro.add(mntmFuncionarios);
		
		JMenu mnRgistros = new JMenu("Registros");
		menuBar.add(mnRgistros);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRegistroClientes frameRegCli = new TelaRegistroClientes();
				frameRegCli.setLocationRelativeTo(null);
				frameRegCli.setVisible(true);
			}
		});
		mnRgistros.add(mntmNewMenuItem_1);
		
		JMenuItem mntmFuncionarios_1 = new JMenuItem("Funcionarios");
		mntmFuncionarios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRegistroFuncionarios frameRegFun = new TelaRegistroFuncionarios();
				frameRegFun.setLocationRelativeTo(null);
				frameRegFun.setVisible(true);
			}
		});
		mnRgistros.add(mntmFuncionarios_1);
		
		JMenu mnChamado = new JMenu("Chamado");
		menuBar.add(mnChamado);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Abrir chamado ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaChamado frameChamado;
				try {
					frameChamado = new TelaChamado();
					frameChamado.setLocationRelativeTo(null);
					frameChamado.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnChamado.add(mntmNewMenuItem);
		
		JMenu mnAtendimentos = new JMenu("Atendimentos");
		menuBar.add(mnAtendimentos);
		
		JMenuItem mntmRelatrio = new JMenuItem("Relat\u00F3rio ");
		mntmRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtendimento frameAtendimento = new TelaAtendimento();
				frameAtendimento.setLocationRelativeTo(null);
				frameAtendimento.setVisible(true);
			}
		});
		mnAtendimentos.add(mntmRelatrio);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Confirm = JOptionPane.showConfirmDialog(null,"Deseja sair do sistema?","sim ou nao", JOptionPane.YES_NO_OPTION);
			    if (Confirm == JOptionPane.YES_OPTION) {
			    	dispose();
			    } 
			}
		});
		menuBar.add(mnSair);
	}
}
