package wimix;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.getSelenideProxy;

final class ProxyServerInjectCookieTest {

    @Test
    void testCookieInjection() {
        Configuration.proxyEnabled = true;
        open();
        SelenideProxyServer selenideProxy = getSelenideProxy();

        assert selenideProxy != null;
        selenideProxy.addRequestFilter("request", (request, contents, messageInfo) -> {
            request.headers().remove("cookie");
            request.headers().add("cookie", "_got_selected_key=ui35n491itk2j19h8mc5v0phb3; _fbp=fb.1.1616691008245.2117837222; _ga=GA1.2.502398389.1616691008; _ym_uid=1616691008316846133; roistat_first_visit=1854897; ___dc=e17d7c2b-06f9-4dd6-8ae2-e332afef1677; dbl=e4d29e924a2043488f13ecea44b3b674; fco2r34=e4d29e924a2043488f13ecea44b3b674; PHPSESSID=1963h8rjobl06ig7k692a38dn1; roistat_is_need_listen_requests=0; _gcl_au=1.1.810918088.1636050455; _ym_d=1636050455; roistat_call_tracking=1; roistat_emailtracking_email=null; roistat_emailtracking_tracking_email=null; roistat_leadHunterCaught=1; roistat_visit=2477497; _accounts_anyprofiles=[{\"id\":\"23335\",\"name\":\"\\u0410\\u0431\\u043c\\u0451\\u0442\\u043a\\u043e+\\u0410\\u043d\\u0434\\u0440\\u0435\\u0439\",\"cook_email\":\"abmetko.a@gmail.com\",\"cook_pass\":\"d0dd21dbf1c5a435ba047db9acb884ae\"}]; cook_email=abmetko.a@gmail.com; cook_pass=d0dd21dbf1c5a435ba047db9acb884ae; roistat_emailtracking_emails=null; _scSID=163769526915216; _statclick=4c501be40b23ecd8c06740e137bcb72f; _gid=GA1.2.182583520.1637781829; _ym_isad=1; _dc_gtm_UA-111897233-1=1");
            return null;
        });
        open("https://autoostrov.by/account/");
        System.out.println("for debug");
    }

    @Test
    void testBypassLoginFlow() {
        open("https://autoostrov.by/");
        webdriver().driver().getWebDriver().manage().addCookie(new Cookie("_scSID", "163769526915216"));
        webdriver().driver().getWebDriver().manage().addCookie(new Cookie("cook_email", "abmetko.a%40gmail.com"));
        webdriver().driver().getWebDriver().manage().addCookie(new Cookie("cook_pass", "d0dd21dbf1c5a435ba047db9acb884ae"));
        webdriver().driver().getWebDriver().manage().addCookie(new Cookie("_accounts_anyprofiles", "%5B%7B%22id%22%3A%2223335%22%2C%22name%22%3A%22%5Cu0410%5Cu0431%5Cu043c%5Cu0451%5Cu0442%5Cu043a%5Cu043e+%5Cu0410%5Cu043d%5Cu0434%5Cu0440%5Cu0435%5Cu0439%22%2C%22cook_email%22%3A%22abmetko.a%40gmail.com%22%2C%22cook_pass%22%3A%22d0dd21dbf1c5a435ba047db9acb884ae%22%7D%5D"));
        open("https://autoostrov.by/account/");
        System.out.println("for debug");
    }
}