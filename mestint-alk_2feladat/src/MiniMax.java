
//A piros korong a gép, neki ajánlunk lépést ő a 2-es
public class MiniMax {


    public MiniMaxAjanlottLepes miniMaxLepes(Allapot allapot, int korlat) {
        MiniMaxAjanlottLepes ajanlottLepes = new MiniMaxAjanlottLepes();
        int max = Integer.MIN_VALUE;
        Operator op = new Operator();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++){
                if(op.alkalmazhato(allapot,"DiagRight",i,j)){
                    Allapot ujAllapot = op.alkalmaz(allapot,"DiagRight",i,j);
                    int v = miniMaxErtek(ujAllapot,korlat-1);
                    if(v > max ){
                        max = v;
                        ajanlottLepes.sor=i;
                        ajanlottLepes.oszlop=j;
                        ajanlottLepes.irany = "DiagRight";
                    }
                }
                else if(op.alkalmazhato(allapot,"DiagLeft",i,j)){
                    Allapot ujAllapot = op.alkalmaz(allapot,"DiagLeft",i,j);
                    int v = miniMaxErtek(ujAllapot,korlat-1);
                    if(v > max ){
                        max = v;
                        ajanlottLepes.sor=i;
                        ajanlottLepes.oszlop=j;
                        ajanlottLepes.irany = "DiagLeft";
                    }
                }
                else if(op.alkalmazhato(allapot,"Forward",i,j)){
                    Allapot ujAllapot = op.alkalmaz(allapot,"Forward",i,j);
                    int v = miniMaxErtek(ujAllapot,korlat-1);
                    if(v > max ){
                        max = v;
                        ajanlottLepes.sor=i;
                        ajanlottLepes.oszlop=j;
                        ajanlottLepes.irany = "Forward";
                    }
                }
            }
        }
        System.out.println("Gép irány: "+ajanlottLepes.irany
                + " Gép sor: " + ajanlottLepes.sor
                + " Gép oszlop : " +ajanlottLepes.oszlop  );
        return ajanlottLepes;
    }

    public int miniMaxErtek(Allapot allapot, int melyseg){
        if(melyseg == 0){
            Heurisztika heurisztika = new Heurisztika();
            return heurisztika.heurisztikatSzamol(allapot);
        }
        else if(allapot.jatekos.equals("R")){
            int max = Integer.MIN_VALUE;
            Operator op = new Operator();
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++){
                    if(op.alkalmazhato(allapot,"DiagRight",i,j)){
                        Allapot ujAllapot =  op.alkalmaz(allapot,"DiagRight",i,j);

                        int v = miniMaxErtek(ujAllapot,melyseg-1);
                        if(v > max ){
                            max = v;
                        }
                    }
                    else if(op.alkalmazhato(allapot,"DiagLeft",i,j)){
                        Allapot ujAllapot =  op.alkalmaz(allapot,"DiagLeft",i,j);

                        int v = miniMaxErtek(ujAllapot,melyseg-1);
                        if(v > max ){
                            max = v;
                        }
                    }
                    else if(op.alkalmazhato(allapot,"Forward",i,j)){
                        Allapot ujAllapot =  op.alkalmaz(allapot,"Forward",i,j);

                        int v = miniMaxErtek(ujAllapot,melyseg-1);
                        if(v > max ){
                            max = v;
                        }
                    }
                }
            }
            return max;
        }
        else{
            int min = Integer.MAX_VALUE;
            Operator op = new Operator();
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++){
                    if(op.alkalmazhato(allapot,"DiagRight",i,j)){
                        Allapot ujAllapot =  op.alkalmaz(allapot,"DiagRight",i,j);
                        int v = miniMaxErtek(ujAllapot,melyseg-1);
                        if(v < min ){
                            min = v;
                        }
                    }
                    else if(op.alkalmazhato(allapot,"DiagLeft",i,j)){
                        Allapot ujAllapot =  op.alkalmaz(allapot,"DiagLeft",i,j);
                        int v = miniMaxErtek(ujAllapot,melyseg-1);
                        if(v < min ){
                            min = v;
                        }
                    }
                    else if(op.alkalmazhato(allapot,"Forward",i,j)){
                        Allapot ujAllapot =  op.alkalmaz(allapot,"Forward",i,j);
                        int v = miniMaxErtek(ujAllapot,melyseg-1);
                        if(v < min ){
                            min = v;
                        }
                    }
                }
            }
            return min;
        }
    }

}
