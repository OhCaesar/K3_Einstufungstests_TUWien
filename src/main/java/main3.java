import java.util.Arrays;

public class main3 {

    public static void main(String[] args) {
        int[][] data0 = {{3,0},{0,1},{2,2}};
        int[][] data1 = {{0,1,0,0,1,0},{},{2,2,2,2,0,1}};
        int[] target1 = {0,0,0};
        int[] target2 = {9,9,9,9};

        System.out.println(Arrays.deepToString(labelPath(3, new int[][]{})));
        System.out.println(Arrays.deepToString(labelPath(4, data0)));

        findMatches(data0,data0[1],target1);
        System.out.println(Arrays.toString(target1));
        findMatches(data1,data0[1],target1);
        System.out.println(Arrays.toString(target1));
        findMatches(data1,data0[2],target2);
        System.out.println(Arrays.toString(target2));

        System.out.println(insertMiddle("XY","abc"));
        System.out.println(insertMiddle("01234","abc"));
        System.out.println(insertMiddle("01234567890123","./-"));


    }

    //Richtig LESEN
    public static int[][] labelPath(int n,int[][] points){
        int[][] nArray = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int y = 0; y < n; y++)
                nArray[i][y]=n;

        for (int i = 0; i < points.length ; i++) {
            nArray[points[i][0]][points[i][1]] = -1;
        }
        return nArray;
    }


    public static void findMatches(int[][] data,int[] pattern,int[] target){
        int count ;
            for (int i = 0; i < data.length; i++) {
                count=0;
                for (int d = 0; d < data[i].length-1; d++)
                    if(data[i][d]==pattern[0]&&data[i][d+1]==pattern[1]) count++;
                target[i]=count;
            }

    }

    public static String insertMiddle(String input, String seps){
        if(!seps.isEmpty() &&input.length()>1)
            input = insertMiddle(input.substring(0,input.length()/2),seps.substring(1))+seps.charAt(0)+insertMiddle(input.substring(input.length()/2),seps.substring(1));
        return input;

    }

}
