package com.green.board.application;

import com.green.board.application.model.DataListRes;
import com.green.board.application.model.DataOneRes;
import com.green.board.application.model.DataRes;
import com.green.board.application.model.DataUpdateRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int save(DataRes res);
    List<DataListRes> findList();
    DataOneRes findOne(int id);
    int delete(int id);
    int mod(DataUpdateRes res);
}
