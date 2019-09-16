import java.util.Scanner;

/**
 * Homework for Week 1. Task: write a program calculating the bonuses depending on the total amount of previous
 * purchases.
 * All calculations will be done in roubles (kopeks are discarded, or rounded down).
 *
 * @author Aleksei Litvinov
 */
public class Main {
	public static void main(String[] args) {
		int totalPurchases = 9000;
		int currentPurchase = 2550;

		//Uncomment the lines below for extra interactivity
//		Scanner scanner = new Scanner(System.in);
//		do {
//			System.out.print("Please enter the total amount of previous purchases (rounded to roubles): ");
//			totalPurchases = scanner.nextInt();
//			System.out.print("Please enter the amount of the current purchase (rounded to roubles): ");
//			currentPurchase = scanner.nextInt();
//			if (totalPurchases < 0 || currentPurchase < 0){
//				System.out.println("Sorry, something went wrong, please try again");
//			}
//		} while (totalPurchases < 0 || currentPurchase < 0);


		int bonusBase = currentPurchase / 1000;
		int bonusMultiplier = 50; //Base bonus for Blue membership card

		if (totalPurchases >= 150_000) {
			bonusMultiplier = 100;
		} else if (totalPurchases >= 15_000) {
			bonusMultiplier = 70;
		} else if (totalPurchases < 1){
			bonusMultiplier = 0;
		}

		if (bonusMultiplier == 0){
			System.out.println("We are sorry, but no bonuses are awarded until you have purchased at least once " +
					"(for at least 1 rouble)");
		} else {
			System.out.println("You have been awarded " + bonusBase * bonusMultiplier + " bonus points.");
		}

		if (totalPurchases < 150_000 && totalPurchases + currentPurchase >= 150_000) {
			System.out.println("You have reached the golden membership, your next purchase will grant you 100 points " +
					"per 1000 roubles spent");
		} else if (totalPurchases < 15_000 && totalPurchases + currentPurchase >= 15_000){
			System.out.println("You have reached the silver membership, your next purchase will grant you 70 points " +
					"per 1000 roubles spent");
		}

		// Useless here, but for a real case we would want the new purchase added to
		// the total and put back into database
		totalPurchases += currentPurchase;

	}
}
