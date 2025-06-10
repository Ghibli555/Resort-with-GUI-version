import java.io.*;

public class Accommodation implements Serializable {
	private String type;
	private int price;
	private int accID;
	private boolean availability;
	
	public Accommodation (String type, int price, int accID) {
		this.type = type;
		this.price = price;
		this.accID = accID;
		this.availability = true;
	}
	
	@Override
	public String toString( ) {
		 return "Accommodation [Type: " + type + ", Price: $" + price + ", ID: " + accID + "]";
	}
}
	


