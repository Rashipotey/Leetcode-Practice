class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen={}
        l, n=0, len(s)
        maxLen=0
        for r in range(n):
            seen[s[r]]=seen.get(s[r],0)+1
            while seen[s[r]]>1:
                seen[s[l]]-=1
                l+=1
            maxLen=max(maxLen,r-l+1)
        return maxLen