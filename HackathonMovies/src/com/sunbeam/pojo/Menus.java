package com.sunbeam.pojo;

import java.util.Scanner;

public class Menus {

	public static int mainMenu()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("0.Exit\n1.Sign Up\n2.Sign In");
		System.out.println("Enter your choice: ");
		int choice =sc.nextInt();
	
		return choice;
	}
	
	public static int subMenu()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("0.Log out\n1.Edit Profile\n2.Change Password\n3.Write Review\n4.Edit Review\n5.Display All Movies\n6.Display All Reviews\n7.Display My Reviws\n8.Display Reviews Shared with me\n9.share a Reviews\n10.Delete a Review");
		System.out.println("Enter your choice: ");
		int choice =sc.nextInt();
		
		return choice;
	
	}
}
