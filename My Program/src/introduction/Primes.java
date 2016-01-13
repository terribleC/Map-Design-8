package introduction;

public class Primes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countPrimes(999999);
	}
	public static void countPrimes(int max){
		boolean[] theNumbers = new boolean[max + 1];
		for(int index = 2;index < theNumbers.length;index++){
			theNumbers[index] = true;
		}
		for(int index = 0;index<theNumbers.length;index++){
			if(theNumbers[index]){
				for(int multipleIndex=index+index;
						multipleIndex<theNumbers.length;
						multipleIndex+=index){
					theNumbers[multipleIndex] = false;
				}
			}
		}
		String statement = "";
		int count = 0;
		for(int index = 0;index< theNumbers.length; index++){
			if(theNumbers[index]){
				count++;
				statement +=" "+index+",";
			}
		}
		statement += "\nThere are "+count+" primes between 1 and "+ max+".";
		System.out.println(statement);
	}
	private static void printArrayContents(boolean[] array) {
		String arrayContent = "[";
		for(int index = 0;index < array.length;index++){
			if(index < array.length -1){
				arrayContent = arrayContent + array[index]+", ";
			}
			else{
				arrayContent = arrayContent + array[index];
			}

		}
		arrayContent= arrayContent + "]";
		System.out.println(arrayContent);
	}
}
