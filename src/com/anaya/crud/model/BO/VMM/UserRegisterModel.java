package com.anaya.crud.model.BO.VMM;

public class UserRegisterModel {
    public String nameUser;
    public String nickName;
    public String mailUser;
    public String birthDate;

    //* Constructores
    public UserRegisterModel(){
        
    }

    public UserRegisterModel(String nameUser, String nickName, String mailUser, String birthDate){
        this.nameUser = nameUser;
        this.nickName = nickName;
        this.mailUser = mailUser;
        this.birthDate = birthDate;
    }

    // * Getters y Setters
    public void setNameUser(String nameUser){
        this.nameUser = nameUser;
    }
    public String getNameUser(){
        return this.nameUser;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    public String getNickName(){
        return this.nickName;
    }
    public void setMailUser(String mailUser){
        this.mailUser = mailUser;
    }
    public String getMailUser(){
        return this.mailUser;
    }
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    public String getBirthDate(){
        return this.birthDate;
    }


}
