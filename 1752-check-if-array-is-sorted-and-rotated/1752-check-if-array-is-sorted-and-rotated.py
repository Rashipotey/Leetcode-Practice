class Solution:
    def check(self, nums: List[int]) -> bool:
        number_of_inversions=0
        if nums[0]<nums[len(nums)-1]: number_of_inversions+=1
        for i in range(len(nums)-1):
            if nums[i]>nums[i+1]:
                number_of_inversions+=1
            if number_of_inversions>1: return False
        return number_of_inversions<=1
    