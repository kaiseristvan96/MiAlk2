public class Heurisztika {
    public int heurisztikatSzamol(Allapot allapot){
        int ertek = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (allapot.tabla[i][j] == 2) {
                    if (j < 5) {
                        if (allapot.tabla[i + 1][j + 1] == 1)
                            ertek += 100;
                        if (allapot.tabla[i + 1][j + 1] == 0)
                            ertek += 5;
                    }
                    if (j > 1) {
                        if (allapot.tabla[i + 1][j - 1] == 1)
                            ertek += 100;
                        if (allapot.tabla[i + 1][j - 1] == 0)
                            ertek += 5;
                    }
                    if(i<5){
                        if (allapot.tabla[i + 1][j] == 1)
                            ertek -= 50;
                    }
                }
            }
        }
        return ertek;
    }
}




