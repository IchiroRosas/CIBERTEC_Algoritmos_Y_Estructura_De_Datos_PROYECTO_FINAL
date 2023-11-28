package Guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;


public class Principal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnReportes;
	private JMenuItem mntmProductos;
	private JMenuItem mntmClientes;
	private JMenuItem mntmVendedores;
	private JMenuItem mntmReProductos;
	private JMenuItem mntmReVendedores;
	private JMenuItem mntmRVendedor;
	private JMenuItem mntmRProducto;
	private JMenuItem mntmRPrecios;
	private JMenuItem mntmVender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		/*AQUI SE HACE REFERENCIA A flatlaf PARA EL UI DESIGN*/
		try {
			UIManager.setLookAndFeel(new FlatDarkLaf());
			/*AQUI LA LISTA DE ESTILOS QUE PUEDES USAR*/
			/**
			 * UIManager.setLookAndFeel(new FlatLightLaf());
			 * UIManager.setLookAndFeel(new FlatDarkLaf());
			 * UIManager.setLookAndFeel(new FlatIntelliJLaf());
			 * UIManager.setLookAndFeel(new FlatDarculaLaf());
			 * UIManager.setLookAndFeel(new FlatMacLightLaf());
			 * UIManager.setLookAndFeel(new FlatMacDarkLaf());
			 */
			
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/iconos/tienda.png")));
		setResizable(false);
		setTitle("Men\u00FA Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 547);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setForeground(new Color(255, 255, 255));
		mnArchivo.setFont(new Font("Verdana", Font.BOLD, 14));
		mnArchivo.setIcon(new ImageIcon(Principal.class.getResource("/iconos/Imagen1.png")));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setForeground(new Color(255, 255, 255));
		mntmSalir.setFont(new Font("Verdana", Font.PLAIN, 13));
		mntmSalir.setIcon(new ImageIcon(Principal.class.getResource("/iconos/Imagen2.png")));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setForeground(new Color(255, 255, 255));
		mnMantenimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		mnMantenimiento.setIcon(new ImageIcon(Principal.class.getResource("/iconos/Imagen10.png")));
		mnMantenimiento.addActionListener(this);
		menuBar.add(mnMantenimiento);
		
		mntmVendedores = new JMenuItem("Vendedores");
		mntmVendedores.setForeground(new Color(255, 255, 255));
		mntmVendedores.setIcon(new ImageIcon(Principal.class.getResource("/iconos/vendedor.png")));
		mntmVendedores.setFont(new Font("Verdana", Font.PLAIN, 13));
		mntmVendedores.addActionListener(this);
		mnMantenimiento.add(mntmVendedores);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setForeground(new Color(255, 255, 255));
		mntmClientes.setIcon(new ImageIcon(Principal.class.getResource("/iconos/cliente.png")));
		mntmClientes.setFont(new Font("Verdana", Font.PLAIN, 13));
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.setForeground(new Color(255, 255, 255));
		mntmProductos.setIcon(new ImageIcon(Principal.class.getResource("/iconos/producto.png")));
		mntmProductos.setFont(new Font("Verdana", Font.PLAIN, 13));
		mntmProductos.addActionListener(this);
		mnMantenimiento.add(mntmProductos);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setForeground(new Color(255, 255, 255));
		mnVentas.setFont(new Font("Verdana", Font.BOLD, 14));
		mnVentas.setIcon(new ImageIcon(Principal.class.getResource("/iconos/Imagen8.png")));
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.setForeground(new Color(255, 255, 255));
		mntmVender.setFont(new Font("Verdana", Font.PLAIN, 13));
		mntmVender.setIcon(new ImageIcon(Principal.class.getResource("/iconos/Imagen7.png")));
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setForeground(new Color(255, 255, 255));
		mnReportes.setFont(new Font("Verdana", Font.BOLD, 14));
		mnReportes.setIcon(new ImageIcon(Principal.class.getResource("/iconos/listar.png")));
		menuBar.add(mnReportes);
		
		mntmReProductos = new JMenuItem("Reporte general por productos");
		mntmReProductos.setForeground(new Color(255, 255, 255));
		mntmReProductos.setIcon(new ImageIcon(Principal.class.getResource("/iconos/reporte1.png")));
		mntmReProductos.setFont(new Font("Verdana", Font.PLAIN, 13));
		mntmReProductos.addActionListener(this);
		mnReportes.add(mntmReProductos);
		
		mntmReVendedores = new JMenuItem("Reporte general por vendedores");
		mntmReVendedores.setForeground(new Color(255, 255, 255));
		mntmReVendedores.setIcon(new ImageIcon(Principal.class.getResource("/iconos/reporte1.png")));
		mntmReVendedores.setFont(new Font("Verdana", Font.PLAIN, 13));
		mntmReVendedores.addActionListener(this);
		mnReportes.add(mntmReVendedores);
		
		mntmRVendedor = new JMenuItem("Reporte por vendedor");
		mntmRVendedor.setForeground(new Color(255, 255, 255));
		mntmRVendedor.setIcon(new ImageIcon(Principal.class.getResource("/iconos/reporte2.png")));
		mntmRVendedor.setFont(new Font("Verdana", Font.PLAIN, 13));
		mntmRVendedor.addActionListener(this);
		mnReportes.add(mntmRVendedor);
		
		mntmRProducto = new JMenuItem("Reporte por producto");
		mntmRProducto.setForeground(new Color(255, 255, 255));
		mntmRProducto.setIcon(new ImageIcon(Principal.class.getResource("/iconos/reporte2.png")));
		mntmRProducto.setFont(new Font("Verdana", Font.PLAIN, 13));
		mntmRProducto.addActionListener(this);
		mnReportes.add(mntmRProducto);
		
		mntmRPrecios = new JMenuItem("Reporte de precios");
		mntmRPrecios.setForeground(new Color(255, 255, 255));
		mntmRPrecios.setIcon(new ImageIcon(Principal.class.getResource("/iconos/reporte2.png")));
		mntmRPrecios.setFont(new Font("Verdana", Font.PLAIN, 13));
		mntmRPrecios.addActionListener(this);
		mnReportes.add(mntmRPrecios);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	//If´s para identificar los botones
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == mntmSalir) {
			actionPerformedSalir(e);
		}
		if(e.getSource() == mntmVendedores) {
			actionPerformedVendedores(e);
		}
		if(e.getSource() == mntmClientes) {
			actionPerformedClientes(e);
		}
		if(e.getSource() == mntmProductos) {
			actionPerformedProductos(e);
		}
		if(e.getSource() == mntmVender) {
			actionPerformedVender(e);
		}
		if(e.getSource() == mntmReProductos) {
			actionPerformedReProductos(e);
		}
		if(e.getSource() == mntmReVendedores) {
			actionPerformedReVendedores(e);
		}
		if(e.getSource() == mntmRVendedor) {
			actionPerformedReVendedor(e);
		}
		if(e.getSource() == mntmRProducto) {
			actionPerformedRProducto(e);
		}
		if(e.getSource() == mntmRPrecios) {
			actionPerformedRPrecios(e);
		}
		
	}
	
	//Conectando el JFrame principal a los demas JDialog :v
	
	public void actionPerformedSalir(ActionEvent e) {
		int ok = JOptionPane.showConfirmDialog(this," Estás seguro(a)?", "Alerta", 0, 1, null);
		if (ok == 0) {
			this.setVisible(false);
		}
	}
	
	public void actionPerformedVendedores(ActionEvent e) {
		Vendedores a = new Vendedores();
		a.setModal(true);
		a.setLocationRelativeTo(this);
		a.setVisible(true);
	}
	
	public void actionPerformedClientes(ActionEvent e) {
		Clientes a = new Clientes();
		a.setLocationRelativeTo(this);
		a.setModal(true);
		a.setVisible(true);
	}
	
	public void actionPerformedProductos(ActionEvent e) {
		Productos a = new Productos();
		a.setModal(true);
		a.setLocationRelativeTo(this);
		a.setVisible(true);
	}
	
	public void actionPerformedVender(ActionEvent e) {
		VentanaVender a = new VentanaVender();
		a.setModal(true);
		a.setLocationRelativeTo(this);
		a.setVisible(true);
	}
	
	public void actionPerformedReProductos(ActionEvent e) {
		ReporteProductos a = new ReporteProductos();
		a.setModal(true);
		a.setLocationRelativeTo(this);
		a.setVisible(true);
	}
	
	public void actionPerformedReVendedores(ActionEvent e) {
		ReporteVendedores a = new ReporteVendedores();
		a.setModal(true);
		a.setLocationRelativeTo(this);
		a.setVisible(true);
	}
	
	public void actionPerformedReVendedor(ActionEvent e) {
		ReporteReVendedor a = new ReporteReVendedor();
		a.setModal(true);
		a.setLocationRelativeTo(this);
		a.setVisible(true);
	}
	
	public void actionPerformedRProducto(ActionEvent e) {
		ReporteReProducto a = new ReporteReProducto();
		a.setModal(true);
		a.setLocationRelativeTo(this);
		a.setVisible(true);
	}
	
	public void actionPerformedRPrecios(ActionEvent e) {
		ReporteRePrecios a = new ReporteRePrecios();
		a.setModal(true);
		a.setLocationRelativeTo(this);
		a.setVisible(true);
	}
}
