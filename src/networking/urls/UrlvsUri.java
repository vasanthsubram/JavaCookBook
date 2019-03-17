package networking.urls;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlvsUri {


  public static void main(String[] args) throws MalformedURLException, URISyntaxException {
    String str = "https://www.expedia.com/Seattle-Hotels.d178307.Travel-Guide-Hotels?locale=en_US&siteid=1&regionId=178307&semcid=US.UB.GOOGLE.DL-c-EN.HOTEL&semdtl=a11618438778.b160569787566.r1be827d80c6347f05c9b1431090c8dd58c9771e3ff9e6aede4ca7dad108fe78aa.g1kwd-91127096.i1.d1310137611418.e1c.j11027509.k11027744.f11t2.n1.l1g.h1e.m1&gclid=EAIaIQobChMI15Cij--d4AIVh6_sCh38Ng91EAAYAiAAEgLqUPD_BwE";
    URL url = new URL(str);
    System.out.println("protocol=" +url.getProtocol());
    System.out.println("authority=" +url.getAuthority());
    System.out.println("host=" +url.getHost());
    System.out.println("path=" +url.getPath());
    System.out.println("query=" +url.getQuery());
    System.out.println("uri=" +url.toURI());

  }
}
