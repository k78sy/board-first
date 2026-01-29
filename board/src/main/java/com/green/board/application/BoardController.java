package com.green.board.application;

import com.green.board.application.model.BoardDetailReq;
import com.green.board.application.model.BoardListReq;
import com.green.board.application.model.BoardPostRep;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board1")
public class BoardController  {
    private final BoardService boardService;

//    @PostMapping("/board1")
//    public String test(@RequestParam String title){
//        System.out.println("title: " + title);
//        return "통신 성공";
//    }

//    @PostMapping("/board1")
//    public String test(@RequestBody BoardCreateRep rep){
//        System.out.println("통신내용: " +rep);
//        return "POST 통신";
//    }

//    @PostMapping("/board1")
//    public int BoardPost(@RequestBody BoardPostRep req){
//        int result = req;
//        return result;
//    }

    @PostMapping
    public int postArticle(@RequestBody BoardPostRep req){
        int result = boardService.boardPost(req);
        System.out.println(result);
        return result;
    }

    @GetMapping
    public List<BoardListReq> listAll(){
        return boardService.listAll();
    }

    @GetMapping("{id}")
    public BoardDetailReq oneDetail(@PathVariable int id){
        BoardDetailReq result = boardService.detailOne(id);
        System.out.println("id" + id);
        return result;
    }
}
