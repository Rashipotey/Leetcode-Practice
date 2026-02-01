class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        curr_sum=0
        seen={0:1}
        count=0
        for num in nums:
            curr_sum+=num
            if curr_sum-k in seen:
                count+=seen[curr_sum-k]
            seen[curr_sum]=seen.get(curr_sum,0)+1
        return count