using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;
namespace DataAccessLayer
{
    public class Data
    {
        //Hàm kết nối
        public SqlConnection getConnect()
        {
            return new SqlConnection(@"Data Source=PC2009010100HVA\SQLEXPRESS;Initial Catalog=QuanLyQuanCafe;Integrated Security=True");
        }
        public void khoitao() {
            SqlConnection conn = null;
            SqlDataAdapter da = null;
            DataTable dt = null;
        }
        //Hàm sql trả về 1 bảng
        public DataTable getTable(string sql)
        {
            SqlConnection conn = getConnect();
            SqlDataAdapter da = new SqlDataAdapter(sql, conn);
            DataTable dt = new DataTable();
            da.Fill(dt);
            return dt;
        }
        //hàm sql không trả về bảng
        public void ExNon(string sql)
        {
            SqlConnection conn = getConnect();
            conn.Open();
            SqlCommand cmd = new SqlCommand(sql, conn);
            cmd.ExecuteNonQuery();
            cmd.Dispose();
            cmd.Clone();
        }
        //hàm sql không trả về bảng nhưng return giá trị
        public int returnExNon(string sql)
        {
            SqlConnection conn = getConnect();
            conn.Open();
            SqlCommand cmd = new SqlCommand(sql, conn);
            int x =(int) cmd.ExecuteScalar();
            return x;
            
        }
    }
}
