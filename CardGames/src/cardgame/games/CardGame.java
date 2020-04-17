package cardgame.games;

import cardgame.controller.GameController;
import cardgame.model.Deck;
import cardgame.view.CommandLineView;
import cardgame.view.GameSwing;

public class CardGame {
	
	public static void main(String[] args) {
		
		GameSwing gs = new GameSwing();
		gs.createAndShowGUI();
		GameController gc = new GameController(
				gs, 
				new Deck(),
				null
				);
		gc.run();
	}

}