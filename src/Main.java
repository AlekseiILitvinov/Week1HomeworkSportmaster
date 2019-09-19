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
		int thresholdBlue = 1;
		int thresholdSilver = 15_000;
		int thresholdGold = 150_000;
		int bonusBlue = 50;
		int bonusSilver = 70;
		int bonusGold = 100;

		Scanner scanner = new Scanner(System.in);

		int totalPurchases;
		int currentPurchase;
		do {
			System.out.print("Please enter the total amount of previous purchases (rounded to roubles): ");
			totalPurchases = scanner.nextInt();
			System.out.print("Please enter the amount of the current purchase (rounded to roubles): ");
			currentPurchase = scanner.nextInt();
			if (totalPurchases < 0 || currentPurchase < 0) {
				System.out.println("Sorry, something went wrong, please try again");
			}
		} while (totalPurchases < 0 || currentPurchase < 0);

		int bonusBase = currentPurchase / 1000;
		int bonusMultiplier = bonusBlue;

		if (totalPurchases >= thresholdGold) {
			bonusMultiplier = bonusGold;
		} else if (totalPurchases >= thresholdSilver) {
			bonusMultiplier = bonusSilver;
		} else if (totalPurchases < thresholdBlue) {
			bonusMultiplier = 0;
		}

		int bonusAwarded = bonusBase * bonusMultiplier;

		if (bonusMultiplier == 0) {
			System.out.println("We are sorry, but no bonuses are awarded until you have purchased at least once " +
					"(for at least 1 rouble)");
		} else {
			System.out.println("You have been awarded " + bonusAwarded + " bonus points.");
		}

		if (totalPurchases < thresholdGold && totalPurchases + currentPurchase >= thresholdGold) {
			System.out.println("You have reached the golden membership, your next purchase will grant you 100 points " +
					"per 1000 roubles spent");
		} else if (totalPurchases < thresholdSilver && totalPurchases + currentPurchase >= thresholdSilver) {
			System.out.println("You have reached the silver membership, your next purchase will grant you 70 points " +
					"per 1000 roubles spent");
		}

		totalPurchases += currentPurchase;
		System.out.println("Your sum of purchases is now " + totalPurchases + " roubles. Thank you!");

	}
}
