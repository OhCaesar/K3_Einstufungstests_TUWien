import java.util.Arrays;

public class main {

    public static void main(String[] args) {


        //Var Sector

        int[][] test1 = {{5,2,4},{2,7,3},{9,5,8}};
        int[][] test2 = {{1}};
        int[][] test3 = {{6,7,8},{7,5,3,1},{2}};

        String seq1="ABAACBA";

        int[][] result1 = generate(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = generate(test2);
        System.out.println(Arrays.deepToString(result2));

        reorder(result1);
        reorder(result2);

        System.out.println(isPresentNTimes(seq1, 'A', 4));
        System.out.println(isPresentNTimes(seq1, 'A', 3));
        System.out.println(isPresentNTimes(seq1, 'A', 5));
        System.out.println(isPresentNTimes(seq1, 'Z', 0));



    }



    public static int[][] generate(int[][] input){
        int[][] inputClone=new int[input.length*2-1][];
        for(int i = 0 ; i<input.length;i++){
            inputClone[i]=new int[input[i].length-i];
            for(int y = 0;y<=(input[0].length-1)-i;y++){
                inputClone[i][y] = input[i][y];
            }
        }
        for(int i = 0 ; i<input.length;i++){
            inputClone[(inputClone.length-1)-i]=new int[input[i].length-i];
            for(int y = 0;y<=(input[0].length-1)-i;y++){
                inputClone[(inputClone.length-1)-i][y] = input[i][y];
            }
        }

        return inputClone;
    }

    public static void reorder(int[][] input){
        int[][] inputClone=new int[input.length][];
        for(int i = 0; i< input.length;i++){
            inputClone[i] = new int[input[i].length];
            for(int y = 0; y< input[i].length;y++){
                inputClone[i][input[i].length-1-y] = input[i][y];
            }
        }
        System.out.println(Arrays.deepToString(inputClone));
    }

    public static boolean isPresentNTimes(String sequence,char marker,int count){
        if(!sequence.isEmpty())
            if (sequence.charAt(0) == marker) {
                return isPresentNTimes(sequence.substring(1), marker, count - 1);
            } else return isPresentNTimes(sequence.substring(1), marker, count);
        return count == 0;
    }
}
