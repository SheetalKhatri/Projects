import Assignment1.Assignment1;

import java.util.ArrayList;

class Main {
    public void print(String[] arr) {
        for (String i:arr) {
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        String[] fruits = new String[10];
        for(int a=0; a<10; a++) {
            if (a<5) {
                fruits[a] ="apple";
            }
            else if (a>4 && a<8) {
                fruits[a]= "mango";
            }
            else{
                fruits[a]="oranges";
            }

        }
        Main m = new Main();
        m.print(fruits);



        int[][] a = {
                {1, -2, 3},
                {-4, -5, 6, 9},
                {7}
        };
        for (int i = 0; i < a.length;i++) {
            for(int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }


}
