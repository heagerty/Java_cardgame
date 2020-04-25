package cardgame.model;

public class PlayingCard {

	private Rank rank;
	private Suit suit;
	private boolean faceUp;
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public PlayingCard(Rank r, Suit s) {
		rank = r;
		suit = s;
		faceUp = false;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}
	
	

}
