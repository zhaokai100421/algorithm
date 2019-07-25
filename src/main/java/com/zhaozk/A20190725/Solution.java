package com.zhaozk.A20190725;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;

        int[] total = new int[nums1.length + nums2.length];

        int f_counter = 0;  // First nums array counter
        int s_counter = 0;  // Second nums array counter
        for (int i = 0; i < total.length; i++) {
            if (f_counter >= nums1.length)
                total[i] = nums2[s_counter++];
            else if (s_counter >= nums2.length)
                total[i] = nums1[f_counter++];
            else
                total[i] = (nums1[f_counter] < nums2[s_counter] ? nums1[f_counter++] : nums2[s_counter++]);
        }

        if (total.length % 2 == 0)
            median = (double) (total[total.length / 2] + total[total.length / 2 - 1]) / 2;
        else
            median = (double) total[total.length / 2];

        return median;
    }
}
