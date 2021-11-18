package wimix;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getSelenideProxy;

final class ProxyServerUsageTest {

    @Test
    void canAddInterceptorsToProxyServer() {
        Configuration.proxyEnabled = true;
        open();
        SelenideProxyServer selenideProxy = getSelenideProxy();

        selenideProxy.addRequestFilter("proxy-usages.request", (request, contents, messageInfo) -> {
            request.headers().remove("authorization");
            request.headers().add("authorization", "Basic bXNxLXVzZXI6Z2pyWDQ2Sk51NTYzNHY=");
            return null;
        });
        open("https://app.magictrade.io/app/login");
    }
}