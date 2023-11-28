package Guis;

import clases.Factura;
import clases.Vendedor;
import array_lists.ArrayList_Vendedor;
import array_lists.ArrayList_Factura;
import array_lists.ArrayList_Producto;

import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ReporteReVendedor extends JDialog implements ActionListener{
	private JTable tblVendedores;
	private JLabel lblNombres;
	private JComboBox cmbProductos;
	private JScrollPane srpTabla;
	private JLabel lblNewLabel;
	private JLabel lblApellidos;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteReVendedor dialog = new ReporteReVendedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteReVendedor() {
		setTitle("Reporte por Vendedor");
		setBounds(100, 100, 699, 258);
		getContentPane().setLayout(null);
		
		srpTabla = new JScrollPane();
		srpTabla.setBounds(10, 100, 663, 107);
		getContentPane().add(srpTabla);
		
		tblVendedores = new JTable();
		tblVendedores.setSelectionForeground(new Color(255, 255, 255));
		tblVendedores.setGridColor(new Color(255, 255, 255));
		tblVendedores.setForeground(new Color(255, 255, 255));
		tblVendedores.setFillsViewportHeight(true);
		srpTabla.setViewportView(tblVendedores);
		
		cmbProductos = new JComboBox();
		cmbProductos.setForeground(new Color(255, 255, 255));
		cmbProductos.addActionListener(this);
		cmbProductos.setBounds(213, 11, 304, 22);
		getContentPane().add(cmbProductos);
		
		lblNewLabel = new JLabel("Selecciona un Vendedor:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 12, 208, 14);
		getContentPane().add(lblNewLabel);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setForeground(new Color(255, 255, 255));
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombres.setBounds(10, 56, 103, 22);
		getContentPane().add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(new Color(255, 255, 255));
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellidos.setBounds(318, 56, 103, 22);
		getContentPane().add(lblApellidos);
		
		txtNombres = new JTextField();
		txtNombres.setForeground(new Color(255, 255, 255));
		txtNombres.setBounds(92, 58, 195, 25);
		txtNombres.setColumns(10);
		txtNombres.setEditable(false);
		getContentPane().add(txtNombres);

		txtApellidos = new JTextField();
		txtApellidos.setForeground(new Color(255, 255, 255));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(409, 58, 195, 25);
		txtApellidos.setEditable(false);
		getContentPane().add(txtApellidos);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código Factura");
		modelo.addColumn("Código Producto");
		modelo.addColumn("Unidades vendidas");
		modelo.addColumn("Precio Unitario (S/.)");
		tblVendedores.setModel(modelo);
		
		llenarCmbCodProducto();
	}
	
	ArrayList_Factura af = new ArrayList_Factura();
	ArrayList_Vendedor av = new ArrayList_Vendedor();
	
	public void actionPerformed(ActionEvent e) {
	
		int codigoVendedor = leerCMB();
		for (int i = 0; i < av.tamanio(); i++) {
	        if (codigoVendedor == av.obtener(i).getCodigoVendedor()) {
	        	txtNombres.setText(av.obtener(i).getNombres());
	        	txtApellidos.setText(av.obtener(i).getApellidos()); }
	    }
		
	    modelo.setRowCount(0);
	    for (int j = 0; j < af.tamanio(); j++) {
	        if (codigoVendedor == af.obtener(j).getCodigoVendedor()) {
	            Object[] fila = { 
	                af.obtener(j).getCodigoFactura(), 
	                af.obtener(j).getCodigoProducto(), 
	                af.obtener(j).getUnidades(),
	                af.obtener(j).getPrecio()};
	            modelo.addRow(fila);
	        }
	    }
		
	}
	
	void llenarCmbCodProducto() {
		for(int i=0; i<av.tamanio(); i++) {
			int codProducto = av.obtener(i).getCodigoVendedor();
			cmbProductos.addItem(codProducto);
		}
	}
	
	private int leerCMB() {
		String codProducto = cmbProductos.getSelectedItem().toString();
		int codProductoS = Integer.parseInt(codProducto);
		return codProductoS;
	}
}
