package cardgame.games;

import cardgame.controller.GameController;
import cardgame.model.Deck;
import cardgame.view.CommandLineView;
import cardgame.view.GameSwing;
import cardgames.gamedata.DeckFactory;
import cardgames.gamedata.DeckFactory.DeckType;

public class CardGame {
	
	public static void main(String[] args) {
		
		GameSwing gs = new GameSwing();
		gs.createAndShowGUI();
		GameController gc = new GameController(
				gs, 
				DeckFactory.makeDeck(DeckType.Normal),  // Factory design pattern, rather than new Deck()...
				null
				);
		gc.run();
	}

}