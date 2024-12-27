package com.example.rest.domain.member.member.dto;

import com.example.rest.domain.member.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberDto {
    private long id;
    @JsonProperty("createdDatetime")
    private LocalDateTime createDate;
    @JsonProperty("modifiedDatetime")
    private LocalDateTime modifyDate;
    private String nickname;
    public MemberDto(Member member) {
        this.id = member.getId();
        this.createDate = member.getCreateDate();
        this.modifyDate = member.getModifyDate();
        this.nickname = member.getNickname();
    }
}
