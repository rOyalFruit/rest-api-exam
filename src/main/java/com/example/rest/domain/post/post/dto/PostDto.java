package com.example.rest.domain.post.post.dto;

import com.example.rest.domain.post.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDto {
    private long id;
    @JsonProperty("createDatetime")
    private LocalDateTime createAt;
    @JsonProperty("modifiedDatetime")
    private LocalDateTime modifyAt;
    private String title;
    private String content;

    public PostDto(Post post) {
        this.id = post.getId();
        this.createAt = post.getCreateDate();
        this.modifyAt  = post.getModifyDate();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
