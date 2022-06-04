package com.cydeo.tests.day8_Properties;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void java_properties_reading_test(){

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));


    }

}
