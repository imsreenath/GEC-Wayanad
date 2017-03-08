character[a-zA-Z0-9]

%{
    int cCount=0,wCount=0;
    int spCount=0;
%}

%%
{character} {cCount++;}
{character}|{character}* {wCount++;cCount = cCount+yyleng;}
" " {spCount++;}
[\n] {yylineno++;}
%%

main(int argc,char* argv[])
{
    FILE* fp;

    if(argc == 2 && (fp = fopen(argv[1],"r")))
        yyin = fp;
    yylex();
    printf("\nCharacter Count: %d",cCount);
    printf("\nWord Count: %d",wCount);
    printf("\nLines Count: %d",yylineno);
    printf("\nSpace Count: %d",spCount);
    
}
