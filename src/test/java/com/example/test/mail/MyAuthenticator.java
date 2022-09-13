package com.example.test.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-11-02  14:15
 */
public class MyAuthenticator extends Authenticator {
    private String username ;

    private String password ;

    public MyAuthenticator() {
        super();
    }

    public MyAuthenticator(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {

        return new PasswordAuthentication(username, password);
    }
}
