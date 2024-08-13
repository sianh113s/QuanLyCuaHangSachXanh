/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import Database.*;
import Entities.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class WriteDataToDatabase {
    public static void ghi_TacGia_Vao_CSDL(TacGia tacGia) throws SQLException{
        String query = "insert into TacGia (MaTG,TenTG) values (?,?)";
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tacGia.getMaTG());
            preparedStatement.setNString(2, tacGia.getTenTG());
                
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
    public static void xoa_TacGia_Vao_CSDL(String maTacGia) throws SQLException{
        try{
            Connection connection = DatabaseManager.getConnection();
            
            String delSachQuery = "delete from Sach where MaTG = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(delSachQuery);
            preparedStatement.setString(1, maTacGia);
            preparedStatement.executeUpdate();
            
            String delTacGiaquery = "delete from TacGia where MaTG = ?";
            preparedStatement = connection.prepareStatement(delTacGiaquery);
            preparedStatement.setString(1, maTacGia);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void capNhat_TacGia_Vao_CSDL(TacGia tacGia) throws SQLException{
        String query = "update TacGia set TenTG = ? where MaTG = ?";
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tacGia.getTenTG());
            preparedStatement.setNString(2, tacGia.getMaTG());
                
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public static void ghi_Sach_Vao_CSDL(Sach sach) throws SQLException {
        String query = "insert into Sach (MaSach, TenSach, NamXuatBan, SoTrang, MaNXB, DonGia, SoLuongCon, MaTG) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, sach.getMaSach());
            preparedStatement.setNString(2, sach.getTenSach());
            preparedStatement.setInt(3, sach.getNamXuatBan());
            preparedStatement.setInt(4, sach.getSoTrang());
            preparedStatement.setString(5, sach.getMaNXB());
            preparedStatement.setFloat(6, sach.getDonGia());
            preparedStatement.setInt(7, sach.getSoLuongCon());
            preparedStatement.setString(8, sach.getMaTG());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void capNhat_Sach_Vao_CSDL(Sach sach) throws SQLException {
        String query = "update Sach set TenSach = ?, NamXuatBan = ?, SoTrang = ?, MaNXB = ?, DonGia = ?, SoLuongCon = ?, MaTG = ? where MaSach = ?";
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setNString(1, sach.getTenSach());
            preparedStatement.setInt(2, sach.getNamXuatBan());
            preparedStatement.setInt(3, sach.getSoTrang());
            preparedStatement.setString(4, sach.getMaNXB());
            preparedStatement.setFloat(5, sach.getDonGia());
            preparedStatement.setInt(6, sach.getSoLuongCon());
            preparedStatement.setString(7, sach.getMaTG());
            preparedStatement.setString(8, sach.getMaSach());
            
            preparedStatement.executeUpdate();

            preparedStatement.close();
            System.out.println("Đã ghi sách vào CSDL thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để xử lý ở nơi gọi
        }
    }
    public static void xoa_Sach_Vao_CSDL(String maSach) throws SQLException{
        String query = "delete from Sach where MaSach = ?";
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setNString(1, maSach);
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void giam_SoLuong_Sach_trong_CSDL(int soLuong,String maSach) throws SQLException{
        String query ="update Sach set SoLuongCon = SoLuongCon - ? where MaSach = ?";
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, soLuong);
            preparedStatement.setString(2, maSach);
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void ghi_SachTrongGioHang_Vao_CSDL(SachTrongGioHang sachTrongGioHang) throws SQLException{
        String query = "insert into SachTrongGioHang (MaTaiKhoan, MaSach, DonGia, SoLuong, ThanhTien) values (?, ?, ?, ?, ?)";
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setNString(1, sachTrongGioHang.getMaTaiKhoan());
            preparedStatement.setString(2, sachTrongGioHang.getSachDaChon().getMaSach());
            preparedStatement.setLong(3,(long) sachTrongGioHang.getSachDaChon().getDonGia());
            preparedStatement.setInt(4, sachTrongGioHang.getSoLuong());
            preparedStatement.setLong(5,(long) sachTrongGioHang.getThanhTien());
                
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null, "Có vẻ như bạn đã có loại sách này trong giỏ hàng, nếu muốn thay đổi số lượng hãy xóa sản phẩm và chọn lại số lượng!");
        }
    }
    public static void xoa_SachTrongGioHang_Vao_CSDL(String maSach , String maTaiKhoan) throws SQLException{
        String query = "delete from SachTrongGioHang where MaSach = ? and MaTaiKhoan = ?";
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setNString(1, maSach);
            preparedStatement.setNString(2, maTaiKhoan);
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void xoaALL_SachTrongGioHang_Vao_CSDL(String maTaiKhoan) throws SQLException{
        DatabaseToList.Doc_HoaDon_Tu_CSDL();
        String query = "delete from SachTrongGioHang";
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void ghi_HoaDon_Vao_CSDL(HoaDon hoaDon) throws SQLException{
        String query1 = "insert into HoaDon (MaHD, NgayGiaoDich, MaTaiKhoan, MaSach,SoLuong, ThanhTien) values (?, ?, ?, ?, ?,?)";
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setString(1, hoaDon.getMaHD());
            for(SachTrongGioHang sachTrongGioHang : hoaDon.getSachMua()){
                preparedStatement.setDate(2, Date.valueOf(hoaDon.getNgayGiaoDich()));
                preparedStatement.setNString(3, hoaDon.getTenKH());
                preparedStatement.setString(4, sachTrongGioHang.getSachDaChon().getMaSach());
                preparedStatement.setInt(5, sachTrongGioHang.getSoLuong());
                preparedStatement.setLong(6,(long) hoaDon.getThanhTien());
                
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void ghi_NhaXuatBan_Vao_CSDL(NhaXuatBan nhaXuatBan) throws SQLException{
        String query = "insert into NhaXuatBan (MaNXB,TenNXB,DiaChi,SDT) values (?,?,?,?)";
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, nhaXuatBan.getMaNXB());
            preparedStatement.setNString(2, nhaXuatBan.getTenNXB());
            preparedStatement.setNString(3, nhaXuatBan.getDiaChi());
            preparedStatement.setNString(4, nhaXuatBan.getSDT());
                
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void capNhat_NhaXuatBan_Trong_CSDL(NhaXuatBan nhaXuatBan) throws SQLException {
        String query = "update NhaXuatBan set TenNXB = ?, DiaChi = ?, SDT = ? where MaNXB = ?";
        try {
            Connection connection = DatabaseManager.getConnection();
        
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        
            preparedStatement.setNString(1, nhaXuatBan.getTenNXB());
            preparedStatement.setNString(2, nhaXuatBan.getDiaChi());
            preparedStatement.setNString(3, nhaXuatBan.getSDT());
            preparedStatement.setString(4, nhaXuatBan.getMaNXB());
        
            preparedStatement.executeUpdate();
            preparedStatement.close();       
        } catch (SQLException e) {
            e.printStackTrace();
        } 
}

    public static void xoa_NhaXuatBan_Tu_CSDL(String maNXB) throws SQLException {
        try {
            Connection connection = DatabaseManager.getConnection();
        
        // Xóa các sách có mã nhà xuất bản tương ứng
            String delSachQuery = "DELETE FROM Sach WHERE MaNXB = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(delSachQuery);
            preparedStatement.setString(1, maNXB);
        
        
        //Xóa nhà xuất bản từ bảng nhà xuất bản
            String deleteNXBQuery = "DELETE FROM NhaXuatBan WHERE MaNXB = ?";
            preparedStatement = connection.prepareStatement(deleteNXBQuery);
            preparedStatement.setString(1, maNXB);
            preparedStatement.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        } 
}

    public static void ghi_TaiKhoan_Vao_File(TaiKhoan taiKhoan) throws SQLException{
        String query = "insert into TaiKhoan (MaTaiKhoan,MatKhau,VaiTro) values (?,?,?)";
        try{
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setNString(1, taiKhoan.getMaTaiKhoan());
            preparedStatement.setNString(2, taiKhoan.getMatKhau());
            preparedStatement.setNString(3, taiKhoan.getVaiTro());
                
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void cap_Nhat_TaiKhoan(TaiKhoan taiKhoan) throws SQLException {
        String query = "UPDATE TaiKhoan SET MatKhau = ? WHERE MaTaiKhoan = ?";
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setNString(1, taiKhoan.getMatKhau());
            preparedStatement.setNString(2, taiKhoan.getMaTaiKhoan());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Cập nhật tài khoản thành công!");
        } catch(SQLException e) {
            e.printStackTrace();
        }
}

    public static void xoa_TaiKhoan_Tu_CSDL(String maTaiKhoan) throws SQLException {
        String query = "DELETE FROM TaiKhoan WHERE MaTaiKhoan = ?";
    
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setNString(1, maTaiKhoan);
        
            preparedStatement.executeUpdate();
        
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
