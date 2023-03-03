package com.merkez.training.spring.firstspring;

import com.merkez.training.spring.firstspring.person.rest.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// @SpringBootApplication(scanBasePackages = {"com.merkez.training.spring.firstspring","a.b.c"})
@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
@EnableScheduling
@EnableAsync
public class FirstSpringApplication implements CommandLineRunner {

    @Autowired
    private AsycTaskTest asyncTaskTest;

    private long counter = 0;

    @Bean
    public Executor executorMyAsync(){
        return Executors.newFixedThreadPool(10);
    }

    @Scheduled(fixedDelay = 5_000, initialDelay = 2_000)
    public void perMethod() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException eParam) {
        }
        System.out.println("Counter : " + counter++);
    }

    @Scheduled(fixedRate = 5_000, initialDelay = 2_000)
    public void perMethod2() {
        System.out.println("Counter 2 : " + counter++);
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void perMethod3() {
        System.out.println("Counter 3 : " + counter++);
    }

    @Scheduled(fixedDelayString = "${app.schedule}", initialDelay = 2_000)
    public void perMethod4() {
        System.out.println("Counter 4 : " + counter++);
    }

    //@Scheduled(cron = "${my.app.task-cron}")
    @Scheduled(cron = "#{appProperties.getTaskCron()}")
    public void perMethod5() {
        System.out.println("Counter 5 : " + counter++);
    }


    public static void main(String[] args) {
//        Class<FirstSpringApplication> firstSpringApplicationClass = FirstSpringApplication.class;
//        SpringBootApplication annotation = firstSpringApplicationClass.getAnnotation(SpringBootApplication.class);
//        String[] strings = annotation.scanBasePackages();
        ConfigurableApplicationContext context = SpringApplication.run(FirstSpringApplication.class,
                                                                       args);
        Person person = new Person();
        person.setUsername("user3");
        person.setFirstName("osman");
        person.setLastName("yaycıoğlu");
        person.setAge(53);

        PersonManager personManager = context.getBean(PersonManager.class);
        personManager.addPerson(person);

        System.out.println("hello");

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("<-------------   Bu önceki satır " + Thread.currentThread().getName());
        Future<String> stringFuture = asyncTaskTest.asycMethod();
        System.out.println("<-------------   Bu sonraki satır " + Thread.currentThread().getName());
        System.out.println(stringFuture.get());
    }
}
