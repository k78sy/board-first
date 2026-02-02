package com.green.board.application.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardPutRes {
    private int id;
    private String title;
    private String contents;
}
