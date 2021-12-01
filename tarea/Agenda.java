import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class Agenda implements ActionListener, ChangeListener {

	private JFrame frmAgendaElectronica;
	private JTextField nom;
	private JTextField desc;
	private JTable table;
	JDateChooser date2;
	JDateChooser date1;
	DefaultTableModel Table;
	String nombre;
	String descrip;
	String fecha1;
	String fecha2;
	int id;
	String idconvertido;
	int id_busqueda;
	String idc_busqueda;
	String nombre_busqueda;
	String descrip_busqueda;
	String fecha1_busqueda;
	String fecha2_busqueda;
	JMenuItem search1;
	JMenuItem search2;
	JMenuItem del1;
	JMenuItem del2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda window = new Agenda();
					window.frmAgendaElectronica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Agenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaElectronica = new JFrame();
		frmAgendaElectronica.setTitle("Agenda Electronica");
		frmAgendaElectronica.setBounds(100, 100, 647, 380);
		frmAgendaElectronica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgendaElectronica.getContentPane().setLayout(null);
		
		String completerow [][]={};
	   	String columna [] = {"ID","Nombre","Fecha Inicio","Fecha Fin","Descripcion"};
	   	Table = new DefaultTableModel(completerow,columna);
	   	table = new JTable(Table);
	   	JScrollPane scroll = new JScrollPane(table);
	   	scroll.setBounds(0, 192, 631, 128);
	   	table.setFillsViewportHeight(true);
	   	frmAgendaElectronica.getContentPane().add(scroll);
		
		JLabel lblNewLabel = new JLabel("Evento");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(291, 11, 46, 14);
		frmAgendaElectronica.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del Evento");
		lblNewLabel_1.setBounds(29, 43, 110, 14);
		frmAgendaElectronica.getContentPane().add(lblNewLabel_1);
		
		nom = new JTextField();
		nom.setBounds(29, 68, 161, 20);
		nom.addActionListener(e ->  {
		});
		frmAgendaElectronica.getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha del evento");
		lblNewLabel_2.setBounds(425, 43, 120, 14);
		frmAgendaElectronica.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de Inicio");
		lblNewLabel_3.setBounds(352, 68, 104, 14);
		frmAgendaElectronica.getContentPane().add(lblNewLabel_3);
		
		Label label = new Label("Fecha de Cierre");
		label.setBounds(488, 68, 91, 14);
		frmAgendaElectronica.getContentPane().add(label);
		
		JLabel lblNewLabel_4 = new JLabel("Descripcion");
		lblNewLabel_4.setBounds(29, 111, 161, 14);
		frmAgendaElectronica.getContentPane().add(lblNewLabel_4);
		
		desc = new JTextField();
		desc.setBounds(29, 136, 200, 20);
		desc.addActionListener(e ->  {
		});
		frmAgendaElectronica.getContentPane().add(desc);
		desc.setColumns(10);
		
		JButton guardar = new JButton("Guardar");
		guardar.setForeground(new Color(0, 0, 0));
		guardar.setBackground(new Color(50, 205, 50));
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con= 
							DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea4?characterEncoding=latin1","root","mercy241");
					java.sql.Statement stm= con.createStatement();
					nombre = nom.getText();
					descrip = desc.getText();
                    fecha1 = String.valueOf(date1.getDate());
                    fecha2 = String.valueOf(date2.getDate());
					((java.sql.Statement) stm).executeUpdate("INSERT INTO eventos(nombre,descripcion,fecha1,fecha2) Values('"+nombre+"','"+descrip+"','"+fecha1+"','"+fecha2+"')");
					JOptionPane.showMessageDialog(null, "Se ha registrado el evento Exitosamente");
					java.sql.ResultSet rs = stm.executeQuery("select ID from eventos where nombre='"+nombre+"' and descripcion= '"+descrip+"'");
					if (rs.next()==true){
						id = rs.getInt("id");
						idconvertido = String.valueOf(id);
			           }
			           rs.close();
					setTable(idconvertido, nombre, descrip, fecha1, fecha2);
					con.close();
				}catch(ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Algo salio mal, parece que se ha producido un error. Disculpe por los inconvenientes." + "\n" + e.getMessage());
					e.printStackTrace();
				}catch(SQLException i) {
					JOptionPane.showMessageDialog(null, "Algo salio mal, parece que se ha producido un error. Disculpe por los inconvenientes." + "\n" + i.getMessage());
				}
			}	
			});
		guardar.setBounds(231, 157, 199, 35);
		frmAgendaElectronica.getContentPane().add(guardar);
		
		JButton actualizar = new JButton("Actualizar");
		actualizar.setForeground(new Color(0, 0, 0));
		actualizar.setBackground(new Color(255, 165, 0));
		actualizar.setBounds(432, 157, 199, 35);
		actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				idc_busqueda= JOptionPane.showInputDialog("Impute la ID de el evento que desea actualizar");
		    	id_busqueda= Integer.valueOf(idc_busqueda);
		    	try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con= 
							DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","");
					java.sql.Statement stm= con.createStatement();
					java.sql.ResultSet rs = stm.executeQuery("select ID from eventos where ID='"+id_busqueda+"'");
					if (rs.next()==true){
						nombre = nom.getText();
						descrip = desc.getText();
	                    fecha1 = String.valueOf(date1.getDate());
	                    fecha2 = String.valueOf(date2.getDate());
						((java.sql.Statement) stm).executeUpdate("INSERT INTO eventos(nombre,descripcion,fecha1,fecha2) Values('"+nombre+"','"+descrip+"','"+fecha1+"','"+fecha2+"')");
						JOptionPane.showMessageDialog(null, "Evento actualizado exitosamente");
						idconvertido= idc_busqueda;
						setTable(idconvertido, nombre, descrip, fecha1, fecha2);
						con.close();
		    	}}catch(ClassNotFoundException d) {
						JOptionPane.showMessageDialog(null, "No se encontro ningun evento con ese valor." + "\n" + d.getMessage());
						d.printStackTrace();
					}catch(SQLException i) {
						JOptionPane.showMessageDialog(null, "Algo salio mal, parece que se ha producido un error. Disculpe por los inconvenientes." + "\n" + i.getMessage());
					}
			}
		});
		frmAgendaElectronica.getContentPane().add(actualizar);
		
		date2 = new JDateChooser();
		date2.getCalendarButton().addActionListener(this);
		date2.setBounds(466, 93, 125, 20);
		frmAgendaElectronica.getContentPane().add(date2);
		
		date1 = new JDateChooser();
		date1.getCalendarButton().addActionListener(this);
		date1.setBounds(331, 93, 125, 20);
		frmAgendaElectronica.getContentPane().add(date1);
		
		JButton nuevo = new JButton("Limpiar");
		nuevo.setBounds(0, 167, 89, 23);
		nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nom.setText("");
				desc.setText("");
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}	
			});
		frmAgendaElectronica.getContentPane().add(nuevo);
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmAgendaElectronica.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.setForeground(Color.DARK_GRAY);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Buscar");
		mnNewMenu_1.setForeground(SystemColor.textHighlight);
		mnNewMenu.add(mnNewMenu_1);
		
		search1 = new JMenuItem("Por ID");
		search1.addActionListener(this);
		mnNewMenu_1.add(search1);
		
		search2 = new JMenuItem("Por Nombre");
		search2.addActionListener(this);
		mnNewMenu_1.add(search2);
		
		JMenu mnNewMenu_2 = new JMenu("Borrar");
		mnNewMenu_2.setForeground(Color.RED);
		mnNewMenu.add(mnNewMenu_2);
		
		del1 = new JMenuItem("Borrar por ID");
		del1.addActionListener(this);
		mnNewMenu_2.add(del1);
		
		del2 = new JMenuItem("Borrar por Nombre");
		del2.addActionListener(this);
		mnNewMenu_2.add(del2);
		
		JMenuItem Alan = new JMenuItem("Perfil del Estudiante");
		Alan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PerfilAlan perfilalan= new PerfilAlan();
				perfilalan.setVisible(true);
			}
		});
		Alan.setForeground(Color.GRAY);
		mnNewMenu.add(Alan);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search1) {
			idc_busqueda= JOptionPane.showInputDialog("Impute la ID de el evento que desea Buscar");
	    	id_busqueda= Integer.valueOf(idc_busqueda);
	    	idconvertido= idc_busqueda;
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con= 
						DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","");
				java.sql.Statement stm= con.createStatement();
				java.sql.ResultSet rs = stm.executeQuery("select ID from eventos where ID='"+id_busqueda+"'");
				if (rs.next()==true){
					JOptionPane.showMessageDialog(null, "La tabla ha sido encontrada!");
					java.sql.ResultSet rs2 = stm.executeQuery("select nombre from eventos where ID='"+id_busqueda+"'");
					if (rs2.next()==true){
						 nombre= rs2.getString("nombre");
			           }
					java.sql.ResultSet rs3 = stm.executeQuery("select descripcion from eventos where ID='"+id_busqueda+"'");
					if (rs3.next()==true){
						 descrip= rs3.getString("descripcion");
			           }
					java.sql.ResultSet rs4 = stm.executeQuery("select fecha1 from eventos where ID='"+id_busqueda+"'");
					if (rs4.next()==true){
						 fecha1= rs4.getString("fecha1");
			           }
					java.sql.ResultSet rs5 = stm.executeQuery("select fecha2 from eventos where ID='"+id_busqueda+"'");
					if (rs5.next()==true){
						 fecha2= rs5.getString("fecha2");
			           }
					setTable(idconvertido, nombre, descrip, fecha1, fecha2);
				} else {
					JOptionPane.showMessageDialog(null, "La tabla no fue encontrada, intente escribir otra ID");
				}
					}catch(ClassNotFoundException d) {
					JOptionPane.showMessageDialog(null, "No se encontro ningun evento con ese valor." + "\n" + d.getMessage());
					d.printStackTrace();
				}catch(SQLException i) {
					JOptionPane.showMessageDialog(null, "Algo salio mal, parece que se ha producido un error. Disculpe por los inconvenientes." + "\n" + i.getMessage());
				}
	    }
		if(e.getSource()==search2) {
			nombre_busqueda= JOptionPane.showInputDialog("Impute el Nombre de el evento que desea Buscar");
	    	nombre= String.valueOf(nombre_busqueda);
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con= 
						DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","");
				java.sql.Statement stm= con.createStatement();
				java.sql.ResultSet rs = stm.executeQuery("select nombre from eventos where nombre='"+nombre+"'");
				if (rs.next()==true){
					JOptionPane.showMessageDialog(null, "La tabla ha sido encontrada!");
					java.sql.ResultSet rs2 = stm.executeQuery("select ID from eventos where nombre='"+nombre+"'");
					if (rs2.next()==true){
						 idconvertido= rs2.getString("idconvertido");
			           }
					java.sql.ResultSet rs3 = stm.executeQuery("select descripcion from eventos where nombre='"+nombre+"'");
					if (rs3.next()==true){
						 descrip= rs3.getString("descripcion");
			           }
					java.sql.ResultSet rs4 = stm.executeQuery("select fecha1 from eventos where nombre='"+nombre+"'");
					if (rs4.next()==true){
						 fecha1= rs4.getString("fecha1");
			           }
					java.sql.ResultSet rs5 = stm.executeQuery("select fecha2 from eventos where nombre='"+nombre+"'");
					if (rs5.next()==true){
						 fecha2= rs5.getString("fecha2");
			           }
					setTable(idconvertido, nombre, descrip, fecha1, fecha2);
				} else {
					JOptionPane.showMessageDialog(null, "La tabla no fue encontrada, intente escribir otra ID");
				}
					
	    	}catch(ClassNotFoundException d) {
					JOptionPane.showMessageDialog(null, "No se encontro ningun evento con ese valor." + "\n" + d.getMessage());
					d.printStackTrace();
				}catch(SQLException i) {
					JOptionPane.showMessageDialog(null, "Algo salio mal, parece que se ha producido un error. Disculpe por los inconvenientes." + "\n" + i.getMessage());
				}
	    }if(e.getSource()==del1) {
	    	idc_busqueda= JOptionPane.showInputDialog("Impute la ID de el evento que desea Borrar");
	    	id_busqueda= Integer.valueOf(idc_busqueda);
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con= 
						DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","");
				java.sql.Statement stm= con.createStatement();
				java.sql.ResultSet rs = stm.executeQuery("select ID from eventos where ID='"+id_busqueda+"'");
				if (rs.next()==true){
					try {
						((java.sql.Statement) stm).executeUpdate("DELETE FROM eventos WHERE ID= '"+id_busqueda+"'");
					JOptionPane.showMessageDialog(null, "La tabla ha sido borrada exitosamente");
				}catch(SQLException i) {
					JOptionPane.showMessageDialog(null, "Algo salio mal, parece que se ha producido un error. Disculpe por los inconvenientes." + "\n" + i.getMessage());
				}
					
	    	}}catch(ClassNotFoundException d) {
					JOptionPane.showMessageDialog(null, "No se encontro ningun evento con ese valor." + "\n" + d.getMessage());
					d.printStackTrace();
				}catch(SQLException i) {
					JOptionPane.showMessageDialog(null, "Algo salio mal, parece que se ha producido un error. Disculpe por los inconvenientes." + "\n" + i.getMessage());
				}
	    }if(e.getSource()==del2) {
	    	nombre_busqueda= JOptionPane.showInputDialog("Impute el Nombre de el evento que desea Borrar");
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con= 
						DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","");
				java.sql.Statement stm= con.createStatement();
				java.sql.ResultSet rs = stm.executeQuery("select ID from eventos where ID='"+id_busqueda+"'");
				if (rs.next()==true){
					try {
						((java.sql.Statement) stm).executeUpdate("DELETE FROM eventos WHERE ID= '"+id_busqueda+"'");
					JOptionPane.showMessageDialog(null, "La tabla ha sido borrada exitosamente");
				}catch(SQLException i) {
					JOptionPane.showMessageDialog(null, "Algo salio mal, parece que se ha producido un error. Disculpe por los inconvenientes." + "\n" + i.getMessage());
				}
					
	    	}}catch(ClassNotFoundException d) {
					JOptionPane.showMessageDialog(null, "No se encontro ningun evento con ese valor." + "\n" + d.getMessage());
					d.printStackTrace();
				}catch(SQLException i) {
					JOptionPane.showMessageDialog(null, "Algo salio mal, parece que se ha producido un error. Disculpe por los inconvenientes." + "\n" + i.getMessage());
				}
	    }
	}
	private void setTable(String idconvertido, String nombre, String descrip, String fecha1, String fecha2) {
		try{ 
			Object [] newobject = {idconvertido, nombre, descrip, fecha1, fecha2};
			Table.addRow(newobject);
			} catch(Exception e){
				JOptionPane.showMessageDialog(null, "Algo salio mal, parece que se ha producido un error. Disculpe por los inconvenientes." + "\n" + e.getMessage());
			}
		}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}