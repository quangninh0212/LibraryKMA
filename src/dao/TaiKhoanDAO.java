/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.TaiKhoan;


/**
 *
 * @author admin
 */
public class TaiKhoanDAO extends DAO {

    public TaiKhoanDAO() {
        super();
    }
    
    public String dangNhap(String username, String password) {
        String sql = "select * from users where tenDangNhap = ? and matKhau = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                String vaiTro = res.getString(4);
                return vaiTro;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return "-1";
        }
        return "-1";
    }
    
    public DefaultTableModel getAccountADTTList() {
        String sql = "select * from users where vaiTro IN (N'Admin', N'Thủ thư')";
        String[] col = {"ID", "Tên đăng nhập", "Mật khẩu", "Vai trò"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getInt(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                vecto.add(res.getString(4));
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel getAccountTTList() {
        String sql = "select * from users where vaiTro = N'Thủ thư'";
        String[] col = {"ID", "Tên đăng nhập", "Mật khẩu", "Vai trò"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getInt(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                vecto.add(res.getString(4));
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public ArrayList<TaiKhoan> getAccountTTArr() {
        String sql = "select * from users where vaiTro = N'Thủ thư'";
        ArrayList<TaiKhoan> arr = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                TaiKhoan tk = new TaiKhoan(res.getString(2), res.getString(3), res.getString(4), res.getInt(1));
                arr.add(tk);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }
    
    public ArrayList<TaiKhoan> getAccountDGArr() {
        String sql = "select * from users where vaiTro = N'Độc giả'";
        ArrayList<TaiKhoan> arr = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                TaiKhoan tk = new TaiKhoan(res.getString(2), res.getString(3), res.getString(4), res.getInt(1));
                arr.add(tk);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }
    
    public DefaultTableModel getAccountDGList() {
        String sql = "select * from users where vaiTro = N'Độc giả'";
        String[] col = {"ID", "Tên đăng nhập", "Mật khẩu", "Vai trò"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getInt(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                vecto.add(res.getString(4));
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel getIDTTList() {
        String sql = "select userID, tenDangNhap from users where vaiTro = N'Thủ thư'";
        String[] col = {"ID", "Tên đăng nhập"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getInt(1));
                vecto.add(res.getString(2));
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel getIDDGList() {
        String sql = "select userID, tenDangNhap from users where vaiTro = N'Độc giả'";
        String[] col = {"ID", "Tên đăng nhập"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getInt(1));
                vecto.add(res.getString(2));
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel getTK_MaDG_HoTenList() {
        String sql = "select tenDangNhap, maDG, hoTen from users, people where users.userID = people.userID and vaiTro = N'Độc giả'";
        String[] col = {"Tài khoản", "Mã ĐG", "Họ tên"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getString(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public boolean addTaiKhoan(TaiKhoan acc) {
        String sql = "insert into users(tenDangNhap, matKhau, vaiTro) values (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, acc.getTenDangNhap());
            ps.setString(2, acc.getMatKhau());
            ps.setString(3, acc.getVaiTro());
            
            int row = ps.executeUpdate();
            if(row != 0) {
                return true;
            }
            else
                return false;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteTaiKhoan(int userID) {
        String sql = "delete from users where userID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            int row = ps.executeUpdate();
            if(row != 0) {
                return true;
            }
            else
                return false;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public int getSoLuongTaiKhoanADTT() {
        String sql = "select count(userID) from users where vaiTro IN (N'Admin', N'Thủ thư')";
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                return res.getInt(1);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public int getSoLuongTaiKhoanDG() {
        String sql = "select count(userID) from users where vaiTro = N'Độc giả'";
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                return res.getInt(1);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public boolean updateTaiKhoan(TaiKhoan acc, int userId) {
        String sql = "update users set tenDangNhap = ?, matKhau = ?, vaiTro = ? where userID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, acc.getTenDangNhap());
            ps.setString(2, acc.getMatKhau());
            ps.setString(3, acc.getVaiTro());
            ps.setInt(4, userId);
            int row = ps.executeUpdate();
            if(row != 0) {
                return true;
            }
            else
                return false;
            
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateMatKhau(String matKhau, int userID) {
        String sql = "update users set matKhau = ? where userID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, matKhau);
            ps.setInt(2, userID);
            int row = ps.executeUpdate();
            if(row != 0) {
                return true;
            }
            else
                return false;
            
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public TaiKhoan timTaiKhoan(String tenDangNhap) {
        String sql = "select * from users where tenDangNhap = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ResultSet res = ps.executeQuery();
            if(res.next()) {
                TaiKhoan tk = new TaiKhoan(res.getString(2), res.getString(3), res.getString(4), res.getInt(1));
                
                return tk;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }
}
