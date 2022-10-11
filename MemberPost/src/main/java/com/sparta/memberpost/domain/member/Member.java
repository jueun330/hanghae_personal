package com.sparta.memberpost.domain.member;

import com.sparta.memberpost.domain.comment.Comment;
import com.sparta.memberpost.domain.post.Post;
import com.sparta.memberpost.global.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Table(name="Members")
public class Member extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }

    @Column
    private String refreshToken;

    @Builder.Default
    @OneToMany(mappedBy = "writer", cascade = ALL, orphanRemoval = true)
    private List<Post> postList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "writer", cascade = ALL, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();


    public void addPost(Post post){
        postList.add(post);
    }

    public void addComment(Comment comment){
        commentList.add(comment);
    }

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public void destroyRefreshToken(){
        this.refreshToken = null;
    }

    /**
     * 패스워드 일치하는지 확인
     * @param passwordEncoder 패스워드 인코더
     * @param checkPassword 검사할 비밀번호
     * @return
     */
    public boolean matchPassword(PasswordEncoder passwordEncoder, String checkPassword){
        return passwordEncoder.matches(checkPassword, getPassword());
    }

}
