import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class PerfilAlan extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilAlan frame = new PerfilAlan();
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
	public PerfilAlan() {
		setTitle("Perfil del Estudiante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 297);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Este programa fue hecho con <3 por Alan Ramirez!");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(31, 11, 262, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(30, 46, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Alan Eduardo Ramirez Socias");
		lblNewLabel_2.setBounds(135, 46, 158, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Matricula:");
		lblNewLabel_3.setBounds(26, 77, 76, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("2019-8331");
		lblNewLabel_4.setBounds(135, 77, 139, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Curso: ");
		lblNewLabel_5.setBounds(26, 111, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Software");
		lblNewLabel_6.setBounds(135, 111, 139, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Hola! Si estas leyendo esto, significa que elegiste la opcion");
		lblNewLabel_7.setBounds(31, 146, 340, 24);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("de mi perfil, soy Alan, un estudiante de software del");
		lblNewLabel_8.setBounds(31, 168, 340, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Instituto Tecnologico de las Americas, ITLA!");
		lblNewLabel_9.setForeground(new Color(0, 255, 255));
		lblNewLabel_9.setBounds(31, 181, 283, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Espero seguir adelante y hacer un gran cambio para mi pais!");
		lblNewLabel_10.setBounds(31, 198, 361, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("(Hello, world!)");
		lblNewLabel_11.setBounds(306, 244, 86, 14);
		contentPane.add(lblNewLabel_11);
	}
}
