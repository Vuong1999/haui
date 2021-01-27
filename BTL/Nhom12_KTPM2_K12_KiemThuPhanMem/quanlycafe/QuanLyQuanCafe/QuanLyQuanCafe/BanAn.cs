using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;
using DataAccessLayer;
using BusinessLogicLayer;
namespace QuanLyQuanCafe
{
    public partial class BanAn : Form
    {
        QlBanAn ql = new QlBanAn();
        public void Reload()
        {
            DataTable dt = new DataTable();
            dt = ql.ShowTable();
            dgvBanAn.DataSource = dt;
            txtIDban.Clear();
            txtTenBan.Clear();
            txtTinhTrang.Clear();
        }
       

        
        public BanAn()
        {
            InitializeComponent();
        }

        private void btnThembanan_Click(object sender, EventArgs e)
        {
            string tenban = null;
            string tinhtrang = null;
            try
            {

                tenban = txtTenBan.Text;
                tinhtrang = txtTinhTrang.Text;
                try
                {
                    if (tenban == "" || tinhtrang == "")
                    {
                        MessageBox.Show("Không thêm được");
                    }
                    else
                    {
                        ql.AddTable(tenban, tinhtrang);
                        MessageBox.Show("Đã thêm thành công");
                        Reload();
                    }
                }catch(Exception){

                    MessageBox.Show("Không thêm được");
                }
            }catch(FormatException){
                MessageBox.Show("Không thêm được");
            }
           
        }

        private void btnSuabanan_Click(object sender, EventArgs e)
        {
            string tenban = null;
            string tinhtrang = null;
            int Id = 0;
            try
            {
                tenban = txtTenBan.Text;
                tinhtrang = txtTinhTrang.Text;
                Id = Int32.Parse(txtIDban.Text);
                if (tenban != "" && tinhtrang != "" && Id != 0)
                {
                    try
                    {

                        ql.ChangeTable(tenban, tinhtrang, Id);
                        MessageBox.Show("Đã sửa thành công");
                        Reload();
                    }
                    catch (Exception)
                    {
                        MessageBox.Show("Không sửa được");
                    }
                }
                else {
                    MessageBox.Show("Không sửa được");
                }
            }catch(FormatException){
                MessageBox.Show("Không Sửa được");
            }
            
        }

        private void btnXoabanan_Click(object sender, EventArgs e)
        {
            int Id = 0;
            try
            {
                Id = Int32.Parse(txtIDban.Text);
                try
                {
                    ql.DelTable(Id);
                    MessageBox.Show("Đã xóa thành công");
                    Reload();
                }catch(Exception){
                    MessageBox.Show("Không xóa được");
                }
            }catch(FormatException){
                MessageBox.Show("Không xóa được");
            
            }
        }

        private void btnXembanan_Click(object sender, EventArgs e)
        {
            Reload();
        }

        private void BanAn_Load(object sender, EventArgs e)
        {

        }
    }
}
