interface JavascriptExecutor {
    public void executeScript();
}

interface WebDriver {
    public void findElement();
    public void findElements();
}

class RemoteWebDriver implements JavascriptExecutor, WebDriver {

    @Override
    public void executeScript() {
        System.out.println("RemoteWebDriver - executeScript");
    }

    @Override
    public void findElement() {
        System.out.println("RemoteWebDriver - findElement");
    }

    @Override
    public void findElements() {
        System.out.println("RemoteWebDriver - findElements");
    }
}

class ChromeDriver extends RemoteWebDriver {

    @Override
    public void findElement() {
        System.out.println("ChromeDriver - find element");
    }

    @Override
    public void findElements() {
        System.out.println("ChromeDriver - find elements");
    }
}

public class WebDriverSimulation {

    static RemoteWebDriver remoteDriver;
    static WebDriver driver;
    static JavascriptExecutor js;

    public static void main(String[] args) {
        remoteDriver = new RemoteWebDriver();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

        remoteDriver.findElement();
        remoteDriver.findElements();
        remoteDriver.executeScript();

        driver.findElement();
        driver.findElements();
        ((JavascriptExecutor) driver).executeScript();

        js.executeScript();
    }
}

