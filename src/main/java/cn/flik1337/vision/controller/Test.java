package cn.flik1337.vision.controller;

import cn.flik1337.vision.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    public static void main(String[] args) {
        int[] price = new int[2];
        price[0] = 1990;
        price[1] = 3990;
        for (int i = 0;i < 10;i++){
            int index= i%2;
            System.out.println(price[index]);
        }
    }
}
