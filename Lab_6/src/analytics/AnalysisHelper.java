/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics;

/**
 *
 * @author harshalneelkamal
 */

import data.DataStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.Comment;
import model.Post;
import model.User;


public class AnalysisHelper {
    //Find Average number of likes per comment.
    //TODO
    public void getAverageLikesPerComments() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likeNumber = 0;
        int commentNumber = comments.size();
        for (Comment c : comments.values()) {
            likeNumber += c.getLikes();
        }
        
        System.out.println("Average number of likes per comments: " + likeNumber / commentNumber);
            
    }
    public void getMaxLikeCommentPost(){
        DataStore data = DataStore.getInstance();
        Comment commentWithMaxLikes = null;
        for(Comment c : data.getComments().values()){
            if(commentWithMaxLikes == null){
                commentWithMaxLikes = c;
            }
           if(c.getLikes()>  commentWithMaxLikes.getLikes()) {
               commentWithMaxLikes = c;
           }
        }
        int postId = commentWithMaxLikes.getPostId();
        System.out.println("Q2- post with more likes per comment: " + data.getPosts().get(postId).getPostId());
    }
    public void getMaxCommentPost(){
        DataStore data = DataStore.getInstance();
        Post postWithMaxComments = null;
        for(Post p : data.getPosts().values()){
            if(postWithMaxComments == null){
                postWithMaxComments = p;
            }
           if(p.getComments().size() >  postWithMaxComments.getComments().size()) {
               postWithMaxComments = p;
           }
        }
        int postId = postWithMaxComments.getPostId();
        System.out.println("Q3- post with Maximum  comments: " + postWithMaxComments.getPostId());
    }
    public void getPassiveUsers(){
        DataStore data = DataStore.getInstance();
        HashMap<Integer,Integer> postNumbers = new HashMap<Integer,Integer>();
        for(Post p : data.getPosts().values()){
            int userId = p.getUserId();
            if(postNumbers.containsKey(userId)){
                postNumbers.put(userId,postNumbers.get(userId)+1);
            }
            else{
                postNumbers.put(userId,1);
            }
        }
        ArrayList<User> users = new ArrayList<>(data.getUsers().values());
        Collections.sort(users, new UserMapComparator(postNumbers));
        System.out.println("Q-4 The following users have lesast posts ");
        for(int i =0;i<5;i++){
            System.out.println(users.get(i) + ", - PostCount: "+ postNumbers.get(users.get(i).getId()));
        
    }
    }
     public void getPassiveCommentUsers(){
        DataStore data = DataStore.getInstance();
        HashMap<Integer,Integer> commentNumbers = new HashMap<Integer,Integer>();
        for(Comment  c : data.getComments().values()){
            int userId = c.getUserId();
            if(commentNumbers.containsKey(userId)){
                commentNumbers.put(userId,commentNumbers.get(userId)+1);
            }
            else{
                commentNumbers.put(userId,1);
            }
        }
        ArrayList<User> users = new ArrayList<>(data.getUsers().values());
        Collections.sort(users, new UserMapComparator(commentNumbers));
        System.out.println("Q-5 The following users have lesast comments ");
        for(int i =0;i<5;i++){
            System.out.println(users.get(i) + ", - PostCount: "+ commentNumbers.get(users.get(i).getId()));
        
    }
    
}
     public void getPassiveAndActiveOverallUsers(){
         DataStore data = DataStore.getInstance();
         
        HashMap<Integer,Integer> overAllNumbers = new HashMap<Integer,Integer>();
        for(Comment  c : data.getComments().values()){
            int userId = c.getUserId();
            if(overAllNumbers.containsKey(userId)){
                overAllNumbers.put(userId,overAllNumbers.get(userId)+1);
            }
            else{
                overAllNumbers.put(userId,1);
            }
        }
        for(Post p : data.getPosts().values()){
            int userId = p.getUserId();
            if(overAllNumbers.containsKey(userId)){
                overAllNumbers.put(userId,overAllNumbers.get(userId)+1);
            }
            else{
                overAllNumbers.put(userId,1);
            }
        }
        
        ArrayList<User> users = new ArrayList<>(data.getUsers().values());
        Collections.sort(users, new UserMapComparator(overAllNumbers));
        System.out.println("Q-6 The following users have overall been passive ");
        for(int i =0;i<5;i++){
            System.out.println(users.get(i) + ", - PostCount: "+ overAllNumbers.get(users.get(i).getId()));
        
    }   
        Collections.sort(users, new UserMapComparator(overAllNumbers));
        System.out.println("Q-7 The following users have overall been active ");
        for(int i =users.size()-1;i>users.size()-6;i--){
            System.out.println(users.get(i) + ", - PostCount: "+ overAllNumbers.get(users.get(i).getId()));
        
    }
     }
}