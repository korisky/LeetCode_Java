package Ex301_600.Ex331_to_360.Ex355_DesignTwitter;

import java.util.*;

public class Solution {


    /**
     * 题目希望设计实现一个简单的Tweeter, 每个用户可以看到自己feed流的时间倒叙前10个Tweet
     */
    public static class Twitter {

        /**
         * Tweet类
         */
        public class Tweet {
            public int uuid;
            public int time;
            // 使用简单的list使得搜索更新的tweet更简单
            public Tweet next;

            public Tweet(int id) {
                this.uuid = id;
                this.time = timestamp++; // 这里使用同一的Twitter的时间戳展示时间
                this.next = null;
            }
        }

        /**
         * 用户类, 使用读扩散的方式, 拉取feed的时候才查询对方是否有新tweet
         */
        public class User {
            public int id;
            public Set<Integer> followed;
            public Tweet tweetHead;

            public User(int id) {
                this.id = id;
                this.followed = new HashSet<>();
                this.tweetHead = null;
                // follow itself to own tweet's visibility
                follow(id);
            }

            public void follow(int id) {
                followed.add(id);
            }

            public void unfollow(int id) {
                followed.remove(id);
            }

            /**
             * Post Own Tweet
             *
             * @param id tweetId
             */
            public void post(int id) {
                Tweet t = new Tweet(id);
                t.next = tweetHead;
                tweetHead = t;
            }
        }

        // 模拟的timestamp
        private static int timestamp = 0;
        // 用户搜索map, 方便直接找到用户进行关注取消关注的操作
        private Map<Integer, User> userMap;

        public Twitter() {
            this.userMap = new HashMap<>();
        }

        /**
         * 发Tweet
         */
        public void postTweet(int userId, int tweetId) {
            // 由于没有注册流程, 发tweet同时处理新用户
            if (!userMap.containsKey(userId)) {
                User u = new User(userId);
                userMap.put(userId, u);
            }
            // 加入其tweet
            userMap.get(userId)
                    .post(tweetId);

        }

        /**
         * 获取最新的Feeds, 核心设计是读扩散
         */
        public List<Integer> getNewsFeed(int userId) {
            // 使用priorityQueue保存
            PriorityQueue<Tweet> timelineTweet = new PriorityQueue<>(
                    10, (a, b) -> (b.time - a.time));
            if (!userMap.containsKey(userId)) {
                return Collections.emptyList();
            }
            // 找到关注列表, 准备读扩散
            Set<Integer> followeeSet = userMap.get(userId).followed;
            PriorityQueue<Tweet> followeeTweetHeadQueue = new PriorityQueue<>(
                    followeeSet.size(), (a, b) -> (b.time - a.time));
            // 找到用户关注的用户的tweetHead, 将他们都加入到timeline下
            for (Integer followeeId : followeeSet) {
                Tweet tweetHead = userMap.get(followeeId).tweetHead;
                if (!Objects.isNull(tweetHead)) {
                    followeeTweetHeadQueue.add(tweetHead);
                }
            }
            // 由于只是head, 遍历获取里面10条最新的
            while (!followeeTweetHeadQueue.isEmpty() && timelineTweet.size() < 10) {
                Tweet latestTweet = followeeTweetHeadQueue.poll();
                timelineTweet.offer(latestTweet);
                if (!Objects.isNull(latestTweet.next)) {
                    followeeTweetHeadQueue.offer(latestTweet.next);
                }
            }
            return timelineTweet.stream()
                    .map(a -> a.uuid)
                    .toList();
        }

        public void follow(int followerId, int followeeId) {
            // 由于没有注册流程, follow同时处理用户
            if (!userMap.containsKey(followerId)) {
                User user = new User(followerId);
                userMap.put(followerId, user);
            }
            if (!userMap.containsKey(followeeId)) {
                User user = new User(followeeId);
                userMap.put(followeeId, user);
            }
            userMap.get(followerId)
                    .follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId) || followerId == followeeId) {
                return;
            }
            userMap.get(followerId)
                    .unfollow(followeeId);
        }
    }
}
