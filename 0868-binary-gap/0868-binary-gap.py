class Solution:
    def binaryGap(self, n: int) -> int:
        bin_format=format(n,'b')
        left=0
        right=1
        max_dist=0
        while left<right and right<len(bin_format):
            if bin_format[left]=='1' and bin_format[right]=='1':
                max_dist=max(max_dist,right-left)
                left=right
                right+=1
            elif bin_format[left]!='1':
                left+=1
                right=left+1
            elif bin_format[right]!='1':
                right+=1
        return max_dist