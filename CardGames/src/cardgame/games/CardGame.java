package cardgame.games;

import cardgame.controller.GameController;
import cardgame.model.Deck;
import cardgame.view.View;

public class CardGame {
	
	public static void main(String[] args) {
		GameController gc = new GameController(new View(), new Deck());
		gc.run();
	}

}