package Game;

public class Card {
	private final int value;
	private final Suite suite;
	private final boolean isAce;
	private final boolean isFace;
	
	
	public Card(){
		value=0;
		suite=null;
		isAce=false;
		isFace=false;
	}
	
	public Card(int value, Suite suite) {
		this.value=value;
		this.suite=suite;
		if(value==14) {
			this.isAce=true;
			this.isFace=false;
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
	public int getValue() {
		return value;
	}
	public Suite suite() {
		return suite;
	}
	public boolean getFace() {
		return isFace;
	}
	public boolean getAce() {
		return isAce;
	}
	
	
}
