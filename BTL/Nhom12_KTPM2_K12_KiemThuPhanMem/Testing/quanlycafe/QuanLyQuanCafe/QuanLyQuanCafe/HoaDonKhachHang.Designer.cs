namespace QuanLyQuanCafe
{
    partial class HoaDonKhachHang
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.dgvHoaDonKhachHang = new System.Windows.Forms.DataGridView();
            this.TENBAN = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.TENMON = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.SOLUONG = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.DONGIA = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.cboHoaDon = new System.Windows.Forms.ComboBox();
            this.btnXacNhan = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.dgvThanhToan = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.dgvHoaDonKhachHang)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvThanhToan)).BeginInit();
            this.SuspendLayout();
            // 
            // dgvHoaDonKhachHang
            // 
            this.dgvHoaDonKhachHang.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvHoaDonKhachHang.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.TENBAN,
            this.TENMON,
            this.SOLUONG,
            this.DONGIA});
            this.dgvHoaDonKhachHang.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.dgvHoaDonKhachHang.Location = new System.Drawing.Point(0, 188);
            this.dgvHoaDonKhachHang.Name = "dgvHoaDonKhachHang";
            this.dgvHoaDonKhachHang.Size = new System.Drawing.Size(839, 245);
            this.dgvHoaDonKhachHang.TabIndex = 0;
            // 
            // TENBAN
            // 
            this.TENBAN.DataPropertyName = "name";
            this.TENBAN.HeaderText = "TÊN BÀN";
            this.TENBAN.Name = "TENBAN";
            this.TENBAN.Width = 200;
            // 
            // TENMON
            // 
            this.TENMON.DataPropertyName = "name1";
            this.TENMON.HeaderText = "TÊN MÓN";
            this.TENMON.Name = "TENMON";
            this.TENMON.Width = 200;
            // 
            // SOLUONG
            // 
            this.SOLUONG.DataPropertyName = "SoLuongThanhToan";
            this.SOLUONG.HeaderText = "SỐ LƯỢNG";
            this.SOLUONG.Name = "SOLUONG";
            this.SOLUONG.Width = 200;
            // 
            // DONGIA
            // 
            this.DONGIA.DataPropertyName = "price";
            this.DONGIA.HeaderText = "ĐƠN GIÁ";
            this.DONGIA.Name = "DONGIA";
            this.DONGIA.Width = 200;
            // 
            // label1
            // 
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(197, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(394, 42);
            this.label1.TabIndex = 1;
            this.label1.Text = "Quản Lý ThanhToán";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(13, 78);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(169, 16);
            this.label2.TabIndex = 2;
            this.label2.Text = "Tên bàn cần thanh toán";
            // 
            // cboHoaDon
            // 
            this.cboHoaDon.FormattingEnabled = true;
            this.cboHoaDon.Location = new System.Drawing.Point(214, 78);
            this.cboHoaDon.Name = "cboHoaDon";
            this.cboHoaDon.Size = new System.Drawing.Size(121, 21);
            this.cboHoaDon.TabIndex = 3;
            // 
            // btnXacNhan
            // 
            this.btnXacNhan.Location = new System.Drawing.Point(367, 75);
            this.btnXacNhan.Name = "btnXacNhan";
            this.btnXacNhan.Size = new System.Drawing.Size(75, 23);
            this.btnXacNhan.TabIndex = 4;
            this.btnXacNhan.Text = "Xác Nhận";
            this.btnXacNhan.UseVisualStyleBackColor = true;
            this.btnXacNhan.Click += new System.EventHandler(this.btnXacNhan_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(482, 75);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 5;
            this.button1.Text = "Tính Tiền";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // dgvThanhToan
            // 
            this.dgvThanhToan.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvThanhToan.Location = new System.Drawing.Point(582, 54);
            this.dgvThanhToan.Name = "dgvThanhToan";
            this.dgvThanhToan.Size = new System.Drawing.Size(143, 78);
            this.dgvThanhToan.TabIndex = 6;
            // 
            // HoaDonKhachHang
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(839, 433);
            this.Controls.Add(this.dgvThanhToan);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.btnXacNhan);
            this.Controls.Add(this.cboHoaDon);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.dgvHoaDonKhachHang);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.MaximizeBox = false;
            this.Name = "HoaDonKhachHang";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "QUẢN LÝ THANH TOÁN";
            this.Load += new System.EventHandler(this.HoaDonKhachHang_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvHoaDonKhachHang)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvThanhToan)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dgvHoaDonKhachHang;
        private System.Windows.Forms.DataGridViewTextBoxColumn TENBAN;
        private System.Windows.Forms.DataGridViewTextBoxColumn TENMON;
        private System.Windows.Forms.DataGridViewTextBoxColumn SOLUONG;
        private System.Windows.Forms.DataGridViewTextBoxColumn DONGIA;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox cboHoaDon;
        private System.Windows.Forms.Button btnXacNhan;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.DataGridView dgvThanhToan;
    }
}