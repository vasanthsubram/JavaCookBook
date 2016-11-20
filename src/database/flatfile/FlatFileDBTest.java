package database.flatfile;

public class FlatFileDBTest {

	public static void main(String[] args) throws Exception {

		Engine engine=new Engine();
		engine.insert("Hello World 100");
		//engine.insert("Hello World 200");
		//System.out.println((String)engine.query(2));
		System.out.println((String)engine.query(1));
		
		engine.close();
	}

}
