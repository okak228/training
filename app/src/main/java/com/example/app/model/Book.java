package com.example.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "books")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String genre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", orphanRemoval = true)
    private Set<AuthorBook> authors = new HashSet<>();

    public void addAuthorBook(AuthorBook authorBook) {
        this.authors.add(authorBook);
        authorBook.getBook().getAuthors().add(authorBook);
    }
}
