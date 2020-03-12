
public class parser extends {


    public static void main(String[] args) throws IOException {

        parser app = new parser(); //GUI

        getPage();
        Schedule();

    }


     public static Document getPage() throws IOException{

        String url="https://lpnu.ua/students_schedule?institutecode_selective=%D0%86%D0%9A%D0%A2%D0%90&edugrupabr_selective=%D0%9A%D0%91-15";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;

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

//By Y.K