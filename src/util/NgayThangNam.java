/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author admin
 */
public class NgayThangNam {
    public static String getBorrowDate() {
         // Tạo một đối tượng JDateChooser
        JDateChooser dateChooser = new JDateChooser();
        
        // Lấy ngày hiện tại
        Date currentDate = new Date();
        dateChooser.setDate(currentDate); // Cập nhật ngày vào JDateChooser

        // Định dạng ngày theo kiểu dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(dateChooser.getDate());
        
        return formattedDate;
    }
    
    public static String getReturnDate() {
        // Lấy ngày hiện tại (ngày mượn)
        Date currentDate = new Date();
        
        // Định dạng ngày kiểu dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String borrowDate = dateFormat.format(currentDate);
        
        // Tính ngày hẹn trả (cộng thêm 2 tháng)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, 2); // Cộng 2 tháng
        Date dueDate = calendar.getTime();
        String returnDate = dateFormat.format(dueDate);
        
        return returnDate;
    }
    
    public static String getReturnDate(String ngayYeuCau) {
        try {
            // Định dạng ngày theo "dd/MM/yyyy"
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            // Chuyển đổi chuỗi ngày yêu cầu thành đối tượng Date
            Date requestDate = dateFormat.parse(ngayYeuCau);
            
            // Tạo Calendar để cộng thêm 2 tháng
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(requestDate);
            calendar.add(Calendar.MONTH, 2); // Cộng 2 tháng
            
            // Lấy ngày hẹn trả
            Date returnDate = calendar.getTime();
            return dateFormat.format(returnDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "Ngày không hợp lệ";
        }
    }
    
}
