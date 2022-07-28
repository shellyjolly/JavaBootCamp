package com.example;

public class NamePattern {

	
	
	public static void main(String args[])
	{
		int n =10;
		int m = 6; // no of letters
		
		NamePattern np = new NamePattern();
		char name[][];
		name = new char[n][(n*m)+(m-1)];
		
	    name = np.patternS(0, n, name,n);
	    for(int i=0;i<n;i++)
			name[i][n]= ' ';
	    
	    name =np.patternH(n+1,2*n+1,name,n);
	    for(int i=0;i<n;i++)
	    	name[i][2*n+1]=' ';
	    
	    name=np.patternE(2*n+2, 3*n+2, name, n);
	    for(int i=0;i<n;i++)
	    	name[i][3*n+2]=' ';
	    
	    name = np.patternL(3*n+3,4*n+3 , name, n);
	    for(int i =0;i<n;i++)
	    	name[i][4*n+3]=' ';
	    
	    name=np.patternL(4*n+4, 5*n+4, name, n);
	    for(int i =0;i<n;i++)
	    	name[i][5*n+4]=' ';

	    
	    name=np.patternY(5*n+5, 6*n+5, name, n);
	
		System.out.println("PATTERN!!!"+"\n"+"\n"+"\n");
		for(int i=0;i<n;i++)
		
		{
			for(int j=0;j<6*n+5;j++)
				System.out.print(name[i][j]);
			System.out.println();
		}
		
		System.out.println("\n"+"\n"+"\n");
		
		//Using outer loop Approach
		
		//creating S pattern
		for(int i=0;i<n;i++)
		{
			for(int j =0;j<n;j++)
			{
				if(i==0 || i==n/2 || i == (n-1) || (j==0 && i<n/2) || (j==(n-1) && i>n/2))
					System.out.print("*");
				else
					System.out.print(" ");
			}
		//	System.out.println();
	 	//}
		System.out.print(" ");
		//creating H pattern
	//	for(int i =0;i<n;i++)
	//	{
			for(int j =0;j<n;j++)
			{
				if((j==0 || j== (n-1)) || i==(n-1)/2 )
					System.out.print("*");
				else
					System.out.print(" ");				
			}
			//System.out.println();
		//}
		System.out.print(" ");
		//creating E pattern
	//	for(int i=0;i<n;i++)
		//{
			for(int j=0;j<n;j++)
			{
				if(i==0 || j==0|| (i==(n-1)/2 && (j!=(n-1) && j!=(n-2)))|| (j==(n-1)&&(i==0)&&(i==(n-1))) || i==(n-1))
					System.out.print("*");
				else
					System.out.print(" ");	
			}
		//	System.out.println();
		//}
		System.out.print(" ");
		//creating L pattern
	//	for(int i =0;i<n;i++)
	//	{
			for(int j =0;j<n;j++)
			{
				if(j==0 || i==(n-1))
					System.out.print("*");
				else
					System.out.print(" ");
			}
		//	System.out.println();
	//	}
		System.out.print(" ");	
		for(int j =0;j<n;j++)
		{
			if(j==0 || i==(n-1))
				System.out.print("*");
			else
				System.out.print(" ");
		}
	//	System.out.println();
//	}
	System.out.print(" ");	
		//creating Y pattern
	//	for(int i =0;i<n;i++)
	//	{
			for(int j=0;j<n;j++)
			{
				if((i+j)==(n-1)||(i == j && i+j<=n-1))
						System.out.print("*");
				else
					System.out.print(" ");	
						
			}
	//		System.out.println();
	//	}
		System.out.println();
		
		}
		}
//	}
	
	
	 char[][] patternS(int start_pos,int end_pos,char[][] arr,int length)
	{
		int n = end_pos;
		for(int i=0;i<n;i++)
		{
			for(int j =0;j<n;j++)
			{
				if(i==0 || i==n/2 || i == (n-1) || (j==0 && i<n/2) || (j==(n-1) && i>n/2))
				{	
					arr[i][j]='*';
				}
				else
				{
					arr[i][j] =' ';
				}
					
			}
		}
		return arr;
	}
	 
	 char[][] patternH(int start_pos,int end_pos,char[][] arr,int length)
		{
			int n = end_pos;
			for(int i=0;i<length;i++)
			{
				for(int j =start_pos;j<n;j++)
				{
					if((j==start_pos || j== (n-1)) || i==(length-1)/2 )
					{
						arr[i][j]='*';
					}
					else
					{
						arr[i][j] =' ';
					}
						
				}
			}
			return arr;
		}
	 char[][] patternE(int start_pos,int end_pos,char[][] arr,int length)
		{
			int n = end_pos;
			for(int i=0;i<length;i++)
			{
				for(int j =start_pos;j<n;j++)
				{
						if(i==0 || j==start_pos|| (i==(length-1)/2 && (j!=(n-1) && j!=(n-2)))|| (j==(n-1)&&(i==0)&&(i==(length-1))) || i==(length-1))
					{	
						arr[i][j]='*';
					}
					else
					{
						arr[i][j] =' ';
					}
						
				}
			}
			return arr;
		}
	 char[][] patternL(int start_pos,int end_pos,char[][] arr,int length)
		{//for S pattern i,j=0
			int n = end_pos;
			for(int i=0;i<length;i++)
			{
				for(int j =start_pos;j<n;j++)
				{
					if(j==start_pos || i==(length-1))
					{
						arr[i][j]='*';
					}
					else
					{
						arr[i][j] =' ';
					}
						
				}
			}
			return arr;
		}
	 
	 char[][] patternY(int start_pos,int end_pos,char[][] arr,int length)
		{
			int n = end_pos;
			for(int i=0;i<length;i++)
			{
				for(int j =start_pos;j<n;j++)
				{
					if((i+j)==(n-1)||(i+start_pos == j && i+j<=n-1))
					{
						arr[i][j]='*';
					}
					else
					{
						arr[i][j] =' ';
					}
						
				}
			}
			return arr;
		}
	 
}
