package com.green.board.application;

import com.green.board.application.model.DataListRes;
import com.green.board.application.model.DataOneRes;
import com.green.board.application.model.DataRes;
import com.green.board.application.model.DataUpdateRes;
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

    public DataOneRes dataDetail(int id){
        return boardMapper.findOne(id);
    }

    public int dataDelete(int id){
        return boardMapper.delete(id);
    }

    public int dataUpdate(DataUpdateRes res){
        return boardMapper.mod(res);
    }
}
