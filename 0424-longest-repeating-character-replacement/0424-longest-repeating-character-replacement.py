class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l=0
        temp=k
        maxLen=0
        seen={}
        max_freq=0
        for r in range(len(s)):
            seen[s[r]]=seen.get(s[r],0)+1
            max_freq=max(max_freq, seen.get(s[r]))
            if r-l+1-max_freq>k:
                seen[s[l]]-=1
                l+=1
            maxLen=max(maxLen, r-l+1)
        return maxLen