package advanced.javabytecode;

public class CompilingConstants {

	public static void main(String[] args) {
		System.out.println(5 + 6); // the byte code shows that the constant is
									// calculated at compiled time

	}

//	public static void main(java.lang.String[]);
//	  Code:
//	   0:   getstatic       #16; //Field java/lang/System.out:Ljava/io/PrintStream;
//	   3:   bipush  11
//	   5:   invokevirtual   #22; //Method java/io/PrintStream.println:(I)V
//	   8:   return
//
//	}
}
