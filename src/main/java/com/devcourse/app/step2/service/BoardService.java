package com.devcourse.app.step2.service;

import com.devcourse.app.step2.data.Board;
import com.devcourse.app.step2.repository.BoardRepository;

public class BoardService {
    private BoardRepository boardRepository = new BoardRepository();

    public int createBoard (String boardName,String createdBoardDesc){
       return boardRepository.save(boardName,createdBoardDesc);
    }

    public Board getBoardById(int boardId){
        return boardRepository.getBoardById(boardId);
    }

    public Board getBoardByName(String boardName){
        return boardRepository.getBoardByName(boardName);
    }

    public void updateBoard(int boardId, String boardName, String boardDesc){
         boardRepository.update(boardId,boardName,boardDesc);
    }

    public boolean removeBoard(int boardId){
        try {
            boardRepository.remove(boardId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
