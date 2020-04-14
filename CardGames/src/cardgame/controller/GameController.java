package cardgame.controller;

import java.util.ArrayList;

import cardgame.model.Deck;
import cardgame.model.Player;
import cardgame.model.PlayingCard;
import cardgame.view.View;
import cardgames.gamedata.GameEvaluator;

public class GameController {
	
	enum GameState {
		AddingPlayers,
		CardsDealt,
		WinnerRevealed
	}
	
	Deck deck;
	ArrayList<Player> players;
	Player winner;
	View view;
	GameState gameState;
	
	
	public GameController(View view, Deck deck) {
		this.view = view;
		this.deck = deck;
		players = new ArrayList<Player> ();
		gameState = GameState.AddingPlayers;
		view.setController(this);
	}
	
	public void run() {
		while (true) {
			switch (gameState) {
				case AddingPlayers:
					view.promptForPlayerName();
					break;
				
				case CardsDealt:
					view.promptForFlip();
					break;
				
				case WinnerRevealed:
					view.promptForNewGame();
					break;
			}
		}
	}
	
	public void addPlayer(String playerName) {
		if (gameState == GameState.AddingPlayers) {
			players.add(new Player(playerName));
			view.showPlayerName(players.size(), playerName);
		}
	}
	
	
	public void startGame() {
		if (gameState != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex = 1;
			for (Player player : players) {
				player.addCardToHand(deck.removeTopCard());
				view.showFaceDownCardForPlayer(playerIndex++, player.getName());
			}
			gameState = GameState.CardsDealt;
		}
	}
	
	public void flipCards() {
		int playerIndex = 1;
		for (Player player : players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
		}
		
		evaluateWinner();
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
	}
	
	void evaluateWinner() {
		winner = new GameEvaluator().evaluateWinner(players);
	}
	
	void displayWinner() {
		view.showWinner(winner.getName());
	}
	
	void rebuildDeck() {
		for (Player player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}
	
}
