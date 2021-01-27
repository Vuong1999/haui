using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;
using DataAccessLayer;
namespace BusinessLogicLayer
{
    public class Category
    {
        Data da = new Data();
        //Load dữ liệu lên datagrview trong Form Category
        public DataTable ShowCategory() {
            string sql = "SELECT*FROM FoodCategory";
            DataTable dt = new DataTable();
            dt = da.getTable(sql);
            return dt;
            
        }
        public void AddCategory( string txtCategory) {
            string add = "INSERT INTO FoodCategory VALUES (N'" + txtCategory + "'  )";
            da.ExNon(add);
            
        }
        public void Del(string txtDanhMuc)
        {
            string del = "DELETE FROM FoodCategory WHERE id='" + txtDanhMuc + "'";
            da.ExNon(del);
        }
    }
}
