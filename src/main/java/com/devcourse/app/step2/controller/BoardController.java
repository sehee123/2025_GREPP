package com.devcourse.app.step2.controller;


import com.devcourse.app.step2.data.Board;
import com.devcourse.app.step2.data.Post;
import com.devcourse.app.step2.service.BoardService;
import com.devcourse.app.step2.sys.Request;

import java.util.List;
import java.util.Scanner;

public class BoardController {

    private Scanner sc = new Scanner(System.in);
    private BoardService boardService = new BoardService();

    public void requestHandle(Request request){
        switch (request.getMethodCode()){
            case "add" :
                System.out.println("게시판을 생성합니다.");
                System.out.print("게시판 이름 ");
                String title = sc.nextLine().trim();
                System.out.print("게시판 설명 ");
                String content = sc.nextLine().trim();
                int createdBoardId = boardService.createBoard(title,content);
                System.out.println(createdBoardId + "번 게시판이 생성 되었습니다.");
                break;
            case "edit" :
                System.out.println("게시판을 수정합니다.");
                System.out.println("게시판 번호를 정수로 입력해주세요.");

                System.out.print("게시판 번호 : ");
                String updatedId = sc.nextLine().trim();

                int updatedBoardId = Integer.parseInt(updatedId);

                System.out.print("게시판 제목 : ");
                String updateBoardName = sc.nextLine().trim();
                System.out.print("게시판 설명 : ");
                String updatedBoardDesc = sc.nextLine().trim();

                boardService.updateBoard(updatedBoardId, updateBoardName,updatedBoardDesc);

                break;
            case "remove" :
                System.out.println("게시판을 삭제합니다.");
                System.out.println("게시판 번호를 정수로 입력해주세요.");

                System.out.print("게시판 번호 : ");
                String removeId = sc.nextLine().trim();

                int removdBoardId = Integer.parseInt(removeId);
                boolean result = boardService.removeBoard(removdBoardId);

                if (result){
                    System.out.println("성공적으로 게시판이 삭제되었습니다.");
                }else{
                    System.out.println("게시판이 삭제에 실패하였습니다.다시 시도해주세요");
                }
                break;

            case "view" :
                System.out.println("게시판을 조회합니다.");
                System.out.println("게시판 이름을 입력해주세요!");
                System.out.println("게시판 이름 : ");

                String boardName = sc.nextLine().trim();

                Board findBoard = boardService.getBoardByName(boardName);

                if (findBoard == null){
                    System.out.println("해당 게시판은 존재하지 않습니다.");
                    break;
                }

                List<Post> postList = findBoard.getPostList();

                if (postList.isEmpty()){
                    System.out.println("아직 작성된 글이 없습니다.");
                }else {
                    System.out.println("글 번호 / 글 제목 / 작성일 ");
                    for (Post post : postList){
                        System.out.printf("%s / %s / %s \n", post.getId(), post.getTitle(), post.getCreatedAt());
                    }
                }

                break;
            default :
                System.out.println("존재하지 않는 명령어입니다.");
        }
    }

}
