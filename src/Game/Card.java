package Game;

public class Card {
	private int value;
	private Suite suite;
	private boolean isAce;
	private boolean isFace;
	
	public Card(){
		value=0;
		suite=null;
		isAce=false;
		isFace=false;
	}
	
	public Card(int value, Suite suite) {
		this.value=value;
		this.suite=suite;
		if(value==13) {
			this.isAce=true;
			this.isAce=false;
		}
		else if(value>10) {
			this.isFace=true;
			this.isAce=false;
		}
		else {
			this.isFace=false;
			this.isAce=false;
		}
	}
}
