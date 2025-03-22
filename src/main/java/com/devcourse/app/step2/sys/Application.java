package com.devcourse.app.step2.sys;

import com.devcourse.app.step2.controller.BoardController;

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

        while(programStatus){
            String line = "https://" + domain;

             String command = sc.nextLine().trim();

             if (command.equals("exit")){
                 programStatus = false;
                 System.out.println("exit");
                 break;
             }




        }
    }
}
