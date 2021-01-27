namespace QuanLyQuanCafe
{
    partial class BanAn
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
            this.btnThembanan = new System.Windows.Forms.Button();
            this.btnSuabanan = new System.Windows.Forms.Button();
            this.btnXoabanan = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.btnXembanan = new System.Windows.Forms.Button();
            this.panel2 = new System.Windows.Forms.Panel();
            this.dgvBanAn = new System.Windows.Forms.DataGridView();
            this.idb = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.TENB = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.STT = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.panel3 = new System.Windows.Forms.Panel();
            this.panel6 = new System.Windows.Forms.Panel();
            this.txtTinhTrang = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.panel5 = new System.Windows.Forms.Panel();
            this.txtTenBan = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.panel4 = new System.Windows.Forms.Panel();
            this.txtIDban = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvBanAn)).BeginInit();
            this.panel3.SuspendLayout();
            this.panel6.SuspendLayout();
            this.panel5.SuspendLayout();
            this.panel4.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnThembanan
            // 
            this.btnThembanan.Location = new System.Drawing.Point(4, 4);
            this.btnThembanan.Name = "btnThembanan";
            this.btnThembanan.Size = new System.Drawing.Size(75, 65);
            this.btnThembanan.TabIndex = 0;
            this.btnThembanan.Text = "Thêm";
            this.btnThembanan.UseVisualStyleBackColor = true;
            this.btnThembanan.Click += new System.EventHandler(this.btnThembanan_Click);
            // 
            // btnSuabanan
            // 
            this.btnSuabanan.Location = new System.Drawing.Point(85, 4);
            this.btnSuabanan.Name = "btnSuabanan";
            this.btnSuabanan.Size = new System.Drawing.Size(75, 65);
            this.btnSuabanan.TabIndex = 0;
            this.btnSuabanan.Text = "Sửa";
            this.btnSuabanan.UseVisualStyleBackColor = true;
            this.btnSuabanan.Click += new System.EventHandler(this.btnSuabanan_Click);
            // 
            // btnXoabanan
            // 
            this.btnXoabanan.Location = new System.Drawing.Point(166, 3);
            this.btnXoabanan.Name = "btnXoabanan";
            this.btnXoabanan.Size = new System.Drawing.Size(75, 66);
            this.btnXoabanan.TabIndex = 0;
            this.btnXoabanan.Text = "Xóa";
            this.btnXoabanan.UseVisualStyleBackColor = true;
            this.btnXoabanan.Click += new System.EventHandler(this.btnXoabanan_Click);
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.btnXembanan);
            this.panel1.Controls.Add(this.btnXoabanan);
            this.panel1.Controls.Add(this.btnSuabanan);
            this.panel1.Controls.Add(this.btnThembanan);
            this.panel1.Location = new System.Drawing.Point(12, 12);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(324, 72);
            this.panel1.TabIndex = 0;
            // 
            // btnXembanan
            // 
            this.btnXembanan.Location = new System.Drawing.Point(247, 4);
            this.btnXembanan.Name = "btnXembanan";
            this.btnXembanan.Size = new System.Drawing.Size(75, 66);
            this.btnXembanan.TabIndex = 0;
            this.btnXembanan.Text = "Xem";
            this.btnXembanan.UseVisualStyleBackColor = true;
            this.btnXembanan.Click += new System.EventHandler(this.btnXembanan_Click);
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.dgvBanAn);
            this.panel2.Location = new System.Drawing.Point(16, 90);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(391, 322);
            this.panel2.TabIndex = 1;
            // 
            // dgvBanAn
            // 
            this.dgvBanAn.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvBanAn.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idb,
            this.TENB,
            this.STT});
            this.dgvBanAn.Location = new System.Drawing.Point(3, 3);
            this.dgvBanAn.Name = "dgvBanAn";
            this.dgvBanAn.Size = new System.Drawing.Size(372, 292);
            this.dgvBanAn.TabIndex = 0;
            // 
            // idb
            // 
            this.idb.DataPropertyName = "id";
            this.idb.HeaderText = "ID";
            this.idb.Name = "idb";
            this.idb.Width = 110;
            // 
            // TENB
            // 
            this.TENB.DataPropertyName = "name";
            this.TENB.HeaderText = "TÊN BÀN";
            this.TENB.Name = "TENB";
            this.TENB.Width = 110;
            // 
            // STT
            // 
            this.STT.DataPropertyName = "status";
            this.STT.HeaderText = "TRẠNG THÁI";
            this.STT.Name = "STT";
            this.STT.Width = 110;
            // 
            // panel3
            // 
            this.panel3.Controls.Add(this.panel6);
            this.panel3.Controls.Add(this.panel5);
            this.panel3.Controls.Add(this.panel4);
            this.panel3.Location = new System.Drawing.Point(433, 87);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(481, 322);
            this.panel3.TabIndex = 2;
            // 
            // panel6
            // 
            this.panel6.Controls.Add(this.txtTinhTrang);
            this.panel6.Controls.Add(this.label3);
            this.panel6.Location = new System.Drawing.Point(0, 156);
            this.panel6.Name = "panel6";
            this.panel6.Size = new System.Drawing.Size(465, 43);
            this.panel6.TabIndex = 2;
            // 
            // txtTinhTrang
            // 
            this.txtTinhTrang.Location = new System.Drawing.Point(77, 11);
            this.txtTinhTrang.Name = "txtTinhTrang";
            this.txtTinhTrang.Size = new System.Drawing.Size(247, 20);
            this.txtTinhTrang.TabIndex = 1;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(16, 11);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(55, 13);
            this.label3.TabIndex = 0;
            this.label3.Text = "Tình trạng";
            // 
            // panel5
            // 
            this.panel5.Controls.Add(this.txtTenBan);
            this.panel5.Controls.Add(this.label2);
            this.panel5.Location = new System.Drawing.Point(3, 78);
            this.panel5.Name = "panel5";
            this.panel5.Size = new System.Drawing.Size(465, 43);
            this.panel5.TabIndex = 1;
            // 
            // txtTenBan
            // 
            this.txtTenBan.Location = new System.Drawing.Point(74, 11);
            this.txtTenBan.Name = "txtTenBan";
            this.txtTenBan.Size = new System.Drawing.Size(250, 20);
            this.txtTenBan.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(16, 11);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(50, 13);
            this.label2.TabIndex = 0;
            this.label2.Text = "Tên bàn:";
            // 
            // panel4
            // 
            this.panel4.Controls.Add(this.txtIDban);
            this.panel4.Controls.Add(this.label1);
            this.panel4.Location = new System.Drawing.Point(3, 3);
            this.panel4.Name = "panel4";
            this.panel4.Size = new System.Drawing.Size(465, 43);
            this.panel4.TabIndex = 0;
            // 
            // txtIDban
            // 
            this.txtIDban.Location = new System.Drawing.Point(74, 11);
            this.txtIDban.Name = "txtIDban";
            this.txtIDban.Size = new System.Drawing.Size(250, 20);
            this.txtIDban.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(16, 11);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(21, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "ID:";
            // 
            // BanAn
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(926, 424);
            this.Controls.Add(this.panel3);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "BanAn";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "QUẢN LÝ DANH SÁCH BÀN";
            this.Load += new System.EventHandler(this.BanAn_Load);
            this.panel1.ResumeLayout(false);
            this.panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgvBanAn)).EndInit();
            this.panel3.ResumeLayout(false);
            this.panel6.ResumeLayout(false);
            this.panel6.PerformLayout();
            this.panel5.ResumeLayout(false);
            this.panel5.PerformLayout();
            this.panel4.ResumeLayout(false);
            this.panel4.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnThembanan;
        private System.Windows.Forms.Button btnSuabanan;
        private System.Windows.Forms.Button btnXoabanan;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button btnXembanan;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.DataGridView dgvBanAn;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Panel panel6;
        private System.Windows.Forms.TextBox txtTinhTrang;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Panel panel5;
        private System.Windows.Forms.TextBox txtTenBan;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Panel panel4;
        private System.Windows.Forms.TextBox txtIDban;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DataGridViewTextBoxColumn idb;
        private System.Windows.Forms.DataGridViewTextBoxColumn TENB;
        private System.Windows.Forms.DataGridViewTextBoxColumn STT;
    }
}