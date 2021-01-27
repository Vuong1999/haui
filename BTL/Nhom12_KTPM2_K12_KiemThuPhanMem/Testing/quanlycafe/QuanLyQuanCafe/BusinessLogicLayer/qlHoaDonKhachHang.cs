using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;
using DataAccessLayer;
namespace BusinessLogicLayer
{
    public class qlHoaDonKhachHang
    {
        Data da = new Data();
        public DataTable ShowHoaDon(string cbo) {
            DataTable dt = new DataTable();
            string sql = "SELECT TableFood.name,Food.name,SoLuongThanhToan,price FROM ThanhToan,Food,TableFood  WHERE (ThanhToan.idFoodThanhToan=Food.id) AND (ThanhToan.idTableThanhToan=TableFood.id) AND (TableFood.name='"+cbo+"')";
            dt = da.getTable(sql);
            return dt;
        }
        public DataTable Load()
        {
            DataTable dt = new DataTable();
            string sql = "SELECT*FROM TableFood";
            dt = da.getTable(sql);
            return dt;
        }
        public DataTable tinhtien(string cbo)
        {
            DataTable dt = new DataTable();
            string sql = "SELECT SUM(ThanhToan.SoLuongThanhToan*Food.price) FROM ThanhToan,Food,TableFood WHERE (ThanhToan.idFoodThanhToan=Food.id) AND (ThanhToan.idTableThanhToan=TableFood.id) AND (TableFood.name='"+cbo+"')";
            dt = da.getTable(sql);
            return dt;
        }
        public void xoaDuLieu(int cbo)
        {
            string sql = "DELETE FROM ThanhToan WHERE ThanhToan.idTableThanhToan IN(SELECT TableFood.id FROM TableFood WHERE TableFood.id='" + cbo + "')";
            da.ExNon(sql);
        }
    }
}
