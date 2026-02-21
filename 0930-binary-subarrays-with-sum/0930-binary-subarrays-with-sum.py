class Solution:
    def slidingWindow(self, nums, goal):
        l=0
        curr_sum=0
        count=0
        for r in range(len(nums)):
            curr_sum+=nums[r]
            while l<=r and curr_sum>goal:
                curr_sum-=nums[l]
                l+=1
            count+=(r-l+1)
        return count

    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        return self.slidingWindow(nums, goal)-self.slidingWindow(nums, goal-1)