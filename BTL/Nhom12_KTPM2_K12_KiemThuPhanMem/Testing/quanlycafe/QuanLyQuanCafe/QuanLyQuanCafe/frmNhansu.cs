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
    public partial class frmNhansu : Form
    {
        QlNhanSu qlns = new QlNhanSu();
        public DataTable Reload() {
            DataTable dt = new DataTable();
            dt = qlns.ShowNV();
            dgvNhanSu.DataSource = dt;
            txtUserName.ResetText();
            txtName.ResetText();
            txtPass.ResetText();
            txtType.ResetText();
            return dt;
            
        }
        
      
        public frmNhansu()
        {
            InitializeComponent();
        }

        private void frmNhansu_Load(object sender, EventArgs e)
        {
            Reload();
        }

        private void btnThem_Click(object sender, EventArgs e)
        {
            
            string userName = null;
            string Name = null;
            string Pass = null;
            string Type = null;
            try
            {
                if (txtUserName.Text != "" && txtName.Text != "" && txtPass.Text != "" && txtType.Text != ""&&txtType.Text=="0"||txtType.Text=="1")
                {
                    userName = txtUserName.Text;
                    Name = txtName.Text;
                    Pass = txtPass.Text;
                    Type = txtType.Text;
                    try
                    {
                        qlns.AddNV(userName, Name, Pass, Type);
                        MessageBox.Show("Đã thêm thành công");
                        txtName.Clear();
                        txtPass.Clear();
                        txtType.Clear();
                        txtUserName.Clear();
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

        private void btnSua_Click(object sender, EventArgs e)
        {
           
            string userName = null;
            string Name = null;
            string Pass = null;
            string Type = null;
            try
            {
                if (txtUserName.Text != "" && txtName.Text != "" && txtPass.Text != "" && txtType.Text != "" &&txtType.Text=="0"||txtType.Text=="1")
                {
                userName = txtUserName.Text;
                Name = txtName.Text;
                Pass = txtPass.Text;
                Type = txtType.Text;
                try
                {
                    qlns.changNV(Name, Pass, Type, userName);
                    MessageBox.Show("Đã Sửa thành công");
                    txtType.Clear();
                    txtUserName.Clear();
                    txtPass.Clear();
                    txtName.Clear();
                    Reload();
                }catch(Exception){
                    MessageBox.Show("Không sửa đươc");
                }
            }else{
                MessageBox.Show("Không sửa được");
            }
            }
            catch(FormatException){
                MessageBox.Show("Không sửa được");
            }

        }

        private void btnXoa_Click(object sender, EventArgs e)
        {
            
            
            string userName = null;
            try
            {
                
                userName = txtUserName.Text;
                if (userName != "")
                {
                try
                {
                    qlns.del(userName);
                    MessageBox.Show("Xóa thành công");
                    Reload();
                }catch(Exception){
                    MessageBox.Show("Không xóa được");
                }
                }else{
                    MessageBox.Show("Không thể xóa");
                }
            }catch(FormatException){
                MessageBox.Show("Không thể xóa được");
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
