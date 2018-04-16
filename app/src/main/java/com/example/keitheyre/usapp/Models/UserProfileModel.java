package com.example.keitheyre.usapp.Models;

public class UserProfileModel {

    private String full_name, chatroom_id;

    public UserProfileModel() {
    }

    public UserProfileModel(String full_name, String chatroom_id) {
        this.full_name = full_name;
        this.chatroom_id = chatroom_id;
    }

    public String getfull_name() {
        return full_name;
    }

    public void setfull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getchatroom_id() {
        return chatroom_id;
    }

    public void setchatroom_id(String chatroom_id) {
        this.chatroom_id = chatroom_id;
    }

}
