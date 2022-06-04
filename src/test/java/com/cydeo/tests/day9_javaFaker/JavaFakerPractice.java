package com.cydeo.tests.day9_javaFaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {


    @Test
    public void test1(){

        Faker faker = new Faker();

        System.out.println(faker.animal().name());
        System.out.println(faker.animal().name());
        System.out.println(faker.animal().name());
        System.out.println(faker.animal().name());

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().firstName());

        System.out.println();

        System.out.println(faker.chuckNorris().fact());

        System.out.println(faker.numerify("0 (505) no:### ## ##"));
        System.out.println(faker.numerify(""));

        System.out.println(faker.letterify("???-????").toUpperCase());
        System.out.println(faker.bothify("?###??-??###??").toUpperCase());

        System.out.println(faker.finance().creditCard());


    }
}
