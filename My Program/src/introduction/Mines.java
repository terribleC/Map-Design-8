package introduction;

public class Mines {

    public static void main(String[] args) {
        boolean[][] houses = new boolean[2][2];
        houses[1][1] = true;
        System.out.println(checkNeighbors(houses,0,0));
    }
    
    public static int checkNeighbors(boolean[][] neighborhood, int r, int c){
        //If neighborhood[r][c] is adjacent (above, below, right, left) of a true value, return 1. If neighborhood is not adjacent to a true value, return -1.
        //return zero if IS a true value
        int bombC = 0;
        int bombR = 0;
        for(int cIn=0; cIn<neighborhood.length; cIn++){
            for(int rIn=0; rIn<neighborhood[cIn].length; rIn++){
                if(neighborhood[cIn][rIn]){
                    bombC = cIn;
                    bombR = rIn;
                }
            }
        }
        if((bombC == c && Math.abs(bombR-r)==1)||(bombR == r && Math.abs(bombC-c)==1)){
            return 1;
        }else if(bombC == c && bombR == r){
            return 0;
        }else{
            return -1;
        }
       
    }
}