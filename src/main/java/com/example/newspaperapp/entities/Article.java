package com.example.newspaperapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "title", nullable = false,length = 100)
    private String title;

    @Size(min = 50 , max = 5000)
    @NotNull
    @Column(name = "content", nullable = false, length = 5000)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", length = 50)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "journalist_id")
    private Journalist journalist;

    @NotNull
    @Column(name = "thumbnail_URL",nullable = false)
    private String thumbnailURL;

    @Column(name = "published_at")
    private Instant publishedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",length = 50)
    private Status status;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
