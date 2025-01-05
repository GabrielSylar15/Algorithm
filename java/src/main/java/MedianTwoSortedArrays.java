//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1 = new int[]{};
        int[] num2 = new int[]{4};
        double rs = findMedianSortedArrays(num1, num2);
        System.out.println(rs);
    }

    //1,2,3,4,5,6,7,9
    // middle = 3,5 -> 4

    //1,2,3,4,5,6
    // middle = 3 => 3 and 4
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double middle = (nums1.length + nums2.length) / 2d;
        double rs = 0;
        int indexFirst = 0, indexSecond = 0, temp, count = 0;
        while (true) {
            if (nums1.length == 0 && nums2.length == 0) return 0;
            if(nums1.length == 0 && nums2.length == 1)  return nums2[0];
            if(nums2.length == 0 && nums1.length == 1)  return nums1[0];

            if (indexFirst == nums1.length) {
                temp = nums2[indexSecond];
                indexSecond += 1;
            } else if (indexSecond == nums2.length) {
                temp = nums1[indexFirst];
                indexFirst += 1;
            } else {
                if (nums1[indexFirst] >= nums2[indexSecond]) {
                    temp = nums2[indexSecond];
                    indexSecond += 1;
                } else {
                    temp = nums1[indexFirst];
                    indexFirst += 1;
                }
            }
            if (indexFirst + indexSecond >= middle) {
                if (middle % 1 != 0) {
                    return temp;
                } else {
                    count += 1;
                    rs += temp;
                    if (count == 2) return rs / 2d;
                }
            }
        }
    }
}
