package com.green.board.application;

import com.green.board.application.model.BoardDetailReq;
import com.green.board.application.model.BoardListReq;
import com.green.board.application.model.BoardPostRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public int boardPost(BoardPostRep req){
        return boardMapper.save(req);
    }

    public List<BoardListReq> listAll(){
        return boardMapper.listAll();
    }

    public BoardDetailReq detailOne(int id){
        return boardMapper.detail(id);
    }
}
