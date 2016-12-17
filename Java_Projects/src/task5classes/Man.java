package task5classes;

public class Man {
	protected String middlename = "";
	protected String surname = "";
	protected String name = "";
	protected String address = "";
	/**
	 * @param middlename
	 * @param surname
	 * @param name
	 * @param address
	 */
	protected Man(){
		this("","","","");
	}
	
	protected Man(String middlename, String surname, String name, String address){
		this.middlename = new String(middlename);
		this.surname = new String(surname);
		this.name = new String(name);
		this.address = new String(address);
	}
	
	protected Man(String surname, String name, String address){
		this("", surname, name, address);
	}
	
	public static Man getMan(String middlename, String surname, String name, String address) {
		if(middlename == ""){
			if(surname != "" && name != "" && address != ""){
				return new Man(surname, name, address);
			}
		}else{
			return new Man(middlename, surname, name, address);
		}
		return null;
	}
	
	public Man clone(){
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((middlename == null) ? 0 : middlename.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Man other = (Man) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (middlename == null) {
			if (other.middlename != null)
				return false;
		} else if (!middlename.equals(other.middlename))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	
}
