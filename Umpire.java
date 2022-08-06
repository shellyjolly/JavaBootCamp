package com.example.guesser;

public class Umpire {
	
	
	public void guessing() {

		Utility u = new Utility();
		int number = -1;
		String temp, tempName, gName;
		int no_of_player = 0;
		int j = 0; // actual number of players
		Player[] players = null;
		Player[] temppl = null;
		int pnumber;
		Guesser g = null;
		boolean winner = false, already_played = false;
		System.out.println("*********************Let's Play Guessing Game********************************************");
		System.out.println("*****************************************************************************************");
		System.out.println("**********A Guesser has a number that all players have to guess *************************");
		System.out.println("*****************************************************************************************");
		System.out.println("***********************Guesser's turn****************************************************");
		System.out.println("*****************************************************************************************");
		System.out.println("*******************Guesser, Please Enter your name **************************************");
		gName = u.getInput();
		if (null == gName || gName == "")
			gName = null;
		while (!winner) {
			if (null != gName)
				System.out.println(
						"***************** " + gName + " : Please Guess: " + " ***************************************");
			number = u.guessNumber(); // call to guess number by guesser
			number = u.chances(number); // check if chances needed
			if (number == -1) {
				System.out.println("**************Game Over : No Number From The Guesser*******************************");
				System.exit(0);
			}

			else {
				if (g == null) { // first time creation of Guesser
					g = new Guesser();
					g.setGname(gName);
					g.setGnumber(number);
				} else
					g.setGnumber(number);
				if (no_of_player == 0) // first time
				{
					System.out.print("\n" + "\n" + "\n");
					System.out.println("***********Players, Please Guess The Number Chosen by  : " + g.getGname()
							+ "**********************");
					System.out.println(
							"*************Enter the number of players(Maximum player allowed 9)***********************");
					temp = u.getInput();
					no_of_player = u.getvalidNumber(temp); // checking user input
					no_of_player = u.chances(no_of_player);
					System.out.println("********************** " + no_of_player + " Player Playing******************");
					if (no_of_player == -1 || no_of_player == 0) {
						System.out.println(
								"************Game Over : Wrong Selection of Number of Players************************");
						System.exit(0);
					}
				}
				if (players == null)
					players = new Player[no_of_player];
				else {
					System.out.println("***********Next Round, There Is A Tie*******************************");
					already_played = true;
					temppl = new Player[j];
				}
				j = 0; // again start counting actual no of players
				for (int i = 0; i < no_of_player; i++) {
					if (!already_played) // (first time)
					{
						System.out.println("******Player: " + (i + 1) + "**Please Enter your name*****************");
						tempName = u.getInput();
					} else {
						tempName = players[i].getPname();
						already_played = true;
					}

					System.out.println(
							"**** " + tempName + ": Please Enter your best guess number within the range 0-9 ***********");
					temp = u.getInput();
					pnumber = u.getvalidNumber(temp);
					pnumber = u.chances(pnumber);
					if (pnumber == -1)
						System.out.println("**************Okay,So Player: " + tempName
								+ " decided to quit**********************************");
					else if (pnumber == g.getGnumber()) {

						players[j] = new Player(); // creating player object only if the number matched
						players[j].setPname(tempName);
						players[j].setPguessNum(pnumber);
						if (already_played)
							temppl[j] = players[j];
						j++;
					}
				}

			}
			if (temppl != null) {
				players = temppl; // Imp now players is referring to the temporary array,existing players eligible
									// for GC
			}

			no_of_player = j; // setting no of players left
			if (j <= 0) {
				System.out.println("********No-one Guessed the right number : " + g.getGnumber()
						+ "*********Better luck next time*****************");
				winner = true; // false true to end the loop
			}

			else if (j > 1) {

				System.out.print("\n" + "\n" + "\n");
				System.out.println("*********Winner(s) Name : *****************************");
				for (int i = 0; i < players.length; i++) {
					if (players[i] != null)
						System.out.println(players[i].getPname());

				}
				System.out.print("\n" + "\n" + "\n");
				System.out.println("**************Let's Play Again With the Winner(s) **********************");
				already_played = true;
			} else {
				System.out.print("\n" + "\n" + "\n");
				System.out.println("*********CONGRATULATIONS!!!OUR FINAL WINNER IS: " + players[0].getPname()
						+ " and the number was : " + g.getGnumber() + "****************");
				winner = true;
			}

		} // End of While loop
		players = null;
		temppl = null; // free the resources
	
		
	}

}
