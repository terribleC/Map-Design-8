package objectsMath;

import java.util.ArrayList;

public class Equation {

	private ArrayList<Term> leftSide;
	private ArrayList<Term> rightSide;
	private boolean cancelRight;
	private ArrayList<Double> solution;
	double a = 0;
	double b = 0;
	double c = 0;
	double d = 0;

	public void toZeroOnOneside(ArrayList<Term> sideBeingCanceled) {
		ArrayList<Term> addIn = new ArrayList<Term>();
		for(Term t:sideBeingCanceled){
			addIn.add(t.getAddInverse());
		}
		for(Term t:addIn){
			leftSide.add(t);
			rightSide.add(new Term(t.getCoefficient(),t.getVariable(),t.getExponent()));
		}

	}

	public Equation(ArrayList<Term> leftSide, ArrayList<Term> rightSide) {
		this.leftSide = leftSide;
		this.rightSide = rightSide;
		// sets values of leftSide and rightSide only
	}

	public void factor(ArrayList<Term> eq) {
		a = eq.get(0).getCoefficient();
		b = eq.get(1).getCoefficient();
		c = eq.get(2).getCoefficient();
		double d = (b * b) - 4 * (a * c);

		double[] positiveFacts = null;
		double[] negativeFacts = null;
		for (int i = 0; i < a * c; i++) {
			if ((a * c) % i == 0) {
				positiveFacts[i] = i;
				negativeFacts[i] = -1;
			}
		}

		if (d > 0) {
			System.out.println("There are two real roots");
		}
		if (d == 0) {
			System.out.println("There are is one real root that is repeated");
		}
		if (d < 0) {
			System.out.println("There are no real roots");
		}
	}

	public boolean isLinear() {

		// returns 'true' if this equation is linear
		// and every term is either constant or has the same variable

		return isOfDegree(1);
	}

	public void solveLinear(ArrayList<Term> sideWithVariable) {
		Term tmpConst = null;
		Term tmpVarTerm = null;
		for (Term t : sideWithVariable) {
			if (t.isConstant()) {
				tmpConst = t;
			}
			if (!t.getVariable().equals("")) {
				tmpVarTerm = t;
			}
		}
		System.out.println(tmpVarTerm.getCoefficient());
		double resulting = tmpConst.getCoefficient()/tmpVarTerm.getCoefficient();
		tmpConst.setCoefficient(resulting);
		tmpVarTerm.setCoefficient(1);
		System.out.println(resulting);
		rightSide.add(tmpConst.getAddInverse());
		leftSide.add(tmpConst.getAddInverse());
	}

	private boolean isOfDegree(int degree) {
		int maxDegree = 0;
		int minDegree = 0;
		String variable = "";
		for (Term t : leftSide) {
			if (t.getDegree() > maxDegree)
				maxDegree = t.getDegree();
			if (t.getDegree() < minDegree)
				minDegree = t.getDegree();
			if (!t.isConstant())
				variable = t.getVariable();
		}
		for (Term t : rightSide) {
			if (t.getDegree() > maxDegree)
				maxDegree = t.getDegree();
			if (t.getDegree() < minDegree)
				minDegree = t.getDegree();
			if (!t.isConstant())
				variable = t.getVariable();
		}
		if (maxDegree == degree && minDegree >= 0 && variablesMatch(variable))
			return true;
		else
			return false;
	}

	private boolean variablesMatch(String s) {
		for (Term t : leftSide) {
			if (!t.isConstant() && !t.getVariable().equals(s))
				return false;
		}
		for (Term t : rightSide) {
			if (!t.isConstant() && !t.getVariable().equals(s))
				return false;
		}
		return false;
	}

	private boolean isSameVariable(ArrayList<Term> side1, ArrayList<Term> side2) {
		ArrayList<Term> temp = new ArrayList<Term>();
		temp.addAll(side1);
		temp.addAll(side2);
		String variable = "";
		for (int i = 0; i < temp.size(); i++) {
			Term t = temp.get(i);
			if (!(t.isConstant()) && variable.equals("")) {
				variable = t.getVariable();
			}
			if (!(variable.equals(t.getVariable()) && !(t.isConstant()))) {
				return false;
			}
		}
		return true;
	}

	private boolean checkExponent(ArrayList<Term> side1, ArrayList<Term> side2,
			int expVal) {
		ArrayList<Term> temp = new ArrayList<Term>();
		temp.addAll(side1);
		temp.addAll(side2);
		int highest = 0;
		for (int i = 0; i < temp.size(); i++) {
			Term t = temp.get(i);
			if (!(t.isConstant())) {
				if (t.getExponent() > highest) {
					highest = t.getExponent();
				}
			}
		}
		if (highest != expVal) {
			return false;
		}
		return true;
	}

	public boolean isQuadratic() {
		if (!isSameVariable(leftSide, rightSide)
				|| !checkExponent(leftSide, rightSide, 2)) {
			return false;
		}
		return true;
		// returns 'true' if this equation is quadratic
		// and every term is either constant or has the same variable
	}

	public boolean isSolveable() {
		if (isLinear() || isQuadratic()) {
			return true;
		}
		return true;
		// returns 'true' if this equation is linear or quadratic, 'false'
		// otherwise
		// (because in this project we are not programming a means of solving
		// anything other than linear and quadratic equations)
	}

	public boolean cancelRight() {

		Term highestLeft =  getHighestDegreeTerm(leftSide);
		Term highestRight = getHighestDegreeTerm(rightSide);
		///
		if (highestRight.getDegree() > highestLeft.getDegree()&& highestRight.isPositive())
			return false;
		if (highestRight.getDegree() < highestLeft.getDegree()&& !highestRight.isPositive())
			return true;
		if (highestRight.getDegree() < highestLeft.getDegree()&& !highestRight.isPositive())
			return false;
		if (highestRight.getDegree() == highestLeft.getDegree()&& highestRight.getCoefficient() >= highestRight.getCoefficient())
			return true;
		if(highestRight.getDegree() < highestLeft.getCoefficient() && highestRight.getCoefficient() == 0)
			return true;
		else
			return false;
		// sets the value of cancelRight and
		// returns 'true' if the equation should be solved by subtracting terms
		// from the right side, false if it is better to subtract terms on the
		// left side
	}

	public String toString() {
		/**
		 * Take your time on this method! There are many things to consider:
		 * Every terms should be separated by a '+' UNLESS it has a negative
		 * coefficient. When a term is negative, the negative sign will appear
		 * as a minus.
		 */
		String s = getSideString(leftSide) + " = " + getSideString(rightSide);
		return s;
	}

	private String getSideString(ArrayList<Term> side) {
		/**
		 * String s = ""; try { s = side.get(0).toString(); } catch (Exception
		 * e) { s = "0"; } for (int i = 1; i < side.size(); i++) { if
		 * (side.get(i).isPositive()) s += " +" + side.get(i); else s += " -" +
		 * side.get(i).toString().replaceFirst("-", ""); } return s;
		 */
		String s = "";
		try {
			s = side.get(0).toString();
		} catch (Exception e) {
			s = "0";
		}
		for (int i = 1; i < side.size(); i++) {
			if (side.get(i).isPositive())
				s += " + " + side.get(i);
			else
				s += " - " + side.get(i).toString().replaceFirst("-", "");
		}
		return s;
	}

	public static Term getHighestDegreeTerm(ArrayList<Term> side) {
		int highestExponent = 0;
		Term greatestDegree = side.get(0);
		for (Term a : side) {
			if (a.getExponent() > highestExponent) {
				highestExponent = a.getExponent();
				greatestDegree = a;
			}
		}
		System.out.println(greatestDegree);
		return greatestDegree;
		// returns the term in the ArrayList that is the highest degree.
		// example
		// 3x^2 + 4x^3 - 12x + x^2
		// will return 4x^3
	}

	public ArrayList<Term> getLeftSide() {
		return leftSide;
	}

	public ArrayList<Term> getRightSide() {
		return rightSide;
	}

	public boolean isCancelRight() {
		return cancelRight;
	}

	public ArrayList<Double> getSolution() {
		return solution;
	}

	public void simplify(ArrayList<Term> side) {
		ArrayList<Term> removeThese = new ArrayList<Term>();
		for (Term t : side) {
			for (Term s : side) {
				if (t != s && t.getCoefficient() != 0) {
					if (Term.areLikeTerms(s, t)) {
						Term result = Term.combine(s, t);
						t.setCoefficient(result.getCoefficient());
						s.setCoefficient(0);
						removeThese.add(s);
					}
				}
			}
			if(t.getCoefficient() == 0){
				removeThese.add(t);
			}
		}
		side.removeAll(removeThese);

	}

	public void multiplyScalar(ArrayList<Term> side, double scalar) {
		double multiScalar;
		for (int i = 0; i < side.size(); i++) {
			multiScalar = side.get(i).getCoefficient() * scalar;
		}
	}

	public void solveQuadratic(ArrayList<Term> leftSide2) {
		// TODO Auto-generated method stub

	}
}
