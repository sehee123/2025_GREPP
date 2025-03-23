package com.devcourse.app.step2.sys;

import com.devcourse.app.step2.controller.BoardController;
import com.devcourse.app.step2.controller.PostController;

import javax.smartcardio.CommandAPDU;
import java.util.Scanner;

public class Application {


    private String domain;

    private Scanner sc = new Scanner(System.in);
    private boolean programStatus = true;

    public Application(String domain) {
        this.domain = domain;
    }

    public void run (){
        BoardController boardController = new BoardController();
        PostController postController = new PostController();
        while(programStatus){
            String line = "https://" + domain;

             String command = sc.nextLine().trim();

             if (command.equals("exit")){
                 programStatus = false;
                 System.out.println("exit");
                 break;
             }

             Request request = new Request(command);

             if (!request.isValid()){
                 System.out.println("잘못된 형식의 입력입니다!");
                 continue;
             }

             switch (request.getControllerCode()){
                 case "posts":
                    postController.requestHandler(request);
                     break;
                 case "boards":
                     boardController.requestHandle(request);
                     break;
                 default:
                     System.out.println("존재하지않는 명령어");
             }




        }
    }
}
