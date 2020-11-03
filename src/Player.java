import java.util.Random;

public class Player 
{
	private String name;
	private int age;
	
	public Player(String name)
	{
		this.name = name;
		Random r = new Random();
		this.age = r.nextInt(100) + 1; //random vals 1 to 100 for age
	}

	public String toString()
	{
		return this.name + " (" + this.age + ")";
	}
	
	public String getName() 
	{
		return name;
	}

	public int getAge() 
	{
		return age;
	}
	
	
}
