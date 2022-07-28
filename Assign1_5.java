package com.example;

public class Assign1_5 {

	public static void main(String[] args) {
		int n=14; //length of pattern
		for(int i =0;i<n;i++)
		{
			for(int j =0;j<n;j++)
				if(i==0 || i==n-1 || i+j<=n/2 || j==0 || i-j>=(n-1)/2)
				System.out.print("*");
				else
					System.out.print(" ");
			System.out.println();
		}
	}

}
