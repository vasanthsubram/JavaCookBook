package xml.jaxb.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import xml.jaxb.demo.Book;
import xml.jaxb.demo.Bookstore;

public class BookMain {

	private static final String BOOKSTORE_XML = "bookstore-jaxb.xml";

	public static void main(String[] args) throws JAXBException, IOException {

		ArrayList<Book> bookList = new ArrayList<Book>();

		// create books
		Book book1 = new Book();
		book1.setIsbn("978-0060554736");
		book1.setName("The Game");
		book1.setAuthor("Neil Strauss");
		book1.setPublisher("Harpercollins");
		bookList.add(book1);

		Book book2 = new Book();
		book2.setIsbn("978-3832180577");
		book2.setName("Feuchtgebiete");
		book2.setAuthor("Charlotte Roche");
		book2.setPublisher("Dumont Buchverlag");
		bookList.add(book2);

		// create bookstore, assigning book
		Bookstore bookstore = new Bookstore();
		bookstore.setName("Fraport Bookstore");
		Location location = new LocationImpl();
		location.setStreet("Elm Street");
		location.setZip("12345");
		bookstore.setLocation(location);
		bookstore.setBookList(bookList);
		bookstore.setWorkerNames(new String[]{"ABC", "LKJ"});
		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(Bookstore.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		//write to the console
		m.marshal(bookstore, System.out);

		//write it to a file
		Writer w = null;
		try {
			w = new FileWriter(BOOKSTORE_XML);
			m.marshal(bookstore, w);
		} finally {
			try {
				w.close();
			} catch (Exception e) {
			}
		}

		// get variables from our xml file, created before
		System.out.println();
		System.out.println("Output from our XML File: ");
		Unmarshaller um = context.createUnmarshaller();
		Bookstore bookstore2 = (Bookstore) um.unmarshal(new FileReader(BOOKSTORE_XML));

		for (int i = 0; i < bookstore2.getBooksList().toArray().length; i++) {
			System.out.println("Book " + (i + 1) + ": "
					+ bookstore2.getBooksList().get(i).getName() + " from "
					+ bookstore2.getBooksList().get(i).getAuthor());
		}

	}
}
