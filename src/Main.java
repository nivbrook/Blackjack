
public class Main {

	public static void main(String[] args) {
		
		Game game = new Game();
		game.addPlayer(new UserPlayer("Niv"));
		game.addPlayer(new UserPlayer("Steve"));
		game.playRound();
	}

}
