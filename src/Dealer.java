
public class Dealer extends Player{
	private Game game;
	
	public Dealer(Game game) {
		super();
		this.game = game;
		this.name = "Dealer";
	}
	// returns isBust
	public boolean playTurn() {
		System.out.println("Dealer's Turn:");
		while (getHandSum() < 17) {
			System.out.println("Dealer hits!");
			game.dealCard(this);
			printHand(true);
		}
		
		if (getHandSum() > 21) {
			System.out.println(name + " busts!");
		} else {
			System.out.println(name + " stays!");
		}
		
		return (getHandSum() > 21);
	}
}
