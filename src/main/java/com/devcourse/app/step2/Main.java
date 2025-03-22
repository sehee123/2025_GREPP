package com.devcourse.app.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String URL = sc.nextLine();
        String [] split = URL.split("\\?",2); //정규표현식에서 ? 는 특수 문자이므로 이스케이프 필요
        String [] gubun = split[0].split("/");
        List<String> boardList = new ArrayList<String>();

        if (spglit[1].equals("boards")){
            if (split[2].equals("add")){

            }else if(split[2].equals("edit")){

            }else if (split[2].equals("remove")){

            }else if(split[2].equals("view")){

            }
        }else if (split[1].equals("posts")){

        }
    }

}
