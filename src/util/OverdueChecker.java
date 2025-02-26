/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class OverdueChecker {    
    public static void checkOverdueBooks() {
        LocalDate today = LocalDate.now();
        
        // Kết nối đến MySQL
        String url = "";
        String username = "";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            // 📌 Kiểm tra ngày cuối cùng đã gửi email trong CSDL
            String checkQuery = "SELECT last_sent_date FROM email_log WHERE id = 1";
            PreparedStatement checkPs = con.prepareStatement(checkQuery);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                LocalDate lastSentDate = rs.getDate("last_sent_date").toLocalDate();
                if (lastSentDate.equals(today)) {
                    return;
                }
            }

            // 📌 Truy vấn danh sách sách quá hạn
            String query = "SELECT p.email, b.tenSach, br.ngayHenTra " +
                           "FROM borrow br " +
                           "JOIN people p ON br.maDG = p.maDG " +
                           "JOIN books b ON br.maSach = b.maSach " +
                           "WHERE br.ngayHenTra < CURDATE() AND br.tinhTrang = 1";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rsBooks = ps.executeQuery();

            List<String[]> overdueBooks = new ArrayList<>();
            while (rsBooks.next()) {
                String email = rsBooks.getString("email");
                String bookTitle = rsBooks.getString("tenSach");
                String dueDate = rsBooks.getString("ngayHenTra");
                overdueBooks.add(new String[]{email, bookTitle, dueDate});
            }

            // 📌 Nếu có sách quá hạn, gửi email và cập nhật ngày đã gửi vào CSDL
            if (!overdueBooks.isEmpty()) {
                for (String[] book : overdueBooks) {
                    EmailSender.sendEmail(book[0], book[1], book[2]);
                }

                // 📌 Cập nhật ngày đã gửi email vào CSDL
                String updateQuery = "UPDATE email_log SET last_sent_date = ?";
                PreparedStatement updatePs = con.prepareStatement(updateQuery);
                updatePs.setDate(1, Date.valueOf(today));
                updatePs.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
