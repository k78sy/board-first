package com.green.board.application.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDetailReq {
    private int id;
    private String title;
    private String contents;
    private String createdAt;
}
