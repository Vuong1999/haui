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
    public class QlBanAn
    {
        Data da = new Data();
        public DataTable ShowTable()
        {
            string sql = "SELECT*FROM TableFood";
            DataTable dt = new DataTable();
            dt = da.getTable(sql);
            return dt;

        }
        public void AddTable(string txtTenBan,string txtTinhTrang)
        {
            string add = "INSERT INTO TableFood  VALUES (N'" + txtTenBan + "',N'" + txtTinhTrang + "'  )";
            da.ExNon(add);

        }
        public void ChangeTable(string txtTenBan,string txtTinhTrang,int txtIDban)
        {
            string change = "UPDATE TableFood SET  name=N'" + txtTenBan + "',status=N'" + txtTinhTrang + "' WHERE id='" + txtIDban + "'";
            da.ExNon(change);
        }
        public void DelTable(int txtIDban)
        {
            string Del = "DELETE FROM TableFood WHERE id='" + txtIDban + "'";
            da.ExNon(Del);
        }
    }
}
