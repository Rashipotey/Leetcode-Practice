class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum= nums[0]
        curr_sum=0
        temp_start=0
        for i in range(len(nums)):
            curr_sum+=nums[i]
            if curr_sum>max_sum:
                max_sum=curr_sum
            if curr_sum<0:
                curr_sum=0
                temp_start=i+1
        return max_sum