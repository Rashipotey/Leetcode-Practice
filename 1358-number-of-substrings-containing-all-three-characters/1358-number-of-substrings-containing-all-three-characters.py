class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        seen={}
        l=0
        count=0
        for r in range(len(s)):
            seen[s[r]]=seen.get(s[r],0)+1
            while len(seen)==3:
                count+=len(s)-r
                seen[s[l]]-=1
                if seen[s[l]]==0:
                    del seen[s[l]]
                l+=1
        return count