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

    public int postBoard(BoardPostReq req){
        return boardMapper.save(req);
    }

    public List<BoardGetReq> allList(){
        return boardMapper.allList();
    }

    public BoardGetOneReq detailOne(int id){
        return boardMapper.detailOne(id);
    }

    public int deleteOne(int id){
        return boardMapper.delete(id);
    }

    public int UpdateOne(BoardPutReq req){
        return boardMapper.update(req);
    }
}
