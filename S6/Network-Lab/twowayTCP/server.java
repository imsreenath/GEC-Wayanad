import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;


public class server
{
     public static void main(String[] args)throws IOException
     {
          int number;
          int p,q;          
          ServerSocket s = new ServerSocket(1283);
          Socket s1 = s.accept();
          OutputStream s1out = s1.getOutputStream();
          DataOutputStream dos = new DataOutputStream(s1out);
          InputStream s1in = s1.getInputStream();
          DataInputStream dis = new DataInputStream(s1in);
     

         // String st = new String(dis.readUTF());
         // number = Integer.parseInt(st);
          number = dis.readInt(); 
          int count=0,r;
          double sum = 0;

          p = number;
          q = number;
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

          if(sum == number)
          {
               dos.writeUTF("Ambstrong Number");
          }
          else
          {
               dos.writeUTF("Not An Ambstrong Number");
          }
          dis.close();
          dos.close();
          s1out.close();
          s1in.close();
          s1.close();
     }
}