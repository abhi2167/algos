package com.ds.course.greedyAlgorithms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActivitySelectionMain {

	public static void main(String[] args) {
		//Create an ArrayList to store all activities
		ArrayList<Activity> activityList = new ArrayList<Activity>();
		
		//Insert activities in Arraylist
		activityList.add(new Activity("A1", 0, 6));
		activityList.add(new Activity("A2", 3, 4));
		activityList.add(new Activity("A3", 1, 2));
		activityList.add(new Activity("A4", 5, 8));
		activityList.add(new Activity("A5", 5, 7));
		activityList.add(new Activity("A6", 8, 9));
	
		//Print user entered data
		System.out.println("User provided Schedule:");
		for (int i = 0; i < activityList.size() ; i++) {
			Activity activity = activityList.get(i);
			System.out.println(activity.toString());
		}

		List<Activity> sortedList = activityList.stream().sorted(Comparator.comparingInt(Activity::getFinishTime)).collect(Collectors.toList());

		Activity currentActivity = sortedList.get(0);
		System.out.println("\n Activity : " + currentActivity.getName() + " start time = " + currentActivity.getStartTime() + " finish time = " + currentActivity.getFinishTime());
		for(int i=1; i < sortedList.size(); i++) {
			if(sortedList.get(i).getStartTime() > currentActivity.getFinishTime()) {
				currentActivity = sortedList.get(i);
				System.out.println("Activity : " + currentActivity.getName() + " start time = " + currentActivity.getStartTime() + " finish time = " + currentActivity.getFinishTime());
			}
		}
		
		//Perform calculation on activities
		ActivitiySelection.activitySelection(activityList);


	
	}//end of method


}//end of class