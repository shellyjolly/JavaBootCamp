package com.example;

/*
Program to print
1 1 1 1
2 2 2 2
3 3 3 3
4 4 4 4
*/

public class Assign1_2 {
	
	public static void main(String args[])
	{
		int num =4;  // length of pattern
		for(int i =1;i<=num;i++)
		{
			for(int j =1;j<=num;j++)
				System.out.print(i);
			System.out.println();
		}
		
	}

}
