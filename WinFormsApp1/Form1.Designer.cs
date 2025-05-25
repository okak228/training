namespace WinFormsApp1
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            LoadButton = new Button();
            SaveButton = new Button();
            YearFilterButton = new Button();
            dataGridView1 = new DataGridView();
            YearTextBox = new TextBox();
            textBox2 = new TextBox();
            button4 = new Button();
            label1 = new Label();
            label2 = new Label();
            groupBox1 = new GroupBox();
            AddButton = new Button();
            label5 = new Label();
            AddPageCountTextBox = new TextBox();
            label4 = new Label();
            AddYearTextBox = new TextBox();
            label3 = new Label();
            AddAuthorNameTextBox = new TextBox();
            ReloadButton = new Button();
            ((System.ComponentModel.ISupportInitialize)dataGridView1).BeginInit();
            groupBox1.SuspendLayout();
            SuspendLayout();
            // 
            // LoadButton
            // 
            LoadButton.Location = new Point(12, 12);
            LoadButton.Name = "LoadButton";
            LoadButton.Size = new Size(75, 23);
            LoadButton.TabIndex = 0;
            LoadButton.Text = "Загрузка";
            LoadButton.UseVisualStyleBackColor = true;
            LoadButton.Click += LoadButton_Click;
            // 
            // SaveButton
            // 
            SaveButton.Location = new Point(93, 12);
            SaveButton.Name = "SaveButton";
            SaveButton.Size = new Size(83, 23);
            SaveButton.TabIndex = 1;
            SaveButton.Text = "Сохранение";
            SaveButton.UseVisualStyleBackColor = true;
            SaveButton.Click += SaveButton_Click;
            // 
            // YearFilterButton
            // 
            YearFilterButton.Location = new Point(128, 61);
            YearFilterButton.Name = "YearFilterButton";
            YearFilterButton.Size = new Size(142, 23);
            YearFilterButton.TabIndex = 4;
            YearFilterButton.Text = "Отсортировать по году";
            YearFilterButton.UseVisualStyleBackColor = true;
            YearFilterButton.Click += button3_Click;
            // 
            // dataGridView1
            // 
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dataGridView1.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridView1.Location = new Point(12, 173);
            dataGridView1.Name = "dataGridView1";
            dataGridView1.Size = new Size(536, 217);
            dataGridView1.TabIndex = 5;
            // 
            // YearTextBox
            // 
            YearTextBox.Location = new Point(12, 61);
            YearTextBox.Name = "YearTextBox";
            YearTextBox.Size = new Size(100, 23);
            YearTextBox.TabIndex = 6;
            // 
            // textBox2
            // 
            textBox2.Location = new Point(12, 112);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(100, 23);
            textBox2.TabIndex = 7;
            // 
            // button4
            // 
            button4.Location = new Point(128, 112);
            button4.Name = "button4";
            button4.Size = new Size(195, 23);
            button4.TabIndex = 8;
            button4.Text = "Минимальная по размеру книга";
            button4.UseVisualStyleBackColor = true;
            button4.Click += button4_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 43);
            label1.Name = "label1";
            label1.Size = new Size(26, 15);
            label1.TabIndex = 9;
            label1.Text = "Год";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(12, 94);
            label2.Name = "label2";
            label2.Size = new Size(40, 15);
            label2.TabIndex = 10;
            label2.Text = "Автор";
            // 
            // groupBox1
            // 
            groupBox1.Controls.Add(AddButton);
            groupBox1.Controls.Add(label5);
            groupBox1.Controls.Add(AddPageCountTextBox);
            groupBox1.Controls.Add(label4);
            groupBox1.Controls.Add(AddYearTextBox);
            groupBox1.Controls.Add(label3);
            groupBox1.Controls.Add(AddAuthorNameTextBox);
            groupBox1.Location = new Point(342, 12);
            groupBox1.Name = "groupBox1";
            groupBox1.Size = new Size(200, 155);
            groupBox1.TabIndex = 11;
            groupBox1.TabStop = false;
            groupBox1.Text = "Форма добавления книги";
            // 
            // AddButton
            // 
            AddButton.Location = new Point(119, 126);
            AddButton.Name = "AddButton";
            AddButton.Size = new Size(75, 23);
            AddButton.TabIndex = 6;
            AddButton.Text = "Создать";
            AddButton.UseVisualStyleBackColor = true;
            AddButton.Click += button1_Click;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(6, 83);
            label5.Name = "label5";
            label5.Size = new Size(63, 15);
            label5.TabIndex = 5;
            label5.Text = "Страницы";
            // 
            // AddPageCountTextBox
            // 
            AddPageCountTextBox.Location = new Point(81, 80);
            AddPageCountTextBox.Name = "AddPageCountTextBox";
            AddPageCountTextBox.Size = new Size(113, 23);
            AddPageCountTextBox.TabIndex = 4;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(6, 54);
            label4.Name = "label4";
            label4.Size = new Size(26, 15);
            label4.TabIndex = 3;
            label4.Text = "Год";
            // 
            // AddYearTextBox
            // 
            AddYearTextBox.Location = new Point(52, 51);
            AddYearTextBox.Name = "AddYearTextBox";
            AddYearTextBox.Size = new Size(142, 23);
            AddYearTextBox.TabIndex = 2;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(6, 25);
            label3.Name = "label3";
            label3.Size = new Size(40, 15);
            label3.TabIndex = 1;
            label3.Text = "Автор";
            // 
            // AddAuthorNameTextBox
            // 
            AddAuthorNameTextBox.Location = new Point(52, 22);
            AddAuthorNameTextBox.Name = "AddAuthorNameTextBox";
            AddAuthorNameTextBox.Size = new Size(142, 23);
            AddAuthorNameTextBox.TabIndex = 0;
            // 
            // ReloadButton
            // 
            ReloadButton.Location = new Point(12, 396);
            ReloadButton.Name = "ReloadButton";
            ReloadButton.Size = new Size(100, 23);
            ReloadButton.TabIndex = 12;
            ReloadButton.Text = "Перезагрузить";
            ReloadButton.UseVisualStyleBackColor = true;
            ReloadButton.Click += ReloadButton_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(554, 420);
            Controls.Add(ReloadButton);
            Controls.Add(groupBox1);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(button4);
            Controls.Add(textBox2);
            Controls.Add(YearTextBox);
            Controls.Add(dataGridView1);
            Controls.Add(YearFilterButton);
            Controls.Add(SaveButton);
            Controls.Add(LoadButton);
            Name = "Form1";
            Text = "Форма";
            ((System.ComponentModel.ISupportInitialize)dataGridView1).EndInit();
            groupBox1.ResumeLayout(false);
            groupBox1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private Button LoadButton;
        private Button SaveButton;
        private Button YearFilterButton;
        private DataGridView dataGridView1;
        private TextBox YearTextBox;
        private TextBox textBox2;
        private Button button4;
        private Label label1;
        private Label label2;
        private GroupBox groupBox1;
        private TextBox AddAuthorNameTextBox;
        private Label label4;
        private TextBox AddYearTextBox;
        private Label label3;
        private Label label5;
        private TextBox AddPageCountTextBox;
        private Button AddButton;
        private Button ReloadButton;
    }
}
