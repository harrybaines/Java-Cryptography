public class Driver {

	public static void main(String[] args) {

		String message = "hello my name is harry";
		String key = "PIG";
		Encryption e = new Encryption(key, message);
		e.printDetails();

	}

}