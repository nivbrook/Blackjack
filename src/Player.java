import java.util.LinkedList;

public class Player {
	private String name;
	private LinkedList<Card> hand;
	
	public Player(String name) {
		this.name = name;
		hand = new LinkedList<Card>();
	}
	
	public void emptyHand() {
		hand.clear();
	}
	
	public boolean addCard(Card card) {
		hand.add(card);
		return (getHandSum() <= 21);
	}
	
	public int getHandSum() {
		int sum = 0;
		int cardVal;
		int numAces = 0;
		for (Card card : hand) {
			cardVal = card.getNumber();
			if (cardVal > 10) {
				sum += 10;
			} else if (cardVal == 1) {
				sum += 11;
				numAces++;
			} else {
				sum += cardVal;
			}
		}
		
		while (sum > 21 && numAces > 0) {
			sum -= 10;
			numAces--;
		}
		return sum;
	}
	
	public void printHand(boolean showFirstCard) {
		System.out.printf("%s's cards:\n", name);
		for (int c = 0; c<hand.size(); c++) {
			if (c == 0 && !showFirstCard) {
				System.out.println(" [Hidden]");
			} else {
				System.out.printf(" %s\n", hand.get(c).toString());
			}
		}
	}
}
