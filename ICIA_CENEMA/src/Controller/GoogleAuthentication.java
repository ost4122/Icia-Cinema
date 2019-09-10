package Controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

	public class GoogleAuthentication extends Authenticator {
		PasswordAuthentication passAuth;
		
		public GoogleAuthentication() {
			passAuth = new PasswordAuthentication("ht090716","nbijyyjbwtfqdste");
		}
		
		public PasswordAuthentication getPasswordAuthentication() {
			return passAuth;
		}
	}
	

