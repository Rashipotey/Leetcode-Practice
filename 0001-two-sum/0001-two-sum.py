class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen={}
        for i in range(len(nums)):
            if target-nums[i] in seen:
                return [i, seen[target-nums[i]]]
            seen[nums[i]]=i