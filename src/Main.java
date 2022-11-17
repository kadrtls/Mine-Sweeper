import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println('\n'+"Mayın tarlası oyununa hoşgeldiniz."+'\n');
        Scanner scanner=new Scanner(System.in);
        System.out.println("Mayın tarlasının satır sayıysını giriniz");
        int x= scanner.nextInt();
        System.out.println("Mayın tarlasının sütun sayısını belirleyin.");
        int y= scanner.nextInt();
        Minesweeper minesweeper=new Minesweeper(x,y);
        minesweeper.run();
    }
}