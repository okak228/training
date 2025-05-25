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
        Author author = new Author(null, "Mike", "Mike", "Mike");
        Book book = new Book(null, "Genre", "Book", new HashSet<>());

        authorRepository.save(author);
        bookRepository.save(book);

        AuthorBook authorBook = new AuthorBook(
                new AuthorBookId(author.getId(), book.getId()),
                author,
                book);

        book.addAuthorBook(authorBook);
        authorRepository.save(author);

        bookRepository.delete(book);

        assertThat(bookRepository.findAll()).isEmpty();
        assertThat(authorRepository.findAll()).isNotEmpty();
    }

}
