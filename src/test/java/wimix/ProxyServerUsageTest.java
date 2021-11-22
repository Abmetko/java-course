package wimix;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getSelenideProxy;
import static io.restassured.RestAssured.given;

final class ProxyServerUsageTest {

    @Test
    void testCookieInjection() {
        Configuration.proxyEnabled = true;
        open();
        SelenideProxyServer selenideProxy = getSelenideProxy();

        selenideProxy.addRequestFilter("proxy-usages.request", (request, contents, messageInfo) -> {
            request.headers().remove("authorization");
            request.headers().remove("cookie");
            request.headers().add("authorization", "Basic bXNxLXVzZXI6Z2pyWDQ2Sk51NTYzNHY=");
            request.headers().add("cookie", "io=8kpTPuTf_zIUqO5PAABL;_gid=8kpTPuTf_zIUqO5PAABL;_ga=GA1.2.1704210729.1637241771;");
            return null;
        });
        open("https://app.magictrade.io/app/login");
        System.out.println("");



//        Configuration.proxyEnabled = true;
//        open();
//        SelenideProxyServer selenideProxy = getSelenideProxy();
//
//        if (selenideProxy != null) {
//            selenideProxy.addRequestFilter("test request", (request, contents, messageInfo) -> {
//                request.headers().remove("cookie");
//                request.headers().remove("csrf-token");
//
//                request.headers().add("cookie", "li_sugr=3973b8df-83e6-47a4-908c-ad1431c11241; bcookie=\"v=2&3026bdc4-7be0-414d-81c6-4d97088a053d\"; bscookie=\"v=1&20210218185141a09015a5-feb5-428b-8ccf-72836aeb7121AQHcZiTsXxUUotM7u-HJAoVneU8c3IU5\"; _ga=GA1.2.792270641.1613674304; aam_uuid=84233023782005151201274759407967425880; li_rm=AQFswQ1QtOotYQAAAXe2fEhnGC6LQMbv2GhqK0g12262f5IvkklP-_k4wYfB9B-ttRfru1M0pV4s79-y9U2HTPoPzRgm5d1GhiubEeenEkC2fhyvllKrE90s; liap=true; JSESSIONID=\"ajax:8929999631073576633\"; spectroscopyId=151b0a61-3d4a-4c30-a7bc-ecace9e3ce93; AMCVS_14215E3D5995C57C0A495C55@AdobeOrg=1; lil-lang=en_US; li_ep_auth_context=AE5hcHA9bGVhcm5pbmcsYWlkPTIwOTU4MjgsaWlkPTYxNjAyMDA5LHBpZD0xMzg1NDY2NDQsZXhwPTE2MzY2NTYyMDIwNDUsY3VyPXRydWUBSFdmdrElULkK5Omu5a2jaRgx_jc; _gcl_au=1.1.1786088997.1628880207; s_cc=true; timezone=Europe/Minsk; AMCV_14215E3D5995C57C0A495C55@AdobeOrg=-637568504|MCIDTS|18886|MCMID|83707094231465784271260996702057178771|MCAAMLH-1632377503|6|MCAAMB-1632377503|6G1ynYcLPuiQxYZrsz_pkqfLG9yMXBpb2zX5dvJdYQJzPXImdj0y|MCOPTOUT-1631779903s|NONE|vVersion|5.1.1|MCCIDH|-2088431077; s_fid=572270DF5F2250E2-2BA8F7647CA33CE9; _guid=e45fc9a1-dcb6-428a-9b7c-56dc29437a71; PLAY_LANG=en; __ssid=64d765c4-25e3-4a8f-93fe-c2250fa82bfe; fptctx2=taBcrIH61PuCVH7eNCyH0Hqy8%2bhstDy2LqBxkv54lMmR5%2bmNz9hHqi6%2bFivVGJTTbt0XHgTiK5A6vp1hJgPaiVsDsMZm0HEwxm6Gs9VsSOI6LbvSmNsPJYD9jH0VZo1ySHhBEERzaToI1PfPIhoibs%2fyJ1m9nXUyRvbOI7Qfi0LQ1HFpAcifuYuFlL3KXVHigp6O5TYkN9QG4yNLr0V4u3gCU7BhwiuW8cgDn1c6l%2bMB2mKwDxe4Abiw3U9aWMmuW7t7N7XGPciJaW228VzMV8JggCZhl0J%2bs9JKs3eX01JoMbRbgS8ny6nISz3ega%2be; dfpfpt=9598c77e46c740d3a7be17c19595386f; lang=v=2&lang=en-US; PLAY_SESSION=eyJhbGciOiJIUzI1NiJ9.eyJkYXRhIjp7InNlc3Npb25faWQiOiI3OTc1MGFlZS0wZTAzLTQ2OGUtOTUwMi1mNTQ3OTQyNzE5NWV8MTYzNDY3MzY2OSIsImFsbG93bGlzdCI6Int9IiwicmVjZW50bHktc2VhcmNoZWQiOiIiLCJyZWZlcnJhbC11cmwiOiJodHRwczovL3d3dy5saW5rZWRpbi5jb20vcHJlbWl1bS9wcm9kdWN0cy8_ZGVzdFJlZGlyZWN0VVJMPWh0dHBzJTNBJTJGJTJGd3d3LmxpbmtlZGluLmNvbSUyRm1lJTJGcHJvZmlsZS12aWV3cyUyRnVybiUzQWxpJTNBY29tcGFueSUzQTI1OTY2MTklMkYlM0ZzaG93UHJlbWl1bVdlbGNvbWVCYW5uZXIlM0R0cnVlJmluZGV4RGVzdFJlZGlyZWN0VVJMPWh0dHBzJTNBJTJGJTJGd3d3LmxpbmtlZGluLmNvbSUyRm1lJTJGcHJvZmlsZS12aWV3cyUyRnVybiUzQWxpJTNBY29tcGFueSUzQTI1OTY2MTklMkYlM0ZzaG93UHJlbWl1bVdlbGNvbWVCYW5uZXIlM0R0cnVlJmluZGV4VXBzZWxsT3JkZXJPcmlnaW49cHJlbWl1bV93dm1wX3Vwc2VsbF9jb21wYW55JnVwc2VsbE9yZGVyT3JpZ2luPXByZW1pdW1fd3ZtcF91cHNlbGxfY29tcGFueSIsImFpZCI6IiIsIlJOVC1pZCI6InwwIiwicmVjZW50bHktdmlld2VkIjoiNDMxIiwiQ1BULWlkIjoiQHbCmVxuwpbCvcKlw7jCv1wielx1MDAxQn3Cs8ONMyIsImV4cGVyaWVuY2UiOiJlbnRpdHkiLCJpc19uYXRpdmUiOiJmYWxzZSIsInRyayI6IiJ9LCJuYmYiOjE2MzQ2NzM2NzAsImlhdCI6MTYzNDY3MzY3MH0.xmmqSZAFl_49G6mzFUtiADrQUJkL-FjVpGNwAGpS4EU; s_sq=[[B]]; s_ips=714; s_tp=714; s_plt=3.88; s_pltp=www.linkedin.com/learning/advanced-selenium-support-classes/slow-loadable-components; s_ppv=www.linkedin.com/learning/advanced-selenium-support-classes/slow-loadable-components,100,100,714,1,1; gpv_pn=www.linkedin.com/learning/advanced-selenium-support-classes/slow-loadable-components; s_tslv=1636960438699; sdsc=1:1SZM1shxDNbLt36wZwCgPgvN58iw=; AnalyticsSyncHistory=AQJLcQcrO3BUOAAAAX0y0ZwAGnC92Xed46ucX1YSfDx-wlK_vy01AdicxT_jZLjmHUPU4FDF4eS1HmJh8Iq6tg; lms_ads=AQEMJcWSFm-VEQAAAX0y0Z1GpyEkYHTBY4v-8-04cO67s_vPJftR0J7KBsm-idWd3ZQN3ZrYTe3ZFtY8hlX8USd7ehMF_SiP; lms_analytics=AQEMJcWSFm-VEQAAAX0y0Z1GpyEkYHTBY4v-8-04cO67s_vPJftR0J7KBsm-idWd3ZQN3ZrYTe3ZFtY8hlX8USd7ehMF_SiP; li_at=AQEFAHQBAAAAAAX4WeIAAAF8hFRe-gAAAX1YsTAbTQAAF3VybjpsaTptZW1iZXI6MzU3MDA3ODcwWNrhPAKAtXTj1f60XxmL8l9U_akaCV7O3lRmXHlDRng807YkA6Y9GPQyIKXiY01gRvehNoHWBpAybDOiyRojtYY97FkA2_l2faRsDvPAVUHoqYpQisvqmlXHg5nbjxS8Cq_nW8lXgj71-UdOJEYO4z7E9pSQ22blKQUcfISomlWxAiO3kIAyldbC4rOzJ9C_OclZUg; li_mc=MTsyMTsxNjM3MzA4MDkwOzE7MDIxKRp/LWBtsGjbRtWX6jrokIrjCSaWfW09+wCKDZy7Jl8=; UserMatchHistory=AQLeqCjpwGP0lgAAAX03KtCZdV5G4bS-qWxkU9hxkov1f5gNaUM6ZZhUrxCPuvB1eDRNBecvvIHNESNKD6FYF2L4Cn3FTL8Z-CP52dk-7emjB2P7rPznjm9uOstqlROn_ew1Ayhd1I8xg_ITcDxyBtswYw5KCiDFd2cg_ykJxwjKOdgxcVTEuVXPMowfYAszRqdDaTad0ckUuXTjGnZ70m7ArnGpkXKDSffjUVSF038IWxE6T_OdyfMv8SRb8yEFmeM_tcSInadrgdVXim05tXjQEYzANyKUkfbevrc; AMCV_14215E3D5995C57C0A495C55@AdobeOrg=-637568504|MCIDTS|18951|MCMID|83707094231465784271260996702057178771|MCAAMLH-1637912894|6|MCAAMB-1637912894|6G1ynYcLPuiQxYZrsz_pkqfLG9yMXBpb2zX5dvJdYQJzPXImdj0y|MCOPTOUT-1637315294s|NONE|vVersion|5.1.1|MCCIDH|-2088431077; lidc=\"b=VB70:s=V:r=V:a=V:p=V:g=2849:u=339:x=1:i=1637308094:t=1637372907:v=2:sig=AQEXAhy8gKmpsNwt-vbLA4QJUX4KSVt1\"");
//                request.headers().add("csrf-token","ajax:8929999631073576633");
//                return null;
//            });
//        }
//
//        open("https://www.linkedin.com/mynetwork/");
//        Configuration.proxyEnabled = false;
//
//        $("input.search-number-field").setValue("31262092").pressEnter();
//        $$("div.ftr.element-for-filter.cursor")
//                .get(1)
//                .$("i.fal.fa-search").shouldBe(Condition.enabled, Duration.ofSeconds(30)).click();
//        $x("//h1[contains(text(),'VOLVO 31262092')]").shouldBe(Condition.visible, Duration.ofSeconds(30));
//        $("div.head-profile.head-item").hover();
//        $$("li").get(0).$("a").click();
//        System.out.println("");
    }


    public static class RestService {

        static {
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }

        public static String getCookie() {
            Response response = given().relaxedHTTPSValidation()
                    .contentType(ContentType.URLENC)
                    .header("referer", "https://autoostrov.by/account/signin/")
                    .formParam("action", "signin")
                    .formParam("form[email]", "abmetko.a@gmail.com")
                    .formParam("form[pass]", "Andrey21061985")
                    .formParam("form[rememberme]", "1")
                    .when().redirects().follow(false)
                    .post("https://autoostrov.by/account/login/")
                    .then()
                    .assertThat()
                    .statusCode(301)
                    .extract()
                    .response();

            return "_scSID=" + response.getCookie("_scSID") + ";" +
                    "cook_email=" + response.getCookie("cook_email") + ";" +
                    "cook_pass=" + response.getCookie("cook_pass") + ";" +
                    "_accounts_anyprofiles=" + response.getCookie("_accounts_anyprofiles") + ";";
        }

        public static void main(String[] args) {
            getCookie();
        }

        public void userCreation(Object obj) {

        }

        public void adminCreation(Object obj) {

        }
    }
}