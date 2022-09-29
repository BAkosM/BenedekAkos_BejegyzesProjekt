import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import bejegyzes.*;

public class Main {        
    public static List<Bejegyzes> bejegyzesek = new ArrayList<>();
    public static void beker(){
        String fajlNev = "bejegyzesek.csv";
        try {
            beolv(fajlNev);
        } catch (FileNotFoundException e){
            System.err.printf("Nem található az %s fájl!", fajlNev);
        } catch (IOException e){
            System.err.println("Hiba történt a fájl beolvasása közben!");
        }
    }
    public static void beolv(String fajlNev) throws IOException {
        FileReader fr= new FileReader(fajlNev);
        BufferedReader br= new BufferedReader(fr);      
        String sor = br.readLine();
        while (sor != null && !sor.equals("")) {
            String[] elem = sor.split(";");
            Bejegyzes bejegyzes  = new Bejegyzes(elem[0],elem[1]);
            bejegyzesek.add(bejegyzes);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }
    public static void main(String[] args) throws FileNotFoundException {      
        Scanner sr = new Scanner(System.in);
        int db = 0;
        System.out.println("Menyi új bejegyzést szeretne létrhozni: ");
        db = sr.nextInt();
        String szerzo = "";
        String tartalom = "";
        if (db%1==0){
            for(int i=0; i<db; i++){
                System.out.print("Bejegyzes szerzője: ");
                szerzo = sr.next();
                System.out.print("Bejegyzes tartalma: ");
                tartalom = sr.next();
                Bejegyzes bejegyzes  = new Bejegyzes(szerzo,tartalom);
                bejegyzesek.add(bejegyzes);
            }
        }else{
            System.out.println("Nem megfelelő számot adot meg!");
        }
        beker();
    }
}        