letter [A-Za-z]
digit [0-9]
escape [\][n]|[\][t]|[\][0]
keyword "if"|"switch"|"int"|"char"|"else"|"goto"|"break"|"continue"|"float"
special "`"|"~"|"@"|"#"|"$"|"("|")"|"{"|"}"|"["|"]"
operator "+"|"!"|"-"|"="|"=="|"*"|"/"|"%"|"&"


%{
	int keyCount = 0;
	int iCount = 0;
%}


%%
{escape} {printf("%s is an escape sequence\n", yytext);}
{keyword} {printf("%s is a keyword\n", yytext); keyCount++;}
{special} {printf("%s is a special Character\n", yytext);}
{operator} {printf("%s is an operator\n", yytext);}
{digit}*"."{digit}+ {printf("%s is a floating point Number\n", yytext);}
{letter}({letter}|{digit})* {printf("%s is an identifier \n", yytext); iCount++;}
{digit}({letter}|{digit})* {printf("%s is Not an identifier \n", yytext);}
[\n] {printf("Line Number is %d\n\n", yylineno++);}
%%

main(int argc, char** argv)
{
	FILE* fp;
	
	if(argc == 2 && (fp = fopen(argv[1],"r")))
		yyin = fp;
	yylex();
	
	printf("\n\nNo of KeyWords = %d\n",keyCount);
	printf("\nNo of Identifiers = %d\n",iCount);
}
