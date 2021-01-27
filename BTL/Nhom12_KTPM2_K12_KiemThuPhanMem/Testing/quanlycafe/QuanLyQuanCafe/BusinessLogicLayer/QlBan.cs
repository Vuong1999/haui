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
    public class QlBan
    {
        Data da = new Data();
        public DataTable ShowFoodCategory()
        {
            string sql = "SELECT*FROM FoodCategory";
            DataTable dt = new DataTable();
            dt = da.getTable(sql);
            return dt;
            
        }
        public DataTable ShowTableFood()
        {
            string sql = "SELECT*FROM TableFood";
            DataTable dt = new DataTable();
            dt = da.getTable(sql);
            return dt;
            
        }
        public DataTable ShowFood()
        {
            string sql = "SELECT*FROM Food";
            DataTable dt = new DataTable();
            dt = da.getTable(sql);
            return dt;

        }
        public void addMon(int cboMon,int txtSoLuong,int cboBan)
        {
            string sql = "INSERT INTO ThongKe VALUES('" + cboMon+ "','" + txtSoLuong+ "','" + cboBan + "')";
            da.ExNon(sql);
        }
        public void addMonHoaDon(int cboMon, int txtSoLuong, int cboBan)
        {
            string sql = "INSERT INTO ThanhToan VALUES('" + cboMon + "','" + txtSoLuong + "','" + cboBan + "')";
            da.ExNon(sql);
        }
        public void addTableFood(int cbo)
        {
            string sql = "UPDATE TableFood SET status='Có Khách' WHERE TableFood.id IN (SELECT ThongKe.idTable FROM Food,ThongKe WHERE (Food.id=ThongKe.idFood)) AND TableFood.id='"+cbo+"'";
            da.ExNon(sql);
        }
        public int AddColor(int cbo)
        {
            //string strConnection = @"Data Source=PC2009010100HVA\SQLEXPRESS;Initial Catalog=QuanLyQuanCafe;Integrated Security=True";
            //SqlConnection conn = new SqlConnection(strConnection);
            //conn.Open();
            string sql = "SELECT Count(*) FROM TableFood WHERE TableFood.status='Có Khách' AND TableFood.id='" + cbo + "'";
            //SqlCommand cmd = new SqlCommand(sql, conn);
            //int x = (int)cmd.ExecuteScalar();
            //return x;
            int x=da.returnExNon(sql);
            return x;
            

        }
        public void ChangeTableFood(int cbo)
        {
            string sql = "UPDATE TableFood SET status='trống' WHERE TableFood.id IN (SELECT ThongKe.idTable FROM Food,ThongKe WHERE (Food.id=ThongKe.idFood)) AND TableFood.id='" + cbo + "'";
            da.ExNon(sql);
        }
    }
}
