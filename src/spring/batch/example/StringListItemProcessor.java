package spring.batch.example;

import org.springframework.batch.item.ItemProcessor;

public class StringListItemProcessor implements ItemProcessor<String, String>{

	public String process(String string) throws Exception {
		
		System.out.println("Processing data " + string);
		return string + "-ER";
	}

}
