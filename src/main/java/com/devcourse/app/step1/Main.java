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
                System.out.println("제목 : [" + board.peek()[0] + "]");
                System.out.println("내용 : [" + board.peek()[1] + "]");
            }else if(command.equals("삭제")){
                board.pop();
            }else if (command.equals("수정")){
                String[] arr = new String[2];
                System.out.print("제목 : ");
                String title = sc.next();
                System.out.print("내용 : ");
                String content = sc.next();

                arr[0] = title;
                arr[1] = content;
                board.pop();
                board.push(arr);
            }
        }

    }


}
