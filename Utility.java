package com.example.guesser;

import java.util.Scanner;

public class Utility {
	Scanner sc;
	
	/*fetch the input from console*/
	 public String getInput()
		{
			String value = null;
			sc = new Scanner(System.in);
			value = sc.next();
			return value;
		}
	 
	/* Validation of the number passed by user*/
	 public int getvalidNumber(String tempnum)
	 { 
		 int gnumber=-1;
		 if(tempnum.length() == 1) 
			{
				gnumber=tempnum.charAt(0); 
				if(gnumber >= 48 && gnumber <= 57)
				{
					gnumber = gnumber-48; 
				}
					
				else
					gnumber=-1;
			}
		 return gnumber;
	 }
	 /*Validation failed , further chances*/
	 public int chances(int gnumber)
	 {
			boolean interested = true;
			while (interested) {
				if (gnumber == -1) {
					System.out.println("*********Please select a valid number within the range************");
					System.out.println("******Do you want to try again? Please enter (Y) to try again or press any key to quit.*****");
					String input = getInput();

					if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
						System.out.println("************************Let's try Again**********************************");
						gnumber = guessNumber();
					} else {
						interested = false;
						System.out.println("************************You decided to quit the game*************************");
					}

				} else {
					System.out.println("************************Thanks for the input :  **************");
					interested = false;
				}

			}
			
         return gnumber;
		
	 }
	 
	 public int guessNumber() {
			int gnumber = -1;
			String tempnum = null;
			System.out.println("**********************Let's Play the Game**********************************");
			System.out.println("***************************************************************************");
			System.out.println("******************Please share the number from the range 0 to 9************");

			tempnum = getInput(); // getting the value for the input
			gnumber =getvalidNumber(tempnum);

			return gnumber;
		}

}
