package exponential.backoff.and.jitter;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ExponentialBackoffAndJitterSampleTest {
    @Test
    void sleepExponentiallyTest() throws Exception {
        final var exponentialBackoffAndJitterSample = new ExponentialBackoffAndJitterSample();
        var actual = new ArrayList<Double>();
        for(int i = 1; i <= 5; i++) {
            actual.add(exponentialBackoffAndJitterSample.sleepExponentially(i));
        }

        assertTrue(actual.get(0) <= actual.get(1));
        assertTrue(actual.get(1) <= actual.get(2));
        assertTrue(actual.get(2) <= actual.get(3));
        assertTrue(actual.get(3) <= actual.get(4));
    }
}
