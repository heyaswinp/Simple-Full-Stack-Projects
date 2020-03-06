package edu.sjsu.cmpe275.aop.tweet;

import java.lang.reflect.Array;
import java.util.*;

public class TweetStatsServiceImpl implements TweetStatsService {
  /***
   * Following is a dummy implementation.
   * You are expected to provide an actual implementation based on the requirements.
   */

  public Map<String, Set<String>> follow;
  public Map<String, Set<String>> block;
  public List<List<String>> tweet;
  public Map<String, Integer> missed;

  public TweetStatsServiceImpl() {
    follow = new HashMap<String, Set<String>>();
    block = new HashMap<String, Set<String>>();
    tweet = new ArrayList<List<String>>();
    missed = new HashMap<String, Integer>();
  }

  @Override
  public void resetStatsAndSystem() {
    // TODO Auto-generated method stub

  }

  @Override
  public int getLengthOfLongestTweet() {

    int maxLength = Integer.MIN_VALUE;
    for(int i = 0; i < tweet.size(); i++) {
      maxLength = Math.max(maxLength, tweet.get(i).get(0).length());
    }

    if(maxLength < 0)
      return 0;
    else
      return maxLength;
  }

  @Override
  public String getMostFollowedUser() {

    if(follow.size() == 0)
      return null;

    int maxFollowing = Integer.MIN_VALUE;
    String mostFollowed = null;

    for(String s: follow.keySet()) {
      if(follow.get(s).size() > maxFollowing) {
        maxFollowing = follow.get(s).size();
        mostFollowed = s;
      } else if(follow.get(s).size() == maxFollowing) {
        if(s.compareTo(mostFollowed) < 0) {
          mostFollowed = s;
        }
      } else {

      }
    }

    return mostFollowed;
  }

  @Override
  public String getMostPopularMessage() {

    if(tweet.size() == 0)
      return null;

    Map<String, Integer> map = new HashMap<String, Integer>();

    for(List<String> l: tweet) {
      if(map.get(l.get(0)) == null) {
        map.put(l.get(0), Integer.parseInt(l.get(2)));
      } else {
        map.put(l.get(0), map.get(l.get(0)) + Integer.parseInt(l.get(2)));
      }
    }

    int highestReachCount = Integer.MIN_VALUE;
    String highestReachTweet = null;

    for(String s: map.keySet()) {
      if(map.get(s) > highestReachCount) {
        highestReachCount = map.get(s);
        highestReachTweet = s;
      } else if(map.get(s) == highestReachCount) {
        if(s.compareTo(highestReachTweet) < 0) {
          highestReachTweet = s;
        }
      } else {

      }
    }
    return highestReachTweet;
  }

  @Override
  public String getMostProductiveUser() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getMostBlockedFollowerByNumberOfMissedTweets() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getMostBlockedFollowerByNumberOfFollowees() {
    // TODO Auto-generated method stub
    return null;
  }
}



