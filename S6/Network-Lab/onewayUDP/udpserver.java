import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.*;

class udpserver
{
     public static void main(String[] args)throws IOException
     {
          DatagramSocket s = new DatagramSocket(9864);
          byte[] b = new byte[1024];
          DatagramPacket ds = new DatagramPacket(b,b.length);
          s.receive(ds);
          String str = new String(ds.getData());
          String str1 = str.toUpperCase();
          System.out.println("Message from Client: "+str1);
          s.close();
     }
}