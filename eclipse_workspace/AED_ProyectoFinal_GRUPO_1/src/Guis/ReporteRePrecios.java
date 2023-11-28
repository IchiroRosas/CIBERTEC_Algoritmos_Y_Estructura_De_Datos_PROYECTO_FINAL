package Guis;

import clases.Producto;
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
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class ReporteRePrecios extends JDialog {
	private JTextField txtPrecioPromedio;
	private JTextField txtPrecioMayor;
	private JTextField txtPrecioMenor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteRePrecios dialog = new ReporteRePrecios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteRePrecios() {
		setTitle("Reporte de Precios");
		setBounds(100, 100, 319, 199);
		getContentPane().setLayout(null);

		JLabel lblPrecioPromedio = new JLabel("Precio promedio (S/.):");
		lblPrecioPromedio.setForeground(new Color(255, 255, 255));
		lblPrecioPromedio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecioPromedio.setBounds(10, 30, 178, 13);
		getContentPane().add(lblPrecioPromedio);

		JLabel lblPrecioMayor = new JLabel("Precio mayor (S/.):");
		lblPrecioMayor.setForeground(new Color(255, 255, 255));
		lblPrecioMayor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecioMayor.setBounds(10, 71, 178, 13);
		getContentPane().add(lblPrecioMayor);

		JLabel lblNewLabel_1_1 = new JLabel("Precio menor (S/.):  ");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 113, 178, 13);
		getContentPane().add(lblNewLabel_1_1);

		txtPrecioPromedio = new JTextField();
		txtPrecioPromedio.setForeground(new Color(255, 255, 255));
		txtPrecioPromedio.setColumns(10);
		txtPrecioPromedio.setBounds(198, 27, 96, 19);
		txtPrecioPromedio.setEditable(false);
		txtPrecioPromedio.setText(ap.promedioPrecios());
		getContentPane().add(txtPrecioPromedio);

		txtPrecioMayor = new JTextField();
		txtPrecioMayor.setForeground(new Color(255, 255, 255));
		txtPrecioMayor.setColumns(10);
		txtPrecioMayor.setText(ap.mayorPrecio());
		txtPrecioMayor.setBounds(198, 68, 96, 19);
		txtPrecioMayor.setEditable(false);
		getContentPane().add(txtPrecioMayor);

		txtPrecioMenor = new JTextField();
		txtPrecioMenor.setForeground(new Color(255, 255, 255));
		txtPrecioMenor.setColumns(10);
		txtPrecioMenor.setText(ap.menorPrecio());
		txtPrecioMenor.setBounds(198, 110, 96, 19);
		txtPrecioMenor.setEditable(false);
		getContentPane().add(txtPrecioMenor);
	}
	
	ArrayList_Producto ap = new ArrayList_Producto();
	
	

}