package Game;

import java.util.ArrayList;

/**
 * Luokka Player kuvaa pelaajaa, joka on vuorovaikutuksessa pelin kanssa.
 * Player-luokalla on yksi attribuutti, Card-tyyppinen arraylist hand.
 */
public class Player {

	public ArrayList<Card> hand;
	
	public Player() {
		this.hand=new ArrayList<Card>();
	}
	/**
     * Metodi addACard() lis�� yhden card-tyyppisen kortin attribuutin hand listaan.
     * @param card       Card tyyppinen olio
     */
	public void addACard(Card card) {
		hand.add(card);
	}
	public Card getCardAtIndex(int i) {
		return hand.get(i);
	}
	
	/**
     * Metodi getHandValue() laskee koko k�den korttien summan Blackjackin s��nt�jen
     * mukaan ja palauttaa t�m�n int tyyppisen�.
     * @return palauttaa k�den "arvon" kokonaislukutyyppisen�
     */
	public int getHandValue() {
		int x=0;
		int aces=0;
		for(int i=0;i<hand.size();i++) {
			int a=hand.get(i).getValue();
			if(a==14) {
				x+=11;
				aces++;
			}
			else if(a>10) {
				x+=10;
			}
			else {
				x+=a;
			}
		}
		while(x>21 && aces>0) {
			x=x-10;
			aces--;
		}
		return x;
	}
}
