namespace WinFormsApp1
{
    partial class CadastrarAtividade
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
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            label7 = new Label();
            btnCadastrar = new Button();
            txbNome = new TextBox();
            txbTema = new TextBox();
            dtpAtribuicao = new DateTimePicker();
            dtpSubmissao = new DateTimePicker();
            dtpEntrega = new DateTimePicker();
            txbDesc = new TextBox();
            lblDesc = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.BackColor = Color.Transparent;
            label1.Font = new Font("Segoe UI", 14F, FontStyle.Bold, GraphicsUnit.Point);
            label1.Location = new Point(133, 12);
            label1.Name = "label1";
            label1.Size = new Size(325, 32);
            label1.TabIndex = 0;
            label1.Text = "Gerenciamento de Projetos";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.BackColor = Color.Transparent;
            label2.Location = new Point(25, 75);
            label2.Name = "label2";
            label2.Size = new Size(50, 20);
            label2.TabIndex = 1;
            label2.Text = "Nome";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(32, 111);
            label3.Name = "label3";
            label3.Size = new Size(0, 20);
            label3.TabIndex = 2;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.BackColor = Color.Transparent;
            label4.Location = new Point(25, 128);
            label4.Name = "label4";
            label4.Size = new Size(45, 20);
            label4.TabIndex = 3;
            label4.Text = "Tema";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.BackColor = Color.Transparent;
            label5.Location = new Point(25, 243);
            label5.Name = "label5";
            label5.Size = new Size(133, 20);
            label5.TabIndex = 4;
            label5.Text = "Data de atribuição";
            label5.Click += label5_Click;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.BackColor = Color.Transparent;
            label6.Location = new Point(25, 292);
            label6.Name = "label6";
            label6.Size = new Size(135, 20);
            label6.TabIndex = 5;
            label6.Text = "Data de submissão";
            label6.Visible = false;
            label6.Click += label6_Click;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.BackColor = Color.Transparent;
            label7.Location = new Point(25, 341);
            label7.Name = "label7";
            label7.Size = new Size(117, 20);
            label7.TabIndex = 6;
            label7.Text = "Data de entrega";
            // 
            // btnCadastrar
            // 
            btnCadastrar.Location = new Point(416, 320);
            btnCadastrar.Margin = new Padding(3, 4, 3, 4);
            btnCadastrar.Name = "btnCadastrar";
            btnCadastrar.Size = new Size(103, 44);
            btnCadastrar.TabIndex = 7;
            btnCadastrar.Text = "Cadastrar";
            btnCadastrar.UseVisualStyleBackColor = true;
            btnCadastrar.Click += button1_Click;
            // 
            // txbNome
            // 
            txbNome.Location = new Point(98, 71);
            txbNome.Margin = new Padding(3, 4, 3, 4);
            txbNome.Name = "txbNome";
            txbNome.Size = new Size(420, 27);
            txbNome.TabIndex = 1;
            // 
            // txbTema
            // 
            txbTema.Location = new Point(98, 124);
            txbTema.Margin = new Padding(3, 4, 3, 4);
            txbTema.Name = "txbTema";
            txbTema.Size = new Size(420, 27);
            txbTema.TabIndex = 2;
            txbTema.TextChanged += textBox2_TextChanged;
            // 
            // dtpAtribuicao
            // 
            dtpAtribuicao.Format = DateTimePickerFormat.Short;
            dtpAtribuicao.Location = new Point(160, 235);
            dtpAtribuicao.Margin = new Padding(3, 4, 3, 4);
            dtpAtribuicao.Name = "dtpAtribuicao";
            dtpAtribuicao.Size = new Size(130, 27);
            dtpAtribuicao.TabIndex = 4;
            // 
            // dtpSubmissao
            // 
            dtpSubmissao.Format = DateTimePickerFormat.Short;
            dtpSubmissao.Location = new Point(160, 284);
            dtpSubmissao.Margin = new Padding(3, 4, 3, 4);
            dtpSubmissao.Name = "dtpSubmissao";
            dtpSubmissao.Size = new Size(130, 27);
            dtpSubmissao.TabIndex = 5;
            dtpSubmissao.Visible = false;
            // 
            // dtpEntrega
            // 
            dtpEntrega.Format = DateTimePickerFormat.Short;
            dtpEntrega.Location = new Point(160, 333);
            dtpEntrega.Margin = new Padding(3, 4, 3, 4);
            dtpEntrega.Name = "dtpEntrega";
            dtpEntrega.Size = new Size(130, 27);
            dtpEntrega.TabIndex = 6;
            dtpEntrega.ValueChanged += dateTimePicker3_ValueChanged;
            // 
            // txbDesc
            // 
            txbDesc.Location = new Point(98, 179);
            txbDesc.Margin = new Padding(3, 4, 3, 4);
            txbDesc.Name = "txbDesc";
            txbDesc.Size = new Size(420, 27);
            txbDesc.TabIndex = 3;
            // 
            // lblDesc
            // 
            lblDesc.AutoSize = true;
            lblDesc.BackColor = Color.Transparent;
            lblDesc.Location = new Point(25, 183);
            lblDesc.Name = "lblDesc";
            lblDesc.Size = new Size(74, 20);
            lblDesc.TabIndex = 13;
            lblDesc.Text = "Descrição";
            // 
            // CadastrarAtividade
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackgroundImage = Properties.Resources._5_skills_project_management_degree_elmhurst_college_infographic_thumb;
            BackgroundImageLayout = ImageLayout.Stretch;
            ClientSize = new Size(559, 407);
            Controls.Add(txbDesc);
            Controls.Add(lblDesc);
            Controls.Add(dtpEntrega);
            Controls.Add(dtpSubmissao);
            Controls.Add(dtpAtribuicao);
            Controls.Add(txbTema);
            Controls.Add(txbNome);
            Controls.Add(btnCadastrar);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Margin = new Padding(3, 4, 3, 4);
            Name = "CadastrarAtividade";
            Text = "Cadastro";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private Label label7;
        private Button btnCadastrar;
        private TextBox txbNome;
        private TextBox txbTema;
        private DateTimePicker dtpAtribuicao;
        private DateTimePicker dtpSubmissao;
        private DateTimePicker dtpEntrega;
        private TextBox txbDesc;
        private Label lblDesc;
    }
}