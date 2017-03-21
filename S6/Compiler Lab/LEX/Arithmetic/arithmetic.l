letter [a-zA-Z]
operator "+"|"-"|"/"|"%"|"*"
eqOperator "="
opBracket "("
clsBracket ")"
increment "++"|"--"


%{
	int idCount=0;
	int opCount=0;
	int opbCount=0;
	int clsCount=0;
	int count = 0;
%}

%%
{increment}{letter} {printf("\nvalid Arithmetic Expression");count = 1;}
{letter}{operator}{eqOperator}{letter} {printf("\nvalid Arithmetic Expression");count = 1;}
{letter}{eqOperator}"-"{letter} {printf("\nvalid Arithmetic Expression");count = 1;}
{letter}{increment} {printf("\nvalid Arithmetic Expression");count = 1;}
{letter}"="{letter}{increment} {printf("valid Arithmetic Expression");count = 1;}
{letter}"="{increment}{letter} {printf("valid Arithmetic Expression");count = 1;}
{letter}({letter})* {idCount++;}
{operator}|{eqOperator} {opCount++;}
{opBracket} {opbCount++;}
{clsBracket} {clsCount++;}
%%

main(int argc, char* argv[])
{
	FILE *fp;
	
	if(argc == 2 && (fp = fopen(argv[1],"r")))
		yyin = fp;
	yylex();

	if(count==0)
	{
	if((opCount < idCount) && (opbCount == clsCount))
	{
		printf("\nValid Arithmetic Expression\n");
	}
	else
	{
		printf("\nInvalid Arithmetic Expression\n");
	}
	}
	fclose(fp);
}

