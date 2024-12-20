import java.util.*;
import java.lang.*;
public class LotteryDrawing {
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        System.out.print("How many numbers do you need to draw?");
        int k=in.nextInt();
        System.out.print("What is the highest number you can draw?");
        int n=in.nextInt();
        int[] numbers=new int [n];
        for (int i=0;i<numbers.length;i++)
            numbers[i]=i+1;
        int [] results=new int[k];
        for (int i=0;i<results.length;i++) {
            int r = (int) (Math.random() * n);
            results[i]=numbers[r];
            numbers[r]=numbers[r-1];//确保再次不会抽取到
            n--;
        }
        Arrays.sort(results);
        System.out.println("Bet the following combination. "+"It'll make you rich!");
        for (int i:results)
            System.out.println(i);

    }
}
