package wimix;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getSelenideProxy;

final class ProxyServerUsageTest {

    @Test
    void testCookieInjection() {
        Configuration.proxyEnabled = true;
        open();
        SelenideProxyServer selenideProxy = getSelenideProxy();

        if (selenideProxy != null) {
            selenideProxy.addRequestFilter("test request", (request, contents, messageInfo) -> {
                request.headers().remove("cookie");
                request.headers().add("cookie", "_got_selected_key=ui35n491itk2j19h8mc5v0phb3; _fbp=fb.1.1616691008245.2117837222; _ga=GA1.2.502398389.1616691008; _ym_uid=1616691008316846133; roistat_first_visit=1854897; ___dc=e17d7c2b-06f9-4dd6-8ae2-e332afef1677; dbl=e4d29e924a2043488f13ecea44b3b674; fco2r34=e4d29e924a2043488f13ecea44b3b674; cook_email=abmetko.a@gmail.com; cook_pass=d0dd21dbf1c5a435ba047db9acb884ae; PHPSESSID=1963h8rjobl06ig7k692a38dn1; roistat_is_need_listen_requests=0; _gcl_au=1.1.810918088.1636050455; _ym_d=1636050455; _scSID=163605253179241; _statclick=4c501be40b23ecd8c06740e137bcb72f; _ym_isad=1; _gid=GA1.2.1582385207.1637247573; roistat_call_tracking=1; roistat_emailtracking_email=null; roistat_emailtracking_tracking_email=null; roistat_emailtracking_emails=[]; leadhunter_expire=1; roistat_leadHunterCaught=1; _dc_gtm_UA-111897233-1=1; roistat_visit=2477497");
                return null;
            });
        }
        open("https://autoostrov.by/account/");
        Configuration.proxyEnabled = false;

        $("input.search-number-field").setValue("31262092").pressEnter();
        $$("div.ftr.element-for-filter.cursor")
                .get(1)
                .$("i.fal.fa-search").shouldBe(Condition.enabled, Duration.ofSeconds(30)).click();
        $x("//h1[contains(text(),'VOLVO 31262092')]").shouldBe(Condition.visible, Duration.ofSeconds(30));
    }
}