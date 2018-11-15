/**Author: NAZMUDDIN AL MASOOD - Contact:nazmumasood96@gmail.com 
  Date started:28/09/2018; Date finished:03/10/2018; Last edited:15/11/2018
  **/

/*                  ----- About the program ----
 The program will build a symbol table from given stream of chars. For this, it reads a file
 named "input.txt" to collect all chars.  For simplicity, input file will be a Java program 
 without headers and methods. Then it will identify all the numerical values, identifiers, 
 keywords, math operators, logical operators and others [distinct]. See the example for more details. 
 
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
 */

/*            ----- About used algorithms -----
 With the help of String tokenizer class, step by step tokenization was done for whitespaces, mathematical operators,
 logical operators,other symbols i.e. ", ; ( }", keywords, identifiers/variables, numerical values.
 */

/* Methods used : main(), analyzer() and some other duplicate checker methods */
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lexicalAnalyzer{ 
  static ArrayList<String> matOp = new ArrayList<String>();
  
  static ArrayList<String> logicOp = new ArrayList<String>();
  
  static ArrayList<String> otherOp = new ArrayList<String>();
  
  static ArrayList<String> keyword = new ArrayList<String>();
  
  static ArrayList<String> var = new ArrayList<String>();  
  
  static ArrayList<String> num = new ArrayList<String>();
  
  public static void main(String[]args)throws FileNotFoundException{
//Reading the stream of characters
    //File file = new File("input.txt"); 
    File file = new File("input1.txt"); 
    Scanner sc = new Scanner(file);   
    while (sc.hasNextLine()){ 
      String l = sc.nextLine();
      analyzer(l);
    }    
//Printing the symbol table    
    System.out.print("Keywords: ");
    for(int i=0,j=1;i<keyword.size();i++,j++){System.out.print(keyword.get(i));if(j<keyword.size()){System.out.print(",");}}
    System.out.println();
    System.out.print("Identifiers: ");
    for(int i=0,j=1;i<var.size();i++,j++){System.out.print(var.get(i));if(j<var.size()){System.out.print(",");}}
    System.out.println();
    System.out.print("Math Operators: ");
    for(int i=0,j=1;i<matOp.size();i++,j++){System.out.print(matOp.get(i));if(j<matOp.size()){System.out.print(",");}}
    System.out.println();
    System.out.print("Logical Operators: ");
    for(int i=0;i<logicOp.size();i++){System.out.print(logicOp.get(i)+" ");}
    System.out.println();
    System.out.print("Numerical Values: ");
    for(int i=0,j=1;i<num.size();i++,j++){System.out.print(num.get(i));if(j<num.size()){System.out.print(",");}}
    System.out.println();
    System.out.print("Others: ");
    for(int i=0;i<otherOp.size();i++){System.out.print(otherOp.get(i)+" ");}
    System.out.println();   
  }
  
  public static int analyzer(String s){ 
//Checking for WhiteSpaces
    if(s.contains(" ")){
      StringTokenizer st = new StringTokenizer(s," ");    
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    
//Checking for logical operators (those which needs to be checked before checking for '=')
    if(s.contains("<=")){
      dupChkLogOp("<=");
      StringTokenizer st = new StringTokenizer(s,"<=");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains(">=")){
      dupChkLogOp(">=");
      StringTokenizer st = new StringTokenizer(s,">=");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("==")){
      dupChkLogOp("==");
      StringTokenizer st = new StringTokenizer(s,"==");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("!=")){
      dupChkLogOp("!=");
      StringTokenizer st = new StringTokenizer(s,"!=");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    
//Checking for Mathmetical Operators
    if(s.contains("=")){
      dupChkMathOp("="); //sends it to the method to see if its already in the array
      StringTokenizer st = new StringTokenizer(s,"=");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      } return 0;
    }     
    if(s.contains("+")){
      dupChkMathOp("+");
      StringTokenizer st = new StringTokenizer(s,"+");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("-")){
      dupChkMathOp("-");
      StringTokenizer st = new StringTokenizer(s,"-");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("/")){
      dupChkMathOp("/");
      StringTokenizer st = new StringTokenizer(s,"/");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("*")){
      dupChkMathOp("*");
      StringTokenizer st = new StringTokenizer(s,"*");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("^")){
      dupChkMathOp("^");
      StringTokenizer st = new StringTokenizer(s,"^");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("%")){
      dupChkMathOp("%");
      StringTokenizer st = new StringTokenizer(s,"%");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    
    
//Checking for Logical Operators
    if(s.contains("||")){
      dupChkLogOp("||");
      StringTokenizer st = new StringTokenizer(s,"||");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("&&")){
      dupChkLogOp("&&");
      StringTokenizer st = new StringTokenizer(s,"&&");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains(">")){
      dupChkLogOp(">");
      StringTokenizer st = new StringTokenizer(s,">");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("<")){
      dupChkLogOp("<");
      StringTokenizer st = new StringTokenizer(s,"<");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    
    
//Checking for Others i.e. (Brackets,',',';')
    if(s.contains("(")){
      dupChkOthOp("(");
      StringTokenizer st = new StringTokenizer(s,"(");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains(")")){
      dupChkOthOp(")");
      StringTokenizer st = new StringTokenizer(s,")");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("{")){
      dupChkOthOp("{");
      StringTokenizer st = new StringTokenizer(s,"{");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("}")){
      dupChkOthOp("}");
      StringTokenizer st = new StringTokenizer(s,"}");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("[")){
      dupChkOthOp("[");
      StringTokenizer st = new StringTokenizer(s,"[");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains("]")){
      dupChkOthOp("]");
      StringTokenizer st = new StringTokenizer(s,"]");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains(",")){
      dupChkOthOp(",");
      StringTokenizer st = new StringTokenizer(s,",");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    if(s.contains(";")){
      dupChkOthOp(";");
      StringTokenizer st = new StringTokenizer(s,";");
      int t = st.countTokens();
      for (int i=0;i<t;i++){
        String s1 = st.nextToken();
        analyzer(s1);
      }return 0;
    }
    
//Checking for Keywords i.e. (int,float,if,else)   
    if(s.equals("int")){
      dupChkKey("int");
      return 0;
    }
    if(s.equals("float")){
      dupChkKey("float");
      return 0;
    }
    if(s.equals("long")){
      dupChkKey("long");
      return 0;
    }
    if(s.equals("char")){
      dupChkKey("char");
      return 0;
    }
    if(s.equals("do")){
      dupChkKey("do");
      return 0;
    }
    if(s.equals("while")){
      dupChkKey("while");
      return 0;
    }
    if(s.equals("for")){
      dupChkKey("for");
      return 0;
    }
    if(s.equals("if")){
      dupChkKey("if");
      return 0;
    }
    if(s.equals("else")){
      dupChkKey("else");
      return 0;
    }
    if(s.equals("return")){
      dupChkKey("return");
      return 0;
    }
    
    
//Checking for Variables
    if(s.matches("[a-zA-Z].*")){
      int count=0;
      for(int i=0;i<var.size();i++){
        if(s.equals(var.get(i))){count++;}
      }
      if(count==0){var.add(s);}
      return 0;
    }
    
//Checking for Integers
    if(s.matches("-?\\d+(\\.\\d+)?")){
      int count=0;
      for(int i=0;i<num.size();i++){
        if(s.equals(num.get(i))){count++;}
      }
      if(count==0){num.add(s);}
      return 0;
    }
    
//Checking for other distinct letters
    if(s!=null){int count = 0;
      for(int i=0;i<otherOp.size();i++){
        if(s.equals(otherOp.get(i))){count++;}
      }
      if(count==0){otherOp.add(s);}
    }    
    return 0; 
  }
  
  
//Following methods checks for duplicate elements in the  
//respective array before registering them
  
//Checking for duplicate mathmetical operators  
  public static void dupChkMathOp(String s){
    int count=0;
    for(int i=0;i<matOp.size();i++){
      if(s.equals(matOp.get(i))){count++;}
    }
    if(count==0){matOp.add(s);}
  }
//Checking for duplicate logical operators    
  public static void dupChkLogOp(String s){
    int count=0;
    for(int i=0;i<logicOp.size();i++){
      if(s.equals(logicOp.get(i))){count++;}
    }
    if(count==0){logicOp.add(s);}
  }
//Checking for duplicate "others" symbol    
  public static void dupChkOthOp(String s){
    int count=0;
    for(int i=0;i<otherOp.size();i++){
      if(s.equals(otherOp.get(i))){count++;}
    }
    if(count==0){otherOp.add(s);}
  }
//Checking for duplicate keywordwords     
  public static void dupChkKey(String s){
    int count=0;
    for(int i=0;i<keyword.size();i++){
      if(s.equals(keyword.get(i))){count++;}
    }
    if(count==0){keyword.add(s);}
  } 
}