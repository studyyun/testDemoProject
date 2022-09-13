package com.example.test.mail;

import com.alibaba.fastjson.JSONArray;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-11-02  14:04
 */

public class MultiMailsender {

    public static void main(String[] args) {
        new MultiMailsender().sendEmail();
    }
    
    public Properties getProps() {
        //服务器地址
        String host = "smtp.qq.com";
        //默认服务器端口
        int port = 25;
        Properties props = new Properties();
        //设置用户的认证方式
        props.setProperty("mail.smtp.auth", "true");
        //设置传输协议
        props.setProperty("mail.transport.protocol", "smtp");
        //设置发件人的SMTP服务器地址
        props.setProperty("mail.smtp.host", host);
        //连接超时时间
        props.put("mail.smtp.connectiontimeout", 30000);
        //读超时时间
        props.put("mail.smtp.timeout", 30000);
        //写超时时间
        props.put("mail.smtp.writetimeout", 60000);
        //加密方式 1无 ， 2tls ， 3ssl
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        port = 465;
        props.setProperty("mail.smtp.port", String.valueOf(port));
        return props;
    }

    public void sendEmail() {
        Transport transport = null;
        Session session = null;
        try {
            //1、创建定义整个应用程序所需的环境信息的 Session 对象
            session = Session.getInstance(getProps(), new MyAuthenticator("569824306@qq.com", "deonwywlsjvfbbgh"));
            //设置调试信息在控制台打印出来
            session.setDebug(true);
            //根据session对象获取邮件传输对象Transport
            transport = session.getTransport();
            //添加监听器
            MailListener mailListener = new MailListener();
            transport.addTransportListener(mailListener);
            //与服务器建立连接
            transport.connect();
            //创建实例，发送邮件
            sendMessage(transport, session);
        } catch (Exception e) {

        }
    }

    public void sendMessage(Transport transport, Session session) {
        //创建邮件的实例对象
        Message message = getMimeMessage(session);
        try {
            //发送邮件
            transport.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            System.out.println("发送邮件报错了");

        }
    }

    public MimeMessage getMimeMessage(Session session) {
        String content = "测试抄送功能";
        MimeMessage msg = null;
        try {
            //创建一封邮件的实例对象
            msg = new MimeMessage(session);
            //设置发件人地址
            msg.setFrom(new InternetAddress("569824306@qq.com"));
            //单个目标收件人
            Address[] toAddresses = new Address[2];
            toAddresses[0] = new InternetAddress("2924069880@qq.com");
            toAddresses[1] = new InternetAddress("2924069880@qq.com");
//            toAddresses[1] = new InternetAddress("295393065@qq.com");
            msg.setRecipients(MimeMessage.RecipientType.TO, toAddresses);
            //抄送人
            Address[] ccAddresses = new Address[1];
            ccAddresses[0] = new InternetAddress("2924069880@qq.com");
//            ccAddresses[1] = new InternetAddress("761196745@qq.com");
            msg.setRecipients(MimeMessage.RecipientType.CC, ccAddresses);
            //密送
            Address[] bccAddresses = new Address[1];
            bccAddresses[0] = new InternetAddress("2924069880@qq.com");
//            ccAddresses[1] = new InternetAddress("761196745@qq.com");
            msg.setRecipients(MimeMessage.RecipientType.BCC, bccAddresses);
            //设置邮件主题
//            msg.setSubject(emailMt.getTheme());
            MimeMultipart multipart = new MimeMultipart();
            //设置邮件正文
            MimeBodyPart text = new MimeBodyPart();
            text.setContent(content, "text/html;charset=UTF-8");
            multipart.addBodyPart(text);
            multipart.setSubType("related");
            msg.setSentDate(new Date());
            msg.setContent(multipart);
            msg.saveChanges();
            msg.setFrom(new InternetAddress(MimeUtility.encodeText("尝试自定义发件人名称")+" <"+"569824306@qq.com"+">"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错错错");
        }
        return msg;
    }
}

class MailListener implements TransportListener {
    /**
     * 全部投递成功
     */
    @Override
    public void messageDelivered(TransportEvent event) {
        System.out.println("邮件回写状态报告-投递成功：任务开始");

    }

    /**
     * 全部投递失败
     */
    @Override
    public void messageNotDelivered(TransportEvent event) {
        System.out.println("邮件回写状态报告-投递失败：任务开始");

    }

    /**
     * 部分投递成功，部分投递失败
     */
    @Override
    public void messagePartiallyDelivered(TransportEvent event) {
        //此方法不会执行
        System.out.println("邮件发送，部分投递成功，部分投递失败");
    }

}

