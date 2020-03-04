package dk.stbn.myapplication;

import java.util.Random;

public class GætTal {

    private int hemmeligtTal;
    private int max;
    private int antalGæt;


    private boolean gættetVarForHøjt;
    private boolean gættetRigtigt;
    private int senesteGæt;
    private int score;

    public GætTal(){
        max = 100;
        nulstil();
    }

    public GætTal(int maximum){
        max = maximum;
        nulstil();
    }

    public void gæt(int tal){
        antalGæt++;
        if(tal == hemmeligtTal) gættetRigtigt = true;
        if (tal > hemmeligtTal) gættetVarForHøjt = true;
        else gættetVarForHøjt = false;
        senesteGæt = tal;
        score = score - 10; //kan forbedres :)
    }

    public void nytTal(){
        hemmeligtTal = new Random().nextInt(max)+1;
        System.out.println("Der er genereret et nyt tilfældigt tal");
        //System.out.println("Tallet som skal gættes: "+hemmeligtTal);
    }

    public void nulstil(){
        antalGæt = 0;
        nytTal();
        gættetVarForHøjt = false;
        gættetRigtigt = false;
        score = max;
        senesteGæt = 0;
        //System.out.println("Spillet blev nulstillet");
    }

    public void setMax (int maximum){

        max = maximum;
        nulstil();
        nytTal();
        System.out.println("Nyt maximum blev sat til: "+max);
    }

    public int snyd (){
        return hemmeligtTal;
    }

    public int getScore() {
        return score;
    }

    public int getAntalGæt(){
        return antalGæt;
    }

    public boolean gættetVarForHøjt() {
        return gættetVarForHøjt;
    }

    public boolean gættetRigtigt() {
        return gættetRigtigt;
    }

    public void logStatus (){
        System.out.println("Status: ");
        System.out.println("Der blev gættet på "+senesteGæt + " | Var det rigtigt? "+gættetRigtigt + " | For lavt? "+!gættetVarForHøjt + " | For højt? "+gættetVarForHøjt);
        System.out.println("Scoren er nu: "+score + " | antal gæt: "+ antalGæt);
    }



    public int getMax() {
        return max;
    }
}
