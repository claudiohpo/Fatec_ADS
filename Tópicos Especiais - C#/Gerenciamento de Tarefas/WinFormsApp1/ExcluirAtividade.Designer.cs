namespace WinFormsApp1
{
    partial class ExcluirAtividade
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
            btnBuscar = new Button();
            dgvDados = new DataGridView();
            label1 = new Label();
            btnExcluir = new Button();
            txbExcluir = new TextBox();
            label2 = new Label();
            panel1 = new Panel();
            ((System.ComponentModel.ISupportInitialize)dgvDados).BeginInit();
            panel1.SuspendLayout();
            SuspendLayout();
            // 
            // btnBuscar
            // 
            btnBuscar.Location = new Point(294, 87);
            btnBuscar.Margin = new Padding(3, 4, 3, 4);
            btnBuscar.Name = "btnBuscar";
            btnBuscar.Size = new Size(135, 44);
            btnBuscar.TabIndex = 2;
            btnBuscar.Text = "Buscar";
            btnBuscar.UseVisualStyleBackColor = true;
            btnBuscar.Click += btnBuscar_Click;
            // 
            // dgvDados
            // 
            dgvDados.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvDados.Location = new Point(30, 165);
            dgvDados.Margin = new Padding(3, 4, 3, 4);
            dgvDados.Name = "dgvDados";
            dgvDados.RowHeadersWidth = 51;
            dgvDados.RowTemplate.Height = 25;
            dgvDados.Size = new Size(664, 235);
            dgvDados.TabIndex = 3;
            dgvDados.Visible = false;
            dgvDados.CellContentClick += dgvDados_CellContentClick;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.BackColor = Color.Transparent;
            label1.Font = new Font("Segoe UI", 14F, FontStyle.Bold, GraphicsUnit.Point);
            label1.ForeColor = SystemColors.ButtonFace;
            label1.Location = new Point(171, 12);
            label1.Name = "label1";
            label1.Size = new Size(397, 32);
            label1.TabIndex = 6;
            label1.Text = "Exclusão de Projetos Cadastrados";
            // 
            // btnExcluir
            // 
            btnExcluir.Location = new Point(556, 16);
            btnExcluir.Margin = new Padding(3, 4, 3, 4);
            btnExcluir.Name = "btnExcluir";
            btnExcluir.Size = new Size(135, 44);
            btnExcluir.TabIndex = 4;
            btnExcluir.Text = "Excluir";
            btnExcluir.UseVisualStyleBackColor = true;
            btnExcluir.Click += btnExcluir_Click;
            // 
            // txbExcluir
            // 
            txbExcluir.Location = new Point(208, 25);
            txbExcluir.Margin = new Padding(3, 4, 3, 4);
            txbExcluir.Name = "txbExcluir";
            txbExcluir.Size = new Size(313, 27);
            txbExcluir.TabIndex = 8;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.BackColor = Color.Transparent;
            label2.ForeColor = SystemColors.ButtonFace;
            label2.Location = new Point(3, 28);
            label2.Name = "label2";
            label2.Size = new Size(187, 20);
            label2.TabIndex = 9;
            label2.Text = "Nome do projeto a excluir:";
            // 
            // panel1
            // 
            panel1.BackColor = Color.Transparent;
            panel1.Controls.Add(label2);
            panel1.Controls.Add(btnExcluir);
            panel1.Controls.Add(txbExcluir);
            panel1.Location = new Point(3, 427);
            panel1.Margin = new Padding(3, 4, 3, 4);
            panel1.Name = "panel1";
            panel1.Size = new Size(719, 97);
            panel1.TabIndex = 10;
            panel1.Visible = false;
            // 
            // ExcluirAtividade
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackgroundImage = Properties.Resources.quadro_negro_com_um_caractere_usando_uma_lata_de_lixo__1_;
            BackgroundImageLayout = ImageLayout.Stretch;
            ClientSize = new Size(723, 561);
            Controls.Add(panel1);
            Controls.Add(btnBuscar);
            Controls.Add(dgvDados);
            Controls.Add(label1);
            Margin = new Padding(3, 4, 3, 4);
            Name = "ExcluirAtividade";
            Text = "Excluir";
            ((System.ComponentModel.ISupportInitialize)dgvDados).EndInit();
            panel1.ResumeLayout(false);
            panel1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button btnBuscar;
        private DataGridView dgvDados;
        private Label label1;
        private Button btnExcluir;
        private TextBox textBox1;
        private Label label2;
        private TextBox txbExcluir;
        private Panel panel1;
    }
}