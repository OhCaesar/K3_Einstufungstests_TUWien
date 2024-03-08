import java.util.Arrays;

public class main4 {

    public static void main(String[] args) {
        int[][] test1 = {{5,2,4},{8,5,4},{9,6,8,7}};
        int[][] test2 = {{0,1,2},{0,1,2},{0,1,2}};
        int[][] test3 = {{6},{2,4},{2,4},{2,4},{4,2}};
        int[] seq1 = {4,3,2,1,10,5,5,5};

        int[][] result1 = rearrange(test1);
        int[][] result2 = rearrange(test3);

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
        System.out.println(Arrays.deepToString(rearrange(new int[][]{})));

        label(test1);
        System.out.println(Arrays.deepToString(test1));
        label(test2);
        System.out.println(Arrays.deepToString(test2));
        label(test3);
        System.out.println(Arrays.deepToString(test3));

        System.out.println(findMaxOppositeSum(seq1,0,7));
        System.out.println(findMaxOppositeSum(seq1,0,5));
        System.out.println(findMaxOppositeSum(seq1,4,7));
    }

    public static int[][] rearrange(int[][] inputArray){
        int numberCount = 0;

        for (int i = 0; i < inputArray.length; i++)
            numberCount+=inputArray[i].length;

        int[][] arrayCopy = new int[numberCount%4==0?numberCount/4:numberCount/4+1][4];
        int[] numbersFlattened = new int[inputArray.length*4];
        int flatteningCount = 0;

        for (int iterator = 0; iterator < inputArray.length ; iterator++)
            for (int i = 0; i < inputArray[iterator].length; i++)
                numbersFlattened[flatteningCount++] = inputArray[iterator][i];

        for (int iterator = 0; iterator < arrayCopy.length ; iterator++)
            for (int i = 0; i < 4; i++)
                if(iterator%2==0)
                    arrayCopy[iterator][i] = numbersFlattened[iterator*4+i];
                else arrayCopy[iterator][i] = numbersFlattened[iterator*4+3-i];

        return arrayCopy;
    }

    public static void label(int[][] inputArray){
        for (int iteratorx = 0; iteratorx < inputArray.length-1 ; iteratorx++) {
            int dubCounter= 0;
            for (int iteratory = 0; iteratory < inputArray[iteratorx].length; iteratory++) {
                if(inputArray[iteratorx][iteratory]==inputArray[iteratorx+1][iteratory])
                    dubCounter++;
            }
            if(dubCounter==inputArray[iteratorx].length &&inputArray[iteratorx].length==inputArray[iteratorx+1].length)
                for (int filler = 0; filler < inputArray[iteratorx].length; filler++)
                    inputArray[iteratorx][filler] = -9;
        }
    }

    public static int findMaxOppositeSum(int[] sequence,int start,int end){
        int maxSum = sequence[start] + sequence[end];
        if(start<=end){

            int deeperMaxSum = findMaxOppositeSum(sequence,start+1,end-1);
            if(maxSum<deeperMaxSum)
                maxSum=deeperMaxSum;

        }
        return maxSum;

    }
}
