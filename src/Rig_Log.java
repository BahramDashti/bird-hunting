import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DropMode;
import javax.swing.SpringLayout;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import com.sun.glass.ui.Screen;
import com.sun.java.swing.plaf.windows.resources.windows;

import javafx.css.PseudoClass;

import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.Color;

public class Rig_Log extends JPanel implements KeyListener {
//Person[] aPerson=new Person[10000];
 JFrame frame= new JFrame();
	JPanel jPanel=new JPanel();
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_1;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Rig_Log() 
	{
		setBounds(0, 0, 10, 10);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	
	
	private void initialize() {
	frame.getContentPane().setLayout(null);
		
	
	frame.getContentPane().add(this);
		//frame.setAlwaysOnTop(true);
		frame.setUndecorated(true);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 1366, 769);
	//	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
			/*	try {
					PrintWriter pWriter=new PrintWriter("memeber.txt");
					pWriter.println(textField.getText());
					pWriter.close();
					frame.dispose();
				} catch (FileNotFoundException e) {
					e.printStackTrace();// TODO: handle exception
				}*/
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
			
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Forte", Font.BOLD, 14));
		tabbedPane.setBounds(10, 11, 1346, 747);
		frame.getContentPane().add(tabbedPane);
		
		JPanel Login = new JPanel();
		Login.setBackground(Color.CYAN);
		tabbedPane.addTab("Login", null, Login, null);
		Login.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(426, 302, 498, 20);
		Login.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(426, 333, 498, 20);
		Login.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setForeground(Color.GREEN);
		btnLogin.setFont(new Font("Forte", Font.BOLD, 14));
		btnLogin.setBounds(582, 428, 188, 23);
		Login.add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.RED);
		lblUsername.setFont(new Font("Forte", Font.BOLD, 14));
		lblUsername.setBounds(276, 305, 109, 14);
		Login.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.RED);
		lblPassword.setFont(new Font("Forte", Font.BOLD, 14));
		lblPassword.setBounds(276, 335, 66, 14);
		Login.add(lblPassword);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setBackground(Color.LIGHT_GRAY);
		btnBack_1.setForeground(Color.RED);
		btnBack_1.setFont(new Font("Forte", Font.BOLD, 12));
		btnBack_1.setBounds(644, 644, 69, 23);
		Login.add(btnBack_1);
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterWindow m=new AfterWindow();
				frame.dispose();
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ac) {
				String nameString=textField_2.getText();
				String pas=passwordField.getText();
				try {
					FileReader log=new FileReader("Screen.txt");
					BufferedReader red=new BufferedReader(log);
					String str="";
					int i=0;
					Path path = Paths.get("Screen.txt");
					long lineCount = Files.lines(path).count();
				
					while ((str=red.readLine()) != null) {
						
						if((nameString+" "+pas).equals(str)) {
							Levels m=new Levels();
							frame.dispose();	
						i=0;
						break;
						}
						
						
					i++;
				} 
					if(!(nameString+" "+pas).equals(str)&&lineCount==i){
						JOptionPane.showMessageDialog(null,"invaild username or password");
					
				}
					}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		tabbedPane.addTab("Rigester", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(435, 224, 561, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterUniqeName = new JLabel("Enter a Unique Name");
		lblEnterUniqeName.setForeground(Color.RED);
		lblEnterUniqeName.setFont(new Font("Forte", Font.BOLD, 16));
		lblEnterUniqeName.setBounds(166, 218, 164, 29);
		panel_1.add(lblEnterUniqeName);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(435, 288, 561, 20);
		panel_1.add(passwordField_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(435, 337, 561, 20);
		panel_1.add(passwordField_1);
		
		JLabel lblE = new JLabel("Enter Your Password Again");
		lblE.setForeground(Color.RED);
		lblE.setFont(new Font("Forte", Font.BOLD, 16));
		lblE.setBounds(106, 331, 224, 29);
		panel_1.add(lblE);
		
		JLabel lblChoosePassword = new JLabel("Choose Password");
		lblChoosePassword.setForeground(Color.RED);
		lblChoosePassword.setFont(new Font("Forte", Font.BOLD, 16));
		lblChoosePassword.setBounds(186, 291, 164, 17);
		panel_1.add(lblChoosePassword);
		
		JButton rig_1 = new JButton("Register");
		rig_1.setForeground(Color.GREEN);
		rig_1.setBackground(Color.LIGHT_GRAY);
		rig_1.setFont(new Font("Forte", Font.BOLD, 15));
		rig_1.setBounds(647, 466, 184, 23);
		panel_1.add(rig_1);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Forte", Font.BOLD, 11));
		btnBack.setBounds(707, 650, 69, 23);
		panel_1.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AfterWindow m=new AfterWindow();
				frame.dispose();
			}
		});
		rig_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			  String nameString= textField.getText();
		//	 String id = textField_1.getText();
			// String gen=(String) comboBox.getSelectedItem();
			 String password=passwordField_2.getText();
			 String password2=passwordField_1.getText();
			 System.out.println(nameString+","+password);
			 try {
				 int i=0;
				 FileReader log=new FileReader("Screen.txt");
					BufferedReader red=new BufferedReader(log);
					
				FileWriter rig=new FileWriter("Screen.txt",true);
				PrintWriter rigwork=new PrintWriter(rig);
				Path path = Paths.get("Screen.txt");
				long lineCount = Files.lines(path).count();
			//	System.out.println(lineCount);
				String str="";
				while ((str=red.readLine()) != null) {
					if(!(str.startsWith(nameString))) {
						i++;
					}
					
				}
				if ((i==lineCount) &&(password.equals(password2))) {
					//System.out.println("yes");
					rigwork.println(nameString+" "+password);
					JOptionPane.showMessageDialog(null, "Done!");
				rig.close();
				}else {
					JOptionPane.showMessageDialog(null, "Error:1.You already a member or\n2.Passwords are not match");
				}
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showInputDialog(null, "Error", JOptionPane.ERROR_MESSAGE);;
			}
		}
				
			
		});
		frame.setVisible(true);}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(KeyEvent.VK_ESCAPE==e.getKeyCode()){
			frame.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
