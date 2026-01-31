class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i, j, n=0, 0, len(nums)
        while i<n and j<n:
            if nums[i]==nums[j]:
                j+=1
            else:
                nums[i+1]=nums[j]
                i+=1
        return i+1