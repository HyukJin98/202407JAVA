package adapter;

public class PrintBanner extends Banner implements Print {

	public PrintBanner(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printWeak() {
		// TODO Auto-generated method stub
		this.showWithParen();
	}

	@Override
	public void printStrong() {
		// TODO Auto-generated method stub
		this.showWithAster();
	}
	
}
