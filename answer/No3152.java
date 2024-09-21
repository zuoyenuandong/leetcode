import java.util.*;

public class No3152 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,9,3};
        int[][] queries = new int[][] {{0,2},{2,2},{1,2},{1,1},{0,2},{0,1},{0,1},{1,2}};
        for (boolean b : isArraySpecial(nums, queries)) {
            System.out.print(b + "  ");
        }
    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {

        List<int[]> trueList = new ArrayList<>();
        List<int[]> falseList = new ArrayList<>();
        boolean[] result = new boolean[queries.length];
        outer : for(int i = 0; i < queries.length; i++) {

            for (int[] ints : falseList) {
                if (queries[i][0] <= ints[0] && queries[i][1] >= ints[1]) {
                    result[i] =  false;
                    continue outer;
                }
            }

            for (int[] ints : trueList) {
                if (queries[i][0] >= ints[0] && queries[i][1] <= ints[1]) {
                    result[i] =  true;
                    continue outer;
                }
            }

            boolean tempResult = true;
            int tempLow = queries[i][0];
            while(queries[i][0] < queries[i][1]) {
                if((nums[queries[i][0]] & 1) == (nums[queries[i][0]+1] & 1)) {
                    tempResult = false;
                    falseList.add(new int[] {queries[i][0] , queries[i][1]});
                    break;
                } else {
                    queries[i][0]++;
                }
            }
            if (tempResult) {
                trueList.add(new int[] {tempLow, queries[i][1]});
            }
            result[i] = tempResult;


        }
        return result;
    }
}
