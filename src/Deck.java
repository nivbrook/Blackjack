import java.util.Collections;
import java.util.LinkedList;

public class Deck {
	private LinkedList<Card> cards = new LinkedList<Card>();
	
	public Deck() {
		this(1, false);
	}
	
	public Deck(int numDecks, boolean shuffle) {
		if (numDecks < 1) {
			throw new IllegalArgumentException("Invalid number of decks.");
		}
		
		
		for (int d = 0; d<numDecks; d++) {
			for (int s = 0; s < 4; s++) {
				for (int n = 1; n<=13; n++) {
					this.cards.add(new Card(Suit.values()[s], n));
				}
			}
		}
		if (shuffle) {
			shuffle();

		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card drawCard() {
		return cards.removeFirst();
	}
	
	public void printDeck() {
		printDeck(cards.size());
	}
	
	public void printDeck(int numToPrint) {
		for (int i = 0; i<numToPrint; i++) {
			System.out.println((i+1) + "/" + cards.size() + ": " + cards.get(i).toString());
		}
	}
}
