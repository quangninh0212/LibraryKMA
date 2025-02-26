/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


/**
 *
 * @author admin
 */
public class ChuanHoa {
    public static String chuanHoaNgayThang(String ngaySinh) {
        String arr[] = ngaySinh.split("/");
        return arr[2] + "-" + arr[1] + "-" + arr[0];
    }
    
    public static String chuanHoaNguoc(String ngaySinh) {
        String arr[] = ngaySinh.split("-");
        return arr[2] + "/" + arr[1] + "/" + arr[0];
    }
}
