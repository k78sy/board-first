package com.green.board.application;

import com.green.board.application.model.BoardDetailReq;
import com.green.board.application.model.BoardListReq;
import com.green.board.application.model.BoardPostRep;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int save(BoardPostRep rep);
    List<BoardListReq> listAll();
    BoardDetailReq detail(int id);
}
