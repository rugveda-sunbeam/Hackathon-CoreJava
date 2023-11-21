package com.sunbeam.tester;

import com.sunbeam.pojo.Menus;
import com.sunbeam.pojo.User;

public class ApplicationMain {
	public static void main(String[] args) {

		User curUser = null;
		int choice;
	do {
		choice =Menus.mainMenu();
		switch (choice) {
		case 0:
			System.exit(0);
		case 1:
			UserMain.signUp();
			break;
		case 2:
			curUser = UserMain.signIn();
			if (curUser != null) {
				while (true) {
					int submenuchoice = Menus.subMenu();
					switch (submenuchoice) {
					case 0:
						System.exit(0);
					case 1:
						UserMain.editProfile();
						break;
					case 2:
						UserMain.changePassword();
						break;
					case 3:
						MovieMain.moviedisplay();
						ReviewMain.writeReview(curUser);
						break;
					case 4:
						ReviewMain.reviewdisplay();
						ReviewMain.editReview();
						break;
					case 5:
						MovieMain.moviedisplay();
						break;

					case 6:
						ReviewMain.reviewdisplay();
						break;
					case 7:
						ReviewMain.displayReviewByUser(curUser);
						break;
					case 8:
//						MovieMain.
						break;
					case 9:
						ReviewMain.reviewdisplay();
						UserMain.displayAllUser();
						break;
					case 10:
						ReviewMain.deleteReview();
						break;
					default:
						break;
					}
				}
			} else {
				System.out.println("You entered worng credentials");
			}

			break;
		
		default:
			System.err.println("Entered choice is not valid");
		}
	}while(choice!=0);
	}
}
