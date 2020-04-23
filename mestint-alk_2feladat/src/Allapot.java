import java.util.LinkedList;

public class Allapot {
    int[][] tabla = new int[6][7];

    String jatekos = ""; //támogatott játékos R és B lesz az emberi ellenfél
    public Allapot() {
        this.jatekos = "B";
        this.tabla = new int[][]{
                {0, 0,  0,  0,  0, 0, 0},
                {0, 0,  0,  0,  0, 0, 0},
                {0, 0,  0,  0, -1, 0, 0},
                {0, 0, -1,  0,  0, 0, 0},
                {0, 0,  0,  0,  0, 0, 0},
                {0, 0,  0,  0,  0, 0, 0}};
    }

    public Allapot(Allapot allapot){
        if(getJatekos().equals("B")){
            this.setJatekos("R");
        }
        if(getJatekos().equals("R")){
            this.setJatekos("B");
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++){
                this.tabla[i][j] = allapot.tabla[i][j];
            }
        }
    }


    boolean elfogytakKorongok() {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if(this.tabla[i][j] == 1){
                    sum1++;

                }else if(this.tabla[i][j]==2){
                    sum2++;
                }
                if (sum1 > 0 && sum2 > 0){
                    return false;
                }
            }
        }
        return true;
    }

    boolean elfogyottLepes(){
        Operator op = new Operator();
        LinkedList<Integer> coordsX = new LinkedList<>();
        LinkedList<Integer> coordsY = new LinkedList<>();
        coordsX.clear();coordsY.clear();
        int jatekosKorongSzama = 1;
        int korongSzama = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if(this.tabla[i][j] == jatekosKorongSzama) {
                    coordsX.addFirst(i);
                    coordsY.addFirst(j);
                }
            }
        }
        if(coordsX.isEmpty()){return true;}
        for(int n = 0; n < coordsX.size(); n++) {
            if ((!op.alkalmazhato(this,"Forward",coordsX.get(n),coordsY.get(n)))
                    && (!op.alkalmazhato(this,"DiagLeft",coordsX.get(n),coordsY.get(n)))
                    && (!op.alkalmazhato(this,"DiagRight",coordsX.get(n),coordsY.get(n))) ) {
                korongSzama++;
            }
        }
        if(korongSzama == coordsX.size()){
            return true;
        }

        return false;
    }


    @Override
    public String toString() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++)
                System.out.print(this.tabla[i][j] + "\t");
            System.out.println();
        }
        return "";
    }

    public void kezdoBeall() {
        this.jatekos = "B";
        this.tabla = new int[][]{
                {2, 2,  2,  2,  2, 2, 2},
                {0, 0,  0,  0,  0, 0, 0},
                {0, 0,  0,  0, -1, 0, 0},
                {0, 0, -1,  0,  0, 0, 0},
                {0, 0,  0,  0,  0, 0, 0},
                {1, 1,  1,  1,  1, 1, 1}};
    }

    public void peldaBeall() {
        this.jatekos = "B";
        this.tabla = new int[][]{
                {2, 0,  2,  0,  0, 0, 2},
                {0, 0,  0,  0,  2, 2, 0},
                {0, 2,  0,  2, -1, 0, 0},
                {0, 0, -1,  0,  1, 0, 1},
                {0, 0,  0,  0,  0, 0, 0},
                {1, 1,  1,  1,  0, 1, 0}};
    }
    public void VegePeldaBeall() {
        this.jatekos = "B";
        this.tabla = new int[][]{
                {0, 0,  0,  0,  0, 0, 0},
                {2, 0,  2,  0,  0, 0, 0},
                {0, 0,  0,  0, -1, 0, 0},
                {0, 0, -1,  0,  0, 0, 0},
                {0, 1,  0,  0,  0, 0, 0},
                {0, 0,  0,  0,  0, 0, 0}};
    }

    public void masolTabla(Allapot allapotCopyFromThis){
        this.jatekos = allapotCopyFromThis.jatekos;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++){
                this.tabla[i][j] = allapotCopyFromThis.tabla[i][j];
            }
        }
    }

    public String getJatekos() {
        return jatekos;
    }
    public void setJatekos(String jatekos){
        this.jatekos = jatekos;
    }
}
