import java.util.ArrayList;
import java.util.List;

public class Game {
	private Dealer dealer;
	private List<UserPlayer> players;
	private Deck deck;
	
	public Game() {
		dealer = new Dealer(this);
		players = new ArrayList<UserPlayer>();
		deck = new Deck();
		deck.shuffle();
	}
	
	public void addPlayer(UserPlayer player) {
		players.add(player);
		player.addToGame(this);
	}
	
	public void dealCard(Player player) {
		player.addCard(deck.drawCard());
	}
	
	public void playRound() {
		boolean[] results = new boolean[players.size()];
		boolean allBusts = true;
		for (int i = 0; i<2; i++) {
			dealCard(dealer);
			for (UserPlayer player : players) {
				dealCard(player);
			}
		}
		
		dealer.printHand(false);
		for (UserPlayer player : players) {
			player.printHand(true);
		}
		
		for (int i = 0; i < players.size(); i++) {
			results[i] = players.get(i).playTurn();
			if (!results[i]) allBusts = false;
		}
		
		dealer.printHand(true);
		if (allBusts) {
			System.out.println("Dealer wins!");
			return;
		}
		
		if(dealer.playTurn()) {
			System.out.println("Payout!");
			return;
		}
		int dealerScore = dealer.getHandSum();
		
		for (int i = 0; i < players.size(); i++) {
			if (!results[i]) {
				if (players.get(i).getHandSum()>dealerScore) {
					System.out.println(players.get(i).getName() + " wins!");
				} else if (players.get(i).getHandSum() == dealerScore){
					System.out.println(players.get(i).getName() + " pushes!");
				} else {
					System.out.println(players.get(i).getName() + " loses!");
				}
			}
		}
		
	}
	
}
