package defaultpackage;

import java.util.Scanner;

public class Decrypter {

	static Scanner scan = new Scanner(System.in);
	
	public static void Decrypt() {

		//read number from user and separate its digits
		int input = scan.nextInt();
		
		int data[] = new int[4];
		for (int i = 3; i >= 0; i--) {
			data[i] = input % 10;
			input /= 10;
		}
		
		//swap first digit with the third and second digit with the fourth
		int temp;
		temp = data[0];
		data[0] = data[2];
		data[2] = temp;
		temp = data[1];
		data[1] = data[3];
		data [3] = temp;
		
		//add 3 to each integer and modulo by 10
		for (int i = 0; i <= 3; i++) {
			data[i] += 3;
			data[i] %= 10;
		}
		
		//print decrypted number
		System.out.print("\nYour new decrypted number is: ");
		for (int i = 0; i <= 3; i++) {
			System.out.print(data[i]);
		}

	}

}