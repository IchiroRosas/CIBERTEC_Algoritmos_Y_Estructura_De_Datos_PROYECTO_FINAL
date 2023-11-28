package Guis;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import array_lists.ArrayList_Producto;
import clases.Producto;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import java.awt.Color;


public class ReporteProductos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable tblReportes;
	private DefaultTableModel modelo;
	private JLabel lblReporteProductos;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteProductos dialog = new ReporteProductos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteProductos() {
		setTitle("Reporte General por Productos");
		setBounds(100, 100, 899, 363);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 863, 241);
		contentPanel.add(scrollPane);
		
		tblReportes = new JTable();
		tblReportes.setSelectionForeground(new Color(255, 255, 255));
		tblReportes.setGridColor(new Color(255, 255, 255));
		tblReportes.setForeground(new Color(255, 255, 255));
		tblReportes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblReportes);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo del Producto");
		modelo.addColumn("Descripción del Producto");
		modelo.addColumn("Cantidad de ventas");
		modelo.addColumn("Unidades Vendidas");
		modelo.addColumn("Importe Total (S/.)");
		tblReportes.setModel(modelo);
		
		lblReporteProductos = new JLabel("Reporte de Productos");
		lblReporteProductos.setForeground(new Color(255, 255, 255));
		lblReporteProductos.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblReporteProductos.setBounds(327, 11, 264, 29);
		contentPanel.add(lblReporteProductos);
		
		lblNewLabel_1 = new JLabel("_________________________");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(290, 11, 397, 59);
		contentPanel.add(lblNewLabel_1);
		
		listar();
		ajustarAnchoColumnas();
	}
	
	ArrayList_Producto ap = new ArrayList_Producto();

	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void ajustarAnchoColumnas() {
        TableColumnModel columnaProducto = tblReportes.getColumnModel();
        columnaProducto.getColumn(0).setPreferredWidth(anchoColumna(15));
        columnaProducto.getColumn(1).setPreferredWidth(anchoColumna(30));
        columnaProducto.getColumn(2).setPreferredWidth(anchoColumna(10));
        columnaProducto.getColumn(3).setPreferredWidth(anchoColumna(10));
        columnaProducto.getColumn(4).setPreferredWidth(anchoColumna(10));
    }
	
	void listar() {
		modelo.setRowCount(0);
		for(int i = 0; i<ap.tamanio(); i++) {
			  String importeF = df2.format(ap.obtener(i).getImporteTotal());	

			Object[] fila = { ap.obtener(i).getCodigoProducto(),
					  ap.obtener(i).getDescripcion(),
					  ap.obtener(i).getVentasEfectuadas(),
					  ap.obtener(i).getUnidadesVendidas(),
					  importeF};
			modelo.addRow(fila);
		}		
	}
	DecimalFormat df2 = new DecimalFormat("0.00");
}
