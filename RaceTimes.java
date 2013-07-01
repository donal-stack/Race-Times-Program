//Programmer:	Donal Stack
//Student ID:	B00056412
//Date:			15th June 2012
//Program: 		CA Project for Race Times of 2-20 participants

   class RaceTimes  //naming the class

{
	//Declaring the arrays
	static String name[];
	static int min[];
	static int sec[];
	static int totaltime[];
	static char group;

   public static void main(String[] args)
   {
        int NumberOfRacers;

       System.out.println("Please enter the number of participants taking part in the Race");
       NumberOfRacers = EasyIn.getInt();

       System.out.println(" ");


		//to make sure the user inputs numbers between 2 and 20.
		//If the user doesn't an error message appears and asked to enter an integer from 2 to 20.
      while(NumberOfRacers<2 || NumberOfRacers>20)
      {

	     System.out.println("Please enter an integer between 2 & 20");
         NumberOfRacers = EasyIn.getInt();
      }
      	System.out.println("Enter data for the number of participants you chose: " + NumberOfRacers );
      	System.out.println(" ");
		System.out.println("********************************************************************************");

		//declaring and creating the arrays for racetimes

		//allocating the declared arrays
		 int Racers[] = new int[NumberOfRacers];
		 String RacerNames[] = new String[NumberOfRacers];
		 min = new int [NumberOfRacers];
		 sec = new int [NumberOfRacers];
		 totaltime = new int [NumberOfRacers];


		//code to enter the participants name and time in minutes and seconds
		//time has two constraints: minutes:0-10 and seconds 0-59
		 for (int i = 0; i < Racers.length; i++)

		 {
			 System.out.println("Name of participant number " + (i+1));
			 RacerNames[i] = EasyIn.getString();

			 System.out.println(" ");

			 System.out.println("Please enter minutes for " + RacerNames[i]);
			 min[i] = EasyIn.getInt();

			 	while(min[i]>10 || min[i]<0)

			 	{
					System.out.println("Please enter an integer for minutes between 0 and 10");
					min[i] = EasyIn.getInt();
				}

				if(min[i]<10)

				{
					System.out.println("Please enter seconds for " + RacerNames[i]);
					sec[i] = EasyIn.getInt();
				}

				while(sec[i]<0 || sec[i]>59)

				{
					System.out.println("Please enter an integer for seconds between 0 and 59");
					sec[i] = EasyIn.getInt();
				}

				totaltime[i]= 60*min[i] + sec[i];

			 System.out.println(" ");
			 System.out.println("--------------------------------------");
			 System.out.println("Participant number " + (i+1) + " is called " + RacerNames[i]);


			 if (sec[i]<10) 		//prints the 0 for seconds less than 10 eg.08
			 {
				 System.out.println(" ");
				 System.out.println(RacerNames[i] + "'s completion time was " + min[i] + ":0" + sec[i]);
			 }

			 else
			 {
				 System.out.println(" ");
				 System.out.println(RacerNames[i] + "'s completion time was " + min[i] + ":" + sec[i]);
			 }
			 System.out.println("--------------------------------------");
			 System.out.println(" ");
			 System.out.println("********************************************************************************");
			 System.out.println(" ");
		}

			//creating a menu using a the do/while loop to display a list of results available to the user

			do
			{

			System.out.println("1: Average of all race times: ");
			System.out.println("2: Fastest race completion time: ");
			System.out.println("3: Slowest race completion time: ");
			System.out.println("4: Race times displayed in descending order:");
			System.out.println("5: Exit ");
			System.out.println("Enter your choice number 1, 2, 3, 4 or 5");  //prompt for group number
			group = EasyIn.getChar();	//uses Char not Int




			//my code before I changed and decided to create a do/while loop

			//error message if user doesnt enter a correct integer from 1-5.
			//while(group<1 || group>5)
			//{
					// System.out.println("Please enter a choice from 1-5: ");
			        // group = EasyIn.getInt();
     		//}





			switch(group)		//created to display the information the user has choosen
				{
					  case '1': average();
					           break;			//breaks are entered to only allow this one choice to be displayed at that given entry
					  case '2': fastest();
					           break;
					  case '3': slowest();
					           break;
					  case '4': descending();
					  		   break;
					  case '5': exit();
					  		   break;
					  default: System.out.println("Please select between 1 and 5");
					  break;

				}
		}
				while(group !='6');		//a choice that is not 6 will display the default message as 1-5 have a command/method!
			}








	//creating the methods for the switch
	public static void average()
	 {
		 int total=0;

		 for(int a=0; a<totaltime.length; a++)
		 {
			 total = total + totaltime[a];
		 }

		 int average = total / totaltime.length;
		 System.out.println("********************************************************************************");
		 System.out.println( "Average of all race times is: " + average/60  + "minutes and " + average%60 + "seconds");
		 System.out.println("********************************************************************************");
		 System.out.println( " ");
		 }


	public static void slowest()
	 {
		 int max = totaltime[0];

		 for (int i=1; i<totaltime.length; i++)
		 {
			 if (totaltime[i] > max) max = totaltime[i];
		 }
		 System.out.println("********************************************************************************");
		 System.out.println( "Slowest race completion time is: " + max/60 + "minutes and " + max%60 + "seconds");
		 System.out.println("********************************************************************************");
		 System.out.println(" ");
	}


	public static void fastest()
	{
		int min = totaltime[0];

		for (int i=1; i<totaltime.length; i++)
		{
			 if (totaltime[i] < min) min = totaltime[i];
		}
		 System.out.println("********************************************************************************");
		 System.out.println( "Fastest race completion time is: " + min/60 + "minutes and " + min%60 + "seconds");
		 System.out.println("********************************************************************************");
		 System.out.println(" ");
	 }


	 public static void descending()
	 {
		 int hold = totaltime[0];											//temporary holding area for swap

		 for (int pass=1; pass<totaltime.length; pass++)	//passes
		 {
			 for (int i=0; i<totaltime.length-1; i++)		//one pass
			 {
				 if(totaltime[i]>totaltime[i+1])
				 {
					 hold=totaltime[i];						//one comparison
					 totaltime[i]=totaltime[i+1];			//one swap
					 totaltime[i+1]=hold;
				 }
			 }
		 }
	 	 System.out.println("********************************************************************************");
		 System.out.println( "Race times displayed in descending order: " + hold/60 +  "minutes and " + hold%60 + "seconds");
		 System.out.println("********************************************************************************");
		 System.out.println(" ");
	 	}


	public static void exit()
		{
			System.exit(0);
		}

}




