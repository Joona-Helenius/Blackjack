package Game;

import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Blackjack_window {

	private JFrame frmBlackjack;
	private static JPanel background;
	private JButton Hit;
	private JButton Stand;
	private Player player;
	private Player dealer;
	private Deck deck;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Blackjack_window window = new Blackjack_window();
					window.frmBlackjack.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Blackjack_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.player= new Player();
		this.dealer= new Player();
		this.deck=new Deck();
		deck.shuffle();
		frmBlackjack = new JFrame();
		frmBlackjack.setSize(1280,800);
		frmBlackjack.setResizable(false);
		frmBlackjack.getContentPane().setForeground(new Color(51, 102, 51));
		frmBlackjack.setType(Type.POPUP);
		frmBlackjack.setTitle("BlackJack");
		frmBlackjack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlackjack.setForeground(Color.WHITE);
		frmBlackjack.setBackground(Color.WHITE);
		frmBlackjack.getContentPane().setLayout(null);
		
		background = new JPanel();
		background.setBackground(new Color(51, 102, 51));
		background.setBounds(0, 0, 1274, 772);
		frmBlackjack.getContentPane().add(background);
		background.setLayout(null);
		
		JButton Hit = new JButton("Hit");
		Hit.setBounds(697, 181, 115, 29);
		background.add(Hit);
		Hit.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e) {
		player.addACard(deck.draw());
		printCard(10, 100, player.getCardAtIndex(0));
		printCard(141,100, player.getCardAtIndex(0));
		System.out.println("huekeke");
	}
		});
		JButton Stand = new JButton("Stand");
		Stand.setBounds(697, 339, 115, 29);
		background.add(Stand);
	}
	
	
	
	public static void printCard(int xPos, int yPos, Card card) {
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Blackjack_window.class.getResource("/Game/images/"+card.getImgPath()+".png")));
		lblNewLabel.setBounds(xPos, yPos, 131, 190);
		background.add(lblNewLabel);

	}
}

