package Recursion;

public class Henoi {

    public int towerOfHanoi(int n, int from, int to, int aux) {
        int [] move = new int [1];

        Hanoi(n,from,aux,to,move);
        return move[0];
    }

    public void Hanoi(int n, int from, int aux, int to, int[] move){
        if(n==0) return;
        move[0]++;
        Hanoi(n-1, from, aux, to, move);

        System.out.println("Move " + n + " from " + from + " to " + to);

        Hanoi(n-1, aux, to, from, move);
    }
    public static void main(String[] args) {
        Henoi ob = new Henoi();
        int n = 3;
        int from = 1;
        int to = 3;
        int aux = 2;

        System.out.println(ob.towerOfHanoi(n,from,to,aux));
    }
}
//https://www.geeksforgeeks.org/tower-of-hanoi/
