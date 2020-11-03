import java.util.Random;

public class Driver
{

	public static void main(String[] args) 
	{
		PlayerCollection theCollection = new PlayerCollection(100);
		theCollection.search(14);
		
		/*
		Player[] thePlayers = new Player[100];
		for(int i = 0; i < thePlayers.length; i++)
		{
			thePlayers[i] = new Player("Player" + i);
		}
		Driver.mergeSortPlayer(thePlayers, 0, thePlayers.length-1);
		//Driver.displayPlayers(thePlayers);
		int pos = Driver.binarySearchPlayer(thePlayers, 28);
		if(pos != -1)
		{
			System.out.println(thePlayers[pos]);
		}
		else
		{
			System.out.println("No player with that age found!");
		}
		*/
	}
	
	static void displayPlayers(Player[] ar)
	{
		for(int i = 0; i < ar.length; i++)
		{
			System.out.println(ar[i]);
		}
	}
	
	//ar MUST BE SORTED!!!!!!
	static int binarySearch(int[] ar, int val)
	{
		int begin = 0;
		int end = ar.length-1;
		int middle; 
		
		do
		{
			middle = (begin + end)/2;	
			if(ar[middle] == val)
			{
				return middle;
			}
			else if(val < ar[middle])
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
	
	static int binarySearchRecursive(int[] ar, int begin, int end, int age)
	{
		if(begin > end)
		{
			return -1;
		}
		
		int middle = (begin + end)/2;; 
		if(ar[middle] == age)
		{
			return middle;
		}
		else if(age < ar[middle])
		{
			end = middle - 1;
		}
		else
		{
			begin = middle + 1;
		}
		return binarySearchRecursive(ar, begin, end, age);
	}
	
	static int binarySearchPlayer(Player[] ar, int age)
	{
		int begin = 0;
		int end = ar.length-1;
		int middle; 
		
		do
		{
			middle = (begin + end)/2;	
			if(ar[middle].getAge() == age)
			{
				return middle;
			}
			else if(age < ar[middle].getAge())
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
	
	static void mergeSort(int[] ar, int begin, int end)
	{
		if(begin != end)
		{
			int begin1 = begin;
			int end1 = begin + ((end - begin)/2);
			int begin2 = end1 + 1;
			int end2 = end;
			mergeSort(ar, begin1, end1);
			mergeSort(ar, begin2, end2);
			merge(ar, begin1, end1, begin2, end2);
		}
	}
	
	static void mergeSortPlayer(Player[] ar, int begin, int end)
	{
		if(begin != end)
		{
			int begin1 = begin;
			int end1 = begin + ((end - begin)/2);
			int begin2 = end1 + 1;
			int end2 = end;
			mergeSortPlayer(ar, begin1, end1);
			mergeSortPlayer(ar, begin2, end2);
			mergePlayer(ar, begin1, end1, begin2, end2);
		}
	}
	
	static void mergePlayer(Player[] ar, int begin1, int end1, int begin2, int end2)
	{
		Player[] temp = new Player[end2 - begin1 + 1];
		int pos1 = begin1;
		int pos2 = begin2;
		for(int i = 0; i < temp.length; i++)
		{
			if(pos1 <= end1 && pos2 <= end2)
			{
				if(ar[pos1].getAge() < ar[pos2].getAge())
				{
					temp[i] = ar[pos1];
					pos1++;
				}
				else
				{
					temp[i] = ar[pos2];
					pos2++;
				}
			}
			else
			{
				//either pos1 or pos2 is off the end of their list and the other guy is the 
				//default winner
				if(pos1 > end1)
				{
					temp[i] = ar[pos2];
					pos2++;
				}
				else
				{
					temp[i] = ar[pos1];
					pos1++;
				}
			}
		} //end of for loop
		
		//copy temp back over ar from begin1 to end2
		int posInTemp = 0;
		for(int i = begin1; i <= end2; i++)
		{
			ar[i] = temp[posInTemp];
			posInTemp++;
		}
	}
	static void merge(int[] ar, int begin1, int end1, int begin2, int end2)
	{
		int[] temp = new int[end2 - begin1 + 1];
		int pos1 = begin1;
		int pos2 = begin2;
		for(int i = 0; i < temp.length; i++)
		{
			if(pos1 <= end1 && pos2 <= end2)
			{
				if(ar[pos1] < ar[pos2])
				{
					temp[i] = ar[pos1];
					pos1++;
				}
				else
				{
					temp[i] = ar[pos2];
					pos2++;
				}
			}
			else
			{
				//either pos1 or pos2 is off the end of their list and the other guy is the 
				//default winner
				if(pos1 > end1)
				{
					temp[i] = ar[pos2];
					pos2++;
				}
				else
				{
					temp[i] = ar[pos1];
					pos1++;
				}
			}
		} //end of for loop
		
		//copy temp back over ar from begin1 to end2
		int posInTemp = 0;
		for(int i = begin1; i <= end2; i++)
		{
			ar[i] = temp[posInTemp];
			posInTemp++;
		}
	}
	
	static int factorialRecursive(int val)
	{
		return (val == 1) ? 1 :val * factorialRecursive(val - 1);
	}
	
	static int factorialIterative(int val)
	{
		int temp = 1;
		for(int i = val; i >= 1; i--)
		{
			temp = temp * i;
		}
		return temp;
	}
	
	static void displayArray(int[] ar)
	{
		for(int i = 0; i < ar.length; i++)
		{
			System.out.println(ar[i]);
		}
	}

}