package com.anaya.crud.model.BO.VMM;

public class UserInternalConsult {
    private int userCipher;
    private String userName;
    private String nickName;
    private String userBirthDate;
    private String mailUser;

    public UserInternalConsult() {

    }

    public UserInternalConsult(int userCipher, String userName, String nickName, String userBirthDate, String mailUser){
        this.userCipher = userCipher;
        this.userName = userName;
        this.nickName = nickName;
        this.userBirthDate = userBirthDate;
        this.mailUser = mailUser;
    }

    public void setUserCipher(int userCipher) {
        this.userCipher = userCipher;
    }

    public int getUserCipher() {
        return this.userCipher;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public String getNickName(){
        return this.nickName;
    }

    public void setBirthDate(String userBirthDate){
        this.userBirthDate = userBirthDate;
    }

    public String getBirthDate(){
        return this.userBirthDate;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getMailUser(){
        return this.mailUser; 
    }

}

