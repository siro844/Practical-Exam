import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int targetSum = 10;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, targetSum, 0, curr, ans);
        System.out.println(ans);
    }

    private static void backtrack(int[] nums, int targetSum, int start, List<Integer> curr, List<List<Integer>> ans) {
        if (targetSum == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] <= targetSum) {
                curr.add(nums[i]); //Push in array
                backtrack(nums, targetSum - nums[i], i + 1, curr, ans);
                curr.remove(curr.size() - 1); //Pop from array
            }
        }
    }
}