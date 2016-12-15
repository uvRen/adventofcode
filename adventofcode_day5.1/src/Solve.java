import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

public class Solve {
	
	private String code;
	private LinkedList<String> password;
	private int lastNumber = 0;
	
	public Solve(String code) {
		password = new LinkedList<String>();
		this.code = code;
	}
	
	public void calculate() {
		String hash = "";
		for(int i = 0; i < 8; i++) {
			hash = generateHashWithLeadingZeroes();
			password.add("" + hash.charAt(5));
		}
		System.out.println(password);
	}
	
	private String generateHashWithLeadingZeroes() {
		String hash = "";
		for(int i = lastNumber; i < Integer.MAX_VALUE; i++) {
			hash = generateHash(i);
			if(hasFiveLeadingZeros(hash)) {
				lastNumber = i + 1;
				return hash;
			}
		}
		return "";
	}
	
	private boolean hasFiveLeadingZeros(String hash) {
		for(int i = 0; i < 5; i++) {
			if(hash.charAt(i) != '0')
				return false;
		}
		return true;
	}
	
	private String generateHash(int i) {
		String plaintext = code + i;
		try {
		    MessageDigest m=MessageDigest.getInstance("MD5");
		    m.update(plaintext.getBytes(),0,plaintext.length());
		    String hashtext = new BigInteger(1,m.digest()).toString(16);
			while(hashtext.length() < 32 ){
				  hashtext = "0"+hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
