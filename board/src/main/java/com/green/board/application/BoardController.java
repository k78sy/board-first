package com.green.board.application;

import com.green.board.application.model.BoardGetOneReq;
import com.green.board.application.model.BoardGetReq;
import com.green.board.application.model.BoardPostReq;
import com.green.board.application.model.BoardPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board_db")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public int postBoard(@RequestBody BoardPostReq req){
        int result = boardService.postBoard(req);
        if(result == 1){
            System.out.println("POST 통신 성공");
        }
        return result;
    }

    @GetMapping
    public List<BoardGetReq> allList(){
        return boardService.allList();
    }

    @GetMapping("{id}")
    public BoardGetOneReq detailOne(@PathVariable int id){
        return boardService.detailOne(id);
    }

    @DeleteMapping
    public int deleteOne(@RequestParam int id){
        int result = boardService.deleteOne(id);
        if(result == 1){
            System.out.println("DELETE 통신 성공: " + id);
        }
        return result;
    }

    @PutMapping
    public int updateOne(@RequestBody BoardPutReq req){
        int result = boardService.UpdateOne(req);
        if(result == 1){
            System.out.println("PUT 통신 성공: " + req);
        }
        return result;
    }
}
