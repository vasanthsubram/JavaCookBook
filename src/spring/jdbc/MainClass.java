package spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("spring/jdbc/config.xml");
		  CountryDao countryDao = (CountryDao) context.getBean("countryDao");
		  List<Country> countries = countryDao.getCountries();
		  
		  for(Country c: countries){
			  System.out.println(c.getName() + " " + c.getRegion());
		  }
		  
	}
	

}
