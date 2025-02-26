/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.PhieuMuonSach;
import model.PhieuMuonSachTable;
import util.ChuanHoa;
import util.NgayThangNam;

/**
 *
 * @author admin
 */
public class PhieuMuonSachDAO extends DAO{

    public PhieuMuonSachDAO() {
        super();
    }
    
    public String timTenDG(String maDG) {
        String sql = "select hoTen from people where maDG = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDG);
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                String tenDG = res.getString(1);
                return tenDG;
            } 
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return "-1";
        }
        return "-1";
    }
    
    public String timtenSach(String maSach) {
        String sql = "select tenSach from books where maSach = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSach);
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                String tenDG = res.getString(1);
                return tenDG;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return "-1";
        }
        return "-1";
    }
    
    public boolean addPhieuMuonSach(PhieuMuonSach phieu) {
        String sql = "insert into borrow(maDG, maSach, ngayMuon, soLuong, tinhTrang, ngayHenTra) values (?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, phieu.getMaDG());
            ps.setString(2, phieu.getMaSach());
            String ngayMuon = ChuanHoa.chuanHoaNgayThang(phieu.getNgayMuon());
            ps.setString(3, ngayMuon);
            ps.setInt(4, phieu.getSoLuong());
            ps.setInt(5, phieu.getTinhTrang());
            String ngayHenTra = ChuanHoa.chuanHoaNgayThang(phieu.getNgayHenTra());
            ps.setString(6, ngayHenTra);
            
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
    
    public void chapNhanPhieuMuon(int requestID) {
        String sql = "update request_borrow set status = 'accept' where requestID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, requestID);
            ps.executeUpdate();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean addRequestPhieuMuonSach(PhieuMuonSach phieu) {
        chapNhanPhieuMuon(phieu.getRequestID());
        String sql = "insert into borrow(maDG, maSach, ngayMuon, soLuong, tinhTrang, requestID, ngayHenTra) values (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, phieu.getMaDG());
            ps.setString(2, phieu.getMaSach());
            String date = ChuanHoa.chuanHoaNgayThang(phieu.getNgayMuon());
            ps.setString(3, date);
            ps.setInt(4, phieu.getSoLuong());
            ps.setInt(5, phieu.getTinhTrang());
            ps.setInt(6, phieu.getRequestID());
            ps.setString(7, phieu.getNgayHenTra());
            
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
    
    public void tuChoiPhieuMuon(int requestID) {
        String sql = "update request_borrow set status = 'reject' where requestID = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, requestID);
            ps.executeUpdate();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean yeuCauMuonSachDG(String maDG, String maSach, String ngayYeuCau) {
        String sql = "insert into request_borrow(maDG, maSach, ngayYeuCau) value (?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDG);
            ps.setString(2, maSach);
            String date = ChuanHoa.chuanHoaNgayThang(ngayYeuCau);
            ps.setString(3, date);
            
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
    
    public void traSach(int maMuon) {
        String sql = "update borrow set tinhTrang = 0, ngayTraThucTe = ? where maMuon = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, ChuanHoa.chuanHoaNgayThang(NgayThangNam.getBorrowDate()));
            ps.setInt(2, maMuon);
            ps.executeUpdate();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    
     public void deletePhieuMuonSach(int maMuon) {
        String sql = "delete from borrow where maMuon = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, maMuon);
            ps.executeUpdate();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    
    public int getSoLuongDocGiaMuonSach() {
        String sql = "select COUNT(distinct maDG) as soLuong from borrow group by maDG";
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
    
    
    public int getSoLuongPhieuChoPheDuyet() {
        String sql = "select COUNT(requestID) as soLuong from request_borrow where status = 'pending'";
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
    
    public DefaultTableModel getListPhieu() {
        String sql = "select * from borrow";
        String[] col = {"Mã mượn", "Mã ĐG", "Mã sách", "Họ tên", "Tên sách", "Ngày mượn", "Ngày hẹn trả", "Ngày trả thực tế", "Số lượng", "Tình trạng"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getInt(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                String hoTen = timTenDG(res.getString(2));
                vecto.add(hoTen);
                String tenSach = timtenSach(res.getString(3));
                vecto.add(tenSach);
                
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String ngayMuon = formatter.format(res.getDate(4));
                vecto.add(ngayMuon);
                
                String ngayhenTra = formatter.format(res.getDate(8));
                vecto.add(ngayhenTra);
                
                String ngayTraThucTe = "";
                if(res.getDate(9) != null) {
                    ngayTraThucTe = formatter.format(res.getDate(9));
                    vecto.add(ngayTraThucTe);
                }
                else
                    vecto.add(ngayTraThucTe);
                
                vecto.add(res.getInt(5));
                String tinhTrang = "";
                if(res.getInt(6) == 1) {
                    if(ngayhenTra.compareTo(ChuanHoa.chuanHoaNgayThang(NgayThangNam.getBorrowDate())) > 0)
                        tinhTrang += "Đang mượn";
                    else
                        tinhTrang += "Đã quá hạn";
                }
                else
                    tinhTrang += "Đã trả";
                vecto.add(tinhTrang);
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel getListPending() {
        String sql = "select * from request_borrow where status = 'pending' ";
        String[] col = {"RequestID", "Mã ĐG", "Mã sách", "Họ tên", "Tên sách", "Ngày yêu cầu", "Số lượng", "Tình trạng"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getInt(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                String hoTen = timTenDG(res.getString(2));
                vecto.add(hoTen);
                String tenSach = timtenSach(res.getString(3));
                vecto.add(tenSach);
                
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String ngayYeuCau = formatter.format(res.getDate(4));
                vecto.add(ngayYeuCau);
                
                int soLuong = 1;
                vecto.add(soLuong);
                
                String tinhTrang = "";
                if(res.getString(5).equals("pending")) {
                    tinhTrang += "Đang chờ phê duyệt";
                }
                vecto.add(tinhTrang);
                
                model.addRow(vecto);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public ArrayList<PhieuMuonSachTable> getAllPhieuMuon() {
        String sql = "select * from borrow";
        ArrayList<PhieuMuonSachTable> arr = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                String hoTen = timTenDG(res.getString(2));
                String tenSach = timtenSach(res.getString(3));
                String tinhTrang = "";
                if(res.getInt(6) == 1) {
                    if(res.getString(4).compareTo(res.getString(8)) <= 0)
                        tinhTrang += "Đang mượn";
                    else
                        tinhTrang += "Đã quá hạn";
                }
                else
                    tinhTrang += "Đã trả";
                
                PhieuMuonSachTable pm = new PhieuMuonSachTable(res.getInt(1), res.getString(2), res.getString(3), hoTen, tenSach, res.getString(4), res.getString(8), res.getString(9),res.getInt(5), tinhTrang);
                arr.add(pm);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }
    
    public DefaultTableModel getReaderOfBorrowRequestList(String maDG) {
        String sql = "select * from request_borrow where maDG = ?";
        String[] col = {"RequestID", "Mã ĐG", "Mã sách", "Tên sách", "Ngày yêu cầu", "Tình trạng"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDG);
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getInt(1));
                vecto.add(res.getString(2));
                vecto.add(res.getString(3));
                String tenSach = timtenSach(res.getString(3));
                vecto.add(tenSach);
                
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String ngayYeuCau = formatter.format(res.getDate(4));
                vecto.add(ngayYeuCau);
                
                String tinhTrang = "";
                if(res.getString(5).equals("pending")) {
                    tinhTrang += "Đang chờ phê duyệt";
                }
                else if(res.getString(5).equals("accept")) {
                    tinhTrang += "Chấp nhận";
                }
                else if(res.getString(5).equals("reject")) {
                    tinhTrang += "Từ chối";
                }
                vecto.add(tinhTrang);
                
                model.addRow(vecto);
            }  
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel getDanhSachYeuCauMuonSachPhu(String maDG) {
        String sql = "select * from request_borrow where maDG = ?";
        String[] col = {"Mã sách", "Tên sách", "Tình trạng"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDG);
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                Vector vecto = new Vector();
                vecto.add(res.getString(3));
                String tenSach = timtenSach(res.getString(3));
                vecto.add(tenSach);
                
                String tinhTrang = "";
                if(res.getString(5).equals("pending")) {
                    tinhTrang += "Đang chờ phê duyệt";
                }
                else if(res.getString(5).equals("accept")) {
                    tinhTrang += "Chấp nhận";
                }
                else if(res.getString(5).equals("reject")) {
                    tinhTrang += "Từ chối";
                }
                vecto.add(tinhTrang);
                
                model.addRow(vecto);
            }  
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
}
