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

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "authors")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String surname;
    private String patronymic;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<AuthorBook> books = new HashSet<>();

    public void addAuthorBook(AuthorBook authorBook) {
        this.books.add(authorBook);
        authorBook.getBook().getAuthors().add(authorBook);
    }
}
