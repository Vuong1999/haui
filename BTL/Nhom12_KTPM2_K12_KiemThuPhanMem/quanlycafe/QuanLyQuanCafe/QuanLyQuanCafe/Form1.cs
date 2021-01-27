using System;
using System.Windows.Forms;
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
            try
            {
                int x = dangnhap.Dangnhap(txtUserName.Text,txtPass.Text);
                if (x==1)
                {
                    frmChinh frm = new frmChinh();
                    frm.Show();
                    this.Hide();
                }
                else{
                    MessageBox.Show("Đăng nhập thất bại");
                }
            }
            catch (Exception)
            {
                MessageBox.Show("Đăng nhập thất bại");
            }

            
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
