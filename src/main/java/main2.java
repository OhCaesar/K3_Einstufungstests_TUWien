import java.util.Arrays;

public class main2
{
    //51 min
    public static void main(String[] args) {

        // Var Definitionen

        int[][] test1 = {{1,2,0,-1,-2,3},{-1,2,3},{0,0},{},{4,5,-1}};
        int[][] test2 = {{1, 2, 3}, {4, 5, 2}, {-2, -3, 2, -1}, {3, 2, 1, 5}, {4, 5, 1, 4} };
        int[][] test3 = {{1,-1,2,-2,3},{1,2,3},{-3,-1,-2}};

        char[] age1 = {'d','u','-','d','u','-','d','a','-','d','a'};
        char[] age2 = {'m','a','m','a','!','n','e','i','n'};


        int [][] result1 = generate(test1);
        System.out.println(Arrays.deepToString(result1));
        int [][] result2 = generate(test2);
        System.out.println(Arrays.deepToString(result2));

        fill(test1, test2[3], test2[4]);
        System.out.println(Arrays.deepToString(test1));
        fill(result1, test2[2], test2[4]);
        System.out.println(Arrays.deepToString(result1));
        fill(test3, test2[2], test2[3]);
        System.out.println(Arrays.deepToString(test3));


        System.out.println(extractString(age1, 0, age1.length, '-'));
        System.out.println(extractString(age1, 1, 7, 'u'));
        System.out.println(extractString(age2, 0, 5, 'a'));
        System.out.println(extractString(age2, 5, age2.length, 'n'));

    }

    public static int[][] generate(int[][] input){
        int[][] inputCopy = new int[input.length][];
        for (int i=0;i< input.length;i++){
            inputCopy[i] = new int[input[i].length];
            int iteratable = 0;
            for(int positives = 0;positives<inputCopy[i].length;positives++)
                if(input[i][positives]<0) {
                    inputCopy[i][iteratable]=input[i][positives];
                    iteratable++;
                }
            for(int negatives = 0;negatives<inputCopy[i].length;negatives++)
                if(input[i][negatives]>=0) {
                    inputCopy[i][iteratable]=input[i][negatives];
                    iteratable++;
                }
        }
        return inputCopy;
    }

    public static void fill(int[][] target, int[] values,int[] times){
        int valueIndex=0;
        int timeCounter=1;
        for(int i = 0;i<target.length;i++){
            for (int y=0;y<target[i].length;y++){
                if(times[valueIndex]>timeCounter) {
                    target[i][y] = values[valueIndex];
                    timeCounter++;
                }
                else  {
                    target[i][y] = values[valueIndex];
                    timeCounter=1;
                    valueIndex++;
                }
            }
        }
    }

    public static String extractString(char[] sequence,int start,int end,char omit){
        String value = "";
        if(sequence[start]!=omit)
            value+=sequence[start];
        if(start<end-1)
            value += extractString(sequence,start+1,end,omit);
        return value;
    }


}
