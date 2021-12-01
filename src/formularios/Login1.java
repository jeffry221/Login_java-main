package formularios;
import java.awt.EventQueue;
import mantenimiento.GestionUsuario;
import inicial.Usuario;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class Login1 {

	JFrame frmLogin;
	private JTextField txtUsuario;
	private JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 window = new Login1();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmLogin.setForeground(Color.BLUE);
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(Login1.class.getResource("/imagenes/registrarse.png")));
		frmLogin.getContentPane().setForeground(Color.BLUE);
		frmLogin.setTitle("Login ");
		frmLogin.setBounds(100, 100, 392, 351);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel((String) null);
		lblNewLabel.setBounds(0, 0, 434, 0);
		frmLogin.getContentPane().add(lblNewLabel);

		JLabel eti1 = new JLabel("Login ");
		eti1.setForeground(Color.BLUE);
		eti1.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		eti1.setBounds(87, 22, 121, 47);
		frmLogin.getContentPane().add(eti1);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("");
		txtUsuario.setBounds(87, 113, 187, 22);
		frmLogin.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrar();
			}
		});
		btnNewButton.setBounds(87, 205, 187, 33);
		frmLogin.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();

			}
		});
		btnNewButton_1.setBounds(87, 249, 187, 23);
		frmLogin.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Nombre de usuario");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(87, 88, 136, 14);
		frmLogin.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(87, 146, 100, 14);
		frmLogin.getContentPane().add(lblNewLabel_2);

		txtClave = new JPasswordField();
		txtClave.setBounds(87, 174, 187, 20);
		frmLogin.getContentPane().add(txtClave);
	}

	protected void registrar() {
		
		frmLogin.dispose();
		Registrate window = new Registrate();
		window.frmRegistro.setVisible(true);
		
	}


	protected void entrar() {
		
		String usuario = txtUsuario.getText();
		String clave = String.valueOf(txtClave.getPassword());
		
		GestionUsuario gestionUsuario = new GestionUsuario();
		
		Usuario usuario2 = new Usuario();
		usuario2.setUsuario(usuario);
		usuario2.setClave(clave);
		
		Usuario usu = gestionUsuario.obtenerUsuario(usuario2);
		
		if(usu  != null) {
			JOptionPane.showMessageDialog(frmLogin, "Bienvenido");
			frmLogin.dispose();
			Registrados2 window = new Registrados2();
			window.frmRegistrados.setVisible(true);
		}
		
			else {
				JOptionPane.showMessageDialog(frmLogin, "Debe ingresar su usuario y contraseña, si no está registrado debe registrarse.", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
		
	}

}
