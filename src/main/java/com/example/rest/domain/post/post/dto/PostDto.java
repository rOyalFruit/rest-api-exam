package com.example.rest.domain.post.post.dto;

import com.example.rest.domain.member.member.dto.MemberDto;
import com.example.rest.domain.post.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDto {
    private long id;
    @JsonProperty("createDatetime")
    private LocalDateTime createDate;
    @JsonProperty("modifiedDatetime")
    private LocalDateTime modifyDate ;
    private MemberDto author;
    private String title;
    private String content;

    public PostDto(Post post) {
        this.id = post.getId();
        this.createDate  = post.getCreateDate();
        this.modifyDate   = post.getModifyDate();
        this.author = new MemberDto(post.getAuthor());
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
