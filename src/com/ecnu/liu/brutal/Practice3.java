//package com.ecnu.liu.brutal;
//
///**
// * @author: create by liuxiansen
// * @description: com.ecnu.liu.brutal
// * @date: Created in 2020-01-29
// * @modified By:
// * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
// */
//public class Practice3 {
//
//    /**
//     * dp[0] = 1
//     * dp[i] = max(dp[i-1]+1, array[i]
//     */
//
//    class Solution {
//        public int lengthOfLongestSubstring(String s) {
//            if (s == null && s.length() == 0) {
//                return 0;
//            }
//            int[] dp = new int[s.length()];
//            dp[0] = 1;
//            for (int i = 1; i < s.length(); i++) {
//                char r = s.charAt(i);
//                for (int j = 0; j < i; j++) {
//                    char l = s.charAt(i);
//                    if (r == l) {
//                        dp[i] = dp[];
//                    }
//                }
//            }
//            int max = dp[0];
//            for (int i = 1; i < dp.length; i++) {
//                if (max < dp[i]) {
//                    max = dp[i];
//                }
//            }
//            return max;
//        }
//    }
//}
