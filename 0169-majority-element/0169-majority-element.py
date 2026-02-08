class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count_map={}
        length=len(nums)
        for n in nums:
            count_map[n]=count_map.get(n,0)+1
        for key, value in count_map.items():
            if value>length//2:
                return key
        return -1