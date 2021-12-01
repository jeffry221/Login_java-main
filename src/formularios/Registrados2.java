package formularios;

import java.awt.EventQueue;
import utils.MySQLConexion;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import inicial.Actualizados;
import inicial.Registrados;
import mantenimiento.GestionActualizados;
import mantenimiento.GestionEliminados;
import mantenimiento.GestionRegistrados;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Registrados2 {

	JFrame frmRegistrados;
	private JTable table;
	private JTextField txtUsuario;
	private JLabel lblBuscar1;
	private JLabel lblBuscar2;
	private JLabel lblBuscar3;
	private JLabel lblBuscar4;
	private JLabel lblBuscar5;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtNumero;
	private JTextField txtNombre;
	private JLabel lblConfirmar;
	private JLabel lblClave;
	private JPasswordField txtClave;
	private JPasswordField txtConfirmar;
	private JButton btnGuardar;
	private JButton btnBuscar;
	private JButton btnEliminar1;
	private JButton btnEliminar;
	private JButton btnCerrarSeccion;
	private JButton btnActualizar;
	private JButton btnNuevo;
	private JButton btnActualizar1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrados2 window = new Registrados2();
					window.frmRegistrados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registrados2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrados = new JFrame();
		frmRegistrados.setTitle("Registrados");
		frmRegistrados.setBounds(100, 100, 884, 529);
		frmRegistrados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 82, 660, 311);

		JLabel lblNewLabel = new JLabel("Clientes Registrados");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(296, 9, 312, 41);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 34));

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setForeground(Color.BLUE);
		btnActualizar.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtCorreo.setText("");
				txtNumero.setText("");
				btnCerrarSeccion.setVisible(false);
				btnEliminar.setVisible(false);
				btnNuevo.setVisible(false);
				btnBuscar.setVisible(false);
				btnActualizar1.setVisible(true);
				
			}
		});
		btnActualizar.setBounds(340, 415, 119, 34);

		btnNuevo = new JButton("NUEVO");
		btnNuevo.setForeground(Color.BLUE);
		btnNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNuevo.setBounds(181, 415, 119, 34);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtCorreo.setText("");
				txtNumero.setText("");
				btnCerrarSeccion.setVisible(false);
				btnEliminar.setVisible(false);
				btnActualizar.setVisible(false);
				btnGuardar.setVisible(true);
				btnBuscar.setVisible(false);
				lblClave.setVisible(true);
				lblConfirmar.setVisible(true);
				txtClave.setVisible(true);
				txtConfirmar.setVisible(true);

			}
		});

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtCorreo.setText("");
				txtNumero.setText("");
				lblBuscar2.setVisible(false);
				lblBuscar3.setVisible(false);
				lblBuscar4.setVisible(false);
				lblBuscar5.setVisible(false);
				txtApellido.setVisible(false);
				txtCorreo.setVisible(false);
				txtNumero.setVisible(false);
				txtNombre.setVisible(false);
				btnBuscar.setVisible(false);
				btnEliminar1.setVisible(true);
				btnNuevo.setVisible(false);
				btnCerrarSeccion.setVisible(false);
				btnActualizar.setVisible(false);
				
				
			}
		});
		btnEliminar.setBounds(469, 415, 139, 34);

		btnCerrarSeccion = new JButton("CERRAR SECCION");
		btnCerrarSeccion.setForeground(Color.BLUE);
		btnCerrarSeccion.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnCerrarSeccion.setBounds(651, 415, 139, 34);
		btnCerrarSeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistrados.dispose();
				Login1 window = new Login1();
				window.frmLogin.setVisible(true);
			}
		});

		txtUsuario = new JTextField();
		txtUsuario.setBounds(25, 52, 104, 20);
		txtUsuario.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.BLUE);
		btnBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;

				try {

					con = MySQLConexion.getConexion();
					pst = con.prepareStatement("SELECT * FROM usuarios WHERE usuario = ?");
					pst.setString(1, txtUsuario.getText());
					System.out.println(rs);
					rs = pst.executeQuery();
					if (rs.next()) {
						txtUsuario.setText(rs.getString("usuario"));
						txtNombre.setText(rs.getString("nombre"));
						txtApellido.setText(rs.getString("apellido"));
						txtCorreo.setText(rs.getString("correo"));
						txtNumero.setText(rs.getString("numero"));

					} else {
						JOptionPane.showMessageDialog(null, "No existe ese usuario");
					}
				} catch (Exception e1) {
					// TODO: handle exception
				}
				

			}
		});
		btnBuscar.setBounds(25, 292, 104, 34);

		MySQLConexion con = new MySQLConexion();
		Connection conexion = con.getConexion();

		String sql = "SELECT * FROM usuarios";
		Statement st;
		String nombreColumnas[] = { "usuario", "nombre", "apellido", "correo", "numero" };

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, nombreColumnas));

		// creacion de la tabla
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("usuario");
		model.addColumn("nombre");
		model.addColumn("apellido");
		model.addColumn("correo");
		model.addColumn("numero");
		table.setModel(model);

		Object[] dato = new Object[5];
		try {
			st = conexion.createStatement();
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				dato[0] = result.getString("usuario");
				dato[1] = result.getString("nombre");
				dato[2] = result.getString("apellido");
				dato[3] = result.getString("correo");
				dato[4] = result.getString("numero");
				model.addRow(dato);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		scrollPane.setViewportView(table);
		frmRegistrados.getContentPane().setLayout(null);
		frmRegistrados.getContentPane().add(btnNuevo);
		frmRegistrados.getContentPane().add(btnActualizar);
		frmRegistrados.getContentPane().add(txtUsuario);
		frmRegistrados.getContentPane().add(btnBuscar);
		frmRegistrados.getContentPane().add(btnEliminar);
		frmRegistrados.getContentPane().add(btnCerrarSeccion);
		frmRegistrados.getContentPane().add(scrollPane);
		frmRegistrados.getContentPane().add(lblNewLabel);

		lblBuscar1 = new JLabel("Usuario");
		lblBuscar1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBuscar1.setBounds(25, 32, 46, 14);
		frmRegistrados.getContentPane().add(lblBuscar1);

		lblBuscar2 = new JLabel("Nombre");
		lblBuscar2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBuscar2.setBounds(25, 83, 46, 14);
		frmRegistrados.getContentPane().add(lblBuscar2);

		lblBuscar3 = new JLabel("Apellido");
		lblBuscar3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBuscar3.setBounds(25, 139, 46, 14);
		frmRegistrados.getContentPane().add(lblBuscar3);

		lblBuscar4 = new JLabel("Correo");
		lblBuscar4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBuscar4.setBounds(25, 185, 46, 14);
		frmRegistrados.getContentPane().add(lblBuscar4);

		lblBuscar5 = new JLabel("Numero");
		lblBuscar5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBuscar5.setBounds(25, 236, 46, 14);
		frmRegistrados.getContentPane().add(lblBuscar5);

		txtApellido = new JTextField();
		txtApellido.setBounds(25, 154, 104, 20);
		frmRegistrados.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(25, 205, 132, 20);
		frmRegistrados.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(25, 261, 104, 20);
		frmRegistrados.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(25, 108, 104, 20);
		frmRegistrados.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		lblClave = new JLabel("Contrase\u00F1a");
		lblClave.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblClave.setBounds(25, 292, 104, 14);
		frmRegistrados.getContentPane().add(lblClave);
		lblClave.setVisible(false);

		lblConfirmar = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblConfirmar.setBounds(25, 344, 145, 14);
		frmRegistrados.getContentPane().add(lblConfirmar);
		lblConfirmar.setVisible(false);

		txtClave = new JPasswordField();
		txtClave.setBounds(25, 317, 104, 20);
		frmRegistrados.getContentPane().add(txtClave);
		txtClave.setVisible(false);

		txtConfirmar = new JPasswordField();
		txtConfirmar.setBounds(25, 373, 104, 20);
		frmRegistrados.getContentPane().add(txtConfirmar);
		txtConfirmar.setVisible(false);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.BLUE);
		btnGuardar.setVisible(false);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String usuario = txtUsuario.getText().toString();
				String clave = txtClave.getText().toString();
				String nombre = txtNombre.getText().toString();
				String apellido = txtApellido.getText().toString();
				String correo = txtCorreo.getText().toString();
				int numero =  (int) Long.parseLong(txtNumero.getText().toString());

				Registrados registrado = new Registrados();
				registrado.setUsuario(usuario);
				registrado.setClave(clave);
				registrado.setNombre(nombre);
				registrado.setApellido(apellido);
				registrado.setCorreo(correo);
				registrado.setNumero(numero);

				String pass = new String(txtClave.getPassword());
				String pass2 = new String(txtConfirmar.getPassword());

				if (pass.equals(pass2)) {
					GestionRegistrados gestionRegistrado = new GestionRegistrados();
					int ok = gestionRegistrado.registrar(registrado);
					System.out.println(ok);
					if (ok > 0) {
						JOptionPane.showMessageDialog(frmRegistrados, "Usuario Registrado");
						btnGuardar.setVisible(false);
						btnBuscar.setVisible(true);
						lblClave.setVisible(false);
						lblConfirmar.setVisible(false);
						txtClave.setVisible(false);
						txtConfirmar.setVisible(false);
						btnActualizar.setVisible(true);
						btnCerrarSeccion.setVisible(true);
						btnNuevo.setVisible(true);
						btnCerrarSeccion.setVisible(true);
						btnEliminar.setVisible(true);
						MySQLConexion con = new MySQLConexion();
						Connection conexion = con.getConexion();

						String sql = "SELECT * FROM usuarios";
						Statement st;
						String nombreColumnas[] = { "usuario", "nombre", "apellido", "correo", "numero" };
						
						DefaultTableModel model = new DefaultTableModel();
						model.addColumn("usuario");
						model.addColumn("nombre");
						model.addColumn("apellido");
						model.addColumn("correo");
						model.addColumn("numero");
						table.setModel(model);

						Object[] dato = new Object[5];
						try {
							st = conexion.createStatement();
							ResultSet result = st.executeQuery(sql);

							while (result.next()) {

								dato[0] = result.getString("usuario");
								dato[1] = result.getString("nombre");
								dato[2] = result.getString("apellido");
								dato[3] = result.getString("correo");
								dato[4] = result.getString("numero");
								model.addRow(dato);
							}

						} catch (Exception e3) {
							// TODO: handle exception
						}
						txtUsuario.setText("");
						txtNombre.setText("");
						txtApellido.setText("");
						txtCorreo.setText("");
						txtNumero.setText("");
						txtClave.setText("");
						txtConfirmar.setText("");
					} else {
						JOptionPane.showMessageDialog(frmRegistrados, "No se Registro el usuario", "aviso",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(frmRegistrados, "Las contraseñas no coinciden", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnGuardar.setBounds(25, 404, 104, 34);
		frmRegistrados.getContentPane().add(btnGuardar);
		
		btnEliminar1 = new JButton("Eliminar");
		btnEliminar1.setForeground(Color.BLUE);
		btnEliminar1.setVisible(false);
		btnEliminar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;

				String usuario = txtUsuario.getText().toString();

				Actualizados actualizados = new Actualizados();
				actualizados.setUsuario(usuario);

				int ok = GestionEliminados.eliminar(actualizados);
				System.out.println(ok);
				txtUsuario.setText("");
				
				if (ok > 0) {

					MySQLConexion con1 = new MySQLConexion();
					@SuppressWarnings("static-access")
					Connection conexion = con1.getConexion();

					String sql = "SELECT * FROM usuarios";
					Statement st1;
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("usuario");
					model.addColumn("nombre");
					model.addColumn("apellido");
					model.addColumn("correo");
					model.addColumn("numero");
					table.setModel(model);

					Object[] dato = new Object[5];
					try {

						st1 = conexion.createStatement();
						ResultSet result = st1.executeQuery(sql);

						while (result.next()) {

							dato[0] = result.getString("usuario");
							dato[1] = result.getString("nombre");
							dato[2] = result.getString("apellido");
							dato[3] = result.getString("correo");
							dato[4] = result.getString("numero");
							model.addRow(dato);
						}
						lblBuscar2.setVisible(true);
						lblBuscar3.setVisible(true);
						lblBuscar4.setVisible(true);
						lblBuscar5.setVisible(true);
						txtApellido.setVisible(true);
						txtCorreo.setVisible(true);
						txtNumero.setVisible(true);
						txtNombre.setVisible(true);
						btnBuscar.setVisible(true);
						btnEliminar1.setVisible(false);
						btnActualizar.setVisible(true);
						btnNuevo.setVisible(true);
						btnCerrarSeccion.setVisible(true);
						

					} catch (Exception e2) {
						// TODO: handle exception
					}
					JOptionPane.showMessageDialog(frmRegistrados, "Usuario Eliminado");

				} else {
					JOptionPane.showMessageDialog(frmRegistrados, "No se elimino el usuario", "aviso",
							JOptionPane.WARNING_MESSAGE);
				}
	

			}
				

				
			
		});
		btnEliminar1.setBounds(25, 83, 104, 34);
		frmRegistrados.getContentPane().add(btnEliminar1);
		
		btnActualizar1 = new JButton("Actualizar");
		btnActualizar1.setForeground(Color.BLUE);
		btnActualizar1.setVisible(false);
		btnActualizar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;

				String usuario = txtUsuario.getText().toString();
				String nombre = txtNombre.getText().toString();
				String apellido = txtApellido.getText().toString();
				String correo = txtCorreo.getText().toString();
				int numero =  (int) Long.parseLong(txtNumero.getText().toString());

				Actualizados actualizados = new Actualizados();
				actualizados.setUsuario(usuario);
				actualizados.setNombre(nombre);
				actualizados.setApellido(apellido);
				actualizados.setCorreo(correo);
				actualizados.setNumero(numero);

				int ok = GestionActualizados.actualizar(actualizados);
				System.out.println(ok);
				btnNuevo.setVisible(true);
				btnCerrarSeccion.setVisible(true);
				btnEliminar.setVisible(true);
				if (ok > 0) {

					MySQLConexion con1 = new MySQLConexion();
					@SuppressWarnings("static-access")
					Connection conexion = con1.getConexion();

					String sql = "SELECT * FROM usuarios";
					Statement st1;
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("usuario");
					model.addColumn("nombre");
					model.addColumn("apellido");
					model.addColumn("correo");
					model.addColumn("numero");
					table.setModel(model);

					Object[] dato = new Object[5];
					try {

						st1 = conexion.createStatement();
						ResultSet result = st1.executeQuery(sql);

						while (result.next()) {

							dato[0] = result.getString("usuario");
							dato[1] = result.getString("nombre");
							dato[2] = result.getString("apellido");
							dato[3] = result.getString("correo");
							dato[4] = result.getString("numero");
							model.addRow(dato);
						}

					} catch (Exception e2) {
						// TODO: handle exception
					}
					JOptionPane.showMessageDialog(frmRegistrados, "Usuario Actualizado");

				} else {
					JOptionPane.showMessageDialog(frmRegistrados, "No se Actualizo el usuario", "aviso",
							JOptionPane.WARNING_MESSAGE);
				}
				txtUsuario.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtCorreo.setText("");
				txtNumero.setText("");

			}
			
		});
		btnActualizar1.setBounds(25, 292, 104, 34);
		frmRegistrados.getContentPane().add(btnActualizar1);

	}

}
