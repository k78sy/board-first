package com.green.board.application;

import com.green.board.application.model.BoardGetOneRes;
import com.green.board.application.model.BoardGetRes;
import com.green.board.application.model.BoardPostRes;
import com.green.board.application.model.BoardPutRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public int postArticle(BoardPostRes res){
        return boardMapper.save(res);
    }

    public List<BoardGetRes> ListBoard(){
        return boardMapper.findAll();
    }
    public BoardGetOneRes DetailBoard(int id){
        return boardMapper.findOne(id);
    }

    public int deleteArticle(int id){
        return boardMapper.delete(id);
    }

    public int modifyArticle(BoardPutRes res){
        return boardMapper.modify(res);
    }
}
