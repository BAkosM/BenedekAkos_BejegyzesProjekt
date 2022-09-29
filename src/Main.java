import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import harcos.*;

public class Main {        
    public static List<Harcos> harcosok = new ArrayList<>();
    public static void beker(){
        String fajlNev = "harcosok.csv";
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
            Harcos harcos  = new Harcos(elem[0],elem[1]);
            harcosok.add(harcos);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
        beker();
        Scanner sr = new Scanner(System.in);
        String menu = "";
        String playername = "";
        String playerclass = "";
        int j = 0;
        int q = 0;
        int b = 0;
        int ellenfel = 0;
        int kor = 3;
        while(j<1){
        System.out.print("Add meg a karaktered nevét: ");
        playername = sr.nextLine();
        System.out.print("Válasz karakter klaszt(1-Harcos,2-Íjász,3-Mágus):");
        playerclass = sr.nextLine();
        if(playerclass.equals("1")||playerclass.equals("2")||playerclass.equals("3")){
            j++;
        } else {
            System.out.println("Hibás karakter név vagy klasz! Próbáld újra!");
        }}
        Harcos player = new Harcos(playername,playerclass);

        while(q<1){
            System.out.printf("%d kor az ellenség támadásáig",kor);   
            System.out.println();
            if(kor == 0){
                kor = 3;
                ellenfel = (int)(Math.random()*(harcosok.size()-1))+1;
                harcosok.get(ellenfel).megkuzd(player);
                System.out.printf("%s megtámadott!",harcosok.get(ellenfel).getNev());
            }
            System.out.println("Ellenfelek: ");  
            for(int i = 0; i < harcosok.size(); i++) {
                System.out.println(harcosok.get(i));
            }
            while(b<1){         
            System.out.println("Mit szeretnél csinálni (a-harcolok,b-gyógyulás,c-státusz,d-kilépés): ");
            menu = sr.next();
            if(menu.equals("a")){
                System.out.println("Hanyadik ellenféllel küzdenél meg: ");
                ellenfel = sr.nextInt()-1;
                if(ellenfel>harcosok.size()){
                    System.out.println("Nincs ilyen ellenfél!");
                }else{
                    b++;
                    player.megkuzd(harcosok.get(ellenfel));
                }
            }else if(menu.equals("b")){
                b++;
                player.gyogyul();
            }else if(menu.equals("d")){
                b++;
                q++;
            }else if(menu.equals("c")){
                System.out.println(player);
            }else{
             System.out.println("Nincs ilyen opció!");   
            }}
            kor--;
            b = 0;
        }
    }
}        