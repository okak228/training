package com.example.app.entity.manytomany;

import com.example.app.entity.Author;
import com.example.app.entity.Book;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuthorBook {
    @EmbeddedId
    private AuthorBookId id;

    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private Author author;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    private Book book;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuthorBook that = (AuthorBook) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
