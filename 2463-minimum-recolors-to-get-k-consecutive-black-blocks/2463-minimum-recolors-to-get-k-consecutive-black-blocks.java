class Solution {
    public int minimumRecolors(String blocks, int k) {
        Queue<Character> blockQueue=new LinkedList<>();
        int numWhites=0;
        for (int i=0;i<k;i++) {
            char currentChar=blocks.charAt(i);
            if(currentChar=='W') numWhites++;
            blockQueue.add(currentChar);
        }
        int numRecolors=numWhites;
        for (int i=k;i<blocks.length();i++) {
            if(blockQueue.poll()=='W') numWhites--;
            char currentChar=blocks.charAt(i);
            if(currentChar=='W') numWhites++;
            blockQueue.add(currentChar);
            numRecolors=Math.min(numRecolors, numWhites);
        }
        return numRecolors;
    }
}