class Solution:
    MOD=10**9+7
    def countGoodNumbers(self, n: int) -> int:
        even_num=(n+1)//2
        prime_nums=n//2
        return (pow(5,even_num,self.MOD)*pow(4,prime_nums,self.MOD))%self.MOD