package lldQuestions.facebookDesign;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class Facebook {
    private Map<String,User>users;
    private Map<String,Post>posts;
    private Map<String,List<Notification>>notifications;

    public Facebook(){
        this.users=new HashMap<>();
        this.posts=new HashMap<>();
        this.notifications=new HashMap<>();
    }

    public void registerUser(User user){
        users.put(user.getId(),user);
    }

    public User loginUser(String email,String password){
        for(User user:users.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public void updateUser(User user){
        users.put(user.getId(),user);
    }

    public void sendFriendRequest(String senderId,String receiverId){
        User sender = users.get(senderId);
        Notification notification=new Notification(generateNotificationId(), receiverId, NotificationType.FRIEND_REQUEST, "Friend Request from "+ sender.getName(), new Timestamp(System.currentTimeMillis()));
        addNotification(receiverId, notification);
    }

    public void acceptFriendRequest(String senderId,String receiverId){
        User sender=users.get(senderId);
        User receiver=users.get(receiverId);
        sender.getFriends().add(receiverId);
        receiver.getFriends().add(senderId);
        Notification notification=new Notification(generateNotificationId(), senderId, NotificationType.FRIEND_REQUEST_ACCEPTED, "Friend Request accepted from "+ receiver.getName(), new Timestamp(System.currentTimeMillis()));
        addNotification(senderId, notification);
    }

    public void createPost(Post post){
        posts.put(post.getId(),post);
        String userId=post.getUserId();
        User user=users.get(userId);
        user.getPost().add(post);
    }

    public void likePost(String userId,String postId){
        Post post=posts.get(postId);
        String postOwnerId=post.getUserId(); 
        User postLiker=users.get(userId);

        post.getLikes().add(userId);
        Notification notification=new Notification(generateNotificationId(), postOwnerId, NotificationType.LIKE, "Post liked by "+postLiker.getName(), new Timestamp(System.currentTimeMillis()));
        addNotification(postOwnerId, notification);
    }

    public void commentPost(Comment comment){
        String commentorId=comment.getUserId();
        User commentor=users.get(commentorId);
        String postId=comment.getPostId();
        Post post=posts.get(postId);
        String postOwnerId=post.getUserId();
        post.getComments().add(comment);
        Notification notification=new Notification(generateNotificationId(), postOwnerId, NotificationType.COMMENT, "Post Commented by "+commentor.getName(), new Timestamp(System.currentTimeMillis()));
        addNotification(postOwnerId, notification);
    }

    public List<Post> getNewsfeed(String userId) {
        List<Post> newsfeed = new ArrayList<>();
        User user = users.get(userId);
        if (user != null) {
            List<String> friendIds = user.getFriends();
            for (String friendId : friendIds) {
                User friend = users.get(friendId);
                if (friend != null) {
                    newsfeed.addAll(friend.getPost());
                }
            }
            newsfeed.addAll(user.getPost());
            newsfeed.sort((p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()));
        }
        return newsfeed;
    }

    private void addNotification(String userId, Notification notification) {
        notifications.computeIfAbsent(userId, k -> new CopyOnWriteArrayList<>()).add(notification);
    }

    public List<Notification> getNotifications(String userId) {
        return notifications.getOrDefault(userId, new ArrayList<>());
    }

    private String generateNotificationId() {
        return UUID.randomUUID().toString();
    }
}
