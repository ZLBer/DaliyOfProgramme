package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leet355 {


    class Twitter {
        class Message{
            int id;
            int time;

            public Message(int id, int time) {
                this.id = id;
                this.time = time;
            }
        }

        int time=0;
        Map<Integer,List<Message>> tw=new HashMap<>();
        Map<Integer, Set<Integer>> fw=new HashMap<>();
        /** Initialize your data structure here. */
        public Twitter() {

        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if(!tw.containsKey(userId)) tw.put(userId,new ArrayList<>());
            tw.get(userId).add(new Message(tweetId,time++));
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
        List<Message> list=new ArrayList<>();
        List<Integer> user=new ArrayList<>();
            Set<Integer> set = fw.get(userId);
        if(set!=null){
            for (Integer integer : set) {
                user.add(integer);
            }
        }
        user.add(userId);
            for (Integer id : user) {
               if(tw.get(id)==null) continue;
                list.addAll(tw.get(id));
            }
            Collections.sort(list,(a,b)->b.time-a.time);

          List<Integer> res=new ArrayList<>();
           if(list.size()<10){
               for (Message message : list) {
                   res.add(message.id);
               }
           }else {
               for (int i = 0; i < 10; i++) {
                   res.add(list.get(i).id);
               } 
           }
           return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(followeeId==followerId) return;
           if(!fw.containsKey(followerId)) fw.put(followerId,new HashSet<>());
            fw.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followeeId==followerId) return;
           if(fw.containsKey(followerId))
            fw.get(followerId).remove(followeeId);
        }
    }
}
