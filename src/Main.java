import java.util.Scanner;

import com.smart_home_system.core.SmartHomeSystem;

public class Main {

	public static void main(String[] args) {
		 SmartHomeSystem homeSystem = new SmartHomeSystem();
           Scanner scanner = new Scanner(System.in);
	        // Add devices to the system
	        homeSystem.addDevice(1, "light");
	        homeSystem.addDevice(2, "thermostat");
	        homeSystem.addDevice(3, "door");
	        homeSystem.scheduleDevice(2,"06:00","Turn On");
	        homeSystem.addAutomatedTrigger("thermostat",">", 75, "turnOff(1)",60,1);
	        outerLoop:
	        while(true) {
	        	System.out.println("1.Status Report\n2.ScheduledTasks \n3.Automated Triggers \n4.Add Device \n5.Toggle Device \n6.ChangeTriggerIntervalForSpecifiedTrigger\n0.exit");
	 	        int option=scanner.nextInt();
	            switch(option) {
	             case 1:
	        	    homeSystem.statusReport();
	        	    break;
	             case 2:
	        	    homeSystem.scheduledTask();
	        	    break;
	             case 3:
	             	homeSystem.automatedTriggers();
	        	    break;
	             case 4:
	            	 System.out.println("enter An id for device:");
	            	 int id=scanner.nextInt();
	            	 System.out.println("enter An type of device:");
	            	 String type=scanner.next();
	            	 homeSystem.addDevice(id,type);
		        	 break;
	             case 5:
	            	 System.out.println("enter an id for device:");
	            	 int targetDeviceId=scanner.nextInt();
	            	 System.out.println("enter 1 for on and 0 for off:");
	            	 int value=scanner.nextInt();
	            	 homeSystem.toggleOnOff(targetDeviceId,value);
	            	 break;
	             case 6:
	            	 System.out.println("enter trigger id:");
	            	 int targetTriggerId=scanner.nextInt();
	            	 System.out.println("current interval of the mentioned trigger is "+homeSystem.presentInterval(targetTriggerId));
	            	 System.out.println("Interval you want to keep:");
	            	 int newInterval=scanner.nextInt();
	            	 homeSystem.changeTriggerCheckingInterval(targetTriggerId,newInterval);
	            	 break;
	             case 0:
	                break outerLoop;
	            }
	            System.out.println("\n");
	        }
	}

}
