package com.green.board.application;

import com.green.board.application.model.DataListRes;
import com.green.board.application.model.DataOneRes;
import com.green.board.application.model.DataRes;
import com.green.board.application.model.DataUpdateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/db")
public class BoardController {
    private final BoardService boardService;

//    @GetMapping
//    public int test(@RequestParam String test){
//        System.out.println(test);
//        return 1;
//    }

    @PostMapping
    public int post(@RequestBody DataRes res){
        int result = boardService.dataPost(res);
        System.out.println("Req" + res);
        return result;
    }

    @GetMapping
    public List<DataListRes> findList(){
        return boardService.dataList();
    }

    @GetMapping("{id}")
    public DataOneRes findOne(@PathVariable int id){
        return boardService.dataDetail(id);
    }

    @DeleteMapping
    public int deleteOne(@RequestParam int id){
        return boardService.dataDelete(id);
    }

    @PutMapping
    public int modifyOne(@RequestBody DataUpdateRes res){
        return boardService.dataModify(res);
    }

}
