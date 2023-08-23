package com.Group3.GeekText.entities;

import org.springframework.data.repository.CrudRepository;
import jakarta.persistence.*;


@Entity
@Table(name = "Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthorID")
    public int authorID;

    @Column(name = "FirstName")
    public String authorFN;

    @Column(name = "LastName")
    public String authorLN;

    @Column(name = "Biography")
    public String authorBio;

    @Column(name = "Publisher")
    public String authorPublisher;

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getAuthorFN() {
        return authorFN;
    }

    public void setAuthorFN(String authorFN) {
        this.authorFN = authorFN;
    }

    public String getAuthorLN() {
        return authorLN;
    }

    public void setAuthorLN(String authorLN) {
        this.authorLN = authorLN;
    }

    public String getAuthorBio() {
        return authorBio;
    }

    public void setAuthorBio(String authorBio) {
        this.authorBio = authorBio;
    }

    public String getAuthorPublisher() {
        return authorPublisher;
    }

    public void setAuthorPublisher(String authorPublisher) {
        this.authorPublisher = authorPublisher;
    }
}
