lexicalAnalyzer -  Java Program Lexical Analyzer
=================================================

## Introduction
lexicalAnalyzer is a simple lexical analyzer which identifies the variables, mathematical operators, logical operators, keywords, numerical values and others from a Java program and builds a symbol table.

## Details about the program
The program will build a symbol table from given stream of chars. For this, it reads a file named "input.txt" to collect all chars.  For simplicity, input file will be a Java program without headers and methods. Then it will identify all the numerical values, identifiers, keywords, math operators, logical operators and others [distinct]. See the example for more details. 
``` 
 INPUT:
 int a,b, c;
 float  d,e;
 a=b=-5;
 c= 16.82;
 if(a>b)
 {
   c =  a - b;
   e=d-2;
 }
 else
 {
   d=e + 6.0;
   b = a+c;
 }

 for(int i=0; i<10;i++)
 {
   i=i*3/b;
 }
 
 OUTPUT:
 Keywords: int,float,if,else,for 
 Identifiers: a,b,c,d,e,i 
 Math Operators: =,-,+,/,* 
 Logical Operators: > <  
 Numerical Values: 5,16.82,2,6.0,0,10,3 
 Others: , ; ( ) { } 
 ```
## About used algorithm
 With the help of String tokenizer class, step by step tokenization was done for whitespaces, mathematical operators,
 logical operators,other symbols i.e. ", ; ( }", keywords, identifiers/variables, numerical values.

### Project Layout
The program was created and tested using Java 10.0.2.

## About author
 NAZMUDDIN AL MASOOD 
 <br> Contact: nazmumasood96@gmail.com

