class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ind=0, res=0;
        while(res<players.length && ind<trainers.length){
            if(players[res]<=trainers[ind]){
                res++;
            }
            ind++;
        }
        return res;
    }
}