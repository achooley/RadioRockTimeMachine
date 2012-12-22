package com.example.Rock;

/**
 * Created with IntelliJ IDEA.
 * User: anton
 * Date: 22.12.12
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 */
public class Token {
    private String Token;
    private String User_ID;
    private String time_sec;

    public Token(String token,String User_ID,String time_sec) {
        setToken("2943f729abd5468d13f7183a6e0a3465be1499f155f4eb6e13c9b1beabe0ac74011fe391f8b33409a4ba0");

    }

    public Token() {
        setToken("2943f729abd5468d13f7183a6e0a3465be1499f155f4eb6e13c9b1beabe0ac74011fe391f8b33409a4ba0");
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }



    public String getTime_sec() {
        return time_sec;
    }

    public void setTime_sec(String time_sec) {
        this.time_sec = time_sec;
    }



    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
