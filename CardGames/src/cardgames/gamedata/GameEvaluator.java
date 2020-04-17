package cardgames.gamedata;

import java.util.List;

import cardgame.model.Player;
import cardgame.model.PlayingCard;

public interface GameEvaluator {
	public Player evaluateWinner(List<Player> players);
}

