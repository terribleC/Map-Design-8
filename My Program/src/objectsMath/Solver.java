package objectsMath;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Solver {
	public static SolverGUI gui;

	public static void main(String[] args) {
		// your other methods
		// Here is something to try:
		System.out
				.println("The terms in the equation \"x = 2x^2 -17x +7\" are:");
		Equation parsedEquation = interpretInput("x = 2x^2 -17x +7");
		for (Term t : parsedEquation.getLeftSide()) {
			System.out.println(t.toString());
		}
		System.out.println("...on the left, and on the right:");
		for (Term t : parsedEquation.getRightSide()) {
			System.out.println(t.toString());
		}
		// Once your methods are all working, you can use the following to
		// initiate the GUI
		gui = new SolverGUI();
		gui.setVisible(true);
		gui.setSize(900, 500);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static Equation interpretInput(String s) {
		// parse s into two ArrayList<Term>
		// expect user input to appear like this:
		// A few things to note:
		// Assume the user will always include exactly one '=',
		// (Invalid input will be handled by the GUI)
		// Terms are always separated by a '+','-' or '='
		// Do not consider subtraction. Rather, subtraction is ADDING a Term
		// with a NEGATIVE coefficient
		// Recall that a term like "x" has a coefficient of '1' and an exponent
		// of '1'
		// Recall that there is a specific constructor for constant terms
		/*
		 * String str = s.replaceAll("\\s", ""); //str = 3x^2 -12x +13 = 2x^2
		 * -17x +7
		 */
		String str = s.replaceAll("\\s", "");
		String[] leftAndRight = str.split("=");
		ArrayList<Term> leftSide = createAndAddTerms(leftAndRight[0]);
		ArrayList<Term> rightSide = createAndAddTerms(leftAndRight[1]);
		return new Equation(leftSide, rightSide);
		// String str=s.replaceAll("\\s", "");//str=3x^2-12x+13=2x^2-17x+7
		// String[] splitStr=str.split("=");
		// ArrayList<Term> leftSide=createAndAddTerms(splitStr[0]);
		// ArrayList<Term> rightSide=createAndAddTerms(splitStr[1]);
		// return new Equation(leftSide, rightSide);
	}

	// private since we are only using it here
	private static ArrayList<Term> createAndAddTerms(String termString) {
		ArrayList<Term> terms = new ArrayList<Term>();
		int i = 0;// index of the first digit (in case the String starts with
					// '-'
		boolean positiveTerm = true;// Assume term is positive
		if (termString.startsWith("-")) {
			positiveTerm = false;
			i++;// start at index 1 if character at 0 is '-'
		}
		while (termString.length() > 0) {// delete one term at a time as it gets
											// added
			int endOfTerm = termString.length();
			int indexOfPlus = termString.indexOf("+");
			// If there is no '+', above value is -1
			if (indexOfPlus < 0)
				indexOfPlus = endOfTerm;
			int indexOfMinus = termString.indexOf("-");
			if (indexOfMinus < 0)
				indexOfMinus = endOfTerm;
			if (indexOfMinus < indexOfPlus)
				endOfTerm = indexOfMinus;
			else
				endOfTerm = indexOfPlus; // Guarantees whatever comes first,
											// end, '+' or '-'
			try {
				Term a = parseTerm(termString.substring(i, endOfTerm));
				if (!positiveTerm)
					a = a.getAddInverse();

				if (a != null) {
					terms.add(a);
				}

				// check of next term is + or -
				if (indexOfMinus < indexOfPlus)
					positiveTerm = false;
				else
					positiveTerm = true;
				// cut out the term that was added, including the next +/-
				// symbol
				termString = termString.substring(endOfTerm + 1,
						termString.length());
			} catch (Exception e) {
				// if the user us trying to do something that throws an error,
				// skip this term
				termString = termString.substring(endOfTerm,
						termString.length());
				// cuts out the term
			}
		}
		return terms;
	}

	/**
	 * 
	 * @param sample
	 *            string from user: 34a^3
	 * 
	 * @return new Term representing input from user
	 * 
	 *         Use this method for writing interpretInput
	 */

	private static Term parseTerm(String s) {
		if (s.matches("\\d*\\w\\^\\d+" +
		// d-digits *-any
		// word character
		// exponent character
		// 1 or more digits
				"|" +

				"\\d*\\w" +
				// any number of diits
				// a character
				"|" +

				"\\d+")) {// regex identifies anything like 23x^2 or y^11 or 12b
							// or z or 13
			// 1 ore more digits
			double coef;

			String variable;

			Term t;

			if (s.matches("\\d*")) {

				coef = Double.parseDouble(s);

				t = new Term(coef);

			}
			// optional ()?
			else if (s.matches("\\d*\\w+(\\^\\d+)?")) {

				String noDigits = s.replaceAll("\\d", "");

				int indOfVar = s.indexOf(noDigits);

				if (s.substring(0, indOfVar).length() == 0) {

					coef = 1.0;

				}

				else
					coef = Double.parseDouble(s.substring(0, indOfVar));

				variable = s.substring(indOfVar, indOfVar + 1);

				if (s.indexOf("^") > -1) {

					int exponent = Integer
							.parseInt(s.substring(s.indexOf("^") + 1));

					t = new Term(coef, variable, exponent);

				} else {

					t = new Term(coef, variable, 1);

				}

			} else {

				t = null;

			}

			return t;

		}

		else
			return null;

	}

	public static String getConfirm(Equation eq) {

		return "Your message was interpreted as " + eq.toString()
				+ " You good?";
		// returns a message confirming the input given by the user, such as
		// "Your input was interpreted as "+eq.toString();

	}

	public static String getNoTricks(String usersInput) {
		Equation x = interpretInput(usersInput);
		if (x.isSolveable()) {
			return "This can be solved";
		} else {
			return "This canned nut be solved";
		}

	}

	public static void solve(Equation eq) {

		gui.clearSteps();// make sure gui is a static field
		System.out.println("hi");
		boolean sideR = eq.cancelRight();////
		if (sideR) {
			eq.toZeroOnOneside(eq.getRightSide());
		} else {
			eq.toZeroOnOneside(eq.getLeftSide());
		}
		gui.addStep(eq,"Cancel");
		eq.simplify(eq.getLeftSide());
		eq.simplify(eq.getRightSide());
		gui.addStep(eq,"Simplify");
		if (eq.isLinear()) {
			if (sideR)
				eq.solveLinear(eq.getLeftSide());
			else
				eq.solveLinear(eq.getRightSide());
		} else if (eq.isQuadratic()) {
			if (sideR)
				eq.solveQuadratic(eq.getLeftSide());
			else
				eq.solveQuadratic(eq.getRightSide());
		}
		gui.addStep(eq.toString());

	}

}
