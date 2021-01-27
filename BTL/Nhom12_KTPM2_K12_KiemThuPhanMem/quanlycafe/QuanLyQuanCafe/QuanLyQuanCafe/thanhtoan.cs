using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;
using System.Data;
using DataAccessLayer;
using BusinessLogicLayer;
namespace QuanLyQuanCafe
{
    public partial class thanhtoan : Form
    {
        QlThanhToan qltt = new QlThanhToan();
        qlThuNhap thunhap = new qlThuNhap();
        public void Reload()
        {
            DataTable dt = new DataTable();
            dt = qltt.Reload();
            dgvThanhToan.DataSource = dt;
        }
        public void TongThuNhap()
        {
            DataTable dt = new DataTable();
            dt = thunhap.tongThuNhap();
            dgvThuNhap.DataSource = dt;
        }

       
        public thanhtoan()
        {
            InitializeComponent();
        }

        private void thanhtoan_Load(object sender, EventArgs e)
        {
            Reload();
        }

        private void btnDongy_Click(object sender, EventArgs e)
        {
            Reload();
        }

        private void btnIn_Click(object sender, EventArgs e)
        {
            
            

        }

        private void button1_Click(object sender, EventArgs e)
        {
            //qlThuNhap();
            //TongThuNhap();
        }

        private void btnThuNhap_Click(object sender, EventArgs e)
        {
            TongThuNhap();
        }

        private void btnReset_Click(object sender, EventArgs e)
        {
            thunhap.xoaDL();
            Reload();
        }
    }
}
