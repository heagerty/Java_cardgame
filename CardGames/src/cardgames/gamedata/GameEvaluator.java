package cardgames.gamedata;

import java.util.List;

import cardgame.model.IPlayer;
import cardgame.model.PlayingCard;

public interface GameEvaluator {
	public IPlayer evaluateWinner(List<IPlayer> players);
}

