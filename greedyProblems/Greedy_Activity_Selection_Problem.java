package greedyProblems;

import java.util.ArrayList;
import java.util.Collections;

class Activity implements Comparable<Activity>
{
	String name;
	int startTime;
	int endTime;

	public Activity(String name, int startTime, int endTime)
	{
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String toString()
	{
		return "Activity : "+name+" Start At : "+startTime+" End At : "+endTime;
	}

	@Override
	public int compareTo(Activity o)
	{
		// TODO Auto-generated method stub
		return this.endTime-o.endTime;
	}
	
}

public class Greedy_Activity_Selection_Problem
{
	public static void doActivitySelction(ArrayList<Activity> activityList)
	{
		Collections.sort(activityList);
		int prevActivity = activityList.get(0).endTime;
		System.out.println(activityList.get(0));
		for(int i=0;i<activityList.size();i++)
		{
			
			if(activityList.get(i).startTime>prevActivity)
			{
				System.out.println(activityList.get(i));
				prevActivity=activityList.get(i).endTime;
			}
		}
		
	}
	public static void main(String[] args)
	{
		// int numOfActivity=10;
		ArrayList<Activity> activityList = new ArrayList<Activity>();
		activityList.add(new Activity("A1", 0, 6));
		activityList.add(new Activity("A2", 3, 4));
		activityList.add(new Activity("A3", 1, 2));
		activityList.add(new Activity("A4", 5, 8));
		activityList.add(new Activity("A5", 5, 7));
		activityList.add(new Activity("A6", 8, 9));
		
		for(Activity a : activityList)
			System.out.println(a);
		System.out.println("\n\n Selected Schedule are: \n");
		doActivitySelction(activityList);
		
	}
}
