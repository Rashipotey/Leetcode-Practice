class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count, candidate=0, None
        for n in nums:
            if count==0:
                candidate=n
            count+=1 if n==candidate else -1
        return candidate