package com.devcourse.app.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("명령어 > " );
            String str = sc.next();
            if(str.equals("exit")){
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
            System.out.println(str);
        }

    }


}
