package com.bridgelabz.dataStructure;

import com.bridgelabz.utility.Utility;

/**purpose-To display calendar using Queue
 * @author yuga
 *@version 1.0
 * @since   30-05-2018
 */
public class CalendarUsingQueue {
	static String [] days= {"S","M","T","W","TH","F","Sa "};
	static Integer[] daysInMonth= {0,31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) {
		int date=1;
		int month=Integer.parseInt(args[0]);
		int year=Integer.parseInt(args[1]);
		
		if(Utility.isLeapYear(year)==true)
		{
			daysInMonth[2]=29;
		}
		
		MyQueue[][]calendar=new MyQueue [6][days.length];
		//create new queue object for every date
		for(int i=0;i<calendar.length;i++)
		{
			for(int j=0;j<calendar[i].length;j++)
			{
				calendar[i][j]=new MyQueue();
			}
		}
		//print spaces for every dates
		for(int i=0;i<calendar.length;i++)
		{
			for(int j=0;j<calendar[i].length;j++)
			{
				calendar[i][j].enqueue(" ");
			}
		}
		if(Utility.isValidDate(month, date, year)==true)
		{
			int day=Utility.dayOfWeek(month, date, year);//gives date
			int endDate=daysInMonth[month];
			//print days with spaces
			for(int i=0;i<days.length;i++)
			{
				System.out.print(days[i]+="  ");
			}
			System.out.println("\n");
			int spaces=0;
			int  count=1;
			for(int i=0;i<calendar.length;i++)
			{
				  if(i==0 )//for first spaces
	                {
	                    for(int k=0;k<day;k++)
	                    {
	                    	calendar[i][spaces].dequeue();
	                        calendar[i][spaces].enqueue("   ");
	                        spaces++;
	                    }
	                }
				  for(spaces=day;spaces<calendar[i].length;spaces++)
	                {   
	                    if(count<=endDate)//loop going on till enddate
	                    {
	                        if(count<=9)//for single digit we print double spaces
	                        {
	                        	calendar[i][spaces].dequeue();
	                            calendar[i][spaces].enqueue(count+"  ");
	                            count++;
	                        }
	                        else
	                        {
	                        	calendar[i][spaces].dequeue();
	                        	calendar[i][spaces].enqueue(count+" ");
	                            count++;
	                        }
	                    }
	                }
				  day=0;
	            }
	           printQueueTwoDArray(calendar);
	        }
	        else
	        {
	            System.out.println("Invalid month or year given");
	            return;
	        }
	}
	/**to print calendar 
	 */
	public static void printQueueTwoDArray(MyQueue[][] calendar) {
		for(int i=0;i<calendar.length;i++)
		{
			for(int j=0;j<calendar[i].length;j++)
			{
				String display=calendar[i][j].dequeue();
				System.out.print(display);
			}
			System.out.println();
		}
		
	}
}
