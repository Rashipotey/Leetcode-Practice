class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        n=len(nums)
        maxLen=0
        l=0
        ones=0
        for r in range(n):
            if nums[r]==1: ones+=1
            while (r-l+1)-ones>k:
                if nums[l]==1:
                    ones-=1
                l+=1
            maxLen=max(maxLen, r-l+1)
        return maxLen