package com.example.app;

import com.example.app.model.Author;
import com.example.app.model.AuthorBook;
import com.example.app.model.AuthorBookId;
import com.example.app.model.Book;
import com.example.app.repository.AuthorRepository;
import com.example.app.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class AppApplicationTests {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;


    @Test
    void contextLoads() {
        Author author = new Author(null, "Mike", "Mike", "Mike", new HashSet<>());
        Book book = new Book(null, "Mike", "Mike", new HashSet<>());

        bookRepository.save(book);
        authorRepository.save(author);

        Author persistedAuthor = authorRepository.findById(author.getId()).orElseThrow();
        Book persistedBook = bookRepository.findById(book.getId()).orElseThrow();

        AuthorBook authorBook = new AuthorBook(
                new AuthorBookId(persistedAuthor.getId(), persistedBook.getId()),
                persistedAuthor,
                persistedBook);

        persistedAuthor.addAuthorBook(authorBook);

        authorRepository.save(persistedAuthor);

        assertThat(persistedAuthor.getBooks().size()).isEqualTo(1);
        assertThat(persistedBook.getAuthors().size()).isEqualTo(1);
    }
}
