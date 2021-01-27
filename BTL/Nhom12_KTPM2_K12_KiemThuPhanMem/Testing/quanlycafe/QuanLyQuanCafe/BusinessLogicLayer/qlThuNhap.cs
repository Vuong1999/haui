using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;
using DataAccessLayer;
namespace BusinessLogicLayer
{
    public class qlThuNhap
    {
        Data da = new Data();
        public DataTable tongThuNhap()
        {
            DataTable dt = new DataTable();
            string sql = "SELECT SUM(ThongKe.SoLuong*Food.price) FROM ThongKe,Food,TableFood WHERE (ThongKe.idFood=Food.id) AND (ThongKe.idTable=TableFood.id)";
            dt = da.getTable(sql);
            return dt;
        }
        public void xoaDL()
        {
            string dt = "DELETE FROM ThongKe";
            da.ExNon(dt);
        }
    }
}
