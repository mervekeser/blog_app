package com.tobeto.blog.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.blog.entity.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity {

    private String title;

    private String content;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @OneToMany(mappedBy = "post")
    @JsonIgnore
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
