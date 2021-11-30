package com.anaya.crud.model.BO.VMM;

public class UserUpdateModel {
    private int userCipher;
    private String nickName;
    private String mailUser;

    //* Constructor
    public UserUpdateModel(){

    }

    public UserUpdateModel(int userCipher, String nickName, String mailUser){
        this.userCipher = userCipher;
        this.nickName = nickName;
        this.mailUser = mailUser;
    }

    //* Getters y Setters
    public void setUserCipher(int userCipher){
        this.userCipher = userCipher;
    }
    public int getUserCipher() {
        return this.userCipher;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    } 
    public String getNickName() {
        return this.nickName;
    }
    public void setMailUser(String mailUser){
        this.mailUser = mailUser;
    }
    public String getMailUser() {
        return this.mailUser; 
    }
}
