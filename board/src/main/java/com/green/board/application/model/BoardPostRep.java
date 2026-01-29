package com.green.board.application.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardCreateRep {
    private String title;
    private String contents;
}
