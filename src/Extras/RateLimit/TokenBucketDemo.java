package Extras.RateLimit;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucketDemo {

    private final long maxTokens;

    private final long refillIntervalInMills;

    private final long tokensPerInterval;

    private AtomicLong availableTokens;

    private long lastRefillTs;


    public TokenBucketDemo(long maxTokens, long refillIntervalInMills, long tokensPerInterval) {
        this.maxTokens = maxTokens;
        this.refillIntervalInMills = refillIntervalInMills;
        this.tokensPerInterval = tokensPerInterval;
        this.availableTokens = new AtomicLong(maxTokens);
        this.lastRefillTs = Instant.now().toEpochMilli();
    }


    public synchronized boolean tryConsume() {
        // 每次consume才顺便去看需不需要进行refill
        refillTokens();
        // 然后再判断当前是否有token, 进行consume
        if (availableTokens.get() > 0) {
            availableTokens.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refillTokens() {
        long currentMs = Instant.now().toEpochMilli();
        long elapsedMs = currentMs - lastRefillTs;
        if (elapsedMs > refillIntervalInMills) {
            // 懒惰型触发, tokenToAdd可能会因为某段时间没人用, 导致fill很多, 但因为maxToken数量的情况, 实际上也不会造成影响
            long tokenToAdd = (elapsedMs / refillIntervalInMills) * tokensPerInterval;
            long newTokenCount = Math.min(maxTokens, tokenToAdd + availableTokens.get());
            availableTokens.set(newTokenCount);
            lastRefillTs = currentMs;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        TokenBucketDemo tokenBucketDemo = new TokenBucketDemo(10, 5000, 10);

        // Simulate request attempts.
        for (int i = 0; i < 15; i++) {
            if (tokenBucketDemo.tryConsume()) {
                System.out.println("Request " + (i + 1) + ": Allowed");
            } else {
                System.out.println("Request " + (i + 1) + ": Denied");
            }

            // Pause to simulate time between requests.
            Thread.sleep(200);
        }
    }

}
