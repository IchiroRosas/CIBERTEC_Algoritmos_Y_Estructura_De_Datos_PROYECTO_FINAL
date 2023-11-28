package Guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import array_lists.ArrayList_Producto;
import clases.Producto;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;


public class Productos extends JDialog implements ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JLabel lblNewLabel_2;
	private JLabel lblDescripcin;
	private JLabel lblNewLabel_1;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JTextArea txtAdescripcion;
	private JScrollPane scrollPane_1;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Productos dialog = new Productos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Productos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Productos.class.getResource("/iconos/tienda.png")));
		setTitle("Productos");
		setBounds(100, 100, 754, 425);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setForeground(new Color(255, 255, 255));
		lblDescripcin.setBounds(10, 43, 103, 14);
		contentPanel.add(lblDescripcin);

		lblNewLabel_1 = new JLabel("Precio(S/.):");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 97, 103, 14);
		contentPanel.add(lblNewLabel_1);

		txtPrecio = new JTextField();
		txtPrecio.setForeground(new Color(255, 255, 255));
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(123, 93, 160, 22);
		contentPanel.add(txtPrecio);

		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setIcon(new ImageIcon(Productos.class.getResource("/iconos/modificar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setEnabled(false);
		btnModificar.setBounds(618, 43, 113, 23);
		contentPanel.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setIcon(new ImageIcon(Productos.class.getResource("/iconos/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(618, 73, 113, 23);
		contentPanel.add(btnEliminar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setIcon(new ImageIcon(Productos.class.getResource("/iconos/grabar.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(170, 126, 113, 23);
		contentPanel.add(btnGuardar);

		lblNewLabel_2 = new JLabel("Codigo Producto:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 15, 103, 14);
		contentPanel.add(lblNewLabel_2);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setIcon(new ImageIcon(Productos.class.getResource("/iconos/adicionar.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(618, 15, 113, 23);
		contentPanel.add(btnAdicionar);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(123, 43, 160, 43);
		contentPanel.add(scrollPane);

		txtAdescripcion = new JTextArea();
		txtAdescripcion.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(txtAdescripcion);
		txtAdescripcion.setLineWrap(true);
		txtAdescripcion.setWrapStyleWord(true);
		txtAdescripcion.setEditable(false);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 160, 721, 215);
		contentPanel.add(scrollPane_1);
		
		tblProductos = new JTable();
		tblProductos.setSelectionForeground(new Color(255, 255, 255));
		tblProductos.setGridColor(new Color(255, 255, 255));
		tblProductos.setForeground(new Color(255, 255, 255));
		tblProductos.addMouseListener(this);
		tblProductos.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblProductos);
		modelo = new DefaultTableModel();
		modelo.addColumn("Código Producto");
		modelo.addColumn("Descripción");
		modelo.addColumn("Precio (S/.)");
		tblProductos.setModel(modelo);


		
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setForeground(new Color(255, 255, 255));
		txtCodigoProducto.setEditable(false);
		txtCodigoProducto.setColumns(10);
		txtCodigoProducto.setBounds(123, 12, 160, 22);
		contentPanel.add(txtCodigoProducto);
		
		listar();
		ajustarAnchoColumnas();
	}

	// INSTANCIAMOS EL ARRAY_LIST_PRODUCTO
	ArrayList_Producto ap = new ArrayList_Producto();
	private JTextField txtCodigoProducto;
	private JTable tblProductos;
	private JScrollPane scrollPane;
	
	public void mouseClicked(MouseEvent e) {
		mouseClickedTblProductos(e);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}

		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}

		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	
	private void mouseClickedTblProductos(MouseEvent e) {
		String descripcion = leerDescripcion();
		MostrarInfoTabla();	
		if(descripcion.isBlank() == false) {
			habilitarBotones();
			deshabilitarEntradas();
		}
	}

	private void actionPerformedBtnAdicionar(ActionEvent e) {
		limpiarTxts();
		int nuevoCodigo = ap.generarCodigoCorrelativoProducto();
		String stringNuevoCodigo = Integer.toString(nuevoCodigo);
		txtCodigoProducto.setText(stringNuevoCodigo);
		habilitarEntradas();
		btnGuardar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnAdicionar.setEnabled(true);
		txtAdescripcion.requestFocus();
	}

	private void actionPerformedBtnModificar(ActionEvent e) {
		habilitarEntradas();
		btnAdicionar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnModificar.setEnabled(true);
		txtAdescripcion.requestFocus();
	}

	private void actionPerformedBtnEliminar(ActionEvent e) {
		int codProducto = Integer.parseInt(txtCodigoProducto.getText());
		for(int i = 0; i<ap.tamanio(); i++) {
			int objetoEliminar = ap.obtener(i).getCodigoProducto();
			if(codProducto == objetoEliminar) {
				int ok = confirmar("¿Desea eliminar el registro?");
				if (ok == 0) {
				ap.eliminar(i);
				ap.grabarSobrescribirProductos();
				btnEliminar.setEnabled(false);
				btnModificar.setEnabled(false);
				listar();
				limpiarTxts();
				}
			}
		}
	}

	private void actionPerformedBtnGuardar(ActionEvent e) {
		int codProducto = Integer.parseInt(txtCodigoProducto.getText());
		String descripcionProducto = leerDescripcion();
		if (descripcionProducto.length() > 0) {
			double precioIn = leerPrecio();
			boolean estaBien = comprobarSoloNumerosDecimales(txtPrecio);
			if (estaBien == true) {
				
				boolean existe = false;
				for (int i = 0; i < ap.tamanio(); i++) {
					int codigoPregunta = ap.obtener(i).getCodigoProducto();
					if (codProducto == codigoPregunta) {
						existe = true;
					}
				}

				if (existe == false) {
					int ventasEfectuadas = 0, unidadesVendidas = 0;
					double importeTotal = 0;
					Producto nuevo = new Producto(codProducto,ventasEfectuadas,unidadesVendidas,descripcionProducto,precioIn,importeTotal);
					ap.adicionar(nuevo);
					ap.grabarSobrescribirProductos();

					deshabilitarEntradas();
					limpiarTxts();					
					btnGuardar.setEnabled(false);
					btnAdicionar.setEnabled(true);
					btnModificar.setEnabled(false);
					btnEliminar.setEnabled(false);
					mensajeConfirmacion("Producto adicionado con exito");
					listar();
					
				} else {
					
					for(int i=0; i<ap.tamanio(); i++) {
						if(codProducto == ap.obtener(i).getCodigoProducto()) {
							Producto nuevoProducto = ap.obtener(i);
						 	nuevoProducto.setDescripcion(descripcionProducto);
						 	nuevoProducto.setPrecio(precioIn);
						 	ap.set(i, nuevoProducto);
						}
					}
					ap.grabarSobrescribirProductos();
					mensajeConfirmacion("Producto modificado con exito");
					limpiarTxts();
					deshabilitarEntradas();
					btnAdicionar.setEnabled(true);
					btnModificar.setEnabled(false);
					btnEliminar.setEnabled(false);
					btnGuardar.setEnabled(false);
					listar();
				}
			} else {
				errorYreubicarMouse("Ingresa un precio válido", txtPrecio);
			}
		} else {
			errorYreubicarMouseDescripcion("Ingresa una descripción", txtAdescripcion);
		}
	}	

	/*____________________________Metodos de tipo Void____________________________*/
	
	void deshabilitarBotones() {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}
	
	void habilitarBotones() {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
	}
	
	void limpiarTxts() {
		txtCodigoProducto.setText("");
		txtAdescripcion.setText("");
		txtPrecio.setText("");
	}

	void deshabilitarEntradas() {
		txtAdescripcion.setEditable(false);
		txtPrecio.setEditable(false);
	}

	void habilitarEntradas() {
		txtAdescripcion.setEditable(true);
		txtPrecio.setEditable(true);
	}

	/*____________________________Metodos DE RETORNO para leer los JTextField/TxtArea____________________________*/

	String leerDescripcion() {
		String descripcion = txtAdescripcion.getText().trim();
		return descripcion;
	}

	double leerPrecio() {
		String precio = txtPrecio.getText().trim();
	    if (precio.isEmpty()==false) {
	        try {
	            DecimalFormat df = new DecimalFormat("0.00");
	            double precioDouble = Double.parseDouble(precio);
	            String precioDosDecimales = df.format(precioDouble);
	            return Double.parseDouble(precioDosDecimales);
	        } catch (NumberFormatException e) {
	            return 0.0;
	        }
	    } else {
	        return 0.0;
	    }
	}
	/*____________________________Métodos para mensajes____________________________*/

	void mensajeError(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}

	void mensajeConfirmacion(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 1);
	}

	void errorYreubicarMouse(String s, JTextField txt) {
		mensajeError(s);
		txt.setText("");
		txt.requestFocus();
	}

	void errorYreubicarMouseDescripcion(String s, JTextArea txt) {
		mensajeError(s);
		txt.setText("");
		txt.requestFocus();
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}


	/*____________________________Métodos para Validaciones____________________________*/

	private boolean comprobarSoloHayLetras(JTextField txt) {
		String texto = txt.getText();
		Pattern patron = Pattern.compile("^[A-Za-z ]+$");
		Matcher matcher = patron.matcher(texto);
		return matcher.matches();
	}

	private boolean comprobarSoloNumerosDecimales(JTextField txt) {
		String texto = txt.getText();
		Pattern patron = Pattern.compile("^[0-9]+(\\.[0-9]+)?$");
		Matcher matcher = patron.matcher(texto);
		return matcher.matches();
	}
	
	/*____________________________Métodos para la Tabla____________________________*/
	
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ap.tamanio(); i++) {
			Object[] fila = { ap.obtener(i).getCodigoProducto(),
							  ap.obtener(i).getDescripcion(),
							  ap.obtener(i).getPrecio(),
			};			          		         
			modelo.addRow(fila);
		}
	}
	
	void MostrarInfoTabla() {
		if (tblProductos.getSelectedRow() != -1) {
			Producto p = ap.obtener(tblProductos.getSelectedRow());
			txtCodigoProducto.setText("" + p.getCodigoProducto());
			txtAdescripcion.setText("" + p.getDescripcion());
			txtPrecio.setText("" + p.getPrecio());
		}
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane_1.getWidth() / 100;
	}
	
	void ajustarAnchoColumnas() {
        TableColumnModel columnaProducto = tblProductos.getColumnModel();
        columnaProducto.getColumn(0).setPreferredWidth(anchoColumna(10));
        columnaProducto.getColumn(1).setPreferredWidth(anchoColumna(60));
        columnaProducto.getColumn(2).setPreferredWidth(anchoColumna(10));
    }
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	
}