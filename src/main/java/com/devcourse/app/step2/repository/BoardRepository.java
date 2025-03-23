package com.devcourse.app.step2.repository;

import com.devcourse.app.step2.data.Board;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BoardRepository {

    private int sequence = 0;
    private List<Board> boardList = new ArrayList<>();

    public int save(String boardName , String description){
        ++sequence;

        Board newBoard = new Board(sequence, boardName, description);
        boardList.add(newBoard);
        return newBoard.getId();
    }

    public Board getBoardById(int id){
        return boardList.get(id-1);
    }

    public void update(int boardId , String boardName , String description){
        Board findBoard = getBoardById(boardId);

        findBoard.setBoardName(boardName);
        findBoard.setDescription(description);
        findBoard.setUpdatedAt(LocalDate.now());
    }

    public void remove(int boardId){
        Board findBoard = getBoardById(boardId);

        if (findBoard != null){
            boardList.set(findBoard.getId()-1, null);
            //.remove하면 순서가 바뀌어버림 순서 = id
        }else {
            throw new NoSuchElementException("해당 게시판은 존재하지 않습니다");
        }
    }

    public Board getBoardByName(String boardName){
        for (Board board : boardList) {
            if (board.getBoardName().equals(boardName)){
               return board;
            }
        }
        return null;
    }
}
