import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AfterWindow extends JPanel {

JFrame winFrame=new JFrame();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public AfterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the winFrame.
	 */
	private void initialize() {
		winFrame.add(this);
		winFrame.getContentPane().setBackground(Color.CYAN);
		
		winFrame.setUndecorated(true);
		winFrame.setExtendedState(winFrame.MAXIMIZED_BOTH);
		//winFrame.setBounds(100, 100, 1355, 761);
		winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Strat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton ) {
					Rig_Log mLog=new Rig_Log();
				winFrame.dispose();
			}
		}});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("Forte", Font.BOLD, 64));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(430, 189, 500, 133);
		winFrame.getContentPane().add(btnNewButton);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAbout ) {
					JOptionPane.showMessageDialog(null, "A Game From:\nBahram Dashti\n&\nHossein Farzi\nPlease Send Your Feedback:\nBahram.Dashti@outlook.com");
				
			}
		}});
		
	
		btnAbout.setForeground(Color.BLUE);
		btnAbout.setFont(new Font("Forte", Font.BOLD, 64));
		btnAbout.setBackground(Color.LIGHT_GRAY);
		btnAbout.setBounds(430, 333, 500, 133);
		winFrame.getContentPane().add(btnAbout);
		
		JButton btnHowToPlay = new JButton("How to play?");
		btnHowToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnHowToPlay) {
					JOptionPane.showMessageDialog(null, "A=move Left\nD=Move right\nSpace=Fire!!");
				}
				
				
			}
		});
		btnHowToPlay.setForeground(Color.BLUE);
		btnHowToPlay.setFont(new Font("Forte", Font.BOLD, 64));
		btnHowToPlay.setBackground(Color.LIGHT_GRAY);
		btnHowToPlay.setBounds(430, 477, 500, 133);
		winFrame.getContentPane().add(btnHowToPlay);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnExit ) {
					int a=JOptionPane.showConfirmDialog(null,"Do you want exit?");
					if(a==0)
						System.exit(0);	
				}
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Forte", Font.BOLD, 64));
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(430, 621, 500, 133);
		winFrame.getContentPane().add(btnExit);
	winFrame.setVisible(true);}
}
