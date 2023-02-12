package exponential.backoff.and.jitter;

import java.util.logging.Logger;

public class App {
    private static final Logger log = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        try {
            new ExponentialBackoffAndJitterSample().run();
        } catch(Exception e) {
            log.severe(e.getMessage());
        }
    }
}
