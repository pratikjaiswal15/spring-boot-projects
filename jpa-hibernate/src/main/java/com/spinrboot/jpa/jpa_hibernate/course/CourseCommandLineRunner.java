package com.spinrboot.jpa.jpa_hibernate.course;

import com.spinrboot.jpa.jpa_hibernate.course.SpringDataJPA.CourseSpringDataJpaRepository;
import com.spinrboot.jpa.jpa_hibernate.course.jdbc.CourseJdbcRepository;
import com.spinrboot.jpa.jpa_hibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;


//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "AWS JPA ", "Udemy"));
//        repository.insert(new Course(2, "Spring boot JPA", "In28Minutes"));
//        repository.insert(new Course(3, "React JPA", "CodeEvolution"));

//        repository.delete(1L);
//        System.out.println(repository.getCourseById(2));
//        System.out.println(repository.getCourseById(3));


        repository.save(new Course(1, "AWS JPA Data", "Udemy"));
        repository.save(new Course(2, "Spring boot JPA Data", "In28Minutes"));
        repository.save(new Course(3, "React JPA Data", "CodeEvolution"));

        repository.deleteById(1L);
//        System.out.println(repository.findById(2L));
//        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("In28Minutes"));

        System.out.println(repository.findByName("React JPA Data"));
        System.out.println(repository.findByName("Angular JPA Data"));



    }
}
