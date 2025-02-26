/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.net.PasswordAuthentication;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

/**
 *
 * @author admin
 */
public class EmailSender {
    public static void sendEmail(String toEmail, String bookTitle, String dueDate) {
        final String fromEmail = ""; // Thay bằng Gmail của bạn
        final String password = ""; // Thay bằng App Password đã tạo

        // Cấu hình SMTP Server (sử dụng Gmail)
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // TLS bảo mật

        // Xác thực tài khoản Gmail
        Session session = Session.getInstance(props, new Authenticator() {
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() { // Dùng jakarta.mail
                return new jakarta.mail.PasswordAuthentication(fromEmail, password);
            }
        });


        try {
            // Tạo email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Thông báo quá hạn sách");
            message.setText("Chào bạn,\n\nCuốn sách '" + bookTitle + "' của bạn đã quá hạn trả từ " + dueDate + 
                            ". Vui lòng trả sách sớm nhất có thể.\n\nCảm ơn bạn!\nPhí phạt trả muộn: 2.000 đồng/ngày\n\nThư viện Học viện Kỹ Thuật Mật Mã - KMA.");

            // Gửi email
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
