import java.util.Arrays;
import java.util.List;
import org.testng.TestNG;

public class CustomRunner {

  public static void main(String[] args) {

    TestNG testNG = new TestNG();
//    List<String> file = Arrays.asList("./src/main/java/resources/suites/mailTests.xml");
    List<String> file = Arrays.asList("./src/main/java/resources/suites/cloudTests.xml");
    testNG.setTestSuites(file);
    testNG.run();
  }
}
