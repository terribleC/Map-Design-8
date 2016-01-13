package introduction;
import java.util.Arrays;
public class SortAlgorithms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {5,5,7,7,8,-2,-3,-4,-5,-5,-6,-6,-6,-7,-7,-7,-7,-7,-7-1,-100000000,19,39856};
	//	long a = System.currentTimeMillis();
	//	selectionSort(test);
	//	long b = System.currentTimeMillis();
	//	System.out.println(b-a + "ms");
	//	bubbleSort(test);
		quickSort(test,0,test.length-1);
	}
	public static void swap(int[] array,int a,int b){
		int placeholder = array[a];
		array[a] = array[b];
		array[b] = placeholder;
	}
	public static void selectionSort(int[] array){
		int tempMin = 0; //2ms
		for(int i = 0;i<array.length;i++){ //2ms * n+1
			tempMin = i; // 1ms * n+1
			for(int j = i;j<array.length;j++){ //2ms * n-i+1
				if(array[j] < array[tempMin]){ //1ms * n-i
					tempMin = j; //1ms * n-i
				}
			}
			//6n-4i+7
			
			swap(array,i,tempMin);//4ms
		}
		System.out.println(Arrays.toString(array));
	}
	public static void bubbleSort(int[] array){
		for(int i = 1;i<array.length-1;i++){
			for(int j = 0;j<array.length-i;j++){
				if(array[j+1]<array[j]){
					swap(array,j,j+1);
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
	private static int factorial(int n){
		if(n<2) return 1;
		return n*factorial(n-1);
	}
	public static int[] mergeSort(int[] array){
		if(array.length == 1){
			return array;
		}
		int half = (array.length)/2;
		int[] half1 = new int[half];
		int[] half2 = new int[array.length-half];
		for(int i = 0; i < half1.length;i++){
			half1[i] = array[i];
		}
		for(int j = 0; j < half1.length;j++){
			half2[j] = array[j+half];
		}
		return merge(mergeSort(half1),mergeSort(half2));
	}
	public static int[] merge(int[]a, int[]b){
		int i = 0;
		int j = 0;
		int k = 0;//index in result
		int[] result = new int[a.length + b.length];
		while(i < a.length && j < b.length){
			if(a[i] < b[j]){
				result[k] = a[i];
				i++;
			}else{
				result[k] = b[j];
				j++;
			}
			k++;
		}
		while(i < a.length){
			result[k] = a[i];
			i++;
			k++;
		}
		while(j < b.length){
			result[k] = b[j];
			j++;
			k++;
		}
		return result;
	}

/**	public static void quickSort(int[] array,int start,int end){
		if(start == end)return;
		int pivotIndex = start + (end-start)/2;
		System.out.println("Attempting to quicksort array from " + start + " to " + end+ ". The pivot index is " + pivotIndex);
		int pivot = array[pivotIndex];
		System.out.println("Pivot is " + pivot);
		int i = start;
		int j = end;
		while(i <= j){
			if(array[i] >= pivot && array[j] <= pivot){
				swap(array,i,j);
				i++;
				j--;
			}
			if(array[i] < pivot){
				i++;
			}
			if(array[j] > pivot){
				j--;
			}
		}
		if(start < j){
			quickSort(array,start,j);
		}
		if(end > i){
			quickSort(array,i,end);
		}
		System.out.println(Arrays.toString(array));
		
	}
	*/
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = (high + low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
		System.out.println(Arrays.toString(arr));
	}
}