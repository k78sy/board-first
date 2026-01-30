package com.green.board.application;

import com.green.board.application.model.DataListRes;
import com.green.board.application.model.DataRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int save(DataRes res);
    List<DataListRes> findList();
}
