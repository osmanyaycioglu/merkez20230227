package com.merkez.training.spring.firstspring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class AsycTaskTest {


    @Async("executorMyAsync")
    public Future<String> asycMethod() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException eParam) {
        }
        return CompletableFuture.completedFuture("OK " + Thread.currentThread()
                                                               .getName());
    }

}
