import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicsAuthenticationn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		Predicate<URI> uripredicate = uri->uri.getHost().contains("httpbin.org");
		((HasAuthentication)driver).register(uripredicate,UsernameAndPassword.of("foo", "bar "));
		driver.get("http://httpbin.org/basic-auth/foo/bar");

	}

}
