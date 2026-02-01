class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n=len(nums)
        list_sum=sum(nums)
        total_sum=sum((range(n+1)))
        return total_sum-list_sum