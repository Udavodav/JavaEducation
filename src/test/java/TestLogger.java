import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestLogger {

    private static Logger logger = LoggerFactory.getLogger(TestLogger.class);

    @Test
    public void testTrace() {
        logger.trace("This is a trace message");
    }

    @Test
    public void testTraceDebug() {
        logger.debug("This is a debug");
    }

    @Test
    public void testTraceInfo() {
        logger.info("This is a info");
    }

    @Test
    public void testTraceError() {
        logger.error("This is a error");
    }

    @Test
    public void testTraceWarm() {
        logger.warn("This is a warning");
    }

}
