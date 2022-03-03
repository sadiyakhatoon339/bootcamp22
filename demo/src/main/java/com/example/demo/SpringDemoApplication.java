package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
//		BinarySearch binarySearch=new BinarySearch(new QuickSort());
//		int r=binarySearch.binarySearch(new int[] {1,3,2},3);
//		System.out.println(r);


        ApplicationContext applicationContext = SpringApplication.run(SpringDemoApplication.class, args);
        //Q4 Get a Spring Bean from application context and display its properties.
        BinarySearch binarySearch = applicationContext.getBean(BinarySearch.class);
        int r = binarySearch.binarySearch(new int[]{1, 3, 2}, 3);
        System.out.println(r);
    }

}
