/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Sach;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author admin
 */
public class SachDAO extends DAO{

    public SachDAO() {
        super();
    }
    
    public boolean addSach(Sach s) {
        String sql = "insert into books values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getTacGia());
            ps.setString(4, s.getNhaXB());
            ps.setInt(5, s.getSoLuong());
            
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
    
    public boolean deleteSach(String maSach) {
        String sql = "delete from books where maSach = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSach);
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
    
    public int getSoLuongSach() {
        String sql = "select soLuong from books";
        try {
            int sum = 0;
            Statement st = con.createStatement();
            ResultSet set = st.executeQuery(sql);
            while(set.next()) {
                sum += Integer.parseInt(set.getString("soLuong"));
            }
            return sum;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public DefaultTableModel getSachList() {
        String sql = "select * from books";
        String[] col = {"Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Số lượng"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getString(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                vecto.add(res.getString(4));
                vecto.add(res.getInt(5));
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public ArrayList<Sach> getAllSach() {
        String sql = "select * from books";
        ArrayList<Sach> arr = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Sach s = new Sach(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5));
                arr.add(s);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }
    
    public DefaultTableModel timKiemTheoMaSach(String maSach) {
        String sql = "select * from books where maSach LIKE ?";
        String[] col = {"Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Số lượng", "Tình trạng"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            String s = "%" + maSach + "%";
            ps.setString(1, s);
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getString(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                vecto.add(res.getString(4));
                vecto.add(res.getInt(5));
                String tinhTrang = "";
                if(res.getInt(5) > 0)
                    tinhTrang += "CÒN";
                else
                    tinhTrang += "HẾT";
                vecto.add(tinhTrang);
                
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel timKiemTheoTenSach(String tenSach) {
        String sql = "select * from books where tenSach LIKE ?";
        String[] col = {"Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Số lượng", "Tình trạng"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            String s = "%" + tenSach + "%";
            ps.setString(1, s);
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getString(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                vecto.add(res.getString(4));
                vecto.add(res.getInt(5));
                String tinhTrang = "";
                if(res.getInt(5) > 0)
                    tinhTrang += "CÒN";
                else
                    tinhTrang += "HẾT";
                vecto.add(tinhTrang);
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel timKiemTheoTacGia(String tacGia) {
        String sql = "select * from books where tacGia LIKE ?";
        String[] col = {"Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Số lượng", "Tình trạng"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            String s = "%" + tacGia + "%";
            ps.setString(1, s);
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getString(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                vecto.add(res.getString(4));
                vecto.add(res.getInt(5));
                String tinhTrang = "";
                if(res.getInt(5) > 0)
                    tinhTrang += "CÒN";
                else
                    tinhTrang += "HẾT";
                vecto.add(tinhTrang);
                
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel timKiemTheoNXB(String nhaXuatBan) {
        String sql = "select * from books where nhaXuatBan LIKE ?";
        String[] col = {"Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Số lượng", "Tình trạng"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            String s = "%" + nhaXuatBan + "%";
            ps.setString(1, s);
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getString(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                vecto.add(res.getString(4));
                vecto.add(res.getInt(5));
                
                String tinhTrang = "";
                if(res.getInt(5) > 0)
                    tinhTrang += "CÒN";
                else
                    tinhTrang += "HẾT";
                vecto.add(tinhTrang);
                
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public boolean updateSach(Sach s, String maSachCu) {
        String sql = "update books set maSach = ?, tenSach = ?, tacGia = ?, nhaXuatBan = ?, soLuong = ? where maSach = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getTacGia());
            ps.setString(4, s.getNhaXB());
            ps.setInt(5, s.getSoLuong());
            ps.setString(6, maSachCu);
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
