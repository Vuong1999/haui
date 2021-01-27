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
    public partial class Form1 : Form
    {
        qlDangNhap dangnhap = new qlDangNhap();
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            frmChinh frm = new frmChinh();
            frm.Show();
            this.Hide();


        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
