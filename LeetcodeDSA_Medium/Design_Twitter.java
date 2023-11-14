class Twitter {

    private static int timestamp=0;

    private Map<Integer,User> usermap;

    public class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id=id;
            time=timestamp++;
            next=null;
        }

    }

    public class User {
        int id;
        HashSet<Integer> followed;
        Tweet tweet_head;

        public User(int id) {
            this.id=id;
            followed = new HashSet<Integer>();
            follow(id);
            tweet_head=null;
        }

        public void follow(int id)
        {
            followed.add(id);
        }

        public void unfollow(int id)
        {
            followed.remove(id);
        }

        public void post(int id)
        {
            Tweet t = new Tweet(id);
            t.next=tweet_head;
            tweet_head=t;
        }
    }
    
    public Twitter() {
        usermap = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!usermap.containsKey(userId))
        {
            User u = new User(userId);
            usermap.put(userId,u);
        }

        usermap.get(userId).post(tweetId);  
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if(!usermap.containsKey(userId)) return res;

        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(
            (a,b)->(b.time-a.time)
        );

        HashSet<Integer> users = usermap.get(userId).followed;
        for(int i:users)
        {
            Tweet t = usermap.get(i).tweet_head;
            if(t!=null)
            {
                pq.add(t);
            }
        }

        int n=0;
        while(!pq.isEmpty() && n<10) {

            Tweet t = pq.poll();
            res.add(t.id);
            n++;
            if(t.next!=null)
            {
                pq.add(t.next);
            }

        }
        return res;

        
    }
    
    public void follow(int followerId, int followeeId) {
        if(!usermap.containsKey(followerId))
        {
            User u = new User(followerId);
            usermap.put(followerId,u);
        }
        if(!usermap.containsKey(followeeId))
        {
            User u = new User(followeeId);
            usermap.put(followeeId,u);
        }
        usermap.get(followerId).follow(followeeId);

        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!usermap.containsKey(followerId) || followerId==followeeId)
        {
            return;
        }
        usermap.get(followerId).unfollow(followeeId);
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
