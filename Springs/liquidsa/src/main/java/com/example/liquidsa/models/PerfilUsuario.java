package com.example.liquidsa.models;

import java.util.List;

public class PerfilUsuario extends User {
    
    public PerfilUsuario(String email, String senha) {
        super(email, senha);
        //TODO Auto-generated constructor stub
    }
    private String bio;
    private List followers;
    private List following;
    private List posts;
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public List getFollowers() {
        return followers;
    }
    public void setFollowers(List followers) {
        this.followers = followers;
    }
    public List getFollowing() {
        return following;
    }
    public void setFollowing(List following) {
        this.following = following;
    }
    public List getPosts() {
        return posts;
    }
    public void setPosts(List posts) {
        this.posts = posts;
    }

}
