using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace QuanLyQuanCafe
{
    public partial class frmChinh : Form
    {
        public frmChinh()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            frmNhansu frm = new frmNhansu();
            frm.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            frmMenu menu = new frmMenu();
            menu.ShowDialog();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            frmBan ban = new frmBan();
            ban.Show();
        }

        private void btnBanAn_Click(object sender, EventArgs e)
        {
            BanAn ba = new BanAn();
            ba.Show();
        }

        private void frmChinh_Load(object sender, EventArgs e)
        {

        }

        private void btnbaocao_Click(object sender, EventArgs e)
        {
            thanhtoan tt = new thanhtoan();
            tt.Show();
        }
    }
}
