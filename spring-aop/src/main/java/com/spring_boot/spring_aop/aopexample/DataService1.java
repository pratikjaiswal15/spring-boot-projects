package com.spring_boot.spring_aop.aopexample;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retrieveData() {
        return new int[] {1,3,56,78,81};
    }
}
