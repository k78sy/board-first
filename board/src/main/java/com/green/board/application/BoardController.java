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
    public int boardPost(@RequestBody BoardPostReq req){
        int result = boardService.boardPost(req);
        if(result == 1){ System.out.println("POST 통신내용: " + req);}
        return result;
    }

    @GetMapping
    public List<BoardGetReq> boardList(){
        List<BoardGetReq> result = boardService.boardList();
        return result;
    }

    @GetMapping("{id}")
    public BoardGetOneReq boardDetail(@PathVariable int id){
        return boardService.boardDetail(id);
    }

    @DeleteMapping
    public int boardDel(@RequestParam int id){
        int result = boardService.boardOneDel(id);
        if(result == 1){ System.out.println("DELETE 통신 성공");}
        return result;
    }

    @PutMapping
    public int boardMod(@RequestBody BoardPutReq req){
        int result = boardService.boardOneMod(req);
        if(result == 1){ System.out.println("PUT 통신내용: " + req);}
        return result;
    }
}
