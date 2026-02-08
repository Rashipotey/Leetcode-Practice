class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum, curr_sum=nums[0], nums[0]
        for i in range(1, len(nums)):
            curr_sum=max(nums[i], curr_sum+nums[i])
            max_sum=max(curr_sum, max_sum)
        return max_sum