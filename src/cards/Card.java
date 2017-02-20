package cards;

public class Card {
	 private CardRank rank;
	    private CardSuit suit;

	    public Card(CardRank r, CardSuit s) {
	        rank = r;
	        suit = s;
	    }

	    @Override
	    public String toString() {
	        return (rank + " of " + suit).toLowerCase();
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result
	                + ((rank == null) ? 0 : rank.hashCode());
	        result = prime * result
	                + ((suit == null) ? 0 : suit.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Card other = (Card) obj;
	        if (rank != other.rank)
	            return false;
	        if (suit != other.suit)
	            return false;
	        return true;
	    }

		public CardRank getRank() {
			return rank;
		}

		public void setRank(CardRank rank) {
			this.rank = rank;
		}

		public CardSuit getSuit() {
			return suit;
		}

		public void setSuit(CardSuit suit) {
			this.suit = suit;
		}

}
