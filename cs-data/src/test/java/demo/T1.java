package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = 0;
        int M = 0;

        String line = bf.readLine();
        Pair nm = getPair(line);
        N = nm.getX();
        M = nm.getY();


        Map<Pair, Integer> mousesMap = new HashMap<>(M);
        Map<Pair, Integer> platsMap = new HashMap<>(M);
        // 老鼠的坐标统计
        for (int i=0; i < N; i++) {
            Pair p = getPair(bf.readLine());

            int v = 0;
            if (mousesMap.containsKey(p)) {
                v = mousesMap.get(p);
            }
            mousesMap.put(p, v+1);
        }
        // 植物的坐标统计
        for (int i=0; i < M; i++) {
            Pair p = getPair(bf.readLine());

            platsMap.put(p, 1);
        }

        int min = -1;
        Pair ans = null;
        for(Map.Entry<Pair, Integer> entry : mousesMap.entrySet()) {
            Pair p = entry.getKey();
            int v = entry.getValue();

            if (platsMap.containsKey(p)) {
                continue;
            }
            if (v >= min) {
                min = v;
                ans = getMin(ans, p);
            }
        }

        echoResult(ans);

    }

    public static Pair getMin(Pair ans, Pair p) {
        if (ans == null) {
            return p;
        }
        int pV = p.getX() + p.getY();
        int aV = ans.getX() + ans.getY();

        if ( pV == aV) {
            if (ans.getX() <= p.getX()) {
                return ans;
            }
            return p;
        }

        return aV <= pV ? ans : p;
    }

    public static void echoResult(Pair p) {
        if (p == null) {
            return;
        }
        System.out.println(p.getX() + " " + p.getY());
    }

    public static Pair getPair(String text) {
        //System.out.println(text);
        String[] pairText = text.split(" ");
        int x = Integer.parseInt(pairText[0]);
        int y = Integer.parseInt(pairText[1]);

        return new Pair(x, y);
    }



    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() {
            return x;
        }
        int getY() {
            return y;
        }
        @Override
        public String toString() {
            return "Pair<" + x + ", " + y + ">";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair p = (Pair) o;
            return this.x == p.getX() && this.y == p.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
