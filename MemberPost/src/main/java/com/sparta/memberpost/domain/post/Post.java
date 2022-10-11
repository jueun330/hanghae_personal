package com.sparta.memberpost.domain.post;

import com.sparta.memberpost.domain.comment.Comment;
import com.sparta.memberpost.domain.member.Member;
import com.sparta.memberpost.global.Timestamped;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
@Builder
@AllArgsConstructor
@Table(name = "POST")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_id")
    private Long id;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "writer_id")
    private Member writer;


    @Column(length = 40, nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;


    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();


    public void confirmWriter(Member writer) {
        this.writer = writer;
        writer.addPost(this);
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}