class Solution:
    def mergeAdjacent(self, nums: List[int]) -> List[int]:
        result=[]
        for i in range(0,len(nums)):
            result.append(nums[i])
            while len(result)>1 and result[-1]==result[-2]:
                last=result.pop()
                sec_last=result.pop()
                result.append(last+sec_last)
        return result