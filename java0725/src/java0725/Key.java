package java0725;

public class Key {
	public int number;
	public String id;

	public Key(int number) {
		super();
		this.number = number;
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Key) {
			Key ck = (Key)obj;
			if(number == ck.number) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id.hashCode();
	}
	
	
}
