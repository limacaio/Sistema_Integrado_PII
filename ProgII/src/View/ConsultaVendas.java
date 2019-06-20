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

public class ConsultaVendas extends JFrame
{

	private JPanel contentPane;
	private JTextField txtFiltroVendas;
	private JTable tblConsultaVendas;

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
	public ConsultaVendas() {
		setResizable(false);
		setTitle("Consulta Vendas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFiltroVendas = new JTextField();
		txtFiltroVendas.setBounds(124, 67, 219, 20);
		contentPane.add(txtFiltroVendas);
		txtFiltroVendas.setColumns(10);
		
		JComboBox cmbFiltroVendas = new JComboBox();
		cmbFiltroVendas.setBounds(10, 67, 104, 20);
		contentPane.add(cmbFiltroVendas);
		
		JButton btnBuscarVenda = new JButton("Buscar");
		btnBuscarVenda.setBounds(353, 66, 89, 23);
		contentPane.add(btnBuscarVenda);
		
		JLabel lblConsultarPor = new JLabel("Consultar por:");
		lblConsultarPor.setBounds(10, 10, 104, 14);
		contentPane.add(lblConsultarPor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 734, 334);
		contentPane.add(scrollPane);
		
		tblConsultaVendas = new JTable();
		tblConsultaVendas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"CodigoVenda", "DataVenda", "NomeCliente", "TotalVenda"
			}
		) {
			Class[] columnTypes = new Class[] {
				Float.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tblConsultaVendas);
		
		JComboBox cmbStatusVenda = new JComboBox();
		cmbStatusVenda.setBounds(124, 7, 119, 20);
		contentPane.add(cmbStatusVenda);
	}
}
