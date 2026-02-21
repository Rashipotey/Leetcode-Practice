class Solution:
    def slidingWindow(self, nums, k):
        odd_nums=0
        l=0
        count=0
        for r in range(len(nums)):
            if nums[r]%2==1: odd_nums+=1
            while l<=r and odd_nums>k:
                if nums[l]%2==1:
                    odd_nums-=1
                l+=1
            count+=(r-l+1)
        return count

    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        return self.slidingWindow(nums, k)-self.slidingWindow(nums, k-1)