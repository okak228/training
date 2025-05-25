using System.Text.Json;
using WinFormsApp1.Models;

namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        private List<Book> books = new List<Book>();
        public Form1()
        {
            InitializeComponent();
        }

        private void LoadButton_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();

            if (openFileDialog.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    string json = File.ReadAllText(openFileDialog.FileName);
                    var data = JsonSerializer.Deserialize<List<Book>>(json);

                    if (data == null || data.Count == 0)
                    {
                        throw new Exception();
                    }

                    books.AddRange(data);

                    ReloadDataGrip(books);

                    MessageBox.Show($"Загружено: {data.Count} записей");
                }
                catch (Exception ex)
                {
                    MessageBox.Show($"Ошибка загрузки: {ex.Message}");
                }
            }
        }

        private void SaveButton_Click(object sender, EventArgs e)
        {
            SaveFileDialog saveFileDialog = new SaveFileDialog();

            if (saveFileDialog.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    string json = JsonSerializer.Serialize(books, new JsonSerializerOptions { WriteIndented = true });
                    File.WriteAllText(saveFileDialog.FileName, json);

                    MessageBox.Show("Файл успешно сохранён!");
                }
                catch (Exception ex)
                {
                    MessageBox.Show($"Ошибка сохранения: {ex.Message}");
                }
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            var year = DateTime.Now.Year;

            if (int.TryParse(YearTextBox.Text, out var value))
            {
                year = value;
            }

            var result =
                books
                    .Where(b => b.Year == year)
                    .ToList();

            ReloadDataGrip(result);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            var authorName = textBox2.Text;
            try
            {
                var result =
                    books
                        .Where(b => b.AuthorName == authorName)
                        .OrderBy(b => b.PageCount)
                        .FirstOrDefault()
                        ?? throw new Exception("Не найдена книга автора");

                ReloadDataGrip([result]);
            }
            catch (Exception ex)
            {
                dataGridView1.DataSource = null;
                MessageBox.Show($"Ошибка сохранения: {ex.Message}");
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                var authorName = AddAuthorNameTextBox.Text;

                if (!int.TryParse(AddYearTextBox.Text, out var year))
                {
                    throw new Exception("Ошибка извлечения года.");
                }

                if (!int.TryParse(AddPageCountTextBox.Text, out var pageCount))
                {
                    throw new Exception("Ошибка извлечения количества страниц.");
                }

                var book = new Book
                {
                    Id = Guid.NewGuid(),
                    AuthorName = authorName,
                    Year = year,
                    PageCount = pageCount
                };

                books.Add(book);

                ReloadDataGrip(books);
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Ошибка сохранения: {ex.Message}");
                return;
            }

            MessageBox.Show("Книга добавлена.");
        }

        private void ReloadDataGrip(List<Book> books)
        {
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = books;
            dataGridView1.Columns.RemoveAt(dataGridView1.Columns.Count - 1);
        }

        private void ReloadButton_Click(object sender, EventArgs e)
        {
            ReloadDataGrip(books);
        }
    }
}
