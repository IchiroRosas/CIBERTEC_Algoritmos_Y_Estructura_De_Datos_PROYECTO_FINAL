package Guis;

import clases.Cliente;
import array_lists.ArrayList_Cliente;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

public class Clientes extends JDialog implements ActionListener, MouseListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnAdicionar;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Clientes dialog = new Clientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/iconos/tienda.png")));
		setTitle("Clientes");
		setBounds(100, 100, 662, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 48, 103, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 73, 103, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Telefono:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 98, 103, 14);
		contentPanel.add(lblNewLabel_3);
		
		txtNombres = new JTextField();
		txtNombres.setForeground(new Color(255, 255, 255));
		txtNombres.setEditable(false);
		txtNombres.setColumns(10);
		txtNombres.setBounds(123, 44, 160, 22);
		contentPanel.add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setForeground(new Color(255, 255, 255));
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(123, 69, 160, 22);
		contentPanel.add(txtApellidos);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(new Color(255, 255, 255));
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(123, 95, 160, 20);
		contentPanel.add(txtTelefono);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setIcon(new ImageIcon(Clientes.class.getResource("/iconos/modificar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setEnabled(false);
		btnModificar.setBounds(519, 43, 117, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setIcon(new ImageIcon(Clientes.class.getResource("/iconos/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(519, 69, 117, 23);
		contentPanel.add(btnEliminar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setIcon(new ImageIcon(Clientes.class.getResource("/iconos/grabar.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(371, 119, 117, 23);
		contentPanel.add(btnGuardar);
		
		lblNewLabel = new JLabel("Codigo Cliente");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 15, 103, 14);
		contentPanel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 626, 248);
		contentPanel.add(scrollPane);
		
		tblClientes = new JTable();
		tblClientes.setForeground(new Color(255, 255, 255));
		tblClientes.setGridColor(new Color(255, 255, 255));
		tblClientes.setSelectionForeground(new Color(255, 255, 255));
		tblClientes.addMouseListener(this);
		tblClientes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblClientes);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Telefonos");
		modelo.addColumn("DNI");
		tblClientes.setModel(modelo);
		listar();
		ajustarAnchoColumnas();

		lblNewLabel_4 = new JLabel("DNI:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(10, 123, 85, 14);
		contentPanel.add(lblNewLabel_4);
		
		txtDni = new JTextField();
		txtDni.setForeground(new Color(255, 255, 255));
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(123, 120, 160, 20);
		contentPanel.add(txtDni);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setIcon(new ImageIcon(Clientes.class.getResource("/iconos/adicionar.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(519, 15, 117, 23);
		contentPanel.add(btnAdicionar);
		
		txtCodigoClientes = new JTextField();
		txtCodigoClientes.setForeground(new Color(255, 255, 255));
		txtCodigoClientes.setEditable(false);
		txtCodigoClientes.setColumns(10);
		txtCodigoClientes.setBounds(123, 12, 160, 22);
		contentPanel.add(txtCodigoClientes);

	}
	
	ArrayList_Cliente ac = new ArrayList_Cliente();
	private JTextField txtCodigoClientes;
	private JTable tblClientes;
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		
		if(e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		
		if(e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		
		if(e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==tblClientes) {
			mouseClickedTblClientes(e);
		}
	}
	
	private void actionPerformedBtnAdicionar(ActionEvent e) {
		limpiarTxts();
		int nuevoCod = ac.generarCodigoCorrelativoCliente();
		String nuevoCodS = Integer.toString(nuevoCod);
		txtCodigoClientes.setText(nuevoCodS);
		habilitarTxts();
		botonesAdicionar();
	}
	
	private void actionPerformedBtnModificar(ActionEvent e) {
		habilitarTxts();
		botonesModificar();
	}

	private void actionPerformedBtnEliminar(ActionEvent e) {
		int codCliente = leerComboBoxCliente();
		for(int i = 0; i<ac.tamanio(); i++) {
			int objetoEliminar = ac.obtener(i).getCodigoCliente();
			if(codCliente == objetoEliminar) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
				ac.eliminar(i);
				ac.grabarSobrescribirClientes();
				limpiarTxts();
				listar();
				}
			}
		}
	}
	
	private void actionPerformedBtnGuardar(ActionEvent e) {
		int codCliente = leerComboBoxCliente();
		String nombresClientes = leerNombres();
		boolean nombresSoloLetras = comprobarSoloHayLetras(txtNombres);
		if (nombresSoloLetras == true) {
			String apellidosClientes = leerApellidos();
			boolean apellidosSoloLetras = comprobarSoloHayLetras(txtApellidos);
			if (apellidosSoloLetras == true) {
				String telefonoCliente = leerTelefonos();
				boolean telefonoNum = comprobarSoloNumeros(txtTelefono);
				if (telefonoNum == true) {
					String dniCliente = leerDni();
					boolean dniNum = comprobarSoloNumeros(txtDni);
					if (dniNum == true) {

						boolean existe = false;

						for (int i = 0; i < ac.tamanio(); i++) {
							int codigoPregunta = ac.obtener(i).getCodigoCliente();
							if (codCliente == codigoPregunta) {
								existe = true;
							}
						}

						try {
							if (existe == false) {
								Cliente nuevo = new Cliente(codCliente, nombresClientes,
										apellidosClientes, telefonoCliente, dniCliente);
								ac.adicionar(nuevo);
								ac.grabarSobrescribirClientes();

								deshabilitarTxts();
								limpiarTxts();
								btnGuardar.setEnabled(false);
								btnAdicionar.setEnabled(true);
								btnModificar.setEnabled(false);
								btnEliminar.setEnabled(false);
								mensajeConfirmacion("Cliente adicionado con exito");
								listar();
							} else {
								Cliente nuevo = new Cliente(codCliente, nombresClientes,
										apellidosClientes, telefonoCliente, dniCliente);
								int posicionAReemplazar = ac.buscar(codCliente);
								ac.set(posicionAReemplazar, nuevo);
								ac.grabarSobrescribirClientes();
								mensajeConfirmacion("Cliente modificado con exito");
								btnGuardar.setEnabled(false);
								btnModificar.setEnabled(false);
								btnEliminar.setEnabled(false);
								btnAdicionar.setEnabled(true);
								deshabilitarTxts();
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
	}
	
	private void mouseClickedTblClientes(MouseEvent e) {
		String nombres = leerNombres();
		MostrarInfoTabla();	
		if(nombres.isBlank() == false) {
			habilitarBotones();
			deshabilitarTxts();
		}
	}

	/*____________________________Metodos de tipo Void____________________________*/
	void limpiarTxts() {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
		txtCodigoClientes.setText("");
	}

	void deshabilitarTxts() {
		txtNombres.setEditable(false);
		txtApellidos.setEditable(false);
		txtTelefono.setEditable(false);
		txtDni.setEditable(false);	
	}
	
	void habilitarTxts() {
		txtNombres.setEditable(true);
		txtApellidos.setEditable(true);
		txtTelefono.setEditable(true);
		txtDni.setEditable(true);	
	}
	
	void botonesAdicionar() {
		btnGuardar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnAdicionar.setEnabled(true);
		txtNombres.requestFocus();
	}
	
	void botonesModificar() {
		btnAdicionar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnModificar.setEnabled(true);
		txtNombres.requestFocus();
	}
	
	void habilitarBotones() {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
	}


	/*____________________________Metodos para leer los JTextFields____________________________*/
	
	String leerNombres() {
		String nombre = txtNombres.getText().trim();
		return nombre;
	}
	
	String leerApellidos() {
		String apellidos = txtApellidos.getText().trim();
		return apellidos;
	}

	String leerTelefonos() {
		String telefono = txtTelefono.getText().trim();
		return telefono;
	}

	String leerDni() {
		String dni = txtDni.getText().trim();
		return dni;
	}
	
	int leerComboBoxCliente() {
		int codCliente = Integer.parseInt(txtCodigoClientes.getText().trim());
		return codCliente;
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	/*____________________________Métodos para mensajes____________________________*/
	
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
	
	/*____________________________Métodos para listar informacion del Cliente____________________________*/

	void listar() {
		modelo.setRowCount(0);
		Cliente c;
		for (int i=0; i<ac.tamanio(); i++) {
			c = ac.obtener(i);
			Object[] fila = { c.getCodigoCliente(),
					          c.getNombres(),
					          c.getApellidos(),
					          c.getTelefono(),
					          c.getDni(),
			};			          		         
			modelo.addRow(fila);
		}
			
	}
	
	void MostrarInfoTabla() {
		if (tblClientes.getSelectedRow() != -1) {
	        Cliente c = ac.obtener(tblClientes.getSelectedRow());
            txtCodigoClientes.setText(""+c.getCodigoCliente());
            txtNombres.setText(c.getNombres());
            txtApellidos.setText(c.getApellidos());
            txtTelefono.setText(c.getTelefono());
            txtDni.setText(c.getDni());      
        }
    }
	
	void ajustarAnchoColumnas() {
		TableColumnModel columnaCliente = tblClientes.getColumnModel();
		columnaCliente.getColumn(0).setPreferredWidth(anchoColumna(20));
		columnaCliente.getColumn(1).setPreferredWidth(anchoColumna(30));
		columnaCliente.getColumn(2).setPreferredWidth(anchoColumna(30));
		columnaCliente.getColumn(3).setPreferredWidth(anchoColumna(20));
		columnaCliente.getColumn(4).setPreferredWidth(anchoColumna(20));
	}
		
	/*____________________________Métodos para Validaciones____________________________*/
	
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
	
	/*____________________________Métodos para hacer funcionar la Tabla____________________________*/

	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}