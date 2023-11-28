package Guis;

import java.awt.BorderLayout;
import clases.Vendedor;
import array_lists.ArrayList_Producto;
import array_lists.ArrayList_Vendedor;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;

public class ReporteVendedores extends JDialog {
	private JScrollPane scrollPane;
	private JTable tblVendedores;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteVendedores dialog = new ReporteVendedores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteVendedores() {
		setTitle("Reporte General por Vendedores");
		setBounds(100, 100, 899, 363);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 863, 241);
		getContentPane().add(scrollPane);
		
		tblVendedores = new JTable();
		tblVendedores.setSelectionForeground(new Color(255, 255, 255));
		tblVendedores.setGridColor(new Color(255, 255, 255));
		tblVendedores.setForeground(new Color(255, 255, 255));
		tblVendedores.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblVendedores);
		
		lblNewLabel = new JLabel("Reporte de Vendedores");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(306, 11, 286, 29);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("_________________________");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(283, 11, 397, 59);
		getContentPane().add(lblNewLabel_1);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código Vendedor");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Cantidad de ventas");
		modelo.addColumn("Unidades Vendidas");
		modelo.addColumn("Importe Total (S/.)");
		tblVendedores.setModel(modelo);

		listar();
		ajustarAnchoColumnas();
	}
	
	ArrayList_Vendedor av = new ArrayList_Vendedor();
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void ajustarAnchoColumnas() {
        TableColumnModel columnaProducto = tblVendedores.getColumnModel();
        columnaProducto.getColumn(0).setPreferredWidth(anchoColumna(30));
        columnaProducto.getColumn(1).setPreferredWidth(anchoColumna(30));
        columnaProducto.getColumn(2).setPreferredWidth(anchoColumna(30));
        columnaProducto.getColumn(3).setPreferredWidth(anchoColumna(30));
        columnaProducto.getColumn(4).setPreferredWidth(anchoColumna(30));
        columnaProducto.getColumn(5).setPreferredWidth(anchoColumna(30));
    }
	
	void listar() {
		modelo.setRowCount(0);
		for(int i = 0; i<av.tamanio(); i++) {
			Object[] fila = { av.obtener(i).getCodigoVendedor(),
					  av.obtener(i).getNombres(),
					  av.obtener(i).getApellidos(),
					  av.obtener(i).getVentasEfectuadas(),
					  av.obtener(i).getUnidadesVendidas(),
					  av.obtener(i).getImporteTotal()};	
			modelo.addRow(fila);
		}
	}
}