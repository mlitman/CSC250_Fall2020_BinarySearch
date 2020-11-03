
public class PlayerCollection 
{
	private Player[] thePlayers;
	
	public PlayerCollection(int numberOfPlayers)
	{
		this.thePlayers = new Player[numberOfPlayers];
		for(int i = 0; i < this.thePlayers.length; i++)
		{
			this.thePlayers[i] = new Player("Player" + i);
		}
	}
	
	public void display()
	{
		for(int i = 0; i < this.thePlayers.length; i++)
		{
			System.out.println(this.thePlayers[i]);
		}
	}
	
	public void search(int age)
	{
		this.sort();
		int pos = this.binarySearchPlayer(age);
		if(pos != -1)
		{
			System.out.println(this.thePlayers[pos]);
		}
		else
		{
			System.err.println("Player with that age not found!");
		}
	}
	
	private int binarySearchPlayer(int age)
	{
		int begin = 0;
		int end = this.thePlayers.length-1;
		int middle; 
		
		do
		{
			middle = (begin + end)/2;	
			if(this.thePlayers[middle].getAge() == age)
			{
				return middle;
			}
			else if(age < this.thePlayers[middle].getAge())
			{
				end = middle - 1;
			}
			else
			{
				begin = middle + 1;
			}
		}
		while(begin <= end);
		return -1;
	}
	
	public void sort()
	{
		this.mergeSortPlayer(0, this.thePlayers.length-1);
	}
	
	private void mergeSortPlayer(int begin, int end)
	{
		if(begin != end)
		{
			int begin1 = begin;
			int end1 = begin + ((end - begin)/2);
			int begin2 = end1 + 1;
			int end2 = end;
			mergeSortPlayer(begin1, end1);
			mergeSortPlayer(begin2, end2);
			mergePlayer(begin1, end1, begin2, end2);
		}
	}
	
	private void mergePlayer(int begin1, int end1, int begin2, int end2)
	{
		Player[] temp = new Player[end2 - begin1 + 1];
		int pos1 = begin1;
		int pos2 = begin2;
		for(int i = 0; i < temp.length; i++)
		{
			if(pos1 <= end1 && pos2 <= end2)
			{
				if(this.thePlayers[pos1].getAge() < this.thePlayers[pos2].getAge())
				{
					temp[i] = this.thePlayers[pos1];
					pos1++;
				}
				else
				{
					temp[i] = this.thePlayers[pos2];
					pos2++;
				}
			}
			else
			{
				//either pos1 or pos2 is off the end of their list and the other guy is the 
				//default winner
				if(pos1 > end1)
				{
					temp[i] = this.thePlayers[pos2];
					pos2++;
				}
				else
				{
					temp[i] = this.thePlayers[pos1];
					pos1++;
				}
			}
		} //end of for loop
		
		//copy temp back over ar from begin1 to end2
		int posInTemp = 0;
		for(int i = begin1; i <= end2; i++)
		{
			this.thePlayers[i] = temp[posInTemp];
			posInTemp++;
		}
	}
}
