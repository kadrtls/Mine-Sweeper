import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    int rowNumber;
    int colNumber;
    int mineNumber;
    int row;
    int col;
    int foundMine;
    int aroundMines;
    String[][] sweeper;
    String[][] mines;

    Minesweeper(int rowNumber,int colNumber){
        this.rowNumber=rowNumber;
        this.colNumber=colNumber;
        sweeper=new String[this.rowNumber][this.colNumber];
        mines=new String[this.rowNumber][this.colNumber];
    }

    void creatSweeper(){
        for (int i=0;i< sweeper.length;i++){
            for (int j=0;j<sweeper[0].length;j++){
                sweeper[i][j]="- ";
            }
        }
    }
    void creatMine(){
        mineNumber=rowNumber*colNumber/4;
        Random random=new Random();
        for (int i=0;i<mines.length;i++){
            for (int j=0;j<mines[0].length;j++){
                mines[i][j]="- ";
            }
        }
        while (mineNumber>0){
            int rowNo=random.nextInt(rowNumber);
            int colNo= random.nextInt(colNumber);
            if (mines[rowNo][colNo] !="* "){
                mines[rowNo][colNo]="* ";
                mineNumber--;
            }
        }
    }
    void printSweeper(){
        for (String[] i: sweeper){
            for (String j:i){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    boolean winControl(){
        foundMine =0;
        for (int i=0;i<rowNumber;i++){
            for (int j=0;j<colNumber;j++){
                if (sweeper[i][j]=="- "){
                    if (mines[i][j]!="* "){
                        foundMine++;
                    }
                }
            }
        }
        if(foundMine==0){
            return true;
        }
        return false;
    }
    void compare(){
        aroundMines=0;
        if (mines[row][col]=="* "){
            System.out.println("GAME OVER.");
            for (String[] i:mines){
                for (String j:i){
                    System.out.print(j);
                }
                System.out.println();
            }
        }
        else{
            for (int i=row-1;i<=row+1;i++){
                for (int j=col-1;j<=col+1;j++){
                    try {
                        if (mines[i][j]=="* "){
                            aroundMines++;
                        }
                    }catch (Exception e){

                    }
                }
            }
            sweeper[row][col]=String.valueOf(aroundMines);
            game();
        }
    }
    void game(){
        if (winControl()){
            System.out.println("YOU WİN :)");
        }else{
            printSweeper();
            Scanner scanner=new Scanner(System.in);
            System.out.println("satır sayısı giriniz.");
            row= scanner.nextInt()-1;
            System.out.println("sütun sayısı giriniz");
            col= scanner.nextInt()-1;
            if (row>rowNumber||col>colNumber){
                System.out.println("Alanın dışında bir değer girdiniz");
                game();
            }else{
                compare();
            }
        }
    }
    void run(){
        creatSweeper();
        creatMine();
        game();
    }

}