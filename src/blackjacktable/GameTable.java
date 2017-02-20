package blackjacktable;

import java.util.Scanner;

import cards.Card;
import cards.Deck;
import player.Player;

public class GameTable {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		Player dealer = new Player();
		Player player = new Player();
		String hitOrStay;
		String name;
		String playAGame;
		String playAgain;

		System.out.println("+----------------------------+");
		System.out.println("|                            |");
		System.out.println("|****************************|");
		System.out.println("|     	 WELCOME TO          |");
		System.out.println("|        Black Jack          |");
		System.out.println("|****************************|");
		System.out.println("|                            |");
		System.out.println("+____________________________+");

		Deck deck = new Deck();
		deck.buildDeck();
		do {
			System.out.println("Would you like to start a game? Yes or No");
			playAGame = kb.next();
			if (!playAGame.equalsIgnoreCase("Yes") && !playAGame.equalsIgnoreCase("No")) {
				System.out.println("Please enter a valid entry. A simple, yes or no will suffice");
			}
		} while (!playAGame.equalsIgnoreCase("yes") && !playAGame.equalsIgnoreCase("no"));

		if (playAGame.equalsIgnoreCase("Yes")) {
			System.out.println("What's your name?");
			name = kb.next();
			player.setName(name);
			deck.deal(player);
			deck.deal(dealer);
			deck.deal(player);
			deck.deal(dealer);
			System.out.println("\n");
			System.out.println("Cards in " + player.getName() + "'s" + " hand: ");
			showHand(player);
			System.out.println(player.getName() + "'s" + " total: " + total(player));
			System.out.println("__________________________");
			System.out.println();
			System.out.println("Dealer's hand: ");
			showHand(dealer);
			System.out.println("Dealer total: " + total(dealer));
			System.out.println("__________________________");
			boolean dealerPlay = true;
			do {
				System.out.println();
				System.out.println();
				System.out.println("Would you like to hit, or stay?");
				System.out.println("Dealers total: " + total(dealer));
				System.out.println("Your total: " + total(player));
				System.out.println();
				hitOrStay = kb.next();
				if (hitOrStay.equalsIgnoreCase("hit")) {
					deck.deal(player);
					System.out.println(player.getName() + " Shows: " + total(player));
					System.out.println("Cards in hand: ");
					showHand(player);
				} else {
					System.out.println(player.getName() + "'s total: " + total(player));
				}
				if (total(player) > 21) {
					System.out.println("Sorry, you broke! Better luck next time.");
					hitOrStay = "stay";
					dealerPlay = false;
				}
			} while (!hitOrStay.equalsIgnoreCase("stay"));

			while (dealerPlay) {
				if (total(dealer) < 17) {
					System.out.println("Dealer hits");
					System.out.println("***************************");
					deck.deal(dealer);
					showHand(dealer);
					System.out.println("Dealer total: " + total(dealer));
					if (total(dealer) > 21) {
						System.out.println("You win Dealer Busted");
						dealerPlay = false;
					}
				} else {
					dealerPlay = false;
				}
			}
			if(total(player)<=21 && total(dealer)<=21){
			winner(player, dealer);
			}
			
		} else {
			System.out.println("Thanks for playing");
			// break;
		}
	}

	// private static void getCard() {

	public static int total(Player player) {
		int total = 0;
		for (Card c : player.getHand().getCards()) {
			total = total + c.getRank().getValue();
		}
		return total;
	}

	public static void showHand(Player p) {
		for (Card c : p.getHand().getCards()) {
			System.out.println(c);
		}
	}

	public static void winner(Player player, Player dealer) {
		if (total(player) > total(dealer)) {
			System.out.println("You win");
		} else if (total(player) < total(dealer)) {
			System.out.println("You lose");
		} else {
			System.out.println("WUBBA LUBBA DUB DUB!!!");
		}
	}

}