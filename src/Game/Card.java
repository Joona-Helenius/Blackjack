package Game;

/**
 * Card-luokka luo pohjan Deck ja Player luokalle. Luokan avulla luodaan pelikortti olioita,
 * jota peli käyttää laskeakseen erilaisia Blackjackkiin kuuluvia toimintoja. Luokan
 * oliot saavat attribuuteiksi int tyyppisen arvon "value", Suite tyyppisen attribuu-
 * tin suite (maa) ja String tyyppisen attribuutin imgPath, jolla ohjelma löytää korteil-
 * le oikeat kuvat.
 */
public class Card {
	private final int value;
	private final Suite suite;
	private final String imgPath;
	
	/**
     * Card-luokan konstruktori, joka saa parametrina kortin arvon value ja kortin 
     * maan suite.Normaalin konstruktorin tapaan, se luo Card-tyyppisiä olioita.
     * Konstruktorista löytyy myös imgPath niminen String-muuttuja, jonka avulla
     * ohjelma löytää korteille oikeat kuvat Game.images-kansiosta.
     * @param value kortin arvo.
     * @param suite kortin maa.
     */
	public Card(int value, Suite suite) {
		this.value=value;
		this.suite=suite;
		String s=String.valueOf(value);
		String s2=String.valueOf(suite);
		imgPath=s+"_of_"+s2;
	}
	public int getValue() {
		return value;
	}
	public Suite suite() {
		return suite;
	}
	public String getImgPath() {
		return imgPath;
	}
}
