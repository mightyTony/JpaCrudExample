package com.example.dtodemo.post.entity;

import com.example.dtodemo.base.BaseTimeEntity;
import com.example.dtodemo.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity@AllArgsConstructor@Builder
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글 고유 번호, PK

    private String title; // 게시글 제목
    private String content; // 게시글 내용

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user.id")
    private User user;

    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
    
    public Post update(String title, String content){
        this.title = title;
        this.content = content;
        return this;
    }
}

