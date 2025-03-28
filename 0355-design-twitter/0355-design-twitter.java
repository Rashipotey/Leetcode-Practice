class Twitter {
    public class Pair implements Comparable<Pair> {
        int id;  
        int time; 

        Pair(int id, int time) {
            this.id = id;
            this.time = time;
        }
        public int compareTo(Pair p) {
            return this.time - p.time; 
        }
    }
    HashMap<Integer, ArrayList<Pair>> userIdMap;
    HashMap<Integer, HashSet<Integer>> followMap;
    PriorityQueue<Pair> p;
    int time;
    
    public Twitter() {
        userIdMap = new HashMap<>(); 
        followMap = new HashMap<>();  
        time = 0;  
    }
    public void postTweet(int userId, int tweetId) {
        userIdMap.putIfAbsent(userId, new ArrayList<>());
        userIdMap.get(userId).add(new Pair(tweetId, time));
        time++;
    }
    public List<Integer> getNewsFeed(int userId) {
        p = new PriorityQueue<>(Collections.reverseOrder()); 
        List<Integer> ans = new ArrayList<>(); 
        ArrayList<Pair> helper = userIdMap.get(userId);
        if (helper != null) {
            for (int i = 0; i < helper.size(); i++) {
                p.add(helper.get(i));
            }
        }
        HashSet<Integer> helper2 = followMap.get(userId);
        if (helper2 != null) {
            for (int key : helper2) {
                ArrayList<Pair> helper3 = userIdMap.get(key);
                if (helper3 != null) {
                    for (int i = 0; i < helper3.size(); i++) {
                        p.add(helper3.get(i));
                    }
                }
            }
        }
        while (!p.isEmpty() && ans.size() < 10) {
            Pair r = p.remove();  
            ans.add(r.id);  
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).add(followeeId);
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(followeeId);
            followMap.put(followerId, set);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}