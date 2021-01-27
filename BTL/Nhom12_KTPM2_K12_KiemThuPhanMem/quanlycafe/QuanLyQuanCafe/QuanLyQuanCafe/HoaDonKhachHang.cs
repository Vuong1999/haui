using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data;
using System.Data.SqlClient;
using DataAccessLayer;
using BusinessLogicLayer;
namespace QuanLyQuanCafe
{
    public partial class HoaDonKhachHang : Form
    {
        qlHoaDonKhachHang ql = new qlHoaDonKhachHang();
        public void load()
        {
            DataTable dt = new DataTable();
            dt = ql.Load();
            cboHoaDon.DataSource = dt;
            cboHoaDon.DisplayMember = "name";
            cboHoaDon.ValueMember = "id";
            

        
        }
        public void tinhtien(){
            DataTable dt = new DataTable();
            dt = ql.tinhtien(cboHoaDon.Text);
            dgvThanhToan.DataSource = dt;

        }
        public void reload()
        {
            DataTable dt = new DataTable();
            dt=ql.ShowHoaDon(cboHoaDon.Text);
            dgvHoaDonKhachHang.DataSource = dt;
        }
        public void xoadulieu() {
            ql.xoaDuLieu(Int32.Parse(cboHoaDon.SelectedValue.ToString()));
        }
        public HoaDonKhachHang()
        {
            InitializeComponent();
        }

        private void HoaDonKhachHang_Load(object sender, EventArgs e)
        {
            load();
            
        }

        private void btnXacNhan_Click(object sender, EventArgs e)
        {
            reload();

        }

        private void button1_Click(object sender, EventArgs e)
        {
            tinhtien();
            xoadulieu();
        }
    }
}
