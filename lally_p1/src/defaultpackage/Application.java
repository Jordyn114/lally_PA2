package defaultpackage;

import java.util.Scanner;

public class Application {

	static int choice = 0;
	Scanner scan = new Scanner(System.in);
	
	//ask user if they want to encrypt or decrypt a number, assign response to a value (1 or 2), then call the related class method
	public void chooseEncryptOrDecrypt(){
		if (choice == 0) {
			System.out.println("Are you encrypting or decrypting a number?\n\t1 - Encrypt\n\t2 - Decrypt");
			choice = scan.nextInt();
			do {
			if (choice != 1 && choice != 2) {
				System.out.print("Invalid Entry! Try again: ");
				choice = scan.nextInt();
			}
			} while (choice != 1 && choice != 2);
		}
	}
	
	public void doCryption() {
		System.out.print("Enter the 4-digit number: ");
		if (choice == 1) {
			Encrypter.Encrypt();
		}
		else {
			Decrypter.Decrypt();
		}
	}
	
	public void askToStartOver() {
		System.out.println("\n\nWould you like to enter another number?\n\t1 - Encrypt a number\n\t2 - Decrpyt a number\n\t3 - Exit Program");
		choice = scan.nextInt();
		do {
		if (choice != 1 && choice != 2 && choice != 3) {
			System.out.print("Invalid Entry! Try again: ");
			choice = scan.nextInt();
		}
		} while (choice != 1 && choice != 2 && choice != 3);
		if (choice == 3) {
			System.out.print("Goodbye!");
			System.exit(0);
		}
	}
	
	//use do-while to restart with new number at user's request
	public static void main(String[] args) {
		Application app = new Application();
		app.chooseEncryptOrDecrypt();
		do {
		app.doCryption();
		app.askToStartOver();
		} while (choice == 1 || choice == 2);
	}

}
