class Solution {
    public int totalMoney(int n) {
        int nWeeks=n/7, rDays=n%7;
        int total=28*nWeeks+(7*nWeeks*(nWeeks-1))/2;
        total+=rDays*nWeeks+(rDays*(rDays+1))/2;
        return total;
    }
}