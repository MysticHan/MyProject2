
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class Test {
 
	public static void main(String[] args)throws Exception{
		
			try{
				Document doc = Jsoup.connect("http://www.facebook.com/607157789366656_828096083939491").get();

				String title = doc.title();
				

				System.out.println(title);
				
				Elements cates = doc.select("html[id*=facebook]");
				
				
				String imgCrawling=convertHtmlimg(cates.html());
				
				System.out.println(imgCrawling);
				
			}
			catch(ArithmeticException e){
			}
	}
	
	public static String convertHtmlimg(String img) {
        Pattern p = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
        Matcher m = p.matcher(img);
        String t = "";
        while (m.find()) {
//            System.out.println(m.group(1));
            t = m.group(1);
        }
        return t;
    }
 
}
