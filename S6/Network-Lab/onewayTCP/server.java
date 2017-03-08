import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;

public class server
{
     public static void main(String[] args)throws IOException
     {
          int n,p,q,r,count = 0;
          double sum = 0;

          ServerSocket s = new ServerSocket(1271);
          Socket s1 = s.accept();
          OutputStream s1out  = s1.getOutputStream();
          DataOutputStream dos = new DataOutputStream(s1out);
          System.out.println("Enter Number: ");
          Scanner ob = new Scanner(System.in);
          n = ob.nextInt();
          p = n;
          q = n;
          while(p != 0)
          {
               p = p/10;
               count++;
          }
          while(q != 0)
          {
               r = q%10;
               sum = sum  + Math.pow(r,count);
               q = q/10;
          }

          if(sum == n)
          {
               dos.writeUTF("Ambstrong Number");
          }
          else
          {
               dos.writeUTF("Not An Ambstrong Number");
          }
          dos.close();
          s1out.close();
          s1.close();    
     }
}