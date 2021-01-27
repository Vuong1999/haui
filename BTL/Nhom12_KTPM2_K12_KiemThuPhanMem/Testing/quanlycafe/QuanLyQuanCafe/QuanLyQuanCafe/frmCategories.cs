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
using System.Data.SqlClient;
using DataAccessLayer;
using BusinessLogicLayer;
namespace QuanLyQuanCafe
{
    public partial class frmCategories : Form
    {
        Category cate = new Category();

        
        public void Reload() {
            DataTable dt = new DataTable();
            dt = cate.ShowCategory();
            dgvCategoriesFood.DataSource = dt;
            txtCategory.Clear();
            idDanhMuc.Clear();
            btnSua.Enabled =false;
        
        }
        public frmCategories()
        {
            InitializeComponent();
        }

        
        
        private void frmCategories_Load(object sender, EventArgs e)
        {
           
            Reload();
        }

        private void btnThem_Click(object sender, EventArgs e)
        {
            string CategoryName = null;
            try
            {
                CategoryName = txtCategory.Text;
                if (CategoryName != "")
                {
                    try
                    {
                        cate.AddCategory(CategoryName);
                        Reload();
                    }
                    catch (Exception)
                    {
                        MessageBox.Show("Không thêm được");
                    }
                }
                else {
                    MessageBox.Show("Không thêm được");
                }
               
            }catch(FormatException){
                MessageBox.Show("Không thêm được");
            }
            
        }

        private void btnXoa_Click(object sender, EventArgs e)
        {
            string id = null;
            try
            {
                id = idDanhMuc.Text;
                if (id != "")
                {
                    try
                    {
                        cate.Del(id);
                        MessageBox.Show("Đã xóa xong");
                        Reload();
                    }catch(Exception){
                        MessageBox.Show("Không xóa được");
                    }
                }
                else {
                    MessageBox.Show("Không xóa được");
                }
            }catch(FormatException){
                MessageBox.Show("Không xóa được");
            }
        }

        private void btnXem_Click(object sender, EventArgs e)
        {
            Reload();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
