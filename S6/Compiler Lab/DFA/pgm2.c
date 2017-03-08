#include<stdio.h>
#include<string.h>


void isAccepted(char[],int);
void readTransition(int[][2],int);

void main()
{
	char input[10];
	int length,i;
	int ch0,loop;
	do
	{
		printf("\nEnter the String to be Accepted: ");
		scanf("%s",input);
		
		length = strlen(input);
		
		printf("\n\t1.Only%s\n\t2.Substring %s",input,input);
		printf("\n\t3.Starts with %s\n\t4.Ends with %s\n",input,input);
		scanf("%d",&ch0);
		switch(ch0)
		{	
			case 1: isAccepted(input,length+1); break;
			case 2: isAccepted(input,length+1); break;
			case 3: isAccepted(input,length+1); break;
			case 4: isAccepted(input,length+1); break;
			default: printf("\nUnidentified Input\n");
		}
		printf("\nTry Another? Press 1\n");
		scanf("%d",&loop);
	}while(loop == 1);	
}


void isAccepted(char str[],int stateCount)
{
	int i,j,ch0;
	char test[10];
	int symbol,state;
	int transition[stateCount][2];
	int final = stateCount - 1;

	readTransition(transition,stateCount);
	
	do
	{
		state = 0;
		printf("Enter Test String:");
		scanf("%s",test);
		
		for(i=0 ; test[i]!='\0' ; ++i)
		{
			if(state == -1)
				break;
			symbol = test[i]-48;
			state = transition[state][symbol];	
		}
		if(state == final)
			printf("\nAccepted\n");
		else
			printf("\nRejected\n");
		printf("\nTry Again Press 1\n");
		scanf("%d",&ch0);	
	}while(ch0 == 1);

}	

void readTransition(int transition[][2],int stateCount)
{
	int i,j;
	printf("Enter the transition Table:\n");
	
	for(i=0 ; i<stateCount ; ++i)
	{
		for(j=0 ; j<2 ; ++j)
		{
			printf("\nTransition of (Q%d,%d) = ",i,j);
			scanf("%d",&transition[i][j]);
		}	
	}
}	
	
	
	
