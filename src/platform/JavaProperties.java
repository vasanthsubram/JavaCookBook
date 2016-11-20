package platform;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class JavaProperties {
	public static void main(String[] args) throws Exception {
		FileInputStream def = null, custom=null;
		FileOutputStream customOut=null;
		try {
			
			//default
			Properties props = new Properties();
			def = new FileInputStream("resources/default.properties");
			props.load(def);
			System.out.println(props.get("test1.prop"));
			System.out.println(props.getProperty("test1.prop"));
			System.out.println(props.contains("test.prop"));
			props.list(System.out);
			
			//custom
			custom = new FileInputStream("resources/custom.properties");
			Properties customProps = new Properties();
			customProps.load(custom);
			customProps.put("new.prop", "pigloo");
			custom.close();
			customOut=new FileOutputStream("resources/custom.properties");
			customProps.store(customOut, "--");
			
		} finally {
			if (def != null) {
				def.close();
			}
			if(custom !=null){
				custom.close();
			}
			if(customOut !=null){
				customOut.close();
			}
		}
	}
}
