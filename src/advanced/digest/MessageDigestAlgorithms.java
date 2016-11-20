package advanced.digest;

import java.security.MessageDigest;

/**
 * This class shows how to create a digest (finger-print) of a text.
 * This can also be used for creating a hash value for an object
 * 
 * @author chq-vasanthakumars
 *
 */
public class MessageDigestAlgorithms {
	public static void main(String args[]) throws Exception{
		String target = "I made him an offer, he could not refuse";
		byte[] bytes = target.getBytes();
		
		// algorithm names - MD2, MD5, SHA-1
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		algorithm.reset();
		algorithm.update(bytes);
		byte messageDigest[] = algorithm.digest();

		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < messageDigest.length; i++) {
			hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
		}
		System.out.println(target + " :  md5 version is ===>  "
				+ hexString.toString());
		target = hexString + "";
	}
}
