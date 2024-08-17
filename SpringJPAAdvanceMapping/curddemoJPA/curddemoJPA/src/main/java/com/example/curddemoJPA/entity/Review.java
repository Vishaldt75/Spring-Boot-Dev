package com.example.curddemoJPA.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "comment")
    private String comment;

    public Review()
    {

    }

    public Review(String comments) {
        this.comment = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComments() {
        return comment;
    }

    public void setComments(String comments) {
        this.comment = comments;
    }



    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comments='" + comment + '\'' +
                '}';
    }
}
