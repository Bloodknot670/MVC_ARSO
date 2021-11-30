package com.anaya.crud.model.BO.VMM;

public class UserPublicConsult {
    private int userCipher;
    private String nickName;

    //* Constructores
    public UserPublicConsult() {}

    public UserPublicConsult(int userCipher, String nickName) {
        this.userCipher = userCipher;
        this.nickName = nickName;
    }

    //* Getters y Setters
    public void setUserCipher(int userCipher) {
        this.userCipher = userCipher;
    }
    public int getUserCipher() {
        return this.userCipher;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getNickName() {
        return this.nickName;
    }
}
