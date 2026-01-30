package com.green.board.application;

import com.green.board.application.model.DataListRes;
import com.green.board.application.model.DataRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public int dataPost(DataRes res){
        return boardMapper.save(res);
    }

    public List<DataListRes> dataList(){
        return boardMapper.findList();
    }
}
