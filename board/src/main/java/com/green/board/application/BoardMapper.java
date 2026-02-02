package com.green.board.application;

import com.green.board.application.model.BoardGetOneRes;
import com.green.board.application.model.BoardGetRes;
import com.green.board.application.model.BoardPostRes;
import com.green.board.application.model.BoardPutRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int save(BoardPostRes res);
    List<BoardGetRes> findAll();
    BoardGetOneRes findOne(int id);
    int delete(int id);
    int modify(BoardPutRes res);
}
