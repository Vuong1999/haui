using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;
using DataAccessLayer;
namespace BusinessLogicLayer
{
    public class qlDangNhap
    {
        Data da = new Data();
        public int Dangnhap(string txtUserName,string txtPass)
        {
            string sql = "SELECT Count(*) FROM Account WHERE (UserName='" + txtUserName + "') AND (PassWord='" + txtPass + "')";
            int x = (int)da.returnExNon(sql);
            return x;
        }
    }
}
