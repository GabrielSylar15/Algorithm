

// https://leetcode.com/problems/remove-element/
public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        removeElement(arr, 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int rs = 0;
        if(nums.length == 0)  return 0;
        int length = nums.length;
        for(int i = 0; i < length; i++){
            if(nums[i] == val){
                rs+=1;
                System.out.println("index: " + i);
                remove(nums, i);
                i-=1;
                length-=1;
//                break;
            }
        }
        System.out.println("Result: " +rs);
        return rs;
    }

    // 0,1,2,2,3,0,4,2
    // 0 1 2 3 0 4 2
    public static void remove(int[] arr, int index) {
        for(int i = index; i<arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Debug: " +arr[i]);
        }
    }
}
