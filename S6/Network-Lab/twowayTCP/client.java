import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.*;

public class client
{
     public static void main(String[] args)throws IOException
     {
          int number;
          Scanner ob = new Scanner(System.in);
          Socket s1 = new Socket("127.0.0.1",1283);
        //  OutputStream s1out = s1.getOutputStream();
          DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
          InputStream s1in = s1.getInputStream();
          DataInputStream dis = new DataInputStream(s1in);
          
          System.out.println("Enter a Number :");
          number = ob.nextInt();
          dos.writeInt(number);

          String st = new String(dis.readUTF());
          System.out.println(st);
          dis.close();
          dos.close();
         // s1out.close();
          s1in.close();
          s1.close();
     }
}