package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int length= nums.length;
        HashMap<Integer,Integer>[] hashMap=new HashMap[nums.length];
        for (int i = 0; i <hashMap.length ; i++) {
            hashMap[i]=new HashMap();
        }
        int max=Integer.MIN_VALUE;
        hashMap[0].put(0,1);
        for (int i = 1; i <length ; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if (hashMap[i].containsKey(nums[i]-nums[j]))
                {
                    continue;
                }
                if (hashMap[j].containsKey(nums[i]-nums[j]))
                {
//                    if (hashMap[i].containsKey(nums[i]-nums[j]))
//                    {
//                        if (hashMap[i].get(nums[i]-nums[j])>hashMap[j].get(nums[i]-nums[j])+1)
//                        {
//                            continue;
//                        }
//                    }
                    hashMap[i].put(nums[i]-nums[j],hashMap[j].get(nums[i]-nums[j])+1);


                    if (hashMap[j].get(nums[i]-nums[j])+1>max)
                    {
                        max=hashMap[j].get(nums[i]-nums[j])+1;
                    }
                }
                else {
                    hashMap[i].put(nums[i]-nums[j],2);
                    if (2>max)
                    {
                        max=2;
                    }
                }
            }
        }
        return max;
    }


    public int longestArithSeqLength2(int[] A) {
        int n = A.length;
        // 特判
        if(n == 0) return 0;
        // 定义哈希表，第一个键表示数组下标索引，其嵌套的哈希表用于存储该元素以不同的公差所包含的最长序列
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 1;
        // 遍历数组
        for(int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
            // 向前遍历，寻找不同公差的最长序列
            for(int j = i - 1; j >= 0; j--) {
                // 如果遇到了重复的元素，可以直接跳过，因为肯定不会比后面的元素能组成更长的序列
                if(map.get(i).containsKey(A[i] - A[j])) continue;
                // 获取以这两个元素差为公差的最长子序列
                int cur =  map.get(j).getOrDefault(A[i] - A[j], 0);
                // 比较答案
                res = Math.max(res, cur + 2);
                // 存入当前元素，某公差下的最长序列
                map.get(i).put(A[i] - A[j], cur + 1);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int []t={24,13,1,100,0,94,3,0,3};
        t=new int[]{22,8,57,41,36,46,42,28,42,14,9,43,27,51,0,0,38,50,31,60,29,31,20,23,37,53,27,1,47,42,28,31,10,35,39,12,15,6,35,31,45,21,30,19,5,5,4,18,38,51,10,7,20,38,28,53,15,55,60,56,43,48,34,53,54,55,14,9,56,52};
        Solution solution = new Solution();
        int i = solution.longestArithSeqLength(t);
        System.out.println(i);
    }
}
