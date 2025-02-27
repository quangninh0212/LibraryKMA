/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import model.DocGia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class DocGiaDAO extends DAO{

    public DocGiaDAO() {
        super();
    }
    
    public boolean addDocGia(DocGia s) {
        String sql = "insert into people values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getMaDG());
            ps.setString(2, s.getHoTen());
            ps.setString(3, s.getGioiTinh());
            ps.setString(4, s.getNgaySinh());
            ps.setString(5, s.getDoiTuong());
            ps.setString(7, s.getEmail());
            ps.setInt(6, s.getUserID());
            
            int cnt = ps.executeUpdate();
            if(cnt != 0)
                return true;
            else
                return false;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public void addDocGiaAfteraddTK(String maDG, int userID) {
        String sql = "insert into people(maDG, userID) values (?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDG);
            ps.setInt(2, userID);
            
            ps.executeUpdate();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateDocGiaAfteraddTK(String maDG, int userID) {
        String sql = "update people set maDG = ? where userID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDG);
            ps.setInt(2, userID);
            
            ps.executeUpdate();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean deleteDocGia(String maDG) {
        String sql = "delete from people where maDG = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDG);
            int cnt = ps.executeUpdate();
            if(cnt != 0)
                return true;
            else
                return false;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteDocGia2(int userID) {
        String sql = "delete from people where userID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            int cnt = ps.executeUpdate();
            if(cnt != 0)
                return true;
            else
                return false;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public DefaultTableModel getListDocGia() {
       String sql = "select users.userID, users.tenDangNhap, people.maDG, people.hoTen, people.gioiTinh, people.ngaySinh, people.doiTuong, people.email from users, people where users.userID = people.userID and vaiTro = N'Độc giả'";
        String[] col = {"UserID", "Tài khoản", "Mã ĐG", "Họ tên", "Giới tính", "Ngày sinh", "Đối tượng", "Email"};
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
                vecto.add(res.getString(5));
                String date = "";
                if(res.getDate(6) != null) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    date = formatter.format(res.getDate(6));
                    vecto.add(date);
                }
                else
                    vecto.add(date);
                vecto.add(res.getString(7));
                vecto.add(res.getString(8));
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public ArrayList<DocGia> getAllDocGia() {
        String sql = "select users.userID, users.tenDangNhap, people.maDG, people.hoTen, people.gioiTinh, people.ngaySinh, people.doiTuong, people.email from users, people where users.userID = people.userID and vaiTro = N'Độc giả'";
        ArrayList<DocGia> arr = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                DocGia dg = new DocGia(res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getInt(1), res.getString(2), res.getString(8));
                arr.add(dg);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }
    
    public int getSoLuongDocGia() {
        String sql = "select count(users.userID) from users, people where users.userID = people.userID and vaiTro = N'Độc giả'";
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
    
    public DefaultTableModel getListThuThu() {
        String sql = "select users.userID, users.tenDangNhap, people.maDG, people.hoTen, people.gioiTinh, people.ngaySinh, people.email from users, people where users.userID = people.userID and vaiTro = N'Thủ thư'";
        String[] col = {"UserID", "Tài khoản", "Mã TT", "Họ tên", "Giới tính", "Ngày sinh", "Email"};
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
                vecto.add(res.getString(5));
                String date = "";
                if(res.getDate(6) != null) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    date = formatter.format(res.getDate(6));
                    vecto.add(date);
                }
                else
                    vecto.add(date);
                
                vecto.add(res.getString(7));
                
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
        
    }
    
    public int getSoLuongThuThu() {
        String sql = "select count(users.userID) from users, people where users.userID = people.userID and vaiTro = N'Thủ thư'";
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
    
    public boolean updateThongTin(DocGia dg, int userID) {
        String sql = "update people set hoTen = ?, gioiTinh = ?, ngaySinh = ?, email = ? where userID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dg.getHoTen());
            ps.setString(2, dg.getGioiTinh());
            ps.setString(3, dg.getNgaySinh());
            ps.setString(4, dg.getEmail());
            ps.setInt(5, userID);
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
    
    public DocGia thongTinCaNhan(int userID) {
        String sql = "select * from people where userID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet res = ps.executeQuery();
            if(res.next()) {
                DocGia dg = new DocGia(res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(7));
                
                return dg;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }
    
    public DocGia thongTinCaNhan(String maDG) {
        String sql = "select * from people where maDG = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDG);
            ResultSet res = ps.executeQuery();
            if(res.next()) {
                DocGia dg = new DocGia(res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(7));
                
                return dg;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }
    
    public boolean updateThongTinCaNhan(DocGia dg, int userID) {
        String sql = "update people set hoTen = ?, gioiTinh = ?, ngaySinh = ?, doiTuong = ?, email = ? where userID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dg.getHoTen());
            ps.setString(2, dg.getGioiTinh());
            ps.setString(3, dg.getNgaySinh());
            ps.setString(4, dg.getDoiTuong());
            ps.setString(5, dg.getEmail());
            ps.setInt(6, userID);
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
}