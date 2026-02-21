class Solution:
    def is_prime(self,num):
        if num<=1: return False
        if num<=3: return True
        if num%2==0 or num%3==0: return False
        i=5
        while i*i<=num:
            if num%i==0 or num%(i+2)==0:
                return False
            i+=6
        return True

    def countPrimeSetBits(self, left: int, right: int) -> int:
        ans=0
        for i in range(left, right+1):
            count=i.bit_count()
            if self.is_prime(count):
                ans+=1
        return ans