import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Created by quan on 2017/7/26.
 */
public class LogTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.info("Hello World");
    }
}
