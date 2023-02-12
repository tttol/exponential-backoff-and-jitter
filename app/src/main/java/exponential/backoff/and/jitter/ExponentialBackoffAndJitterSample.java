package exponential.backoff.and.jitter;

import java.util.Random;
import java.util.logging.Logger;

public class ExponentialBackoffAndJitterSample {
    private static final Logger log = Logger.getLogger(ExponentialBackoffAndJitterSample.class.getName());
    private static final int MAX_RETRY_COUNT = 5;
    private static final int CAP = 10000; //milli second
    private static final int BASE = 1000; 

    public void run() throws InterruptedException {
        for(int i = 1; i <= MAX_RETRY_COUNT; i++) {
            try {
                log.info("------------ try count: %d ------------".formatted(i));
                job();
                return;
            } catch(Exception e) {
                sleepExponentially(i);
            }
        }
    }
    
    public double sleepExponentially(final int attempt) throws InterruptedException {
        final var temp = Math.min(CAP, BASE * Math.pow(2, attempt));
        final var r = new Random();
        final var sleepTime = temp / 2 + r.nextDouble((temp / 2));
        log.info("sleep time: %f ms".formatted(sleepTime));
        
        Thread.sleep(((long)sleepTime));
        
        return sleepTime;
    }

    private void job() {
        // リトライさせたいので常に例外を出すようにしておく
        throw new RuntimeException("Time out!");
    }
}
