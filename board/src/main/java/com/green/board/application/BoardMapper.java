package com.green.board.application;

import com.green.board.application.model.BoardGetOneReq;
import com.green.board.application.model.BoardGetReq;
import com.green.board.application.model.BoardPostReq;
import com.green.board.application.model.BoardPutReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int save(BoardPostReq req);
    List<BoardGetReq> findAll();
    BoardGetOneReq findOne(int id);
    int delOne(int id);
    int modOne(BoardPutReq req);
}
