package com.sparta.memberpost.domain.comment;
import com.sparta.memberpost.domain.member.Member;
import com.sparta.memberpost.domain.post.Post;
import com.sparta.memberpost.global.Timestamped;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Table(name="COMMENT")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "writer_id")
    private Member writer;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Lob
    @Column(nullable = false)
    private String content;

    private boolean isRemoved = false;

    public void confirmWriter(Member writer) {
        this.writer = writer;
        writer.addComment(this);
    }

    public void confirmPost(Post post) {
        this.post = post;
        post.addComment(this);
    }

    public void update(String content) {
        this.content = content;
    }

    public void remove() {
        this.isRemoved = true;
    }


    @Builder
    public Comment(Member writer, Post post, String content) {
        this.writer = writer;
        this.post = post;
        this.content = content;
        this.isRemoved = false;
    }
}