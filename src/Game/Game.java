package Game;

public class Game {
	
	public Player player;
	public Player dealer;
	
	public Game() {
		Player player= new Player();
		Player dealer= new Player();
	}
	
	public void gameSet() {
		Deck deck=new Deck();
		deck.shuffle();
		player.addACard(deck.draw());
		player.addACard(deck.draw());
		dealer.addACard(deck.draw());
		dealer.addACard(deck.draw());
	}
}
