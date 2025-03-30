package Stack;

import java.util.Stack;

public class Asteroids {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            if(stk.isEmpty() || asteroids[i]>0){
                stk.push(asteroids[i]);
            }else{
                while(!stk.isEmpty()){
                    int top = stk.peek();
                    if(top<0){
                        stk.push(asteroids[i]);
                        break;
                    }
                    int modval = Math.abs(asteroids[i]);
                    if(top==modval){
                        stk.pop();
                        break;
                    }else if(top>modval){
                        break;
                    }else{
                        stk.pop();
                        if(stk.isEmpty()){
                            stk.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        int ans [] = new int [stk.size()];
        for(int i=stk.size()-1;i>=0;i--){
            ans[i] = stk.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        int asteroids [] = {5,10,-5};
        Asteroids ob = new Asteroids();
        int ans [] = ob.asteroidCollision(asteroids);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}

//735. Asteroid Collision
//We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.
//
//For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
//Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
//
//Example 1:
//
//Input: asteroids = [5,10,-5]
//Output: [5,10]
//Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
