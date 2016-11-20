package jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 *  For this program to work, fscontext.jar and providerutil.jar should be in the path
 *  
 * @author chq-vasanthakumars
 *
 */
class Lookup {
    public static void main(String[] args) {

	String name = "c://windows/win.ini";

	// Identify service provider to use
	Hashtable env = new Hashtable();
	env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");

	try {

	    // Create the initial context
	    Context ctx = new InitialContext(env);

	    // Look up an object
	    Object obj = ctx.lookup(name);

	    // Print it out
	    System.out.println(name + " is bound to: " + obj);
	    
	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    System.err.println("Problem looking up " + name + ": " + e);
	}
    }
}
