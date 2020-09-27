import java.util.Scanner;

public class UserPlayer extends Player {
	private Game game;
	
	public UserPlayer(String name) {
		super();
		this.name = name;
	}
	
	public void addToGame(Game game) {
		this.game = game;
	}
	
	Scanner sc = new Scanner(System.in);
	
	public boolean playTurn() {
		System.out.println(name + "'s Turn:");
		boolean done = false;
		String ans;
		
		while (!done) {
			printHand(true);
			System.out.print("Hit or Stay? (Enter H or S): ");
			ans = sc.next();
			System.out.println();
			if (ans.compareToIgnoreCase("H") == 0) {
				game.dealCard(this);
				if (getHandSum() > 21) {
					done = true;
				}
			} else {
				done = true;
			}
		}
		if (getHandSum() > 21) {
			System.out.println(name + " busts!");
		}
		return (getHandSum() > 21);
	}

	public String getName() {
		return name;
	}
}
