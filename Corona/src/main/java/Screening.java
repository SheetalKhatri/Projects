public class Screening {
public static void main(String[] args) {
    String[] fruits = new String[10];
    for(int a=0; a<10; a++) {
        String fruit = "oranges";
        if (a < 5) fruit = "apple";
        else if (a > 4 && a < 8) fruit = "mango";

        fruits[a] = fruit;
    }
}
}
