package com.devcourse.app.step2.controller;

import com.devcourse.app.step2.data.Post;
import com.devcourse.app.step2.service.PostService;
import com.devcourse.app.step2.sys.Request;

import java.util.Scanner;

public class PostController {

    private PostService postService = new PostService();
    Scanner sc = new Scanner(System.in);

    public void requestHandler (Request request){
        switch (request.getMethodCode()){
            case "add":
                System.out.println("게시글을 생성합니다!");

                System.out.print("제목: ");
                String title = sc.nextLine().trim();

                System.out.print("내용 : ");
                String body = sc.nextLine().trim();

                int savedPostId = postService.addPost(title,body);

                System.out.println(savedPostId + "번 게시물 작성을 완료했습닏!");
                break;
            case "remove":
                try {
                    System.out.println("게시글을 삭제합니다!");

                    System.out.print("게시물 번호 : ");
                    String targetId = sc.nextLine().trim();

                    int postId = Integer.parseInt(targetId);

                    postService.removdById(postId);
                    System.out.println("성공적으로 삭제 되었습니다!");
                } catch (NumberFormatException e) {
                    System.out.println("게시물 번호는 정수로 입력하여주세요.");
                }catch (NullPointerException e){
                    System.out.println("해당 게시물은 존재하지 않습니다.");
                }catch (IndexOutOfBoundsException e){
                    System.out.println("게시물 번호를 확인해주세요.");
                }catch (Exception e){
                    System.out.println("알 수 없는 오류가 발생했습니다.");
                    e.printStackTrace();
                }

                break;

            case "edit":
                try {
                    System.out.println("게시물을 수정합니다.");

                    System.out.print("게시물 번호 : ");
                    String targetId = sc.nextLine().trim();

                    int postId = Integer.parseInt(targetId);

                    System.out.println("제목 : ");
                    String updateTitle = sc.nextLine().trim();
                    System.out.println("내용 : ");
                    String updateBody = sc.nextLine().trim();

                    postService.update(postId,updateTitle,updateBody);

                    System.out.println("게시물 수정이 완료되었습니다.");
                }catch (NumberFormatException e) {
                    System.out.println("게시물 번호는 정수로 입력하여주세요.");
                }catch (NullPointerException e){
                    System.out.println("해당 게시물은 존재하지 않습니다.");
                }catch (IndexOutOfBoundsException e){
                    System.out.println("게시물 번호를 확인해주세요.");
                }catch (Exception e){
                    System.out.println("알 수 없는 오류가 발생했습니다.");
                    e.printStackTrace();
                }

                break;

            case "view" :
                try {
                    System.out.println("게시물을 조회합니다.");

                    System.out.print("게시물 번호 : ");
                    String targetIdStr = sc.nextLine().trim();

                    int targetId = Integer.parseInt(targetIdStr);

                    Post findPost = postService.getById(targetId);

                    System.out.println("게시물 번호 = " + findPost.getId());
                    System.out.println("게시물 제목 : " + findPost.getTitle());
                    System.out.println("게시물 내용 : " + findPost.getBody());
                    System.out.println("게시물 생성일 : " + findPost.getCreatedAt());
                }catch (NumberFormatException e) {
                    System.out.println("게시물 번호는 정수로 입력하여주세요.");
                }catch (NullPointerException e){
                    System.out.println("해당 게시물은 존재하지 않습니다.");
                }catch (IndexOutOfBoundsException e){
                    System.out.println("게시물 번호를 확인해주세요.");
                }catch (Exception e){
                    System.out.println("알 수 없는 오류가 발생했습니다.");
                    e.printStackTrace();
                }

                break;

            default:
                System.out.println("존재하지 않는 명령어 입니다.");

        }
    }

}
