//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,3,5,7};
        int[] num2 = new int[]{2,4,6};
        findMedianSortedArrays(num1, num2);

    }

    //1,
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double middle = (nums1.length + nums2.length) / 2d;
        double rs = 0;
        int index = 0, indexFirst = 0, indexSecond = 0;
        while (true){
            if(nums1[indexFirst] >= nums2[indexSecond])  indexSecond += 1;
            else indexFirst += 1;
            if(indexFirst + indexSecond > middle){
//                if(middle % 2 == 0)
                break;
            }
        }
        return rs;
    }
}
