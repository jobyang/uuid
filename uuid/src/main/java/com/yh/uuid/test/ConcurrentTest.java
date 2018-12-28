package com.yh.uuid.test;

import java.util.concurrent.*;

public class ConcurrentTest {
    /**
     * 请求数
     */
    private static final int clientTotal = 5000;
    /**
     * 并发数
     */
    private static final int threadsTotal = 5000;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5000, 10000, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        final Semaphore semaphore = new Semaphore(threadsTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        ConcurrentHashMap<String, String> idMap = new ConcurrentHashMap<>(16);
        for (int i = 0; i < clientTotal; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 并发请求逻辑 start
                    String uuid = HttpRequestTest.sendGet("http://localhost:8899/getId", "");
                    System.out.println(Thread.currentThread().getName() + ">>>>>" + uuid);
                    idMap.put(uuid, uuid);
                    // 并发请求逻辑 end
                    semaphore.release();
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        threadPoolExecutor.shutdown();
        System.out.println("is has repeat id : >>>> " + idMap.size() + " 个 " + (idMap.size() == clientTotal));
    }
}
