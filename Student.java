//Author: Eric Zair
//File:	Student.java
//Description:	This class creates a student object
				//With traits like Grade... etc


import java.util.ArrayList;
import java.util.Collections;

public class Student {


	//Variables
	private ArrayList<Double> testScores = new ArrayList<Double>();
	private String firstName;
	private String lastName;
	private int grade;


	//Constructor
	public Student(String fName, String lName, int classYear) {
		firstName = fName;
		lastName = lName;
		grade = classYear;
	}


	//Default Constructor
	public Student() {
		this("N/A", "N/A", 0);
	}



	//Setters
	//set student's firstName
	public void setFirstName(String fName) {
			firstName = fName;
	}


	//set student's lastName
	public void setLastName(String lName) {
		lastName = lName;
	}


	//set students grade
	public void setGrade(int _grade) {
		grade = _grade;
	}


	//Getters
	//return firstName
	public String getFirstname() {
		return firstName;
	}


	//return lastname
	public String getLastName() {
		return lastName;
	}


	//return grade
	public int getGrade() {
		return grade;
	}


	//access ArrayList
	public double getTestScore(int index) {
		return testScores.get(index);
	}


	//Adjective Methods --------------------------------
	//add another testScore
	public void addTestScore(double score) {
		testScores.add(score);
	}


	//sort grades
	public void sortTestScores() {
		Collections.sort(testScores);
	}


	//get amount of test scores
	public int numberOfTests() {
		return testScores.size();
	}


	//replace score
	public void replaceTestScore(int index,double testScore) {
		testScores.set(index, testScore);
	}


	//remove a test score
	public void removeTestScore(int index) {
		testScores.remove(index);
	}


	//remove all testScores
	public void removeTestScores() {
		testScores.clear();
	}


	//calculate final testScore
	public double testScoreAverage() {
		double average = 0.0;
		for(double score: testScores)
			average += score;
		average /= numberOfTests();
		return average;
	}


	//check if score is bigger
	//returns true if score is greater
	public boolean scoreIsBigger(Object o) {
		if(o instanceof Student) {
			Student s = (Student) o;
			return testScoreAverage() > s.testScoreAverage();
		}
		else
			return false;
	}


	//check if students grades are the same
	public boolean equals(Object o) {
		if(o instanceof Student) {
			Student s = (Student) o;
			//if they are not the same length return false
			if(numberOfTests() != s.numberOfTests())
				return false;
			//copy, sort both, see if they are equal
			ArrayList<Double> one = new ArrayList<Double>(testScores);
			ArrayList<Double> two = new ArrayList<Double>(s.testScores);
			Collections.sort(one);
			Collections.sort(two);
			return one.equals(two);
			//sort both and see if they are equal
		}
		else
			return false;
	}


	//print out student as a string
	public String toString() {
		return firstName + " " + lastName + " Final Grade: %" + testScoreAverage();
	}


}//class