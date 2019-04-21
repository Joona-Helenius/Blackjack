package Game;

import java.util.ArrayList;
import java.util.Collections;

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
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card draw() {
		Card c=deck.get(0);
		deck.remove(0);
		return c;
	}
	
}
