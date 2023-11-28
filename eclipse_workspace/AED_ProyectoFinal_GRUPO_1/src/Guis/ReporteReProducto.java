package Guis;

import clases.Producto;
import array_lists.ArrayList_Producto;
import clases.Factura;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import array_lists.ArrayList_Factura;
import array_lists.ArrayList_Producto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ReporteReProducto extends JDialog implements ActionListener{
	private JScrollPane srpTabla;
	private JTable tblReProducto;
	private JComboBox cmbProductos;
	private DefaultTableModel modelo;
	private JLabel lblNewLabel;
	private JScrollPane scpDescripcion;
	private JLabel lblDescripcin;
	private JTextArea txtDescripcion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteReProducto dialog = new ReporteReProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteReProducto() {
		setTitle("Reporte por Producto");
		setBounds(100, 100, 699, 269);
		getContentPane().setLayout(null);
		srpTabla = new JScrollPane();
		srpTabla.setBounds(10, 112, 663, 107);
		getContentPane().add(srpTabla);
		tblReProducto = new JTable();
		tblReProducto.setSelectionForeground(new Color(255, 255, 255));
		tblReProducto.setGridColor(new Color(255, 255, 255));
		tblReProducto.setForeground(new Color(255, 255, 255));
		tblReProducto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tblReProducto.setFillsViewportHeight(true);
		srpTabla.setViewportView(tblReProducto);

		cmbProductos = new JComboBox();
		cmbProductos.setForeground(new Color(255, 255, 255));
		cmbProductos.addActionListener(this);
		cmbProductos.setBounds(213, 23, 304, 22);
		getContentPane().add(cmbProductos);

		lblNewLabel = new JLabel("Selecciona un Producto:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 24, 208, 14);
		getContentPane().add(lblNewLabel);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código Factura");
		modelo.addColumn("Código Vendedor");
		modelo.addColumn("Unidades vendidas");
		modelo.addColumn("Precio Unitario (S/.)");
		tblReProducto.setModel(modelo);
		
		scpDescripcion = new JScrollPane();
		scpDescripcion.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scpDescripcion.setBounds(213, 58, 304, 43);
		getContentPane().add(scpDescripcion);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setForeground(new Color(255, 255, 255));
		txtDescripcion.setEditable(false);
		scpDescripcion.setViewportView(txtDescripcion);
		
		lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setForeground(new Color(255, 255, 255));
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcin.setBounds(10, 57, 103, 22);
		getContentPane().add(lblDescripcin);
		
		llenarCmbCodProducto();
	}
	
	ArrayList_Factura af = new ArrayList_Factura();
	ArrayList_Producto ap = new ArrayList_Producto();

	public void actionPerformed(ActionEvent e) {
	    int codProducto = leerCMB();
	    for (int i = 0; i < ap.tamanio(); i++) {
	        if (codProducto == ap.obtener(i).getCodigoProducto()) {
	        	txtDescripcion.setText(ap.obtener(i).getDescripcion());	        }
	    }

	    modelo.setRowCount(0);
	    for (int j = 0; j < af.tamanio(); j++) {
	        if (codProducto == af.obtener(j).getCodigoProducto()) {
	            Object[] fila = { 
	                af.obtener(j).getCodigoFactura(), 
	                af.obtener(j).getCodigoVendedor(), 
	                af.obtener(j).getUnidades(),
	                af.obtener(j).getPrecio()};
	            modelo.addRow(fila);
	        }
	    }
	}
	
	void llenarCmbCodProducto() {
		for(int i=0; i<ap.tamanio(); i++) {
			int codProducto = ap.obtener(i).getCodigoProducto();
			cmbProductos.addItem(codProducto);
		}
	}
	
	private int leerCMB() {
		String codProducto = cmbProductos.getSelectedItem().toString();
		int codProductoS = Integer.parseInt(codProducto);
		return codProductoS;
	}
}