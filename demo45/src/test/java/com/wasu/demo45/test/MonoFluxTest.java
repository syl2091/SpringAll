package com.wasu.demo45.test;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName:MonoFluxTest
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/19 15:10
 */
public class MonoFluxTest {
    public static void main(String[] args) {
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            private Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("接受到数据" + integer);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                subscription.cancel();
            }

            @Override
            public void onComplete() {
                System.out.println("处理完了!");
            }
        };

        String[] strs = {"1","2","3"};
        Flux.fromArray(strs).map(Integer::parseInt).subscribe(subscriber);
        Mono.fromSupplier(()->1).map(s->s+1).subscribe(subscriber);
    }
}
