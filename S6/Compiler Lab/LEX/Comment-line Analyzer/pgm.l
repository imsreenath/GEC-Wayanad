%{
#include<stdio.h>
%}

%%
"//"(.)* ;
"/"[*](.|[\n])*([*]"/") ;
%%

main(int argc, char* argv[])
{
    FILE* fp;

    char ch;
    fp = fopen(argv[1],"r");
    ch = fgetc(fp);
    printf("\nGiven Test File is\n");
    printf("\n___________________________________\n");
    while(ch != EOF)
    {
        printf("%c",ch);
        ch = fgetc(fp);
    }
    fclose(fp);

    printf("\n\nAfter Removing Comments");
    printf("\n___________________________________\n");

    if(argc == 2 && (fp = fopen(argv[1],"r")))
    {    
        yyin=fp;
    }

    
    yylex();

}
int yywrap()
{
    return 1;
}