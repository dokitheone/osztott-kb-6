import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TippKliens extends Thread{
    
    public static void main(String[] args) {
        for (int i=0; i<5; i++) {
            new TippKliens().start();
        }
    }
    
    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost", 12345);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(socket.getInputStream());
            Random r = new Random();
            boolean vege = false;
            int tipp = r.nextInt(100)+1;
            int nalaKisebb = 101;
            int nalaNagyobb = 0;
            while(!vege) {
                pw.println(tipp);
                String valasz = sc.nextLine();
                System.out.println(this.getName()+" Tipp: "+tipp+", valasz: "+valasz);
                if (valasz.equals("Eltalaltad")) {
                    vege = true;
                }
                else if (valasz.equals("Kisebb")) {
                    int elozotipp = tipp;
                    nalaKisebb = tipp;
                    
                    while(tipp >= elozotipp || tipp <= nalaNagyobb) {
                        tipp = r.nextInt(elozotipp-1)+1;
                    }
                }
                else if (valasz.equals("Nagyobb")) {
                    nalaNagyobb = tipp;
                    int elozotipp = tipp;
                    while(tipp <= elozotipp || tipp > nalaKisebb) {
                        tipp = r.nextInt(100)+1;
                    }
                }
                
            }
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(TippKliens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
