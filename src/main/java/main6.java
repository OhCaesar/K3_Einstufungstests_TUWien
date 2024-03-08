import java.util.Arrays;

public class main6 {


    public static void main(String[] args) {

        int[][] test1 = {{5},{5,7,9},{8,5}, {}};
        int[][] test2 = {{1,2},{1,2,3}, {1,2,3,4}};

        int[][] test3 = {{},{1,2,3,4},{1}};
        int[] seq = {1,2,-5,3,-1,6,-3,3};

        int[][] result1 = getRectangular(test1);
        int[][] result2 = getRectangular(test2);
        int[][] result3 = getRectangular(test3);
        int[][] result4 = getRectangular(new int[][]{});

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
        System.out.println(Arrays.deepToString(result3));
        System.out.println(Arrays.deepToString(result4));

        removeEntry(test2,2);
        System.out.println(Arrays.deepToString(test2));
        removeEntry(test3,0);
        System.out.println(Arrays.deepToString(test3));

        System.out.println(isAlternating(seq,0));
        System.out.println(isAlternating(seq,1));
        System.out.println(isAlternating(seq,6));
        System.out.println(isAlternating(seq,7));


        //Extra Testcases
        int[] seq2 = {1};
        int[] seq3 = {1,-2,4,6,-5};

        System.out.println(isAlternating(seq2,1));
        System.out.println(isAlternating(seq3,1));

    }

    public static int[][] getRectangular(int[][] input){
        //Finde Längste Zeile heraus
        int[][] arrayCopy;
        if(input.length==0) return new int[1][0];

        int maxLength = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].length>maxLength) maxLength= input[i].length;
        }

        arrayCopy = new int[input.length][maxLength];

            //Fill
        for (int i = 0; i < input.length; i++) {
            int counter = 0;
            for (int j = 0; j < maxLength; j++) {
                if(input[i].length==0) {
                    arrayCopy[i][j] = 0;
                    break;
                }
                if(counter>input[i].length-1) counter=0;
                arrayCopy[i][j] = input[i][counter++];
            }
        }

        return arrayCopy;
    }

    public static void removeEntry(int[][] input,int col){
        int counter;
        for (int i = 0; i < input.length; i++) {
            int[] columnValues= input[i];
            counter=0;
            if(col<=columnValues.length-1) {
                input[i] = new int[columnValues.length - 1];
                for (int j = 0; j < columnValues.length; j++) {
                    if(j!=col)  input[i][counter++]=columnValues[j];
                }
            }

        }
    }


    public static boolean isAlternating(int[] seq,int index){
        if (seq.length==1||index==seq.length-1) return true; //

        return ((seq[index] < 0 && seq[index + 1] > 0) ||
                (seq[index] > 0 && seq[index + 1] < 0)) &&
                        isAlternating(seq, index + 1);
    }
}
