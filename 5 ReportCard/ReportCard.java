package reportCard;

//Sneha Bandi
//Udacity Project
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ReportCard { // report card class
	Scanner sc = new Scanner(System.in);
	ArrayList<ReportCard> rArray = new ArrayList<ReportCard>();
	private String name; // To store name of student
	private int rollno; // To store roll no. of student
	//To store marks of student of different subjects
	private float englishMarks;
	private float mathMarks;
	private float chemistryMarks;
	private float physicsMarks;
	private float biologyMarks;
	private float socialMarks;
	private float percentage;
	private float passOrFail;

	public ReportCard(String name, int rollno, float englishMarks,
			float mathMarks, float chemistryMarks, float physicsMarks,
			float biologyMarks, float socialMarks) { // constructor
		this.name = new String(name);
		this.rollno = rollno;
		this.englishMarks = englishMarks;
		this.mathMarks = mathMarks;
		this.chemistryMarks = chemistryMarks;
		this.physicsMarks = physicsMarks;
		this.biologyMarks = biologyMarks;
		this.socialMarks = socialMarks;
	}

	public ReportCard() {
		name = new String(" ");
		rollno = 0;
	}

	// method for retrieving name
	public String getName() {
		return name;
	}

	// method for retrieving Roll no
	public int getRollno() {
		return rollno;
	}

	// method for retrieving English Marks
	public float getEnglishMarks() {
		return englishMarks;
	}

	// method for retrieving Mathematics Marks
	public float getMathMarks() {
		return mathMarks;
	}

	// method for retrieving Chemistry Marks
	public float getChemistryMarks() {
		return chemistryMarks;
	}

	// method for retrieving Physics Marks
	public float getPhysicsMarks() {
		return physicsMarks;
	}

	// method for retrieving Biology Marks
	public float getBiologyMarks() {
		return biologyMarks;
	}

	// method for retrieving Social Marks
	public float getSocialMarks() {
		return socialMarks;
	}

	// method for retrieving Percentage
	public float getPercentage() {
		return percentage;
	}

	// To edcide if student has passed the exam
	public String getPassOrFail() {
		if (percentage < 35)
			return "Fail";
		else
			return "Pass";
	}

	// Setter methods
	public void setName(String name) {
		this.name = new String(name);
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public void setEnglishMarks(float englishMarks) {
		this.englishMarks = englishMarks;
	}

	public void setMathMarks(float mathMarks) {
		this.mathMarks = mathMarks;
	}

	public void setChemistryMarks(float chemistryMarks) {
		this.chemistryMarks = chemistryMarks;
	}

	public void setPhysicsMarks(float physicsMarks) {
		this.physicsMarks = physicsMarks;
	}

	public void setBiologyMarks(float biologyMarks) {
		this.biologyMarks = biologyMarks;
	}

	public void setSocialMarks(float socialMarks) {
		this.socialMarks = socialMarks;
	}

	public void addRecord() {
		ReportCard reportCard = new ReportCard();
		reportCard.acceptMarks();
		rArray.add(reportCard);
	}

	// For calculating percentage
	public void calculatePercentage() {
		percentage = (getEnglishMarks() + getMathMarks() + getChemistryMarks()
				+ getPhysicsMarks() + getBiologyMarks() + getSocialMarks()) / 6;
	}

	// Method for accepting marks from student
	public void acceptMarks() {
		System.out.println("Enter the following Details ");
		System.out.println("\tName : ");
		setName(sc.next());
		System.out.println("\tRoll No : ");
		setRollno(sc.nextInt());
		System.out.println("\tEnglish : ");
		setEnglishMarks(sc.nextFloat());
		System.out.println("\tMathematics : ");
		setMathMarks(sc.nextFloat());
		System.out.println("\tPhysics : ");
		setPhysicsMarks(sc.nextFloat());
		System.out.println("\tChemistry : ");
		setChemistryMarks(sc.nextFloat());
		System.out.println("\tBiology : ");
		setBiologyMarks(sc.nextFloat());
		System.out.println("\tSocial : ");
		setSocialMarks(sc.nextFloat());
		calculatePercentage();
		System.out.println("Record stored successfully !");

	}

	// Overloading toString function
	@Override
	public String toString() {
		return ("\n\tName : " + getName() + "\n\tRoll No : " + getRollno()
				+ "\n\tEnglish : " + getEnglishMarks() + "\n\tMathematics : "
				+ getMathMarks() + "\n\tChemistry : " + getChemistryMarks()
				+ "\n\tPhysics : " + getPhysicsMarks() + "\n\tBiology : "
				+ getBiologyMarks() + "\n\tSocial : " + getSocialMarks()
				+ "\nPercentage : " + getPercentage() + "\nResult : " + getPassOrFail());
	}

	// To display all records
	public void displayAllRrecords() {
		int c = 1;
		Iterator<ReportCard> i = rArray.listIterator();

		while (i.hasNext()) {
			System.out.println("<------------ Record " + c + "-------------> "
					+ i.next().toString());// toString
			c++;
		}
	}

	public static void main(String args[]) {
		ReportCard rc = new ReportCard();
		Scanner scan = new Scanner(System.in);
		String ans;
		int choice;

		do {
			// Menu driven
			System.out.println("************ MENU *************");
			System.out
					.println("\t0.To print default\n\t1. Enter student record "
							+ "\n\t2. Display all records " + "\nCHOICE : ");
			choice = scan.nextInt();
			switch (choice) {
			case 0:
				ReportCard rcDefault = new ReportCard("Default", 0, 65, 64, 63,
						62, 61, 60);
				rcDefault.calculatePercentage();
				System.out.println(rcDefault.toString());
				break;
			case 1:
				rc.addRecord();
				break;
			case 2:
				rc.displayAllRrecords();
				break;
			default:
				System.out.println("\tEnter valid choice !");
			}
			System.out
					.println("===============================================");
			System.out.println("Do you  want to  continue (y/n) ?\nAnswer : ");
			ans = scan.next();
			System.out
					.println("===============================================");

		} while (ans.charAt(0) == 'y' || ans.charAt(0) == 'Y');
		System.out.println("\t\t********** Thank You ! **********");
	}
}
// ends
// -------------------------->> OUTPUT
/*
 * *********** MENU ************* 1. Enter student record 2. Display all records
 * CHOICE : 1 Enter the following Details Name : a Roll No : 1 English : 95
 * Mathematics : 96 Physics : 93 Chemistry : 91 Biology : 92 Social : 94 Record
 * stored successfully ! =============================================== Do you
 * want to continue (y/n) ? Answer : y
 * ===============================================*********** MENU *************
 * 1. Enter student record 2. Display all records CHOICE : 1 Enter the following
 * Details Name : b Roll No : 2 English : 45 Mathematics : 15 Physics : 16
 * Chemistry : 25 Biology : 35 Social : 14 Record stored successfully !
 * =============================================== Do you want to continue (y/n)
 * ? Answer : y ===============================================*********** MENU
 * ************* 1. Enter student record 2. Display all records CHOICE : 2
 * <------------ Record 1-------------> Name : a Roll No : 1 English : 95.0
 * Mathematics : 96.0 Chemistry : 91.0 Physics : 93.0 Biology : 92.0 Social :
 * 94.0 Percentage : 93.5 Result : Pass <------------ Record 2------------->
 * Name : b Roll No : 2 English : 45.0 Mathematics : 15.0 Chemistry : 25.0
 * Physics : 16.0 Biology : 35.0 Social : 14.0 Percentage : 25.0 Result : Fail
 * =============================================== Do you want to continue (y/n)
 * ? Answer : n ===============================================********* Thank
 * You ! **********
 */
