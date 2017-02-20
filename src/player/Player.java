package player;

public class Player {
	
	Hand hand;
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player(){
		this.hand = new Hand();
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

}
