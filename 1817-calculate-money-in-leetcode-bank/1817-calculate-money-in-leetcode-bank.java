class Solution {
    public int totalMoney(int n) {
        int nWeeks=n/7, rDays=n%7;
        return triSum(n)-42*triSum(nWeeks-1)-6*nWeeks*rDays;
    }
    private int triSum(int n){
        return (n*(n+1))/2;
    }
}