class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        xor=0
        for i in range(len(nums)):
            xor^=nums[i]
        return xor