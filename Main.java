import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int linie = pobierzLiczbeWyrazen();
        double[][] wartosciX = new double[linie][linie+1];

        pobierzWyrazenia(linie,wartosciX);
        eliminacjaGaussa(linie, wartosciX);

        double[] wyniki = wyznaczWyniki(linie,wartosciX);
        wyswietlWyniki(wyniki);

    }

    private static void pobierzWyrazenia(int linie, double[][] wartosciX){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i<linie; i++){
            System.out.println((i+1)+".wyrazenie: ");
            for(int j = 0; j<linie+1; j++){
                if(j==linie){
                    System.out.print("  wynik koncowy = ");
                    wartosciX[i][j]=scanner.nextDouble();
                }else{
                    System.out.print("  wartosc x"+(j+1)+"=");
                    wartosciX[i][j]=scanner.nextDouble();
                }
            }
        }
    }

    private static void eliminacjaGaussa(int linie, double[][] wartosciX){
        double wspolczynnikDzialania;
        for(int k=0;k<linie-1;k++) {
            for (int i = 0+k; i < linie - 1; i++) {

                wspolczynnikDzialania = (wartosciX[i + 1][k] / wartosciX[k][k] * (-1));

                for (int j = 0+k; j < linie + 1; j++) {

                    wartosciX[i + 1][j] = wartosciX[i + 1][j] + wspolczynnikDzialania * wartosciX[k][j];
                }
            }
        }
    }

    private static double[] wyznaczWyniki(int linie, double[][] wartosciX){
        double[] wyniki = new double[linie];

        for(int i=linie-1; i>=0; i--){
            for(int j=linie; j>=0; j--){
                if(i!=j-1){
                    wartosciX[i][wartosciX.length] = wartosciX[i][wartosciX.length] - wartosciX[i][j-1]*wyniki[j-1];
                }else {
                    wyniki[i] = wartosciX[i][wartosciX.length] / wartosciX[i][j - 1];
                    break;
                }
            }
        }
        return wyniki;
    }

    private static void wyswietlWyniki(double[] wyniki){
        System.out.println("-----------wyniki--------------");
        for(int i=0; i<wyniki.length; i++){
            System.out.println("x"+(i+1)+"="+wyniki[i]);
        }
    }

    private static int pobierzLiczbeWyrazen(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("liczba wyrazen: ");
        int linie = scanner.nextInt();
        scanner.nextLine();
        return linie;
    }
}

