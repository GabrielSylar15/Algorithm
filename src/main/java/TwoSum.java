
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4};
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(numToIndex.containsKey(target - nums[i]))
                return new int[] {numToIndex.get(target - nums[i]), i};
            else
                numToIndex.put(nums[i], i);
        }
        return new int[]{};
    }

    public int getIndex(int[] nums, int n){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == n)    return i;
        }
        return -1;
    }
}
