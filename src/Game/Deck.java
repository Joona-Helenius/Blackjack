package Game;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deck-luokka sis�lt�� tarvittavat osat pelin pakan luomiseen. Luokalla on yksi attri-
 * buutti, joka on Card-tyyppinen arraylist lista deck. Luokasta l�ytyy my�s t�rke�t metodit
 * shuffle(), jolla deck arraylist sekoitetaan satunnaiseen j�rjestykseen ja draw(), joka
 * "nostaa" pakasta kortin ja palauttaa sen.
 */
public class Deck {
	private ArrayList<Card> deck;
	
	public Deck() {
		ArrayList<Card> deck=new ArrayList<Card>();
		for(int i=2;i<15;i++) {
			Card S=new Card(i, Suite.spades);
			Card C=new Card(i, Suite.clubs);
			Card H=new Card(i, Suite.hearts);
			Card D=new Card(i, Suite.diamonds);
			deck.add(S);
			deck.add(C);
			deck.add(H);
			deck.add(D);
		}
		this.deck=deck;
	}
	/**
     * Metodi shuffle() sekoittaa deck-listan kortit Collections.shuffle()-metodilla
     */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	/**
     * Metodi draw(), ottaa ensimm�isen deck-listan alkion, poistaa sen listasta ja palauttaa sen.
     * @return palauttaa Card olion
     */
	public Card draw() {
		Card c=deck.get(0);
		deck.remove(0);
		return c;
	}
	
}
