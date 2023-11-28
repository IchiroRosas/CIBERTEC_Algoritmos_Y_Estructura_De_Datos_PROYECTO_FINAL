package Guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import array_lists.ArrayList_Factura;
import clases.Factura;
import array_lists.ArrayList_Cliente;
import clases.Cliente;
import array_lists.ArrayList_Vendedor;
import clases.Vendedor;
import array_lists.ArrayList_Producto;
import clases.Producto;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class VentanaVender extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUnidades;
	private JTextArea txtArea;
	private JScrollPane scrollPane;
	private JComboBox cmbCodProducto;
	private JComboBox cmbCodVendedor;
	private JComboBox cmbCodCliente;
	private JButton btnVender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaVender dialog = new VentanaVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaVender() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaVender.class.getResource("/iconos/tienda.png")));
		setTitle("VentanaVender");
		setBounds(100, 100, 593, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 557, 296);
		contentPanel.add(scrollPane);
		
		txtArea = new JTextArea();
		txtArea.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(txtArea);
		txtArea.setEditable(false);
		
		cmbCodCliente = new JComboBox();
		cmbCodCliente.setForeground(new Color(255, 255, 255));
		cmbCodCliente.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR C\u00D3DIGO DE CLIENTE"}));
		cmbCodCliente.addActionListener(this);
		cmbCodCliente.setBounds(136, 11, 247, 22);
		contentPanel.add(cmbCodCliente);
		cmbCodCliente.setSelectedIndex(0);
		
		cmbCodVendedor = new JComboBox();
		cmbCodVendedor.setForeground(new Color(255, 255, 255));
		cmbCodVendedor.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR C\u00D3DIGO DE VENDEDOR"}));
		cmbCodVendedor.setBounds(136, 44, 247, 22);
		contentPanel.add(cmbCodVendedor);
		cmbCodVendedor.setSelectedIndex(0);
		
		cmbCodProducto = new JComboBox();
		cmbCodProducto.setForeground(new Color(255, 255, 255));
		cmbCodProducto.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR C\u00D3DIGO DE PRODUCTO"}));
		cmbCodProducto.setBounds(136, 77, 247, 22);
		contentPanel.add(cmbCodProducto);
		cmbCodProducto.setSelectedIndex(0);
		
		txtUnidades = new JTextField();
		txtUnidades.setForeground(new Color(255, 255, 255));
		txtUnidades.setBounds(136, 110, 89, 20);
		contentPanel.add(txtUnidades);
		txtUnidades.setColumns(10);
		
		btnVender = new JButton("Vender");
		btnVender.setForeground(new Color(255, 255, 255));
		btnVender.setIcon(new ImageIcon(VentanaVender.class.getResource("/iconos/vender.png")));
		btnVender.addActionListener(this);
		btnVender.setBounds(461, 26, 106, 23);
		contentPanel.add(btnVender);
		
		JLabel lblNewLabel = new JLabel("Codigo del Cliente:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 15, 130, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo del Vendedor:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 48, 130, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo del Producto:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 81, 130, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Unidades a Vender:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 113, 116, 14);
		contentPanel.add(lblNewLabel_3);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.addActionListener(this);
		btnBorrar.setIcon(new ImageIcon(VentanaVender.class.getResource("/iconos/borrar.png")));
		btnBorrar.setBounds(461, 60, 106, 23);
		contentPanel.add(btnBorrar);
		
		llenarCmbCodCliente();
		llenarCmbCodVendedor();
		llenarCmbCodProducto();
		af.cargarFacturas();
		
	}
	
	ArrayList_Cliente ac = new ArrayList_Cliente();
	ArrayList_Vendedor av = new ArrayList_Vendedor();
	ArrayList_Producto ap = new ArrayList_Producto();
	ArrayList_Factura af = new ArrayList_Factura();
	private JButton btnBorrar;
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cmbCodCliente) {
			actionPerformedCmbCodigoCliente(e);
		}
		if(e.getSource() == cmbCodVendedor) {
			actionPerformedCmbCodigoVendedor(e);
		}
		if(e.getSource() == cmbCodProducto) {
			actionPerformedCmbCodigoProducto(e);
		}
		if(e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if(e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
	}
	
	private void actionPerformedCmbCodigoCliente(ActionEvent e) {
	}
	
	private void actionPerformedCmbCodigoVendedor(ActionEvent e) {
	}

	private void actionPerformedCmbCodigoProducto(ActionEvent e) {
	}
	
	private void actionPerformedBtnVender(ActionEvent e) {
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		//Variables necesarias
		String descripcionProducto = "";
		double precioProducto = 0.0;
		double importeSubtotal = 0.0;
		double importeIGV = 0.0;
		double importeTotal = 0.0;
		
		//Comprueba CmbCodCliente
		String codClienteSelec = cmbCodCliente.getSelectedItem().toString();
		if(codClienteSelec.equals("SELECCIONAR CÓDIGO DE CLIENTE")==false) {
			int codCliente = Integer.parseInt(codClienteSelec);
			//Comprueba CmbCodVendedor
			String codVendedorSelec = cmbCodVendedor.getSelectedItem().toString();
			if(codVendedorSelec.equals("SELECCIONAR CÓDIGO DE VENDEDOR")==false) {
				int codVendedor = Integer.parseInt(codVendedorSelec);
				//Comprueba CmbCodProducto
				String codProductoSelec = cmbCodProducto.getSelectedItem().toString();
				if(codProductoSelec.equals("SELECCIONAR CÓDIGO DE PRODUCTO")==false) {
					int codProducto = Integer.parseInt(codProductoSelec);
					//Comprueba txtUnidades
					if(comprobarUnidadesInSiEsEntero()==true && comprobarUnidadesInSiEsMayorAcero()==true) {
						int unidadesIn = Integer.parseInt(txtUnidades.getText());
						
						
						//Confirmación de venta
						int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro(a)?", "Confirmar venta", JOptionPane.YES_NO_OPTION);
						if(respuesta==0) {
						
							//Ubicar codProducto en ArrayList de los Productos - Obtener datos del ArrayList Productos
							for(int i=0; i<ap.tamanio(); i++) {
								if(codProducto == ap.obtener(i).getCodigoProducto()) {
									descripcionProducto = ap.obtener(i).getDescripcion();
									
									precioProducto = ap.obtener(i).getPrecio();
									importeSubtotal = precioProducto * unidadesIn;
							        String importeSubtotalS = df.format(importeSubtotal);
							        importeSubtotal = Double.parseDouble(importeSubtotalS);
							        
									importeIGV = 0.18 * importeSubtotal;
									String importeIGVS = df.format(importeIGV);
									importeIGV = Double.parseDouble(importeIGVS);
									
									importeTotal = importeSubtotal + importeIGV;
									String importeTotalS = df.format(importeTotal);
									importeTotal = Double.parseDouble(importeTotalS);
									
								}
							}
						
							//Crear nueva factura, agregarla a su ArrayList y agregarla al txt
							int nuevoCodigoFactura = af.generarCodigoCorrelativoFactura();
							Factura facturaNueva = new Factura (nuevoCodigoFactura, codProducto, codVendedor, unidadesIn, precioProducto);
							af.adicionar(facturaNueva);
							af.grabarFactura(facturaNueva);
						
							//Mostrar la factura en el txtArea (FALTA UNIR CON LOS DISTINTOS ACUMULADORES)
							limpieza();
							imprimir("---------------------------------------------------");
							imprimir("CÓDIGO DE FACTURA: " + nuevoCodigoFactura);
							imprimir("---------------------------------------------------");
							imprimir("Código del cliente: " + codCliente);
							imprimir("Código del vendedor: " + codVendedor);
							imprimir("Código del producto: " + codProducto);
							imprimir("Descripción del producto: " + descripcionProducto);
							imprimir("Precio unitario: S/." + precioProducto);
							imprimir("Unidades: " + unidadesIn);
							imprimir("Importe subtotal: S/." + importeSubtotal);
							imprimir("Importe del IGV: S/." + importeIGV);
							imprimir("Importe total a pagar: S/." + importeTotal);
							imprimir();
						
							//Actualizando acumuladores y contador de PRODUCTO
							for(int i = 0; i < ap.tamanio();i++) {
								if(codProducto==ap.obtener(i).getCodigoProducto()) {
									
									int VentasEfectuadasActualizada = ap.obtener(i).getVentasEfectuadas() + 1;
									ap.obtener(i).setVentasEfectuadas(VentasEfectuadasActualizada);
									
									int unidadesVendidasActualizada = ap.obtener(i).getUnidadesVendidas() + unidadesIn;
									ap.obtener(i).setUnidadesVendidas(unidadesVendidasActualizada);
									
									double nuevoImporteTotal = ap.obtener(i).getImporteTotal() + importeTotal;
									ap.obtener(i).setImporteTotal(nuevoImporteTotal);
								
								}
							}
							ap.grabarSobrescribirProductos();
							
							//Actualizando acumuladores y contador de VENDEDOR
							for(int i = 0; i < av.tamanio();i++) {
								if(codVendedor==av.obtener(i).getCodigoVendedor()) {
									
									int VentasEfectuadasActualizada = av.obtener(i).getVentasEfectuadas() + 1;
									av.obtener(i).setVentasEfectuadas(VentasEfectuadasActualizada);
									
									int unidadesVendidasActualizada = av.obtener(i).getUnidadesVendidas() + unidadesIn;
									av.obtener(i).setUnidadesVendidas(unidadesVendidasActualizada);
									
									double nuevoImporteTotal = av.obtener(i).getImporteTotal() + importeTotal;
									av.obtener(i).setImporteTotal(nuevoImporteTotal);
								
								}
							}
							av.grabarSobrescribirVendedores();
							
							mensajeConfirmacion("Venta realizada con éxito");
						
						} else {
							limpieza();
							mensajeConfirmacion("Venta cancelada");
						}
						
					}else {
						mensajeError("Ingrese una cantidad de unidades válida");
						txtUnidades.requestFocus();
					}
				}else {
					mensajeError("Seleccione un código de producto válido");
				}
			}else {
				mensajeError("Seleccione un código de vendedor válido");
			}
		}else {
			mensajeError("Seleccione un código de cliente válido");
		}
	}
	
	public void actionPerformedBtnBorrar(ActionEvent e) {
		limpieza();
	}
	
	/*--------------------------MÉTODOS PARA LIMPIEZA------------------------------*/
	void limpieza() {
		cmbCodCliente.setSelectedIndex(0);
		cmbCodProducto.setSelectedIndex(0);
		cmbCodVendedor.setSelectedIndex(0);
		txtUnidades.setText("");
		txtArea.setText("");
	}
	
	/*--------------------------MÉTODOS PARA LLENAR CMBs------------------------------*/
	
	void llenarCmbCodCliente() {
		for(int i=0; i<ac.tamanio(); i++) {
			int codCliente = ac.obtener(i).getCodigoCliente();
			cmbCodCliente.addItem(codCliente);
		}
	}
	
	void llenarCmbCodVendedor() {
		for(int i=0; i<av.tamanio(); i++) {
			int codVendedor = av.obtener(i).getCodigoVendedor();
			cmbCodVendedor.addItem(codVendedor);
		}
	}
	
	void llenarCmbCodProducto() {
		for(int i=0; i<ap.tamanio(); i++) {
			int codProducto = ap.obtener(i).getCodigoProducto();
			cmbCodProducto.addItem(codProducto);
		}
	}
	
	/*--------------------------MÉTODOS PARA EL JTEXTFIELD DE UNIDADES------------------------------*/
	
	boolean comprobarUnidadesInSiEsEntero() {
		try {
			int UnidadesIn = Integer.parseInt(txtUnidades.getText().trim());
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	boolean comprobarUnidadesInSiEsMayorAcero() {
		int unidadesIn = Integer.parseInt(txtUnidades.getText());
		if(unidadesIn > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/*--------------------------MÉTODOS PARA MENSAJES------------------------------*/
	
	void mensajeConfirmacion(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", 1, null);
	}
	
	void mensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", 0, null);
	}
	
	/*--------------------------MÉTODOS IMPRIMIR------------------------------*/
	void imprimir (String s) {
		txtArea.append(s + "\n");
	}
	
	void imprimir() {
		imprimir("");
	}
}
