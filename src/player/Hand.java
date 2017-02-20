package player;

import java.util.ArrayList;
import java.util.List;

import cards.Card;

public class Hand {
	List<Card> cards;

	public Hand() {
		this.cards = new ArrayList<>();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void addCard(Card card) {
		cards.add(card);
	}

}
