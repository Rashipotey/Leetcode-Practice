class Solution:
    def minOperations(self, nums: list[int]) -> int:
        result=0
        for i in range(1,len(nums)):
            result+=(max(0,nums[i-1]-nums[i]))
        return result