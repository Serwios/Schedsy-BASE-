import java.io.IOException;
import java.net.URL;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser{
    public static void main(String[] args) throws IOException {
        getPage();
        Schedule();
    }

    public static Document getPage() throws IOException{
        String url="https://lpnu.ua/students_schedule?institutecode_selective=%D0%86%D0%9A%D0%A2%D0%90&edugrupabr_selective=%D0%9A%D0%91-15";
        return Jsoup.parse(new URL(url), 3000);
    }

    public static void Schedule() throws IOException  {
        Document page = getPage();

        Element workfield = page.select("div[class=view-content]").first();
        Elements days_code = workfield.select("div[class=view-grouping]");

        for (Element i : days_code) {
            String lessons = i.select("div[class=view-grouping-header]").text();
            String days = i.select("div[class=stud_schedule]").text();

            String str = "\t";

            System.out.println(str);
            System.out.println(lessons);
            System.out.println(days);
        }
    }

}

