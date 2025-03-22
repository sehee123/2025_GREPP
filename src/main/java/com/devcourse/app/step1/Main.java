package com.devcourse.app.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args)  {
        Stack<String[]> board = new Stack<String[]>();

        while(true){

            Scanner sc = new Scanner(System.in);
            System.out.print("명령어 > " );
            String command = sc.next();

            if (command.equals("작성")){

                String[] arr = new String[2];
                System.out.print("제목 : ");
                String title = sc.next();
                System.out.print("내용 : ");
                String content = sc.next();

                arr[0] = title;
                arr[1] = content;

                board.push(arr);

            }else if(command.equals("조회")){
                System.out.print("어떤 게시물을 조회할까요? " );
                int n = Integer.parseInt(sc.next());

                try {
                    System.out.println("제목 : [" + board.get(n-1)[0] + "]");
                    System.out.println("내용 : [" + board.get(n-1)[1] + "]");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(n + " 게시글은 존재하지 않습니다.");
                }
            }else if(command.equals("삭제")){
                System.out.print("어떤 게시물을 삭제할까요? " );
                int n = Integer.parseInt(sc.next());

                try {
                    board.remove(n-1);
                    System.out.println(n + "번 게시물이 성공적으로 삭제되었습니다!");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(n+"번 게시글은 존재하지 않습니다.");
                }
            }else if (command.equals("수정")){
                System.out.println("어떤 게시물을 수정할까요? " );
                int n = Integer.parseInt(sc.next());

                try {
                    board.remove(n-1);
                    System.out.print(n + "번 게시물을 수정합니다" );
                    String[] arr = new String[2];
                    System.out.print("제목 : ");
                    String title = sc.next();
                    System.out.print("내용 : ");
                    String content = sc.next();

                    arr[0] = title;
                    arr[1] = content;

                    board.add(n-1 , arr);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(n+"번 게시글은 존재하지 않습니다.");
                }
            }else if(command.equals("목록")){
                System.out.println("총 게시글은 " + board.size() + "개 작성되어있습니다.");
                int idx = 0;
                for (String[] strings : board) {
                    idx ++;
                    System.out.println(idx+"번 게시글");
                    System.out.println("제목 : " + strings[0]);
                    System.out.println("내용 : " + strings[1]);
                    System.out.println();
                }
            }
        }

    }


}
