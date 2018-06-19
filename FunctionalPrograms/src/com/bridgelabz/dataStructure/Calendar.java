package com.bridgelabz.dataStructure;

import com.bridgelabz.utility.Utility;

public class Calendar {

	public static void main(String[] args) {
		int date=1;
		int month=Integer.parseInt(args[0]);
		int year=Integer.parseInt(args[1]);
		String [] days= {"S","M","T","W","TH","F","Sa "};
		Integer[] daysInMonth= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(Utility.isLeapYear(year)==true)
		{
			daysInMonth[2]=29;
		}
		String[][]calendar=new String [6][days.length];
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				calendar[i][j]=" ";
			}
		}
		if(Utility.isValidDate(month, date, year)==true)
		{
			int day=Utility.dayOfWeek(month, date, year);
			int endDate=daysInMonth[month];
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
	                        calendar[i][spaces]="   ";
	                        spaces++;
	                    }
	                }
				  for(spaces=day;spaces<calendar[i].length;spaces++)
	                {   
	                    if(count<=endDate)//loop going on till enddate
	                    {
	                        if(count<=9)//for single digit we print double spaces
	                        {
	                            calendar[i][spaces]=count+"  ";
	                            count++;
	                        }
	                        else
	                        {
	                            calendar[i][spaces]=count+" ";
	                            count++;
	                        }
	                    }
	                   
	                }
				  day=0;
	            }
	            Utility.printTwoDArray(calendar);
	        }
	        else
	        {
	            System.out.println("Invalid month or year given");
	            return;
	        }
	}
}
