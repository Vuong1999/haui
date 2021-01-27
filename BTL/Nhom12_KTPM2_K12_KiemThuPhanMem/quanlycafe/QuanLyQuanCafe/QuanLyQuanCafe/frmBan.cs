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
    public partial class frmBan : Form
    {
        QlBan qlban = new QlBan();
        public void changColor()
        {

            int a = qlban.AddColor(1);
            if (a == 1)
            {
                lbl01.BackColor = Color.Red;
            }
            int b = qlban.AddColor(2);
            if (b == 1)
            {
                lbl02.BackColor = Color.Red;
            }
            int c = qlban.AddColor(3);
            if (c == 1)
            {
                lbl03.BackColor = Color.Red;
            }
            int d = qlban.AddColor(4);
            if (d == 1)
            {
                lbl04.BackColor = Color.Red;
            }
            int e = qlban.AddColor(5);
            if (e == 1)
            {
                lbl05.BackColor = Color.Red;
            }
            int f = qlban.AddColor(6);
            if (f == 1)
            {
                lbl06.BackColor = Color.Red;
            }
            int g = qlban.AddColor(7);
            if (g == 1)
            {
                lbl07.BackColor = Color.Red;
            }
            int h = qlban.AddColor(8);
            if (h == 1)
            {
                lbl08.BackColor = Color.Red;
            }
        }
       
        public void reload() {
            QlBan ql = new QlBan();
            DataTable dt = new DataTable();
            dt = ql.ShowFoodCategory();
            cboDanhMuc.DataSource = dt;
            cboDanhMuc.DisplayMember = "name";
            cboDanhMuc.ValueMember = "id";
            dt = ql.ShowFood();
            cboMon.DataSource = dt;
            cboMon.DisplayMember = "name";
            cboMon.ValueMember = "id";
            dt = ql.ShowTableFood();
            cboBan.DataSource = dt;
            cboBan.DisplayMember = "name";
            cboBan.ValueMember = "id";

            btnSuaMon.Enabled = false;
                
        }
        public frmBan()
        {
            InitializeComponent();
        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void frmBan_Load(object sender, EventArgs e)
        {
            reload();
            changColor();
        }

        private void btnThemMon_Click(object sender, EventArgs e)
        {
            
                if (txtSoLuong.Text != "")
                {
                    int Mon = Int32.Parse(cboMon.SelectedValue.ToString());
                    int sl = Int32.Parse(txtSoLuong.Text);
                    int danhmuc = Int32.Parse(cboBan.SelectedValue.ToString());
                   
                        qlban.addMon(Mon, sl, danhmuc);
                        qlban.addMonHoaDon(Mon, sl, danhmuc);
                        qlban.addTableFood(Int32.Parse(cboBan.SelectedValue.ToString()));
                        int a = qlban.AddColor(Int32.Parse(cboBan.SelectedValue.ToString()));
                        changColor();

                }
                else
                {
                    MessageBox.Show("Cần nhập số lượng");
                }
          
            
        }

        private void btnThanhToan_Click(object sender, EventArgs e)
        {
            qlban.ChangeTableFood(Int32.Parse(cboBan.SelectedValue.ToString()));
            HoaDonKhachHang hd = new HoaDonKhachHang();
            hd.Show();
          
            if(cboBan.Text=="bàn 1")
            {
                lbl01.BackColor = Color.Cyan;
            }
            if (cboBan.Text == "bàn 2")
            {
                lbl02.BackColor = Color.Cyan;
            }
            if (cboBan.Text == "bàn 3")
            {
                lbl03.BackColor = Color.Cyan;
            }
            if (cboBan.Text == "bàn 4")
            {
                lbl04.BackColor = Color.Cyan;
            }
            if (cboBan.Text == "bàn 5")
            {
                lbl05.BackColor = Color.Cyan;
            }
            if (cboBan.Text == "bàn 6")
            {
                lbl06.BackColor = Color.Cyan;
            } if (cboBan.Text == "bàn 7")
            {
                lbl07.BackColor = Color.Cyan;
            }
            if (cboBan.Text == "bàn 8")
            {
                lbl08.BackColor = Color.Cyan;
            }

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void lbl01_Click(object sender, EventArgs e)
        {

        }

        private void label11_Click(object sender, EventArgs e)
        {

        }

        private void cboMon_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void txtSoLuong_TextChanged(object sender, EventArgs e)
        {

        }

        private void cboBan_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void cboDanhMuc_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
