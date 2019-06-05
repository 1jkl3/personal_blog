package com.myUtils;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Random;

/**
 * @author 杜虎
 * @Date 2019/6/3 - 16:39
 * //邮箱工具类
 */
@Component
public class eUtils {
    public String emilUtils(String emilnum) throws Exception{
        //接收人
//        String toMail=emilnum;
//        String toMail2="657874997@qq.com";
        //发送人
        String upMail="3521941319@qq.com";
        String mima="";
        Random random=new Random();
        for(int i=0;i<6;i++){
            mima+=String.valueOf(random.nextInt(10));
        }
        //指定是什么服务器
        String Specify="smtp.qq.com";
        //路径
        String path="C:\\Users\\xx\\Desktop\\qq邮箱pop3.txt";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host",Specify);
        properties.put("mail.smtp.auth","true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("3521941319@qq.com","bxejctyvvajydada");
            }
        });
            //ssl加密
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.socketFactory", sf);
            //普通方式发送单条数据
            MimeMessage mimeMessage = new MimeMessage(session);
            //发送方
            mimeMessage.setFrom(new InternetAddress(upMail));
            Address[] addresses = new Address[]{new InternetAddress(emilnum)};
            //接收方
//            mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(toMail));
            mimeMessage.addRecipients(Message.RecipientType.TO,addresses);
            mimeMessage.setSubject("个人博客邮箱验证");
            mimeMessage.setText("验证码为:"+mima);
            //创建datasoure路径
//            DataSource dataSource = new FileDataSource(path);
//            mimeMessage.setDataHandler(new DataHandler(dataSource));
//            mimeMessage.setFileName(path);
            Transport.send(mimeMessage);
        return mima;
    }
}
