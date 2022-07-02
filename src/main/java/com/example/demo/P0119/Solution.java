package com.example.demo.P0119;
import org.apache.el.stream.Stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length<=0 || amount<0)
        {
            return -1;
        }

        if (amount==0)
        {
            return 0;
        }

        //dp[amount]=min_i_0_to_max(dp[amount-coins[i]]+1)
        int []dp=new int[amount+1];
        //init

        for (int i = 0; i <coins.length ; i++) {
            if (coins[i]<dp.length)
            {
                dp[coins[i]]=1;
            }
            if (coins[i]==amount)
            {
                return 1;
            }

        }

        for (int amount_for = 0; amount_for <dp.length ; amount_for++) {
            int min=Integer.MAX_VALUE;

            for (int i = 0; i < coins.length; i++) {
                if (amount_for-coins[i]>=0)
                {
                    if (dp[amount_for-coins[i]]!=0 || amount_for-coins[i]==0)
                    {
                        min=Math.min(min,dp[amount_for-coins[i]]+1);
                        dp[amount_for]=min;
                    }

                }
            }

        }
        return dp[dp.length-1]==0?-1:dp[dp.length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1,2,5},10));;
    }
}