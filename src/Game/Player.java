package Game;

import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand;
	
	public Player() {
		this.hand=new ArrayList<Card>();
	}
	public void addACard(Card card) {
		hand.add(card);
	}
	
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
