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
    public partial class frmMenu : Form
    {
        public frmMenu()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            frmCategories cate = new frmCategories();
            cate.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            frmFood food = new frmFood();
            food.ShowDialog();
        }

        private void frmMenu_Load(object sender, EventArgs e)
        {

        }
    }
}
