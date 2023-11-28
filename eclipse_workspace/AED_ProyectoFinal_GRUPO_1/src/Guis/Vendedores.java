package Guis;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import array_lists.ArrayList_Vendedor;
import clases.Vendedor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class Vendedores extends JDialog implements ActionListener, MouseListener{

	ArrayList_Vendedor v1 = new ArrayList_Vendedor();
	private JTextField txtCategoria;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_4;
	private JLabel btnDNI;
	private JTextField txtDni;
	private JButton btnAdicionar;
	private DefaultTableModel modelo;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Vendedores dialog = new Vendedores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Vendedores() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vendedores.class.getResource("/iconos/tienda.png")));
		setTitle("Vendedores");
		setBounds(100, 100, 718, 484);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Categoria:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 56, 103, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 85, 103, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 110, 103, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Telefono:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 135, 103, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtCategoria = new JTextField();
		txtCategoria.setForeground(new Color(255, 255, 255));
		txtCategoria.setBounds(123, 52, 160, 22);
		getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);
		txtCategoria.setEditable(false);
		
		txtNombres = new JTextField();
		txtNombres.setForeground(new Color(255, 255, 255));
		txtNombres.setColumns(10);
		txtNombres.setBounds(123, 81, 160, 22);
		getContentPane().add(txtNombres);
		txtNombres.setEditable(false);
		
		txtApellidos = new JTextField();
		txtApellidos.setForeground(new Color(255, 255, 255));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(123, 106, 160, 22);
		getContentPane().add(txtApellidos);
		txtApellidos.setEditable(false);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(new Color(255, 255, 255));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(123, 132, 160, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setEditable(false);
		
				
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setIcon(new ImageIcon(Vendedores.class.getResource("/iconos/modificar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(555, 51, 137, 23);
		getContentPane().add(btnModificar);
		btnModificar.setEnabled(false);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setIcon(new ImageIcon(Vendedores.class.getResource("/iconos/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(555, 80, 137, 23);
		getContentPane().add(btnEliminar);
		btnEliminar.setEnabled(false);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setIcon(new ImageIcon(Vendedores.class.getResource("/iconos/grabar.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(373, 156, 108, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.setEnabled(false);
		
		lblNewLabel_4 = new JLabel("Codigo Vendedor:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(10, 28, 103, 14);
		getContentPane().add(lblNewLabel_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 682, 248);
		getContentPane().add(scrollPane);
		
		tblVendedores = new JTable();
		tblVendedores.setSelectionForeground(new Color(255, 255, 255));
		tblVendedores.setGridColor(new Color(255, 255, 255));
		tblVendedores.setForeground(new Color(255, 255, 255));
		tblVendedores.addMouseListener(this);
		tblVendedores.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblVendedores);
		modelo = new DefaultTableModel();
		modelo.addColumn("Código Vendedor");
		modelo.addColumn("Categoría");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Teléfono");
		modelo.addColumn("DNI");
		tblVendedores.setModel(modelo);

		
		btnDNI = new JLabel("DNI:");
		btnDNI.setForeground(new Color(255, 255, 255));
		btnDNI.setBounds(10, 160, 85, 14);
		getContentPane().add(btnDNI);
		
		txtDni = new JTextField();
		txtDni.setForeground(new Color(255, 255, 255));
		txtDni.setColumns(10);
		txtDni.setBounds(123, 157, 160, 20);
		getContentPane().add(txtDni);
		txtDni.setEditable(false);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setIcon(new ImageIcon(Vendedores.class.getResource("/iconos/adicionar.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(555, 23, 137, 23);
		getContentPane().add(btnAdicionar);
		
		txtCodigoVendedor = new JTextField();
		txtCodigoVendedor.setForeground(new Color(255, 255, 255));
		txtCodigoVendedor.setBounds(123, 26, 160, 19);
		getContentPane().add(txtCodigoVendedor);
		txtCodigoVendedor.setColumns(10);
		txtCodigoVendedor.setEditable(false);
		
		
		listar();
		ajustarAnchoColumnas();
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==tblVendedores) {
			mouseClickedTblVendedores(e);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if(e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if(e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if(e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
	}
	
	//INSTANCIAR ARRAYLIST
	ArrayList_Vendedor av = new ArrayList_Vendedor();
	private JTextField txtCodigoVendedor;
	private JTable tblVendedores;
	private JScrollPane scrollPane;
	
	
	private void mouseClickedTblVendedores(MouseEvent e) {
		String nombres = leerNombres();
		MostrarInfoTabla();	
		if(nombres.isBlank() == false) {
			habilitarBotones();
			deshabilitarEntradas();
		}
	}
	
	private void actionPerformedBtnAdicionar(ActionEvent e) {
		limpiarEntradas();
		int nuevoCodigo = av.generarCodigoCorrelativoVendedor();
		String nuevoCodigoS = Integer.toString(nuevoCodigo);
		txtCodigoVendedor.setText(nuevoCodigoS);
		habilitarEntradas();
		btnGuardar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnAdicionar.setEnabled(true);
		txtCategoria.requestFocus();
	}
	
	private void actionPerformedBtnGuardar(ActionEvent e) {
		int codigoVendedor = leerCodVendedor();
		try {
			int categoriaVendedor = leerCategoria();
			String nombresVendedor = leerNombres();
			boolean nombresSoloLetras = comprobarSoloHayLetras(txtNombres);
			if (nombresSoloLetras == true) {
				String apellidosVendedor = leerApellidos();
				boolean apellidosSoloLetras = comprobarSoloHayLetras(txtApellidos);
				if (apellidosSoloLetras == true) {
					String telefonoVendedor = leerTelefono();
					boolean telefonoNum = comprobarSoloNumeros(txtTelefono);
					if (telefonoNum == true) {
						String dniVendedor = leerDni();
						boolean dniNum = comprobarSoloNumeros(txtDni);
						if (dniNum == true) {

							boolean existe = false;

							for (int i = 0; i < av.tamanio(); i++) {
								int codigoPregunta = av.obtener(i).getCodigoVendedor();
								if (codigoVendedor == codigoPregunta) {
									existe = true;
								}
							}

							try {
								if (existe == false) {
									int ventasEfectuadas = 0, unidadesVendidas = 0;
									double importeTotal = 0;
									Vendedor nuevo = new Vendedor(codigoVendedor, categoriaVendedor, nombresVendedor, apellidosVendedor, telefonoVendedor, dniVendedor,ventasEfectuadas,unidadesVendidas,importeTotal);
									av.adicionar(nuevo);
									av.grabarSobrescribirVendedores();

									deshabilitarEntradas();
									limpiarEntradas();
									btnGuardar.setEnabled(false);
									btnAdicionar.setEnabled(true);
									btnModificar.setEnabled(false);
									btnEliminar.setEnabled(false);
									mensajeConfirmacion("Vendedor adicionado con exito");
									listar();
								} else {
									for(int i=0; i<av.tamanio(); i++) {
										if(codigoVendedor == av.obtener(i).getCodigoVendedor()) {
											Vendedor nuevoVendedor = av.obtener(i);
											nuevoVendedor.setCategoria(categoriaVendedor);
											nuevoVendedor.setNombres(nombresVendedor);
											nuevoVendedor.setApellidos(apellidosVendedor);
											nuevoVendedor.setTelefono(telefonoVendedor);
											nuevoVendedor.setDni(dniVendedor);
										 	av.set(i, nuevoVendedor);
										}
									}
									av.grabarSobrescribirVendedores();
									mensajeConfirmacion("Vendedor modificado con exito");
									btnGuardar.setEnabled(false);
									btnModificar.setEnabled(false);
									btnEliminar.setEnabled(false);
									btnAdicionar.setEnabled(true);
									deshabilitarEntradas();
									listar();
								}

							} catch (Exception e1) {
								mensajeError("Error de Sistema");
							}

						} else {
							error("ingrese un DNI correcto", txtDni);
						}
					} else {
						error("ingrese un Telefono correcto", txtTelefono);
					}
				} else {
					error("ingrese Apellidos correctos", txtApellidos);
				}
			} else {
				error("ingrese Nombres correctos", txtNombres);
			}
		} catch (Exception e1) {
			error("ingrese una Categoria correcta", txtCategoria);
		}

	}
	
	private void actionPerformedBtnModificar(ActionEvent e) {
		habilitarEntradas();
		
		btnAdicionar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnModificar.setEnabled(true);
		txtCategoria.requestFocus();
		
	}
	
	private void actionPerformedBtnEliminar(ActionEvent e) {
		int codigoSelect = leerCodVendedor() ;
		for(int i=0; i<av.tamanio(); i++) {
			int objetoEliminar = av.obtener(i).getCodigoVendedor();
			if(codigoSelect == objetoEliminar) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
				av.eliminar(i);
				av.grabarSobrescribirVendedores();
				limpiarEntradas();
				listar();
				}
			}
		}

	}
	
	
	
	//Métodos para leer lo que el usuario ingresa en la UI
	int leerCodVendedor() {
		int codigoIn = Integer.parseInt(txtCodigoVendedor.getText().trim());
		return codigoIn;
		
	}
	
	int leerCategoria() {
		int categoriaIn = Integer.parseInt(txtCategoria.getText().trim());
		return categoriaIn;
	}
	
	String leerNombres() {
		String nombresIn = txtNombres.getText().trim();
		return nombresIn;
	}
	
	String leerApellidos() {
		String apellidosIn = txtApellidos.getText().trim();
		return apellidosIn;
	}
	
	String leerTelefono() {
		String telefonoIn = txtTelefono.getText().trim();
		return telefonoIn;
	}
	
	String leerDni() {
		String dniIn = txtDni.getText().trim();
		return dniIn;
	}
	
	//Métodos para manejo del comboBox y entradasDelUsuario
	
	void habilitarEntradas() {
		txtCategoria.setEditable(true);
		txtNombres.setEditable(true);
		txtApellidos.setEditable(true);
		txtTelefono.setEditable(true);
		txtDni.setEditable(true);
	}
	
	
	void deshabilitarEntradas() {
		txtCategoria.setEditable(false);
		txtNombres.setEditable(false);
		txtApellidos.setEditable(false);
		txtTelefono.setEditable(false);
		txtDni.setEditable(false);
	}
	
	void limpiarEntradas() {
		txtCategoria.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
		txtCodigoVendedor.setText("");
	}
	
	void mensajeError(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	
	void mensajeConfirmacion(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 1);
	}
	
	void error(String s, JTextField txt) {
		mensajeError(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	

	private boolean comprobarSoloHayLetras(JTextField txt) {
        String texto = txt.getText();
        Pattern patron = Pattern.compile("^[A-Za-z ]+$");
        Matcher matcher = patron.matcher(texto);
        return matcher.matches();
    }
	
	private boolean comprobarSoloNumeros(JTextField txt) {
        String texto = txt.getText();
        Pattern patron = Pattern.compile("^[0-9]+$");
        Matcher matcher = patron.matcher(texto);
        return matcher.matches();
    }
	
	void listar() {
		modelo.setRowCount(0);
		Vendedor v;
		for (int i=0; i<av.tamanio(); i++) {
			v = av.obtener(i);
			Object[] fila = { v.getCodigoVendedor(),
					          v.getCategoria(),
					          v.getNombres(),
					          v.getApellidos(),
					          v.getTelefono(),
					          v.getDni(),
			};			          		         
			modelo.addRow(fila);
		}
			
	}
	
	void MostrarInfoTabla() {
		if (tblVendedores.getSelectedRow() != -1) {
			Vendedor v = av.obtener(tblVendedores.getSelectedRow());
			txtCodigoVendedor.setText("" + v.getCodigoVendedor());
			txtCategoria.setText("" + v.getCategoria());
			txtNombres.setText(v.getNombres());
			txtApellidos.setText(v.getApellidos());
			txtTelefono.setText(v.getTelefono());
			txtDni.setText(v.getDni());

		}
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel columnaVendedores = tblVendedores.getColumnModel();
		columnaVendedores.getColumn(0).setPreferredWidth(anchoColumna(40));
		columnaVendedores.getColumn(1).setPreferredWidth(anchoColumna(35));
		columnaVendedores.getColumn(2).setPreferredWidth(anchoColumna(40));
		columnaVendedores.getColumn(3).setPreferredWidth(anchoColumna(40));
		columnaVendedores.getColumn(4).setPreferredWidth(anchoColumna(35));
		columnaVendedores.getColumn(5).setPreferredWidth(anchoColumna(35));

	}
	
	void habilitarBotones() {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
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