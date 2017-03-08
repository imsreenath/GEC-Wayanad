import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class udpclient
{
     public static void main(String[] args)throws IOException
     {
          DatagramSocket s = new DatagramSocket();
          InetAddress ip = InetAddress.getByName("localhost");
          byte[] b = new byte[1024];
          Scanner ob = new Scanner(System.in);
          System.out.println("Enter Message: ");
          String str = ob.nextLine();
          b = str.getBytes();
          DatagramPacket dp = new DatagramPacket(b,b.length,ip,9864);
          s.send(dp);
          s.close();
     }
}