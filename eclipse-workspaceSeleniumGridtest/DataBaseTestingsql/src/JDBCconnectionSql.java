import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JDBCconnectionSql {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo1", "root", "2001");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from creditials where scenario ='zerobalancedcard'");
		while (rs.next()) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com");
			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));

		}

	}

}