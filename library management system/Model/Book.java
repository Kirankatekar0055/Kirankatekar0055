package Model;

public class Book 
{
	private int Id;
	private String bname,auther;
	private double price;
	
	public Book() 
	{
		super();
	}

	public Book(int id, String bname, String auther, double price)
	{
		super();
		this.Id = id;
		this.bname = bname;
		this.auther = auther;
		this.price = price;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [Id=" + Id + ", bname=" + bname + ", auther=" + auther + ", price=" + price + "]";
	}
	
}
