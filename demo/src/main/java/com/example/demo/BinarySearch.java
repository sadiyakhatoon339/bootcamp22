package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//Creating instance of bean 'Binarysearch'
//Creating instance of bean "Bubblesort"
//Finished creating instance of bean "BibbleSort"
//Autowriting by type from bean name "BinarySearch" via constructor
//to bean named "Bubblesort"--when we use contrtr injection
//Finished creating instance of bean :Binarysearch


//Q3  Use @Compenent and @Autowired annotations to in Loosely Coupled code for dependency management

@Component
public class BinarySearch {

    @Autowired
    private SortAlgorithm sortAlgorithm;//SortAlgorithm is a dependency of binary search


    //Q6 Perform Constructor Injection in a Spring Bean
    public BinarySearch(SortAlgorithm sortAlgorithm) {//which algorithm do we want to use
        super();
        this.sortAlgorithm = sortAlgorithm;
    }

    public int binarySearch(int[] numbers, int numberToSearch) {


        int[] sortedNumber = sortAlgorithm.sort(numbers);

        System.out.println(sortAlgorithm);
        return 3;
    }
}
