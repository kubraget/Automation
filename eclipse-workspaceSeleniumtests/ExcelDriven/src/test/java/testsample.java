import java.io.IOException;
import java.util.ArrayList;

public class testsample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		dataDriven d = new dataDriven();
		ArrayList data=d.getData("Add Profile");
		System.out.println(data.get(0));//print testcase name
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
	}

}
