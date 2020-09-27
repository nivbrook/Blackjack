
public class Card {
	private final Suit suit;
	private final int number;
	
	public Card(Suit suit, int number) {
		if (number < 1 || number > 13) {
			throw new IllegalArgumentException("Invalid Card Number: " + number);
		}
		this.suit = suit;
		this.number = number;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getNumber() {
		return number;
	}
	
	public String toString() {
		String numString = "Error";
		
		switch(number) {
		case 1: numString = "Ace"; break;
		case 2: numString = "Two"; break;
		case 3: numString = "Three"; break;
		case 4: numString = "Four"; break;
		case 5: numString = "Five"; break;
		case 6: numString = "Six"; break;
		case 7: numString = "Seven"; break;
		case 8: numString = "Eight"; break;
		case 9: numString = "Nine"; break;
		case 10: numString = "Ten"; break;
		case 11: numString = "Jack"; break;
		case 12: numString = "Queen"; break;
		case 13: numString = "King"; break;
		}
		
		return numString + " of " + suit.toString();
	}
}
