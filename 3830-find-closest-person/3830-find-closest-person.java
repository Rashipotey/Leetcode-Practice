class Solution {
    public int findClosest(int x, int y, int z) {
        return (Math.abs(x-z)>Math.abs(z-y))?2:(Math.abs(z-x)==Math.abs(z-y))?0:1;
    }
}