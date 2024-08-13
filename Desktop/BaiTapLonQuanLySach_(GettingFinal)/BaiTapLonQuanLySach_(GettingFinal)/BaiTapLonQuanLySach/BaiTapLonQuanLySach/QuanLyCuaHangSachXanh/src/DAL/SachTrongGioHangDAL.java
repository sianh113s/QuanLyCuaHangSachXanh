/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import Entities.SachTrongGioHang;
import Tools.DatabaseToList;
import Tools.WriteDataToDatabase;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SachTrongGioHangDAL {
    public static ArrayList<SachTrongGioHang> showAll(){
        try{
            ArrayList<SachTrongGioHang> a = DatabaseToList.Doc_SachTrongGioHang_Tu_CSDL();
            
            return a;
        }
        catch(SQLException e){
            return null;
        }
    }
    
    public static ArrayList<SachTrongGioHang> show(String maTaiKhoan) throws SQLException{
        try{
            ArrayList<SachTrongGioHang> a = DatabaseToList.Doc_SachTrongGioHang_Tu_CSDL(), b = new ArrayList<SachTrongGioHang>();
            for(SachTrongGioHang i:a){
                if(i.getMaTaiKhoan().equals(maTaiKhoan))
                    b.add(i);
            }
            return b;
        }
        catch(SQLException e){
            return null;
        }
    }
    
    public static int showSoLuong(String maTaiKhoan) throws SQLException{
        try{
            int t=0;
            ArrayList<SachTrongGioHang> a = DatabaseToList.Doc_SachTrongGioHang_Tu_CSDL(), b = new ArrayList<SachTrongGioHang>();
            for(SachTrongGioHang i:a){
                if(i.getMaTaiKhoan().equals(maTaiKhoan))
                    t+=i.getSoLuong();
            }
            return t;
        }
        catch(SQLException e){
            return 0;
        }
    }
    
    public static Double showthanhTien(String maTaiKhoan) throws SQLException{
        try{
            Double t=0.0;
            ArrayList<SachTrongGioHang> a = DatabaseToList.Doc_SachTrongGioHang_Tu_CSDL(), b = new ArrayList<SachTrongGioHang>();
            for(SachTrongGioHang i:a){
                if(i.getMaTaiKhoan().equals(maTaiKhoan))
                    t+=i.getThanhTien();
            }
            return t;
        }
        catch(SQLException e){
            return 0.0;
        }
    }
    
    public static boolean insert(ArrayList<SachTrongGioHang> list, SachTrongGioHang a) throws IOException, SQLException{
        if(a.getMaTaiKhoan().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng đăng nhập để thực hiện");
            return false;
        }
        list.add(a);
        WriteDataToDatabase.ghi_SachTrongGioHang_Vao_CSDL(a);
        return true;
    }
    
    
    
    public static boolean delete(ArrayList<SachTrongGioHang> list, SachTrongGioHang a) throws IOException, SQLException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaTaiKhoan().equals(list.get(i).getMaTaiKhoan()) && 
                    a.getSachDaChon().getMaSach().equals(list.get(i).getSachDaChon().getMaSach())){
                index = i;
            }
        if(index!=-1){
            list.remove(index);
            WriteDataToDatabase.xoa_SachTrongGioHang_Vao_CSDL(a.getSachDaChon().getMaSach(),a.getMaTaiKhoan());
            return true;
        }
        else
        return false;
    }
}
