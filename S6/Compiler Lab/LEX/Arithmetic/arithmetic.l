letter [a-zA-Z]
operator "+"|"-"|"/"|"%"|"*"|"="
opBracket "("
clsBracket ")"


%{
	int idCount=0;
	int opCount=0;
	int opbCount=0;
	int clsCount=0;
%}

%%
{letter}({letter})* {idCount++;}
{operator} {opCount++;}
{opBracket} {opbCount++;}
{clsBracket} {clsCount++;}
%%

main(int argc, char* argv[])
{
	FILE *fp;
	
	if(argc == 2 && (fp = fopen(argv[1],"r")))
		yyin = fp;
	yylex();

	printf("\nOp: %d\nId: %d\n",opCount,idCount);
	if((opCount < idCount) && (opbCount == clsCount))
	{
		printf("\nValid Expression\n");
	}
	else
	{
		printf("\nInvalid Expression\n");
	}
	fclose(fp);
}
