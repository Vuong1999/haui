using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;
using DataAccessLayer;
using BusinessLogicLayer;
namespace BusinessLogicLayer
{
     public class QlThanhToan
    {
         Data da = new Data();
         public DataTable Reload()
         {
             string sql = "SELECT TableFood.name,Food.name,SoLuong,price FROM ThongKe,Food,TableFood  WHERE (ThongKe.idFood=Food.id) AND(ThongKe.idTable=TableFood.id)";
             DataTable dt = new DataTable();
             dt = da.getTable(sql);
             return dt;
         }
         public DataTable TinhTien(string txtBan)
         {
             string sql = "SELECT SUM(ThongKe.SoLuong*Food.price) FROM ThongKe,Food,TableFood WHERE (ThongKe.idFood=Food.id) AND TableFood.name='" + txtBan + "'";
             DataTable dt = new DataTable();
             dt = da.getTable(sql);
             return dt;
         }
    }
}
