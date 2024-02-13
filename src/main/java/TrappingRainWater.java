//https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution s = new Solution();
        int rs = s.trap(height);
        System.out.println(rs);
    }
}

class Solution {
    public int trap(int[] h) {
        int l = 0, r = h.length - 1, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, ans = 0;
        while (l < r) {
            lmax = Math.max(lmax, h[l]);
            rmax = Math.max(rmax, h[r]);
            System.out.println(lmax + "-" + rmax+" l-r " +l +"-"+r);
            if (lmax < rmax) {
                ans += lmax - h[l];
                l+=1;
            } else {
                ans += rmax - h[r];
                r-=1;
            }
            System.out.println("ANS: " + ans);
        }
        return ans;
    }

    public int getFirstIndexFlag(int from, int to, int[] height) {
        int fIndex = 0;
        for (int i = from; i < to; i++) {
            if (height[i] > height[i + 1]) {
            } else {
                fIndex = i;
            }
        }
        return fIndex;
    }

}
