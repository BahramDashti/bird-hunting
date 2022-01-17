import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Finished {
FireNoob mFire=new FireNoob();
//NoobLevel mLevel=new NoobLevel();
	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Finished() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 1366, 769);
		frame.setUndecorated(true);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Retry");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				try {
					NoobLevel mLevel=new NoobLevel();
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 64));
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(10, 434, 658, 324);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGiveUp = new JButton("Give Up!");
		btnGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AfterWindow mAfterWindow=new AfterWindow();
			frame.dispose();
			}
		});
		btnGiveUp.setFont(new Font("Tahoma", Font.ITALIC, 64));
		btnGiveUp.setBackground(Color.LIGHT_GRAY);
		btnGiveUp.setForeground(Color.RED);
		btnGiveUp.setBounds(698, 434, 658, 324);
		frame.getContentPane().add(btnGiveUp);
		
		JLabel txtpnTipDontWast = new JLabel();
		txtpnTipDontWast.setBackground(Color.RED);
		txtpnTipDontWast.setFont(new Font("Juice ITC", Font.BOLD | Font.ITALIC, 24));
		txtpnTipDontWast.setText("Tip: Dont wast your bullet they are easy point!!!");
		txtpnTipDontWast.setBounds(479, 342, 415, 38);
		frame.getContentPane().add(txtpnTipDontWast);
		
		JLabel txtpnAsas = new JLabel();
		txtpnAsas.setForeground(Color.RED);
		txtpnAsas.setFont(new Font("Jokerman", Font.BOLD | Font.ITALIC, 64));
		txtpnAsas.setText("Your Score:"+(mFire.getScore()*10));
		txtpnAsas.setBounds(395, 100, 693, 156);
		frame.getContentPane().add(txtpnAsas);
		frame.setVisible(true);
	}
}
