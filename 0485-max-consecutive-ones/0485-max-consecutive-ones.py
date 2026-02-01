class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        max_consecutive_ones=0
        curr_consecutive_ones=0
        for i in range(len(nums)):
            if nums[i]==1:
                curr_consecutive_ones+=1
            else:
                max_consecutive_ones=max(max_consecutive_ones, curr_consecutive_ones)
                curr_consecutive_ones=0
        return max(max_consecutive_ones, curr_consecutive_ones)