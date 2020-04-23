
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String irany = "";
        Allapot allapot = new Allapot();
        //allapot.peldaBeall();
        allapot.VegePeldaBeall();
        //allapot.kezdoBeall();
        MiniMaxAjanlottLepes miniMaxAjanlottLepes = new MiniMaxAjanlottLepes();

        Operator oper = new Operator();
        System.out.println(allapot);
        MiniMax kereso = new MiniMax();

        int jatekosSor;
        int jatekosOszlop;
        int jatekosIrany;


        while (true){
            allapot.jatekos="B";

            if(allapot.elfogytakKorongok()){
            }
            else if (allapot.elfogyottLepes()){
                System.out.println("A játékos vesztett!");
                break;
            }
            do {
                System.out.println("Írja be a választott sort [0-5]");
                jatekosSor = Integer.parseInt(scanner.next());

                System.out.println("Írja be a választott oszlop[0-6]");
                jatekosOszlop = Integer.parseInt(scanner.next());
            }while (allapot.tabla[jatekosSor][jatekosOszlop] != 1);
            do {
                System.out.println("Írja be a választott irányt[1:Balra előre; 2:Előre; 3:Jobbra előre]");
                jatekosIrany = Integer.parseInt(scanner.next());

                switch (jatekosIrany) {
                    case 1:
                        irany = "DiagLeft";
                        break;
                    case 2:
                        irany = "Forward";
                        break;
                    case 3:
                        irany = "DiagRight";
                        break;
                }
            }while(!oper.alkalmazhato(allapot,irany,jatekosSor,jatekosOszlop));

            allapot = oper.alkalmaz(allapot,irany,jatekosSor,jatekosOszlop);
            System.out.println(allapot);
            allapot.setJatekos("R");
            System.out.println("Gép lép \n");
            miniMaxAjanlottLepes = kereso.miniMaxLepes(allapot,1);
            if(miniMaxAjanlottLepes.irany==null){
                System.out.println("A gép nem tudott lépni. Játék vége!");
                break;
            }
            allapot= oper.alkalmaz(allapot, miniMaxAjanlottLepes.irany, miniMaxAjanlottLepes.sor, miniMaxAjanlottLepes.oszlop);
            System.out.println(allapot);
        }
    }
}
