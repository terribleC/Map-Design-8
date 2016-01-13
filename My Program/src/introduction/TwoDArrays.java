package introduction;
import java.util.ArrayList;
public class TwoDArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//	int[][] grid3x3 = new int [3][3];
	//	print2DArrayContents(grid3x3);
		checkAdjacentValues();
	}
	public static void print2DArrayContents(int[][] array){
		String statement = "";
		for(int i = 0;i<array.length;i++){
			for(int j = 0;j<array.length;j++){
				if(j == 0){
					statement += "[";
				}
				if(j < 2){
				statement = statement + array[i][j] + " ";
				}
				else{
					statement += array[i][j] + "]\n";
				}
			}
		}
		System.out.println(statement);
	}
	private static void checkAdjacentValues(){
		boolean[][] mines = new boolean[3][3];
		mines[2][1] = true;
		int row = getRandomInt(2);
		int column = getRandomInt(2);
		int typeOfSpace = checkSpace(mines,row,column);
		if(typeOfSpace == 0){
			HelloWorld.print("At row " + row +", colum " + column+ ", the mine was found");
		}if(typeOfSpace == 1){
			HelloWorld.print("At row " + row +", colum " + column+ ", there is a mine");
		}else{
			HelloWorld.print("At row " + row +", colum " + column+ ", there are no mine");
		}
	}
	private static int checkSpace(boolean[][] mines, int row, int column) {
		int rowM;
		int colM;
		for(int i = 0;i<mines.length;i++){
			for(int j = 0;j<mines.length;j++){
				if(mines[i][j]){
					rowM = i;
					colC = j;
				}
			}
		}
		
	
		return 0;
	}
	public static int getRandomInt(int max) {
		int random = (int)(Math.random()*max);
		return random;
	}
}
