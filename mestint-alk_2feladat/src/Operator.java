
public class Operator {

    public boolean alkalmazhato(Allapot allapot, String irany, int korongSor, int korongOszlop){
        switch (allapot.jatekos+irany){
            case("RForward"): //Piros előre lépne
                if(allapot.tabla[korongSor][korongOszlop] == 2
                        && korongSor+1<5
                        && allapot.tabla[korongSor+1][korongOszlop] == 0) {
                    return true;
                }
                break;
            case("RDiagRight"): //Piros jobbra előre lépne
                if(korongOszlop == 6){
                    return false;
                }
                else if(allapot.tabla[korongSor][korongOszlop] == 2
                        && korongSor+1<6
                        && (allapot.tabla[korongSor+1][korongOszlop+1] == 0 || allapot.tabla[korongSor+1][korongOszlop+1] == 1)) {
                    return true;
                }
                break;
            case("RDiagLeft"): //Piros balra előre lépne
                if(korongOszlop == 0){
                    return false;
                }
                else if(allapot.tabla[korongSor][korongOszlop] == 2
                        && korongSor+1<6
                        && (allapot.tabla[korongSor+1][korongOszlop-1] == 0 || allapot.tabla[korongSor+1][korongOszlop-1] == 1)) {
                    return true;
                }
                break;
            //Kékek ellenörzése
            case("BForward"): //Kék előre lépne
                if(allapot.tabla[korongSor][korongOszlop] == 1
                        && korongSor-1>=0
                        && allapot.tabla[korongSor-1][korongOszlop] == 0) {
                    return true;
                }
                break;
            case("BDiagRight"): //Kék jobbra előre lépne
                if(korongOszlop == 6){
                    return false;
                }
                else if(allapot.tabla[korongSor][korongOszlop] == 1
                        && korongSor-1>=0
                        && (allapot.tabla[korongSor-1][korongOszlop+1] == 0 || allapot.tabla[korongSor-1][korongOszlop+1] == 2)) {
                    return true;
                }
                break;
            case("BDiagLeft"): //Kék balra előre lépne
                if(korongOszlop == 0){
                    return false;
                }
                else if(allapot.tabla[korongSor][korongOszlop] == 1
                        && korongSor-1>=0
                        && (allapot.tabla[korongSor-1][korongOszlop-1] == 0 || allapot.tabla[korongSor-1][korongOszlop-1] == 2)) {
                    return true;
                }
                break;

        }
        return false;
    }
//piros korong 2, kék korong 1, üres 0, -1 tilos lépni
    public Allapot alkalmaz(Allapot allapot, String irany, int korongSor, int korongOszlop){
        Allapot uj = new Allapot(allapot);
        switch (allapot.jatekos+irany){
            case("RForward"): //Piros előre lép
                uj.tabla[korongSor][korongOszlop] = 0;
                uj.tabla[korongSor+1][korongOszlop] = 2;

                break;
            case("RDiagRight"): //Piros jobbra előre lép
                uj.tabla[korongSor][korongOszlop] = 0;
                uj.tabla[korongSor+1][korongOszlop+1] = 2;

                break;
            case("RDiagLeft"): //Piros balra előre lép
                uj.tabla[korongSor][korongOszlop] = 0;
                uj.tabla[korongSor+1][korongOszlop-1] = 2;

                break;
            case("BForward"): //Kék előre lép
                uj.tabla[korongSor][korongOszlop] = 0;
                uj.tabla[korongSor-1][korongOszlop] = 1;

                break;
            case("BDiagRight"): //Kék jobbra előre lép
                uj.tabla[korongSor][korongOszlop] = 0;
                uj.tabla[korongSor-1][korongOszlop+1] = 1;

                break;
            case("BDiagLeft"): //Kék balra előre lép
                uj.tabla[korongSor][korongOszlop] = 0;
                uj.tabla[korongSor-1][korongOszlop-1] = 1;

                break;

        }
        return uj;
    }


}
