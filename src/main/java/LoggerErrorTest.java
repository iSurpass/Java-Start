import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class LoggerErrorTest {

    public static final Logger logger = LoggerFactory.getLogger(LoggerErrorTest.class);

    public static void main(String[] args) {

        logger.error("null exception",new NullPointerException());
    }
}
