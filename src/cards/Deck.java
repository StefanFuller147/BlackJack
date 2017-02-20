package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import player.Player;

public class Deck {
	List<Card> deck = new ArrayList<>(52);

	public void buildDeck() {
		for (CardRank r : CardRank.values()) {
			for (CardSuit s : CardSuit.values()) {
				deck.add(new Card(r, s));
			}

		}
		Collections.shuffle(deck);
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
	
	public void deal(Player player){
		player.getHand().addCard(deck.get(0));
		deck.remove(0);
	}
}
