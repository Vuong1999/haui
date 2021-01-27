using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;
using DataAccessLayer;
namespace BusinessLogicLayer
{
    public class Food
    {
        Data da = new Data();
        public DataTable ShowFood()
        {
            string sql = "SELECT*FROM Food";
            DataTable dt = new DataTable();
            dt = da.getTable(sql);
            return dt;

        }
        public DataTable ShowCategory()
        {
            string sql = "SELECT*FROM FoodCategory";
            DataTable dt = new DataTable();
            dt = da.getTable(sql);
            return dt;

        }
        public void AddFood(string txtTen,int cboDanhMuc, float txtGia)
        {
           
                
                string add = "INSERT INTO Food VALUES (N'" + txtTen + "','" + cboDanhMuc + "','" + txtGia + "')";
                da.ExNon(add);
            
            
        }
        public void ChangeFood(string txtTen, int cboDanhMuc, float txtGia,int txtIdFood)
        {
            string change = "UPDATE Food SET name=N'" + txtTen + "',idCategory='" + cboDanhMuc + "',price='" + txtGia + "' WHERE id='" + txtIdFood + "'";
            da.ExNon(change);
        }
        public void DelFood( int txtIdFood)
        {
            string Del = "DELETE FROM Food WHERE id='" + txtIdFood + "'";
            da.ExNon(Del);
        }
       // public DataTable ShowComBo()
       // {
            //daCate = new SqlDataAdapter("SELECT*FROM FoodCategory", conn);
            //dtCate = new DataTable();
            //daCate.Fill(dtCate);
            //cboDanhMuc.DataSource = dtCate;
            //cboDanhMuc.DisplayMember = "name";
            //cboDanhMuc.ValueMember = "id";
            //(dgvThucDon.Columns["idCategory"] as DataGridViewComboBoxColumn).DataSource = dtCate;
            //(dgvThucDon.Columns["idCategory"] as DataGridViewComboBoxColumn).DisplayMember = "id";
      //  }

    }
}
