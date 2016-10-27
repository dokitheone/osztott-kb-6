
import java.io.*;
import java.net.*;
import java.util.*;

public class TippServer {

    static int szam;

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("A szerver elindult.");
            server.setSoTimeout(10000);

            Random rand = new Random();
            szam = rand.nextInt(100) + 1;
            System.out.println("A sorsolt szam: " + szam);

            while (true) {
                //try {
                Socket client = server.accept();
                System.out.println("Egy kliens csatlakozott.");
                new ClientHandler(client).start();

            }
        } catch (SocketTimeoutException e) {
            System.out.println("A szerverhez nem csatlakozott senki 10 mp-ig, ezert leallt.");
            System.exit(0);
        }

    }
}

class ClientHandler extends Thread {

    Socket s;
    PrintWriter pw;
    Scanner sc;

    ClientHandler(Socket s) throws IOException {
        this.s = s;
        pw = new PrintWriter(s.getOutputStream(), true);
        sc = new Scanner(s.getInputStream());
    }

    @Override
    public void run() {
        try {
            boolean vege = false;
            while (!vege) {
                int tipp = sc.nextInt();
                if(TippServer.szam == tipp) {
                    pw.println("Eltalaltad");
                    vege = true;
                    s.close();
                } else if (tipp > TippServer.szam) {
                    pw.println("Kisebb");
                } else if (tipp < TippServer.szam) {
                    pw.println("Nagyobb");
                }
            }
        } catch (IOException e) {
        }
    }
}
