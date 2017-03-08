%{
#include<stdio.h>
%}

%%
(.+("and"|"or"|"but").+)+($|[\n]) {printf("It is a compount statement");}
%%

main(int argc,char** argv)
{
    FILE* fp;
    
    if(argc == 2 && (fp = fopen(argv[1],"r")))
        yyin = fp;
        
    yylex();
} 