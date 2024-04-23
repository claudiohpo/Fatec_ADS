namespace WinFormsApp1
{
    partial class AlterarAtividade
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
            btnAlterar = new Button();
            btnBuscar = new Button();
            txbCodigo = new TextBox();
            lblCodigo = new Label();
            label1 = new Label();
            panel1 = new Panel();
            txbDesc = new TextBox();
            lblDesc = new Label();
            dtpEntrega = new DateTimePicker();
            dtpSubmissao = new DateTimePicker();
            dtpAtribuicao = new DateTimePicker();
            txbTema = new TextBox();
            txbNome = new TextBox();
            label7 = new Label();
            label6 = new Label();
            label5 = new Label();
            label4 = new Label();
            label3 = new Label();
            label2 = new Label();
            btnEntregar = new Button();
            panel1.SuspendLayout();
            SuspendLayout();
            // 
            // btnAlterar
            // 
            btnAlterar.Font = new Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point);
            btnAlterar.Location = new Point(441, 264);
            btnAlterar.Margin = new Padding(3, 4, 3, 4);
            btnAlterar.Name = "btnAlterar";
            btnAlterar.Size = new Size(135, 44);
            btnAlterar.TabIndex = 4;
            btnAlterar.Text = "Alterar";
            btnAlterar.UseVisualStyleBackColor = true;
            btnAlterar.Click += btnAlterar_Click;
            // 
            // btnBuscar
            // 
            btnBuscar.Font = new Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point);
            btnBuscar.Location = new Point(508, 94);
            btnBuscar.Margin = new Padding(3, 4, 3, 4);
            btnBuscar.Name = "btnBuscar";
            btnBuscar.Size = new Size(135, 44);
            btnBuscar.TabIndex = 2;
            btnBuscar.Text = "Buscar";
            btnBuscar.UseVisualStyleBackColor = true;
            btnBuscar.Click += btnBuscar_Click;
            // 
            // txbCodigo
            // 
            txbCodigo.Location = new Point(207, 106);
            txbCodigo.Margin = new Padding(3, 4, 3, 4);
            txbCodigo.Name = "txbCodigo";
            txbCodigo.Size = new Size(293, 27);
            txbCodigo.TabIndex = 1;
            // 
            // lblCodigo
            // 
            lblCodigo.AutoSize = true;
            lblCodigo.BackColor = Color.Transparent;
            lblCodigo.Location = new Point(6, 109);
            lblCodigo.Name = "lblCodigo";
            lblCodigo.Size = new Size(183, 20);
            lblCodigo.TabIndex = 13;
            lblCodigo.Text = "Digite o nome do projeto:";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.BackColor = Color.Transparent;
            label1.Font = new Font("Segoe UI", 14F, FontStyle.Bold, GraphicsUnit.Point);
            label1.Location = new Point(160, 12);
            label1.Name = "label1";
            label1.Size = new Size(407, 32);
            label1.TabIndex = 12;
            label1.Text = "Alteração de Projetos Cadastrados";
            // 
            // panel1
            // 
            panel1.Controls.Add(btnEntregar);
            panel1.Controls.Add(txbDesc);
            panel1.Controls.Add(btnAlterar);
            panel1.Controls.Add(lblDesc);
            panel1.Controls.Add(dtpEntrega);
            panel1.Controls.Add(dtpSubmissao);
            panel1.Controls.Add(dtpAtribuicao);
            panel1.Controls.Add(txbTema);
            panel1.Controls.Add(txbNome);
            panel1.Controls.Add(label7);
            panel1.Controls.Add(label6);
            panel1.Controls.Add(label5);
            panel1.Controls.Add(label4);
            panel1.Controls.Add(label3);
            panel1.Controls.Add(label2);
            panel1.Location = new Point(30, 191);
            panel1.Margin = new Padding(3, 4, 3, 4);
            panel1.Name = "panel1";
            panel1.Size = new Size(598, 328);
            panel1.TabIndex = 14;
            panel1.Visible = false;
            // 
            // txbDesc
            // 
            txbDesc.Location = new Point(125, 125);
            txbDesc.Margin = new Padding(3, 4, 3, 4);
            txbDesc.Name = "txbDesc";
            txbDesc.Size = new Size(420, 27);
            txbDesc.TabIndex = 18;
            // 
            // lblDesc
            // 
            lblDesc.AutoSize = true;
            lblDesc.BackColor = Color.Transparent;
            lblDesc.Location = new Point(51, 129);
            lblDesc.Name = "lblDesc";
            lblDesc.Size = new Size(74, 20);
            lblDesc.TabIndex = 27;
            lblDesc.Text = "Descrição";
            // 
            // dtpEntrega
            // 
            dtpEntrega.Format = DateTimePickerFormat.Short;
            dtpEntrega.Location = new Point(186, 280);
            dtpEntrega.Margin = new Padding(3, 4, 3, 4);
            dtpEntrega.Name = "dtpEntrega";
            dtpEntrega.Size = new Size(130, 27);
            dtpEntrega.TabIndex = 24;
            // 
            // dtpSubmissao
            // 
            dtpSubmissao.Format = DateTimePickerFormat.Short;
            dtpSubmissao.Location = new Point(186, 231);
            dtpSubmissao.Margin = new Padding(3, 4, 3, 4);
            dtpSubmissao.Name = "dtpSubmissao";
            dtpSubmissao.Size = new Size(130, 27);
            dtpSubmissao.TabIndex = 22;
            dtpSubmissao.Visible = false;
            // 
            // dtpAtribuicao
            // 
            dtpAtribuicao.Format = DateTimePickerFormat.Short;
            dtpAtribuicao.Location = new Point(186, 181);
            dtpAtribuicao.Margin = new Padding(3, 4, 3, 4);
            dtpAtribuicao.Name = "dtpAtribuicao";
            dtpAtribuicao.Size = new Size(130, 27);
            dtpAtribuicao.TabIndex = 20;
            // 
            // txbTema
            // 
            txbTema.Location = new Point(125, 71);
            txbTema.Margin = new Padding(3, 4, 3, 4);
            txbTema.Name = "txbTema";
            txbTema.Size = new Size(420, 27);
            txbTema.TabIndex = 16;
            // 
            // txbNome
            // 
            txbNome.Location = new Point(125, 17);
            txbNome.Margin = new Padding(3, 4, 3, 4);
            txbNome.Name = "txbNome";
            txbNome.Size = new Size(420, 27);
            txbNome.TabIndex = 14;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.BackColor = Color.Transparent;
            label7.Location = new Point(51, 288);
            label7.Name = "label7";
            label7.Size = new Size(117, 20);
            label7.TabIndex = 25;
            label7.Text = "Data de entrega";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.BackColor = Color.Transparent;
            label6.Location = new Point(51, 239);
            label6.Name = "label6";
            label6.Size = new Size(135, 20);
            label6.TabIndex = 23;
            label6.Text = "Data de submissão";
            label6.Visible = false;
            label6.Click += label6_Click;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.BackColor = Color.Transparent;
            label5.Location = new Point(51, 189);
            label5.Name = "label5";
            label5.Size = new Size(133, 20);
            label5.TabIndex = 21;
            label5.Text = "Data de atribuição";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.BackColor = Color.Transparent;
            label4.Location = new Point(51, 75);
            label4.Name = "label4";
            label4.Size = new Size(45, 20);
            label4.TabIndex = 19;
            label4.Text = "Tema";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(58, 57);
            label3.Name = "label3";
            label3.Size = new Size(0, 20);
            label3.TabIndex = 17;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.BackColor = Color.Transparent;
            label2.Location = new Point(51, 21);
            label2.Name = "label2";
            label2.Size = new Size(50, 20);
            label2.TabIndex = 15;
            label2.Text = "Nome";
            // 
            // btnEntregar
            // 
            btnEntregar.Font = new Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point);
            btnEntregar.Location = new Point(441, 181);
            btnEntregar.Margin = new Padding(3, 4, 3, 4);
            btnEntregar.Name = "btnEntregar";
            btnEntregar.Size = new Size(135, 44);
            btnEntregar.TabIndex = 28;
            btnEntregar.Text = "Entregar";
            btnEntregar.UseVisualStyleBackColor = true;
            btnEntregar.Click += btnEntregar_Click;
            // 
            // AlterarAtividade
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ControlDark;
            BackgroundImage = Properties.Resources.como_alterar_dados_da_minha_MEI_SITE;
            BackgroundImageLayout = ImageLayout.Stretch;
            ClientSize = new Size(659, 560);
            Controls.Add(panel1);
            Controls.Add(btnBuscar);
            Controls.Add(txbCodigo);
            Controls.Add(lblCodigo);
            Controls.Add(label1);
            DoubleBuffered = true;
            Margin = new Padding(3, 4, 3, 4);
            Name = "AlterarAtividade";
            Text = "Alterar";
            panel1.ResumeLayout(false);
            panel1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button btnAlterar;
        private Button btnBuscar;
        private TextBox txbCodigo;
        private Label lblCodigo;
        private Label label1;
        private Panel panel1;
        private TextBox txbDesc;
        private Label lblDesc;
        private DateTimePicker dtpEntrega;
        private DateTimePicker dtpSubmissao;
        private DateTimePicker dtpAtribuicao;
        private TextBox txbTema;
        private TextBox txbNome;
        private Label label7;
        private Label label6;
        private Label label5;
        private Label label4;
        private Label label3;
        private Label label2;
        private Button btnEntregar;
    }
}