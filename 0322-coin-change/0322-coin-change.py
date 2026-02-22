class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        max_amt=float('inf')
        dp=[max_amt]*(amount+1)
        dp[0]=0
        for coin in coins:
            for i in range(coin,amount+1):
                dp[i]=min(dp[i], dp[i-coin]+1)
        return dp[amount] if dp[amount]!=float('inf') else -1