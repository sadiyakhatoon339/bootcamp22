package com.example.demo;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//Q5 Demonstrate how you will resolve ambiguity while autowiring bean (Hint : @Primary)

@Primary
@Component

public class QuickSort implements SortAlgorithm  {

    public int [] sort(int[] numbers){
        return numbers;}
}
