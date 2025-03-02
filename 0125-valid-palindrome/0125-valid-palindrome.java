class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder filteredStr=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                filteredStr.append(Character.toLowerCase(c));
            }
        }
        int left=0;
        int right=filteredStr.length()-1;

        while(left<right){
            if(filteredStr.charAt(left)!=filteredStr.charAt(right)){
                return false; 
            }
            left++;
            right--;
        }
        return true; 
    }
}
