package com.akhil.model;

/**
 * Created by e on 05-05-2017.
 */

public class LoginService {
    public boolean login(String userName, String password) {

        return "akhil".equals(userName) && "soni".equals(password);
    }
}
