package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaItens extends JFrame
{

	private JPanel contentPane;
	private JTextField txtFiltroItens;
	private JTable tblConsultaItens;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendasAndamento frame = new VendasAndamento();
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
	public ConsultaItens() {
		setResizable(false);
		setTitle("Consulta Itens");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFiltroItens = new JTextField();
		txtFiltroItens.setBounds(124, 67, 219, 20);
		contentPane.add(txtFiltroItens);
		txtFiltroItens.setColumns(10);
		
		JComboBox cmbFiltroItem = new JComboBox();
		cmbFiltroItem.setBounds(10, 67, 104, 20);
		contentPane.add(cmbFiltroItem);
		
		JButton btnBuscarItens = new JButton("Buscar");
		btnBuscarItens.setBounds(353, 66, 89, 23);
		contentPane.add(btnBuscarItens);
		
		JLabel lblConsultarPor = new JLabel("Consultar por:");
		lblConsultarPor.setBounds(10, 10, 104, 14);
		contentPane.add(lblConsultarPor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 734, 334);
		contentPane.add(scrollPane);
		
		tblConsultaItens = new JTable();
		tblConsultaItens.setModel(new DefaultTableModel(
			new Object[][]
			{
			},
			new String[]
			{
					
			}
		) {
			Class[] columnTypes = new Class[] {
				Float.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tblConsultaItens);
		
		JComboBox cmbStatusItem = new JComboBox();
		cmbStatusItem.setBounds(124, 7, 119, 20);
		contentPane.add(cmbStatusItem);
	}
}
