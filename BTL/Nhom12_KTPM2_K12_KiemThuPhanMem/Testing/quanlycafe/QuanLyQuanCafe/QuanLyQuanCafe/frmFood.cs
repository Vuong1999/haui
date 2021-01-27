using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;
using BusinessLogicLayer;
using DataAccessLayer;
using System.Data;
namespace QuanLyQuanCafe
{
    public partial class frmFood : Form
    {
        Food fd = new Food();
        public void Reload() {
            DataTable dt = new DataTable();
            dt = fd.ShowFood();
            dgvThucDon.DataSource = dt;
            dt = fd.ShowCategory();
            cboDanhMuc.DataSource = dt;
            cboDanhMuc.DisplayMember = "name";
            cboDanhMuc.ValueMember = "id";
            (dgvThucDon.Columns["idCategory"] as DataGridViewComboBoxColumn).DataSource = dt;
            (dgvThucDon.Columns["idCategory"] as DataGridViewComboBoxColumn).DisplayMember = "id";
            txtTen.Clear();
            txtGia.Clear();
            txtIdFood.Clear();
        }
       
       
        public frmFood()
        {
            InitializeComponent();
        }

        private void frmFood_Load(object sender, EventArgs e)
        {
            Reload();
         
        }

        private void btnThem_Click(object sender, EventArgs e)
        {
            
            int danhmuc = 0;
            float gia = 0;
            try
            {
                 danhmuc = (int)cboDanhMuc.SelectedValue;
                 gia = Single.Parse(txtGia.Text);
                 try
                 {
                     fd.AddFood(txtTen.Text, danhmuc, gia);
                     Reload();
                     MessageBox.Show("Thêm thành công!");
                 }
                 catch (SqlException)
                 {
                     MessageBox.Show("không Thêm được");
                 }

            }catch(FormatException){
                MessageBox.Show("Không thêm được", "Báo lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
          

        }

        private void btnSua_Click(object sender, EventArgs e)
        {
            
            int danhmuc = 0;
            float gia = 0;
            int id;
            try
            {
                danhmuc = (int)cboDanhMuc.SelectedValue;
                gia = Single.Parse(txtGia.Text);
                id = Int16.Parse(txtIdFood.Text);
                try
                {
                    fd.ChangeFood(txtTen.Text, danhmuc, gia, id);
                    Reload();
                    MessageBox.Show(" Sửa thành công!");
                }
                catch (SqlException)
                {
                    MessageBox.Show("không Sửa được");
                }

            }
            catch (FormatException)
            {
                MessageBox.Show("Không sửa được", "Báo lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            
           

        }

        private void btnXoa_Click(object sender, EventArgs e)
        {
          
            int id;
            try
            {
               
                id = Int16.Parse(txtIdFood.Text);
                try
                {
                   fd.DelFood(id);
                    Reload();
                    MessageBox.Show(" Xóa thành công!");
                }
                catch (SqlException)
                {
                    MessageBox.Show("không xóa được");
                }

            }
            catch (FormatException)
            {
                MessageBox.Show("Không xóa được", "Báo lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            
           

        }
            
          
        

        private void btnXem_Click(object sender, EventArgs e)
        {
            Reload();
          
        }

        private void txtGia_TextChanged(object sender, EventArgs e)
        {

        }
    }
}

