package hotelmanagement.DAL;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import hotelmanagement.DTO.DichVuDTO;
import java.util.ArrayList;


public class DichVuDAL {
    private static DichVuDAL instance;
    private ArrayList<DichVuDTO> DSDichVu;
    
    private DichVuDAL() {
        this.DSDichVu = new ArrayList<DichVuDTO>();
        loadData();
    }
    
    public static DichVuDAL getInstance() {
        if (instance == null){
            instance = new DichVuDAL();
        }
        return instance;
    }
    
    public ArrayList<DichVuDTO> loadData() {
        String query = "SELECT * FROM DichVu";
        try {
            ResultSet rs = DAL.getInstance().executeQueryToGetData(query);
            while (rs.next()) {
                DichVuDTO DichVu = new DichVuDTO();
                DichVu.setMaDichVu(rs.getInt("madichvu"));
                DichVu.setTenDichVu(rs.getString("tendichvu"));
                DecimalFormat df = new DecimalFormat("#,###.00");
                
                DichVu.setTien(df.format(rs.getBigDecimal("tien")));
                DichVu.setSoLuong(rs.getInt("soluong"));
                DichVu.setThanhTien(df);
                DichVu.setGhiChu(rs.getString("ghichu"));
                this.DSDichVu.add(DichVu);


               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.DSDichVu;
    } 

   

    
}