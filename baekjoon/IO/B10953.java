package baekjoon.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10953 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; ++i){
            String[] s = br.readLine().split(",");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            System.out.println(a+b);
        }

        br.close();
    }
}
