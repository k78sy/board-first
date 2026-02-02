package com.green.board.application;

import com.green.board.application.model.BoardGetOneRes;
import com.green.board.application.model.BoardGetRes;
import com.green.board.application.model.BoardPostRes;
import com.green.board.application.model.BoardPutRes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/db")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public int postArticle(@RequestBody BoardPostRes res){
        System.out.println("content : " + res);
        return boardService.postArticle(res);
    }

    @GetMapping
    public List<BoardGetRes> findAllList(){
        System.out.println("GET 통신 테스트");
        return boardService.ListBoard();
    }

    @GetMapping("{id}")
    public BoardGetOneRes findOneDetail(@PathVariable int id){
        System.out.println("GET 파라미터 통신 테스트");
        return boardService.DetailBoard(id);
    }

    @DeleteMapping
    public int delOne(@RequestParam int id){
        System.out.println("delete 통신 테스트");
        return boardService.deleteArticle(id);
    }

    @PutMapping
    public int modifyOne(@RequestBody BoardPutRes res){
        System.out.println("Put 통신 테스트");
        return boardService.modifyArticle(res);
    }
}
