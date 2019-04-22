package Game;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

/**
 * Blackjack_window luokka toteuttaa peliin tarvittavan GUI:n eli graafisen k‰yttˆliittym‰n.
 * Luokka k‰ytt‰‰ Java Swingi‰ tarvittavien asioiden n‰ytt‰miseen, kuten pˆyt‰, kortit yms.
 * Blackjack_window on luotu k‰ytt‰en Eclipsen lis‰osaa nimelt‰ WindowBuilder. 
 * Ikkuna ja sen v‰ritys toteutetaan JFramella, korttien kuvat JLabelien ja JPanelien
 * avulla, pelaamisen tarvittavat napit JButtonien avulla ja pelinotifikaatiot JTextFieldin
 * kanssa.
 *
 */
public class Blackjack_window {

	private JFrame frmBlackjack;
	private static JPanel background;
	private JButton Hit_1;
	private JButton Stand_1;
	private static Player player;
	private Player dealer;
	private Deck deck;
	private static JTextArea PlayerHandValue;
	private static JTextArea DealerHandValue;
	private static JTextArea Notifications;
	private JLabel tempCard;
	
	/**
     * Main metodi k‰ynnist‰‰ itse pelin.
     * @param args j‰tet‰‰n tyhj‰ksi.
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
     * Blackjack_window konstruktori, joka toteuttaa initialize() -metodin.
     */
	public Blackjack_window() {
		initialize();
	}

	/**
     * initialize() -metodi luo kaiken tarvittavan pelin grafiikan yms. pyˆritt‰miseen.
     */
	private void initialize() {
		this.player= new Player();
		this.dealer= new Player();
		this.deck=new Deck();
		deck.shuffle();
		frmBlackjack = new JFrame();//luodaan ikkuna
		frmBlackjack.setIconImage(Toolkit.getDefaultToolkit().getImage(Blackjack_window.class.getResource("/Game/images/14_of_spades.png")));
		frmBlackjack.setAutoRequestFocus(false);
		frmBlackjack.setSize(800,800);
		frmBlackjack.setResizable(false);
		frmBlackjack.getContentPane().setForeground(new Color(51, 102, 51));
		frmBlackjack.setTitle("BlackJack");
		frmBlackjack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlackjack.getContentPane().setLayout(null);
		
		
		background = new JPanel();//annetaan taustalle joku muu v‰ri, kuin
		background.setBackground(new Color(51, 102, 51));
		background.setBounds(0, 0, 800, 800);
		frmBlackjack.getContentPane().add(background);
		background.setLayout(null);

		Hit_1 = new JButton("Hit");
		Hit_1.setBounds(667, 320, 115, 29);
		background.add(Hit_1);
		Hit_1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e) {//Hit nappia painamalla peli nostaa yhden kortin pelaajan k‰teen ja p‰ivitt‰‰ k‰den kokonaisarvon.
		
		player.addACard(deck.draw());
		printCard(10+(player.hand.size()-1)*90, 500, player.getCardAtIndex(player.hand.size()-1));
		PlayerHandValue.setText("Player Hand Value "+String.valueOf(player.getHandValue()));
		if(player.getHandValue()>21) {// Jos k‰den arvo ylitt‰‰ 21 peli p‰‰ttyy.
			Hit_1.setEnabled(false);
			Stand_1.setEnabled(false);
			Notifications.setText("Player has bust!");
			
		}
	}
		});
		Stand_1 = new JButton("Stand");
		Stand_1.setBounds(667, 370, 115, 29);
		background.add(Stand_1);
		Stand_1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e) {//Stand nappia painamalla peli p‰‰tt‰‰ pelaajan vuoron ja suorittaa jakajan vuoron.
		tempCard.setVisible(false);
		tempCard.repaint();
		printCard(100, 60, dealer.getCardAtIndex(dealer.hand.size()-1));//jakajan k‰den toinen kortti paljastetaan ja k‰den arvo p‰ivitet‰‰n.
		DealerHandValue.setText("Dealer Hand Value: "+String.valueOf(dealer.getHandValue()));
		Stand_1.setEnabled(false);
		Hit_1.setEnabled(false);
		while(dealer.getHandValue()<17) {//jakaja nostaa kortteja kunnes k‰den arvo on yli 16.
			dealer.addACard(deck.draw());
			printCard(10+90*(dealer.hand.size()-1), 60, dealer.getCardAtIndex(dealer.hand.size()-1));
			DealerHandValue.setText("Dealer Hand Value: "+String.valueOf(dealer.getHandValue()));
		}
		if(dealer.getHandValue()>21) {//tarkastetaan pelin lopputulos if/else lauseilla.
			Notifications.setText("Dealer has bust! Player has won!");
		}
		else if(dealer.getHandValue()>player.getHandValue()) {
			Notifications.setText("Dealer has a better hand! Dealer has won!");
		}
		else if(dealer.getHandValue()<player.getHandValue()) {
			Notifications.setText("Player has a better hand! Player has won!");
			}
		else {
			Notifications.setText("Tie!");
		}
	}
		});
	
		PlayerHandValue = new JTextArea("Player Hand Value:");//luodaan kentt‰, johon pelaajan k‰den arvo p‰ivittyy.
		PlayerHandValue.setForeground(Color.WHITE);
		PlayerHandValue.setBackground(new Color(51, 102, 51));
		PlayerHandValue.setBounds(10, 475, 305, 22);
		PlayerHandValue.setFont(new Font("Arial", Font.BOLD, 18));
		background.add(PlayerHandValue);
		PlayerHandValue.setEditable(false);
		
		DealerHandValue = new JTextArea("Dealer Hand Value:");//luodaan kentt‰, johon jakajan k‰den arvo p‰ivittyy.
		DealerHandValue.setForeground(Color.WHITE);
		DealerHandValue.setBackground(new Color(51, 102, 51));
		DealerHandValue.setBounds(10, 260, 305, 22);
		DealerHandValue.setFont(new Font("Arial", Font.BOLD, 18));
		background.add(DealerHandValue);
		DealerHandValue.setEditable(false);
		
		Notifications = new JTextArea();//luodaan kentt‰, johon p‰ivitet‰‰n viestej‰ pelin kulusta.
		Notifications.setForeground(Color.WHITE);
		Notifications.setBackground(new Color(51, 102, 51));
		Notifications.setBounds(10, 370, 450, 22);
		Notifications.setFont(new Font("Arial", Font.BOLD, 20));
		background.add(Notifications);
		Notifications.setEditable(false);
		
		player.addACard(deck.draw());//pelin alkutoiminnot.
		printCard(10,500,player.getCardAtIndex(0));
		player.addACard(deck.draw());
		printCard(100,500,player.getCardAtIndex(1));
		PlayerHandValue.setText("Player Hand Value: "+String.valueOf(player.getHandValue()));
		dealer.addACard(deck.draw());
		printCard(10,60,dealer.getCardAtIndex(0));
		DealerHandValue.setText("Dealer Hand Value: "+String.valueOf(dealer.getHandValue()));
		dealer.addACard(deck.draw());
		tempCard = new JLabel();
		tempCard.setIcon(new ImageIcon(Blackjack_window.class.getResource("/Game/images/back.png")));
		tempCard.setBounds(100, 60, 131, 190);
		background.add(tempCard);
		tempCard.repaint();
		if(player.getHandValue()==21&&dealer.getHandValue()==21) {//tarkastetaan mahdolliset Blackjack tilanteet.
			Hit_1.setEnabled(false);
			Stand_1.setEnabled(false);
			tempCard.setVisible(false);
			tempCard.repaint();
			printCard(100, 60, dealer.getCardAtIndex(dealer.hand.size()-1));//jakajan k‰den toinen kortti paljastetaan ja k‰den arvo p‰ivitet‰‰n.
			DealerHandValue.setText("Dealer Hand Value: "+String.valueOf(dealer.getHandValue()));
			Notifications.setText("Tie! Dealer and player have Blackjack!");
		}
		else if(player.getHandValue()==21) {
			Hit_1.setEnabled(false);
			Stand_1.setEnabled(false);
			tempCard.setVisible(false);
			tempCard.repaint();
			printCard(100, 60, dealer.getCardAtIndex(dealer.hand.size()-1));//jakajan k‰den toinen kortti paljastetaan ja k‰den arvo p‰ivitet‰‰n.
			DealerHandValue.setText("Dealer Hand Value: "+String.valueOf(dealer.getHandValue()));
			Notifications.setText("Player won! Player has Blackjack!");
		}
		else if(dealer.getHandValue()==21) {
			Hit_1.setEnabled(false);
			Stand_1.setEnabled(false);
			tempCard.setVisible(false);
			tempCard.repaint();
			printCard(100, 60, dealer.getCardAtIndex(dealer.hand.size()-1));//jakajan k‰den toinen kortti paljastetaan ja k‰den arvo p‰ivitet‰‰n.
			DealerHandValue.setText("Dealer Hand Value: "+String.valueOf(dealer.getHandValue()));
			Notifications.setText("Dealer won! Dealer has Blackjack!");
		}
		JButton btnRestart = new JButton("Restart");//Nappia painamalla ohjelma sulkee peli-ikkunan ja avaa uuden.
		btnRestart.setBounds(667, 420, 115, 29);
		background.add(btnRestart);
		btnRestart.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e) {
		frmBlackjack.dispose();
		try {
			Blackjack_window window = new Blackjack_window();
			window.frmBlackjack.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
			}
		});
		
		/**
	     * printCard()-metodi saa parametrikseen kortin x ja y position pikselein‰ sek‰ itse
	     * Card-tyyppisen olion.
	     * @param xPos kokonaislukutyyppinen x-akseli pikseliarvona.
	     * @param yPos kokonaislukutyyppinen y-akseli pikseliarvona.
	     * @param card Card-tyyppinen olio.
	     */	
	}
	public static void printCard(int xPos, int yPos, Card card) {
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Blackjack_window.class.getResource("/Game/images/"+card.getImgPath()+".png")));
		lblNewLabel.setBounds(xPos, yPos, 131, 190);
		background.add(lblNewLabel);
		lblNewLabel.revalidate();
		lblNewLabel.repaint();
		
	}
}
