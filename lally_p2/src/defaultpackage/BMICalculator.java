package defaultpackage;

import java.util.Scanner;

public class BMICalculator {
	
	//initialize important variables, i.e. height, weight, unit, BMI (as floats so division works correctly)
	private float unit, height, weight, BMI;
	private String category;
	Scanner scan = new Scanner(System.in);
	
	//prompt user to choose a unit type (loop until valid entry is entered = 1 or 2), scan in and assign unit type,
	//then ask for and scan in height and weight of corresponding type
	public void readUserData() {
		readUnitType();
		readMeasurementData();
		scan.close();
	}
	private void readUnitType() {
		do {
			System.out.println("Choose a measurement system:\n\t1 - Metric\n\t2 - Imperial");
			unit = scan.nextInt();
			if (unit != 1 && unit != 2) {
				System.out.println("Invalid entry! Try again (must be 1 or 2): ");
			}
		} while (unit != 1 && unit != 2);
	}
	
	//if user inputs negative height/weight, exit the program
	private void readMeasurementData() {
		if (unit == 1) {
			readMetricData();
		}
		else {
			readImperialData();
		}
	}
	private void readMetricData() {
		getHeight();
		System.out.print("(in centimeters): ");
		setHeight();
		getWeight();
		System.out.print("(in kilograms): ");
		setWeight();
	}
	private void readImperialData() {
		getHeight();
		System.out.print("(in inches): ");
		setHeight();
		getWeight();
		System.out.print("(in pounds): ");
		setWeight();
	}
	public void getHeight() {
		System.out.print("Please enter your height ");
	}
	private void setHeight() {
		height = scan.nextFloat();
		if (height < 0) {
			System.out.print("Invalid entry, exiting program...");
			System.exit(0);
		}
	}
	public void getWeight() {
		System.out.print("Please enter your weight ");
	}
	private void setWeight() {
		weight = scan.nextFloat();
		if (weight < 0) {
			System.out.print("Invalid entry, exiting program...");
			System.exit(0);
		}
	}
	
	//take height and weight values and plug them into BMI formula of corresponding unit type,
	//set equal to BMI, and correlate BMI to a category with series of if-else statements comparing
	//it to category parameters
	public void calculateBmi() {
		getBmi();
		getBmiCategory();
	}
	public void getBmi() {
		if (unit == 2) {
			BMI = (703 * weight)/(height * height);
		}
		else {
			height /= 100;
			BMI = weight/(height * height);
		}
	}
	public void getBmiCategory() {
		if (BMI < 18.5) {
			category = "underweight";
		}
		else if (BMI < 24.9) {
			category = "a normal weight";
		}
		else if (BMI < 29.9) {
			category = "overweight";
		}
		else {
			category = "obese";
		}
	}
	
	//print the user's BMI and what it means, then print a list of all bmi categories for comparison
	public void displayBmi() {
		System.out.printf("Your Body Mass Index is %.2f. This means you are %s. ", BMI, category);
		System.out.printf("The BMI weight class categories are:\n\n\tUnderweight < 18.5\n\tNormal weight = 18.5-24.9\n\tOverweight = 25 - 29.9\n\tObese = 30 or greater");
	}
	
	public static void main(String[] args) {
		BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();

	}

}
