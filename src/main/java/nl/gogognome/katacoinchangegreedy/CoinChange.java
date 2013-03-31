package nl.gogognome.katacoinchangegreedy;

public class CoinChange {

	final static int[] COINS = new int[] {100, 25, 10, 5, 1};

	public int[] getCointCount(int amount) {
		int[] counts = new int[COINS.length];
		for (int c=0; c<COINS.length; c++) {
			counts[c] = amount / COINS[c];
			amount -= counts[c] * COINS[c];
		}
		return counts;
	}
}
