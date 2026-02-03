package com.green.board.application;

import com.green.board.application.model.BoardGetOneReq;
import com.green.board.application.model.BoardGetReq;
import com.green.board.application.model.BoardPostReq;
import com.green.board.application.model.BoardPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public int boardPost(BoardPostReq req){
        return boardMapper.save(req);
    }

    public List<BoardGetReq> boardList(){
        return boardMapper.findAll();
    }

    public BoardGetOneReq boardDetail(int id){
        return boardMapper.findOne(id);
    }

    public int boardOneDel(int id){
        return boardMapper.delOne(id);
    }

    public int boardOneMod(BoardPutReq req){
        return boardMapper.modOne(req);
    }
}
