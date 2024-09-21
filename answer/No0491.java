import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class No0491 {


    public static void main(String[] args) {
        //[4,6,7,7]
        int[] list = new int[]{4,6,7,7};
        System.out.println(findSubsequences(list));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> resutl = new LinkedHashSet<>();
        for (int index = 0; index < nums.length; index++) {
            List<Integer> subList = new ArrayList<>();
            getSubList(resutl, subList, index, nums);
        }
        return new ArrayList<>(resutl);
    }

    public static void getSubList(Set<List<Integer>> result, List<Integer> now, Integer index, int[] nums) {
        now.add(nums[index]);
        if (now.size() >= 2) {
            result.add(new ArrayList<>(now));
        }
        if (index == nums.length - 1) {
            return ;
        }
        List<Integer> nextNode = findNextNode(index, nums);

        if (nextNode.size() == 0) {
            return ;
        }

        for (Integer integer : nextNode) {
            getSubList(result, new ArrayList<>(now), integer, nums);
        }
    }

    public static List<Integer> findNextNode(Integer index, int[] nums) {
        List<Integer> nextNode = new ArrayList<>();
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] >= nums[index]) {
                nextNode.add(i);
            }
        }
        return nextNode;
    }





}
