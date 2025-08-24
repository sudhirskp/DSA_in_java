package GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Frack_knapsack {

        class Product implements Comparable<Product>{
            int val;
            int w;
            double ratio;

            Product(int val,int w){
                this.val = val;
                this.w = w;

                ratio = (double)val/(double)w;
            }

            public int compareTo(Product that){
                if(this.ratio<=that.ratio) return 1;
                else return -1;
            }
        }

        double fractionalKnapsack(int[] values, int[] weights, int W) {
            // code here

            double res =0.0;
            int n = values.length;

            List<Product> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(new Product(values[i],weights[i]));
            }

            Collections.sort(list);

            for(Product item : list){
                if(item.w>=W){
                    res+= (W*item.ratio);
                    W=0;
                }else{
                    res+=item.val;
                    W-=item.w;
                }
                if(W==0) break;
            }
            return res;
        }

    public static void main(String[] args) {
        int [] values = {60,100,120};
        int [] weights = {10,20,30};
        int W = 50;
        Frack_knapsack obj = new Frack_knapsack();
        System.out.println(obj.fractionalKnapsack(values,weights,W));
    }
}
