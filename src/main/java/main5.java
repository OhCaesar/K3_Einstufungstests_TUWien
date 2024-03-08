import java.util.Arrays;

public class main5 {

    public static void main(String[] args) {

        int[][] test1 = {{0,2,4},{2,0,0},{0,0,1}};
        int[][] test2 = {{1,2,3},{1,2,3,4,5},{1,2,3},{1,2,3,4,5}};
        int[][] test3 = {{2},{0,7},{6,7,8},{6,0},{0,0}};

        String seq1="ABA";

        int[][] result1 = removeLeadingZeros(test1);
        int[][] result2 = removeLeadingZeros(test3);

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));

        mask(test2,new int[]{1,2,3},new int[]{0,1,4});
        mask(test3,new int[]{0,2,4},new int[]{0,1});
        mask(test1,new int[]{},new int[]{0,1});

        System.out.println(Arrays.deepToString(test2));
        System.out.println(Arrays.deepToString(test3));
        System.out.println(Arrays.deepToString(test1));

        System.out.println(replaceCharacters(seq1,"010"));
        System.out.println(replaceCharacters("SAMBA","10001"));
    }

    //11:28
    public static int[][] removeLeadingZeros(int[][] inputArray){
        int zeroCounter;
        int[][] copyArray = new int[inputArray.length][];
        for (int i = 0; i < inputArray.length; i++) {
            zeroCounter=0;
            for (int j = 0; j < inputArray[i].length && inputArray[i][j]==0; j++) zeroCounter++;
            copyArray[i]= new int[inputArray[i].length-zeroCounter];
        }

        for (int i = 0; i < copyArray.length; i++) {
            for (int j = 0; j < copyArray[i].length; j++) {
                copyArray[i][j] = inputArray[i][inputArray[i].length-copyArray[i].length+j];
            }
        }

        return copyArray;
    }

    //18:44
    public static void mask(int[][] inputArray,int[] rows,int[] cols){
        for (int row = 0; row < rows.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if(rows[row]<inputArray.length&&cols[col]<inputArray[rows[row]].length)inputArray[rows[row]][cols[col]] = 0;
            }

        }
    }

    //31 min
    public static String replaceCharacters(String sequence, String repSequence){
        if(sequence.isEmpty()) return "";

        return (repSequence.charAt(0)=='1'?sequence.charAt(0)+"":"")+sequence.charAt(0)+replaceCharacters(sequence.substring(1),repSequence.substring(1));
    }
}
