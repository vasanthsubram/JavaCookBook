package jndi;

import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;

public class LookupLDAP {

	public static void main(String[] args) throws Exception {
//		LdapConnection connection = new LdapNetworkConnection( "localhost", 10389 );
//		connection.bind();
////
//		// Don't do that ! Password in clear text = danger !
////		connection.bind( "dc=example,dc=com", "secret" );
//
//		// The password is encrypted, but it does not protect against a MITM attack
////		connection.bind( "ou=example, dc=com", "{crypt}wSiewPyxdEC2c" );
//
//		EntryCursor cursor = connection.search( "ou=system", "(objectclass=*)", SearchScope.ONELEVEL, "*" );
//
//		while ( cursor.next() )
//		{
//		    Entry entry = cursor.get();
//		    System.out.println(entry);
//
//		}
//
//		connection.unBind();
//		connection.close();
//
	}
}
