import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import bejegyzes.Bejegyzes;

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
                szerzo = sr.nextLine();
                System.out.print("Bejegyzes tartalma: ");
                tartalom = sr.nextLine();
                Bejegyzes bejegyzes  = new Bejegyzes(szerzo,tartalom);
                bejegyzesek.add(bejegyzes);
            }
        }else{
            System.out.println("Nem megfelelő számot adot meg!");
        }
        beker();
        Random rnd = new Random();
        int likekioszt = (bejegyzesek.size()*20);
        for(int i=0;i<likekioszt;i++){
            bejegyzesek.get(rnd.nextInt(bejegyzesek.size()-1)).like();
        }
        System.out.println("Mire módosítaná a második szöveget");
        tartalom = sr.nextLine();
        bejegyzesek.get(1).setTartalom(tartalom);
        System.out.println(bejegyzesek);
        //Feladat 3
        int hanyadik = 0;
        int likokszama = 0;
        int tzotalat = 0;
        for (int i=0;i<bejegyzesek.size();i++){
            if(bejegyzesek.get(i).getLikeok()>likokszama){
                likokszama = bejegyzesek.get(i).getLikeok();
                hanyadik = i;
            }
            if(bejegyzesek.get(i).getLikeok()<15){
                tzotalat += 1;
            }
        }
        System.out.printf("A legtöbb lájkal rendelkező poszt a %d-adik! ",hanyadik);
        if(likokszama>35){
            System.out.println("Van 35 lájknál több lájkal rendelkező bejegyzés!");
        }else{
            System.out.println("Nincs 35 lájknál több lájkal rendelkező bejegyzés!");
        }
        System.out.printf("%d bejegyzés van ami kevessebb mint 15 lájkot kapott",tzotalat);
        /*boolean sort= false;
        int sortszam = 0;
        while(!sort){
            sortszam = 0;
            for(int i=1;i<bejegyzesek.size();i++){
                Bejegyzes bejegyzes1  = bejegyzesek.get(i-1);
                Bejegyzes bejegyzes2  = bejegyzesek.get(i);
                if(bejegyzes1.getLikeok()<bejegyzes2.getLikeok()){
                    bejegyzesek.get(i-1).setListaelem(bejegyzes1);
                    bejegyzesek.get(i).setListaelem(bejegyzes2);;
                    sortszam++;
                }
            }
            if(sortszam == 0){
                sort=true;
            }
        }*/
        System.out.println(bejegyzesek);
    }
}        