import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Levels extends JPanel implements ActionListener,KeyListener {

	private JFrame frame;
JFrame windows = new JFrame ();
	
	JButton btnBack = new JButton("Back");
	JButton btnStart = new JButton("START");
	JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**a
	 * Create the application.
	 */
	public Levels() {
		setBackground(Color.CYAN);
		setBounds(0, 0, 1366, 783);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		 try {
	    	 File sFile=new File("sounds//speech_2.wav");
	    	 AudioInputStream audio=AudioSystem.getAudioInputStream(sFile);
	    	 Clip sclip=AudioSystem.getClip();
	    	 sclip.open(audio);
	    	 sclip.start();
	     }catch (Exception e) {System.out.println(e);
			// TODO: handle exception
		}
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(this);
		setLayout(null);
		btnStart.setBounds(467, 241, 542, 251);
		add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String gen=(String) comboBox.getSelectedItem();
				 if (e.getSource()==btnStart) {
					 if (gen.equals("Noob Player")) {
						 try {
							NoobLevel m=new NoobLevel();
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 frame.dispose();
				}
					 if (gen.equals("Dragon Level")) {
						 try {
							DragonLevel dragonLevel=new DragonLevel();
							frame.dispose();
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}if (gen.equals("Legendery Boss(Coming Soon)")) {
						JOptionPane.showMessageDialog(null, "Comeing Soon...");
					}
				}
				
			}
		});
		
		
		btnStart.setFont(new Font("Segoe Script", Font.ITALIC, 54));
		btnStart.setForeground(Color.BLUE);
		btnStart.setBackground(Color.BLACK);
		comboBox.setFont(new Font("Jokerman", Font.BOLD, 24));
		comboBox.setBounds(467, 82, 542, 47);
		add(comboBox);
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.RED);
		
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Noob Player", "Dragon Level", "Legendery Boss(Coming Soon)"}));
			btnBack.setBounds(388, 660, 695, 35);
			add(btnBack);
			
			
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if (arg0.getSource()==btnBack) {
						AfterWindow mWindow=new AfterWindow();
						frame.dispose();
						
					}
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.ITALIC, 21));
			
			btnBack.setForeground(Color.RED);
			btnBack.setBackground(Color.BLACK);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 1372, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame .getContentPane().setForeground(Color.DARK_GRAY);
		 frame .getContentPane().setBackground(Color.LIGHT_GRAY);
		 frame.setBounds(100, 100, 1366, 769);
		 frame .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		
	}


	
		

}
