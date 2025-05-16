import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("1. calcolatrice!");
        System.out.println("2. ordinamento!");
        System.out.println("3. ricerca sequenziale!");
        System.out.println("4. ricerca binaria!");
        System.out.println("5. inserisci una scelta:");

        Scanner scanner = new Scanner(System.in);
        int valoreTastiera = scanner.nextInt();
        scanner.nextLine();
        switch(valoreTastiera) {
            case 1:
                Main.calcolatrice(scanner);
                break;
            case 2:
                Main.ordinamentoArray();
                break;
            case 3:
                Main.ricercaSequenziale(scanner);
                break;
            case 4:
                Main.ricercaBinaria(scanner);
                break;
            default:
                throw new IllegalArgumentException("Valore non valido");
        }
    }

    public static void calcolatrice(Scanner scanner) {
        System.out.println("1. addizione!");
        System.out.println("2. sottrazione!");
        System.out.println("3. moltiplicazione!");
        System.out.println("4. divisione!");
        int scelta = scanner.nextInt();
        scanner.nextLine();
        System.out.println("inserisci il primo valore");
        float primoValore = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("inserisci il secondo valore");
        float secondoValore = scanner.nextFloat();
        scanner.nextLine();
        switch (scelta) {
            case 1:
                float somma = primoValore + secondoValore;
                System.out.printf("La somma è %.2f", somma);
                break;
            case 2:
                float sottrazione = primoValore - secondoValore;
                System.out.printf("La sottrazione è %.2f", sottrazione);
                break;
            case 3:
                float moltiplicazione = primoValore * secondoValore;
                System.out.printf("La moltiplicazione è %.2f", moltiplicazione);
                break;
            case 4:
                if (secondoValore == 0)
                    throw new IllegalArgumentException("impossibile dividere per 0");
                float divisione = primoValore / secondoValore;
                System.out.printf("La divisione è %.2f", divisione);
                break;
            default:
                throw new IllegalArgumentException("Valore non valido");
        }
    }

    public static void ordinamentoArray() {
        long[] array = new long[10];
        for(int i = 0; i < 10; i++) {
            array[i] = Math.round(Math.random() * 100);
        }
        System.out.print("Array prima dell'ordinamento: ");
        for(long val: array) {
            System.out.print(val + " ");
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            for(int j = i + 1; j < 10; j++) {
                long minVal = array[i];
                if(minVal > array[j]) {
                    long scambio = array[i];
                    array[i] = array[j];
                    array[j] = scambio;
                }
            }
        }
        System.out.print("Array dopo l'ordinamento: ");
        for(long val: array) {
            System.out.print(val + " ");
        }
    }

    public static void ricercaSequenziale(Scanner scanner) {
        long[] array = new long[1000];
        for(int i = 0; i < 1000; i++) {
            array[i] = Math.round(Math.random() * 100);
        }

        System.out.print("Inserisci il numero da cercare: ");
        long cercaVal = scanner.nextLong();
        scanner.nextLine();

        boolean trovato = false;
        int posizione = -1;

        for(int i = 0; i < 1000; i++) {
            if(array[i] == cercaVal) {
                trovato = true;
                posizione = i;
                break;
            }
        }


        if(trovato) {
            System.out.println("Il numero cercato si trova nella posizione " + posizione);
        } else {
            System.out.println("Non ho trovato il numero");
        }
    }

    public static void ricercaBinaria(Scanner scanner) {
        // Creiamo e popoliamo l'array
        long[] array = new long[100000];
        for(int i = 0; i < 100000; i++) {
            array[i] = Math.round(Math.random() * 100);
        }

        System.out.print("Inserisci il numero da cercare: ");
        long cercaVal = scanner.nextLong();
        scanner.nextLine();

        // Ordiniamo l'array (necessario per la ricerca binaria)
        Arrays.sort(array);

        // Inizializziamo gli indici per la ricerca
        int left = 0;
        int right = array.length - 1;
        boolean trovato = false;

        // Ricerca binaria
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(array[mid] == cercaVal) {
                System.out.println("Ho trovato il numero nella posizione " + mid);
                trovato = true;
                break;
            }

            if(array[mid] < cercaVal) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if(!trovato) {
            System.out.println("Numero non trovato");
        }
    }
}