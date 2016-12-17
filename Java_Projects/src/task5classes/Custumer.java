package task5classes;

import java.util.ArrayList;

public class Custumer extends Man{

	private static ArrayList<Custumer> custumers;
	private int account;
	private int creditCardNumber;
	private final int id;
	
	private Custumer(){
		this.id = 0;
	}
	
	private Custumer(String middlename, String surname, String name, String address, int account, int creditCardNumber){
		super(middlename, surname, name, address);
		this.account = account;
		this.creditCardNumber = creditCardNumber;
		this.id = custumers.size();
		custumers.add(this);
	}
	
	private Custumer(String surname, String name, String address, int account, int creditCardNumber){
		super(surname, name, address);
		this.account = account;
		this.creditCardNumber = creditCardNumber;
		this.id = custumers.size();
		custumers.add(this);
	}
	
	public static Custumer getNewCustumer(Man man, int account, int creditCardNumber){
		if(man != null){
			return new Custumer(man.middlename, man.surname, man.name, man.address, account, creditCardNumber);
		}else{
			return null;
		}
	}
	public static Custumer getNewCustumer(String middlename, String surname, String name, String address, 
			int account, int creditCardNumber){
			return Custumer.getNewCustumer(Man.getMan(middlename, surname, name, address), account, creditCardNumber);

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Custumer [account=" + account + ", creditCardNumber=" + creditCardNumber + ", id=" + id + ", "
				+ (surname.equals("") ? "surname=" + surname + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (middlename.equals("") ? "middlename=" + middlename + ", " : "")
				+ (address.equals("") ? "address=" + address : "") + "]";
	}
	
}
