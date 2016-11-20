package spring.batch.example;

import java.util.ArrayList;
import java.util.List;
import org.springframework.batch.repeat.support.RepeatTemplate;

public class Main {

    public static void main(String[] args) {

        RepeatTemplate template = new RepeatTemplate();

        List<String> colors = new ArrayList<String>();
        colors.add("RED");
        colors.add("BLUE");
        colors.add("GREEN");

        StringRepeatCallback callback = new StringRepeatCallback();

        StringListItemReader stringReader = new StringListItemReader(colors);
        callback.setItemReader(stringReader);

        StringListItemProcessor stringProcessor = new StringListItemProcessor();
        callback.setItemProcessor(stringProcessor);

        template.iterate(callback);
    }
}
