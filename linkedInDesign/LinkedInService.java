package lldQuestions.linkedInDesign;

import java.util.Map;
import java.util.HashMap;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedInService {
    private Map<String,User>users;
    private Map<String,JobPosting>jobPostings;
    private Map<String,List<Notification>>notifications;

    public LinkedInService(){
        this.users=new HashMap<>();
        this.jobPostings=new HashMap<>();
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

    public void updateUserProfile(User user){
        users.put(user.getId(),user);
    }

    public void sendConnectionRequest(User sender,User receiver){
        Notification notification=new Notification(generateNotificationId(), receiver, NotificationType.CONNECTION_REQUEST, "Connection request by: "+sender.getName(), new Timestamp(System.currentTimeMillis()));
        addNotification(receiver.getId(),notification);
    }

    public void acceptConnectionRequest(User receiver,User sender){
        Connection connection=new Connection(sender,new Timestamp(System.currentTimeMillis()));
        receiver.
        getConnection().add(connection);
    }

    public List<User> searchUser(String keyword){
        List<User> searchResult=new ArrayList<>();
        for(User user:users.values()){
            if(user.getName().contains(keyword)){
                searchResult.add(user);
            }
        }
        return searchResult;
    }

    public void postJobListing(JobPosting jobPosting){
        jobPostings.put(jobPosting.getId(),jobPosting);
        for(User user:users.values()){
            Notification notification=new Notification(generateNotificationId(), user, null, "Job posting for "+jobPosting.getTitle(), new Timestamp(System.currentTimeMillis()));
            addNotification(user.getId(), notification);
        }
    }

    public List<JobPosting> searchJobPostings(String keyword){
        List<JobPosting> searchResult=new ArrayList<>();
        for(JobPosting jobPosting:jobPostings.values()){
            if(jobPosting.getTitle().contains(keyword) || jobPosting.getDescription().contains(keyword)){
                searchResult.add(jobPosting);
            }
        }
        return searchResult;
    }

    public void sendMessage(User sender,User receiver,String content){
        Message message=new Message(generateMessageId(), sender, receiver, content, new Timestamp(System.currentTimeMillis()));
        sender.getSentMessage().add(message);
        receiver.getInbox().add(message);
        Notification notification=new Notification(generateNotificationId(), receiver, NotificationType.MESSAGE, "Received message from "+sender.getName(), new Timestamp(System.currentTimeMillis()));
        addNotification(receiver.getId(), notification);
    }

    public List<Notification> getNotifications(String userId) {
        return notifications.getOrDefault(userId, new ArrayList<>());
    }

    private void addNotification(String userId,Notification notification){
        notifications.computeIfAbsent(userId, k -> new CopyOnWriteArrayList<>()).add(notification);
    }

    private String generateNotificationId() {
        return UUID.randomUUID().toString();
    }

    private String generateMessageId() {
        return UUID.randomUUID().toString();
    }
}
