import java.io.*;
import java.util.*;
import java.net.*;

class client
{
      public static void main(String[] args)throws IOException
      {
          DatagramSocket ds = new DatagramSocket();
          InetAddress ip = InetAddress.getByName("localhost");
          byte[] b = new byte[1024];
          byte[] b1 = new byte[1024];
          Scanner ob = new Scanner(System.in);
          System.out.println("Enter Message: ");
          String str = ob.nextLine();
          b = str.getBytes();
          DatagramPacket dps = new DatagramPacket(b,b.length,ip,9864);
          ds.send(dps);
          DatagramPacket dpr = new DatagramPacket(b1,b1.length);
          ds.receive(dpr);
          String str1 = new String(dpr.getData());
          System.out.println("Message from Server: "+str1);
          ds.close();
      }
}