package environment;

        import org.openqa.selenium.WebDriver;

public class RunEnvironment {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    static void setDriver(WebDriver driver) {
        RunEnvironment.driver = driver;
    }
}
