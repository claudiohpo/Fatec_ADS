namespace WinFormsApp1
{
    partial class CadastroUsuario
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
            txbNome = new TextBox();
            btnCadastrar = new Button();
            dtpNasc = new DateTimePicker();
            lblNome = new Label();
            lblCpf = new Label();
            lblDtNasc = new Label();
            lblTelefone = new Label();
            lblEmail = new Label();
            lblSenha = new Label();
            txbCpf = new TextBox();
            mtbTelefone = new MaskedTextBox();
            txbSenha = new TextBox();
            txbEmail = new TextBox();
            lblConfSenha = new Label();
            txbConfSenha = new TextBox();
            btnLimpar = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.BackColor = Color.Transparent;
            label1.Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point);
            label1.Location = new Point(102, 9);
            label1.Name = "label1";
            label1.Size = new Size(161, 21);
            label1.TabIndex = 0;
            label1.Text = "Cadastro de usuário";
            // 
            // txbNome
            // 
            txbNome.Location = new Point(93, 46);
            txbNome.Name = "txbNome";
            txbNome.Size = new Size(216, 23);
            txbNome.TabIndex = 1;
            // 
            // btnCadastrar
            // 
            btnCadastrar.Location = new Point(234, 329);
            btnCadastrar.Name = "btnCadastrar";
            btnCadastrar.Size = new Size(75, 23);
            btnCadastrar.TabIndex = 8;
            btnCadastrar.Text = "Cadastrar";
            btnCadastrar.UseVisualStyleBackColor = true;
            btnCadastrar.Click += btnCadastrar_Click;
            // 
            // dtpNasc
            // 
            dtpNasc.Format = DateTimePickerFormat.Short;
            dtpNasc.Location = new Point(207, 131);
            dtpNasc.Name = "dtpNasc";
            dtpNasc.Size = new Size(102, 23);
            dtpNasc.TabIndex = 3;
            // 
            // lblNome
            // 
            lblNome.AutoSize = true;
            lblNome.BackColor = Color.Transparent;
            lblNome.Location = new Point(35, 46);
            lblNome.Name = "lblNome";
            lblNome.Size = new Size(40, 15);
            lblNome.TabIndex = 4;
            lblNome.Text = "Nome";
            // 
            // lblCpf
            // 
            lblCpf.AutoSize = true;
            lblCpf.BackColor = Color.Transparent;
            lblCpf.Location = new Point(35, 91);
            lblCpf.Name = "lblCpf";
            lblCpf.Size = new Size(28, 15);
            lblCpf.TabIndex = 5;
            lblCpf.Text = "CPF";
            // 
            // lblDtNasc
            // 
            lblDtNasc.AutoSize = true;
            lblDtNasc.BackColor = Color.Transparent;
            lblDtNasc.Location = new Point(33, 137);
            lblDtNasc.Name = "lblDtNasc";
            lblDtNasc.Size = new Size(98, 15);
            lblDtNasc.TabIndex = 6;
            lblDtNasc.Text = "Data Nascimento";
            // 
            // lblTelefone
            // 
            lblTelefone.AutoSize = true;
            lblTelefone.BackColor = Color.Transparent;
            lblTelefone.Location = new Point(33, 179);
            lblTelefone.Name = "lblTelefone";
            lblTelefone.Size = new Size(51, 15);
            lblTelefone.TabIndex = 7;
            lblTelefone.Text = "Telefone";
            // 
            // lblEmail
            // 
            lblEmail.AutoSize = true;
            lblEmail.BackColor = Color.Transparent;
            lblEmail.Location = new Point(35, 216);
            lblEmail.Name = "lblEmail";
            lblEmail.Size = new Size(41, 15);
            lblEmail.TabIndex = 8;
            lblEmail.Text = "E-mail";
            // 
            // lblSenha
            // 
            lblSenha.AutoSize = true;
            lblSenha.BackColor = Color.Transparent;
            lblSenha.Location = new Point(35, 255);
            lblSenha.Name = "lblSenha";
            lblSenha.Size = new Size(39, 15);
            lblSenha.TabIndex = 9;
            lblSenha.Text = "Senha";
            // 
            // txbCpf
            // 
            txbCpf.Location = new Point(93, 88);
            txbCpf.MaxLength = 11;
            txbCpf.Name = "txbCpf";
            txbCpf.Size = new Size(216, 23);
            txbCpf.TabIndex = 2;
            // 
            // mtbTelefone
            // 
            mtbTelefone.Location = new Point(93, 176);
            mtbTelefone.Mask = "(00) 00000-0000";
            mtbTelefone.Name = "mtbTelefone";
            mtbTelefone.Size = new Size(216, 23);
            mtbTelefone.TabIndex = 4;
            mtbTelefone.UseWaitCursor = true;
            // 
            // txbSenha
            // 
            txbSenha.Location = new Point(93, 252);
            txbSenha.Name = "txbSenha";
            txbSenha.PasswordChar = '*';
            txbSenha.Size = new Size(216, 23);
            txbSenha.TabIndex = 6;
            // 
            // txbEmail
            // 
            txbEmail.Location = new Point(93, 213);
            txbEmail.Name = "txbEmail";
            txbEmail.Size = new Size(216, 23);
            txbEmail.TabIndex = 5;
            // 
            // lblConfSenha
            // 
            lblConfSenha.AutoSize = true;
            lblConfSenha.BackColor = Color.Transparent;
            lblConfSenha.Location = new Point(35, 293);
            lblConfSenha.Name = "lblConfSenha";
            lblConfSenha.Size = new Size(61, 15);
            lblConfSenha.TabIndex = 14;
            lblConfSenha.Text = "Confirmar";
            // 
            // txbConfSenha
            // 
            txbConfSenha.Location = new Point(102, 290);
            txbConfSenha.Name = "txbConfSenha";
            txbConfSenha.PasswordChar = '*';
            txbConfSenha.Size = new Size(207, 23);
            txbConfSenha.TabIndex = 7;
            // 
            // btnLimpar
            // 
            btnLimpar.Location = new Point(138, 329);
            btnLimpar.Name = "btnLimpar";
            btnLimpar.Size = new Size(75, 23);
            btnLimpar.TabIndex = 9;
            btnLimpar.Text = "Limpar";
            btnLimpar.UseVisualStyleBackColor = true;
            btnLimpar.Click += btnLimpar_Click;
            // 
            // CadastroPessoa
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackgroundImage = Properties.Resources.rm218batch4_ning_29;
            BackgroundImageLayout = ImageLayout.Stretch;
            ClientSize = new Size(365, 364);
            Controls.Add(btnLimpar);
            Controls.Add(txbConfSenha);
            Controls.Add(lblConfSenha);
            Controls.Add(txbEmail);
            Controls.Add(txbSenha);
            Controls.Add(mtbTelefone);
            Controls.Add(txbCpf);
            Controls.Add(lblSenha);
            Controls.Add(lblEmail);
            Controls.Add(lblTelefone);
            Controls.Add(lblDtNasc);
            Controls.Add(lblCpf);
            Controls.Add(lblNome);
            Controls.Add(dtpNasc);
            Controls.Add(btnCadastrar);
            Controls.Add(txbNome);
            Controls.Add(label1);
            Name = "CadastroPessoa";
            Text = "CadastroPessoa";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private TextBox txbNome;
        private Button btnCadastrar;
        private DateTimePicker dtpNasc;
        private Label lblNome;
        private Label lblCpf;
        private Label lblDtNasc;
        private Label lblTelefone;
        private Label lblEmail;
        private Label lblSenha;
        private TextBox txbCpf;
        private MaskedTextBox mtbTelefone;
        private TextBox txbSenha;
        private TextBox txbEmail;
        private Label lblConfSenha;
        private TextBox txbConfSenha;
        private Button btnLimpar;
    }
}