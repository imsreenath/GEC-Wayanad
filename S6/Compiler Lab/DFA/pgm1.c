/*DFA ACCEPTING SUBSTRING 101*/

#include<stdio.h>
#define FINAL 3
#define DEAD -1

void main()
{
	int transition[4][2] = {{0,1},{2,1},{0,3},{3,3}};//transition function of DFA
	//transition[state][symbol = 0 or 1]
	char str[10],ch;
	int symbol,state = 0;
	int i;
	
	
	printf("Enter String: ");
	//scanf("%s",str);
	
	for(i=0 ;  ; ++i)
	{
		ch = getchar();
		if(ch == ' ' || ch == '\n')
			break;
		else
			str[i] = ch;	
	}
	str[i] = '\0';
	
	for(i=0 ; str[i]!='\0' ; ++i)
	{
		symbol = str[i]-48;
		state = transition[state][symbol];	
	}
	
	if(state != FINAL)
		printf("\nRejected\n");
	else
		printf("\nAccepted\n");
}



/*Copyrightⓒ 2017 by Sreenath P Nair.
All Rights Reserved*/

