
public class Mensch extends Aerger {
	public static int[] playerY, playerB;

	public static void yellowMoves(int howManySteps) {
		int newPlace = 0;
		// Zug vom yellow Stein
		int whatStone = read("Mit whelchem Stein wollen Sie jetzt gehen") - 1;
		if (newPlace < 44) {
			newPlace = 6;
			// howManySteps;

			// Checken ob blue Stein auf Position steht, if yes Bluew kommt nach
			// Hause
			while (true) {
				int houseOfBlue = -1;
				for (int indexOfBlue = 0; indexOfBlue < 4; indexOfBlue++) {
						if (playerB[indexOfBlue] < newPlace && playerB[indexOfBlue] > playerY[indexOfBlue]) {
							whatStone = read("Bitte wählen Sie einen anderen Stein") - 1;
						} else {
							if (playerB[indexOfBlue] == newPlace) {
								playerB[indexOfBlue] = houseOfBlue;
								playerY[whatStone] = newPlace;
								houseOfBlue--;
							} else {
								playerY[whatStone] = newPlace;
							}
						}
					
				}
			}

		}
	}

	public static void main(String[] args) {
		playerY = new int[] { -1, 8, -3, -4 };
		playerB = new int[] { 5, -2, -3, -4 };

		int howManySteps = MiniJava.dice();
		System.out.println(howManySteps + " ");
		yellowMoves(howManySteps);

		/*
		 * throw dice ask which stone should be moved check if there is another
		 * stone on this position check which color the stone has if same color
		 * throw does nothing if the color of the contro player: stone of sontro
		 * goes home, the stone takes this place
		 */

		/*
		 * throw dice, read the number ask which stone moves if (moveIsValid)
		 * {move} if ()
		 */
		// dice = MiniJava.dice();
		// whelcherSteinY();

		paintField(playerY, playerB);

	}
}
