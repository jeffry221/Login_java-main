package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import inicial.Registrados;
import mantenimiento.GestionRegistrados;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class Registrate {

	JFrame frmRegistro;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JPasswordField txtClave;
	private JTextField txtNumero;
	private JTextField txtCorreo;
	private JPasswordField txtConfirmar;
	private JLabel lblValidacion;
	private JLabel lblValidacion1;
	private JLabel lblValidacion2;
	private JLabel lblValidacion3;
	private JLabel lblValidacion4;
	private JLabel lblValidacion5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrate window = new Registrate();
					window.frmRegistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Registrate() {
		initialize();
	}

	private void initialize() {
		frmRegistro = new JFrame();
		frmRegistro.setIconImage(Toolkit.getDefaultToolkit().getImage(Registrate.class.getResource("/imagenes/registrarse.png")));
		frmRegistro.setTitle("Registro");
		frmRegistro.setBounds(100, 100, 347, 595);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(96, 11, 142, 41);
		frmRegistro.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(55, 140, 46, 14);
		frmRegistro.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(55, 196, 46, 14);
		frmRegistro.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nombre de Usuario");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(55, 83, 144, 14);
		frmRegistro.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(55, 364, 91, 14);
		frmRegistro.getContentPane().add(lblNewLabel_4);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(55, 109, 144, 20);
		frmRegistro.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(53, 165, 144, 20);
		frmRegistro.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(55, 221, 144, 20);
		frmRegistro.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		JButton btnRegistrar = new JButton("Registrar ");
		btnRegistrar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
				registrarUsuarios();

			}

		});
		btnRegistrar.setBounds(94, 489, 144, 23);
		frmRegistro.getContentPane().add(btnRegistrar);

		txtClave = new JPasswordField();
		txtClave.setBounds(55, 389, 144, 20);
		frmRegistro.getContentPane().add(txtClave);

		JLabel lblNewLabel_5 = new JLabel("Numero de telefono ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(55, 252, 144, 14);
		frmRegistro.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Correo electronico ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(55, 308, 144, 14);
		frmRegistro.getContentPane().add(lblNewLabel_6);

		txtNumero = new JTextField();
		txtNumero.setBounds(55, 277, 144, 20);
		frmRegistro.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(55, 333, 144, 20);
		frmRegistro.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Confirmar contrase\u00F1a ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(55, 420, 144, 14);
		frmRegistro.getContentPane().add(lblNewLabel_7);

		txtConfirmar = new JPasswordField();
		txtConfirmar.setBounds(55, 445, 142, 20);
		frmRegistro.getContentPane().add(txtConfirmar);

		lblValidacion = new JLabel("Campo faltante ");
		lblValidacion.setForeground(Color.RED);
		lblValidacion.setLabelFor(txtUsuario);
		lblValidacion.setBounds(209, 112, 97, 14);
		frmRegistro.getContentPane().add(lblValidacion);
		lblValidacion.setVisible(false);

		lblValidacion1 = new JLabel("Campo faltante");
		lblValidacion1.setForeground(Color.RED);
		lblValidacion1.setBounds(209, 168, 97, 14);
		frmRegistro.getContentPane().add(lblValidacion1);
		lblValidacion1.setVisible(false);

		lblValidacion2 = new JLabel("Campo faltante");
		lblValidacion2.setForeground(Color.RED);
		lblValidacion2.setBounds(209, 224, 97, 14);
		frmRegistro.getContentPane().add(lblValidacion2);
		lblValidacion2.setVisible(false);

		lblValidacion3 = new JLabel("Campo faltante");
		lblValidacion3.setForeground(Color.RED);
		lblValidacion3.setBounds(209, 283, 97, 14);
		frmRegistro.getContentPane().add(lblValidacion3);
		lblValidacion3.setVisible(false);

		lblValidacion4 = new JLabel("Campo faltante");
		lblValidacion4.setForeground(Color.RED);
		lblValidacion4.setBounds(209, 336, 97, 14);
		frmRegistro.getContentPane().add(lblValidacion4);
		lblValidacion4.setVisible(false);

		lblValidacion5 = new JLabel("Campo faltante");
		lblValidacion5.setForeground(Color.RED);
		lblValidacion5.setBounds(209, 392, 97, 14);
		frmRegistro.getContentPane().add(lblValidacion5);
		lblValidacion5.setVisible(false);
	}

	@SuppressWarnings({ "deprecation", "unlikely-arg-type" }) void registrarUsuarios() {
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
				JOptionPane.showMessageDialog(frmRegistro, "Usuario Registrado");
				frmRegistro.dispose();
				Login1 window = new Login1();
				window.frmLogin.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(frmRegistro, "No se Registro el usuario", "aviso", JOptionPane.WARNING_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(frmRegistro, "Las contrase�as no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
		}


	}

	@SuppressWarnings({ "deprecation" })
	private void validar() {
		if (txtUsuario.getText().equals("")) {
			lblValidacion.setVisible(true);

		} else {
			lblValidacion.setVisible(false);
		}
		if (txtNombre.getText().equals("")) {
			lblValidacion1.setVisible(true);

		} else {
			lblValidacion1.setVisible(false);
		}
		if (txtApellido.getText().equals("")) {
			lblValidacion2.setVisible(true);

		} else {
			lblValidacion2.setVisible(false);
		}
		if (txtNumero.getText().equals("")) {
			lblValidacion3.setVisible(true);

		} else {
			lblValidacion3.setVisible(false);
		}
		if (txtCorreo.getText().equals("")) {
			lblValidacion4.setVisible(true);

		} else {
			lblValidacion4.setVisible(false);
		}
		if (txtClave.getText().equals("")) {
			lblValidacion5.setVisible(true);

		} else {
			lblValidacion5.setVisible(false);
		}

	}

}
