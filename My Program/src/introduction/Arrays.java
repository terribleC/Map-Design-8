package introduction;

public class Arrays {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		//		int[] someDigitsOfPi = {3,4,1,2,5,12,3};
		//		int[] someDigitsOfE=new int[4];
		//		someDigitsOfE[0] = 2;
		//		someDigitsOfE[1] = 7;
		//		someDigitsOfE[2] = 1;
		//		someDigitsOfE[3] = 8;
		//		
		//		System.out.println("Some digits of Pi we have is " + someDigitsOfPi.length);
		//		System.out.println("Some digits of E we have is " + someDigitsOfE.length);
		//		printArrayContents(someDigitsOfPi);
		long startTime = System.currentTimeMillis();
		//		int[] randomArray1 = generateARandomArray(1000);	
		//		printArrayContents(randomArray1);
		String[] deck = makeCards();
		String[] deck2 = makeCards();
		shuffle(deck);
		shuffle(deck2);
		int counter = compare(deck,deck2);
		printArrayContents(deck);
		printArrayContents(deck2);
		long endTime = System.currentTimeMillis();
		System.out.println("The method took " +  (endTime-startTime) + " millisecs.");
		System.out.println("Deck was the same " + counter + " times.");
	}

	private static int compare(String[] D1, String[] D2) {
		int count = 0;
		for(int index = 0; index < D1.length;index++){
			if(D1[index].equals(D2[index])){
				count++;
			}
		}
		return count;
	}



	private static void shuffle(String[] deck) { 
		for(int index4 = 0;index4 < deck.length;index4++){
			int swapCard=(int)(Math.random()*deck.length);
			swap(deck,index4,swapCard);
		}
	}

	private static void swap(String[] deck, int a, int b) {
		String placeholder = deck[a];
		deck[a] = deck[b];
		deck[b] = placeholder;
	}

	private static String[] makeCards() {
		String[] suits ={"Hearts","Diamonds","Clubs","Spades"};
		String[] cards ={"Ace","Duece","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
		String[] allCards = new String[52];
		int index3 = 0;
		for(int index1 = 0;index1 < suits.length;index1++){
			for(int index2 = 0; index2 < cards.length;index2++){
				allCards[index3] = cards[index2] + " of " + suits[index1];
				index3++;
			}
		}

		return allCards;
	}

	//	private static int[] generateARandomArray(int arrayLength) {
	//		int[] array = new int[arrayLength];
	//		for(int index = 0;index < arrayLength;index++){
	//			array[index]=arrayLength - index;
	//		}
	//		return array;
	//	}
	private static void printArrayContents(String[] array) {
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


	public static void printArrayContents(int[] array) {
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
