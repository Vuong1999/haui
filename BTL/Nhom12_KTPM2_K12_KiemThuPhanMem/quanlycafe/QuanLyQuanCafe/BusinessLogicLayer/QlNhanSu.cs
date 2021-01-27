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
    public class QlNhanSu
    {
        Data da = new Data();
        public DataTable ShowNV()
        {
            string sql = "SELECT*FROM Account";
            DataTable dt = new DataTable();
            dt = da.getTable(sql);
            return dt;

        }
        public void AddNV(string txtUserName,string txtName,string txtPass,string txtType) {
            string sql = "INSERT INTO Account VALUES (N'" + txtUserName + "',N'" + txtName + "','" + txtPass + "','" + txtType + "')";
            da.ExNon(sql);
        }
        public void changNV(string txtName,string txtPass,string txtType,string txtUserName) {
            string sql = "UPDATE Account SET DisplayName=N'" + txtName+ "',PassWord='" + txtPass + "',Type='" + txtType + "' WHERE UserName='" + txtUserName+ "'";
            da.ExNon(sql);
        }
        public void del(string txtUserName)
        {
            string sql = "DELETE FROM Account WHERE UserName='" + txtUserName+ "'";
            da.ExNon(sql);
        }
    }
}
