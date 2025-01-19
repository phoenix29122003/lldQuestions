package lldQuestions.facebookDesign;

import java.util.List;

public class User{
    private String id;
    private String name;
    private String email;
    private String password;
    private String profilePic;
    private String bio;
    private List<String>friends;
    private List<Post>posts;

    public User(String id,String name,String email,String password,String profilePic,String bio,List<String>friends,List<Post>posts){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.profilePic=profilePic;
        this.bio=bio;
        this.friends=friends;
        this.posts=posts;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getProfilePic(){
        return profilePic;
    }

    public String getBio(){
        return bio;
    }

    public List<String> getFriends(){
        return friends;
    }

    public List<Post> getPost(){
        return posts;
    }
}