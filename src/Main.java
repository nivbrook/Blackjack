import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Deck deck = new Deck(1, true);
		
		Player me = new Player("Niv");
		Player dealer = new Player("Dealer");
		
		for (int i = 0; i<2; i++) {
			me.addCard(deck.drawCard());
			dealer.addCard(deck.drawCard());
		}
		
		dealer.printHand(false);
		me.printHand(true);
		System.out.println("\n");
		
		boolean meDone = false;
		boolean dealerDone = false;
		
		String ans;
		
		while (!meDone) {
			System.out.print("Hit or Stay? (Enter H or S): ");
			ans = sc.next();
			System.out.println();
			
			if (ans.compareToIgnoreCase("H") == 0) {
				meDone = !me.addCard(deck.drawCard());
				me.printHand(true);
				if (meDone) {
					System.out.println("You bust! You lose!");
					System.exit(0);
				}
			} else {
				meDone = true;
			}
		}
		dealer.printHand(true);
		while (!dealerDone) {
			if (dealer.getHandSum() < 17) {
				System.out.println("Dealer hits.");
				dealerDone = !dealer.addCard(deck.drawCard());
				dealer.printHand(true);
				if (dealerDone) {
					System.out.println("Dealer Busts!");
				}
			} else {
				dealerDone = true;
			}
		}
		int dealerScore = dealer.getHandSum();
		int meScore = me.getHandSum();
		System.out.println("Dealer sum is: " + dealerScore + ".");
		System.out.println("Your sum is: " + meScore + ".");
		if (dealerScore > 21 || meScore > dealerScore) {
			System.out.println("You win!");
		} else if (dealerScore > meScore || meScore > 21) {
			System.out.println("Dealer wins!");
		} else {
			System.out.println("Push! No one wins!");
		}
	}

}
