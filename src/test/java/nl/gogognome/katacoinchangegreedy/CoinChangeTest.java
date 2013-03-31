package nl.gogognome.katacoinchangegreedy;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinChangeTest {

	private final CoinChange coinChange = new CoinChange();

	@Test
	public void tests() {
		assertCoinChange("", 0);
		assertCoinChange("1x1", 1);
		assertCoinChange("2x1", 2);
		assertCoinChange("1x5", 5);
		assertCoinChange("1x5 + 4x1", 9);
		assertCoinChange("1x10", 10);
		assertCoinChange("1x10 + 1x5 + 1x1", 16);
		assertCoinChange("2x25 + 1x5 + 4x1", 59);
		assertCoinChange("1x100 + 2x10 + 3x1", 123);
	}

	private void assertCoinChange(String expetedCoins, int amount) {
		assertEquals(expetedCoins, formatCount(coinChange.getCointCount(amount)));
	}

	private String formatCount(int[] counts) {
		StringBuilder sb= new StringBuilder();
		for (int c=0; c<counts.length; c++) {
			if (counts[c] > 0) {
				if (sb.length() > 0) {
					sb.append(" + ");
				}
				sb.append(counts[c]).append('x').append(CoinChange.COINS[c]);
			}
		}
		return sb.toString();
	}

}
