package com.ji.beakjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
	    static int N; // κ·Έλ? ? ? ? ?
	    static int M; // κ°μ ? ?

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        N = scanner.nextInt();
	        M = scanner.nextInt();

	        int[] cntOfLink = new int[N + 1]; // κ°μ ? ?? ??? λ°°μ΄

	        // κ°?μ€μΉκ°? ?? κ·Έλ?(?Έ?  λ¦¬μ€?Έ ?΄?©)
	        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	        for (int i = 0; i < N + 1; i++) {
	            graph.add(new ArrayList<Integer>());
	        }
	        // ?¨λ°©ν₯ ?°κ²? ?€? 
	        for (int i = 0; i < M; i++) {
	            int v1 = scanner.nextInt();
	            int v2 = scanner.nextInt();
	            graph.get(v1).add(v2);
	            cntOfLink[v2]++; // ?? ? ? ? ??? κ°μ ? ? μ¦κ?
	        }

	        // ?? ? ? ¬ (A B: Aκ°? B?? ? ?€. Aκ°? ? ?)
	        topologicalSort(graph, cntOfLink);
	    }

	    /**
	     * ?? ? ? ¬
	     */
	    static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] cntOfLink) {
	        Queue<Integer> queue = new LinkedList();

	        // μ΄κΈ°: ? ? ? ? ? κ°?μ§?μ§? ?? ? ? ? ?? ?½?
	        for (int i = 1; i < N + 1; i++) {
	            if (cntOfLink[i] == 0) { // ?΄?Ή ? ? ? κ°μ ? ?κ°? 0?΄λ©?
	                queue.add(i);
	            }
	        }

	        // ? ? ? ? λ§νΌ λ°λ³΅
	        for (int i = 0; i < N; i++) {
	            int v = queue.remove(); // 1. ??? ? ?  μΆμΆ
	            System.out.print(v + " "); // ? ?  μΆλ ₯

	            // 2. ?΄?Ή ? ? κ³? ?°κ²°λ λͺ¨λ  ? ? ? ???΄
	            for (int nextV : graph.get(v)) {
	                cntOfLink[nextV]--; // 2-1. κ°μ ? ? κ°μ

	                // 2-2. ? ? ? ? ? κ°?μ§?μ§? ?? ? ? ? ?? ?½?
	                if (cntOfLink[nextV] == 0) { // ?΄?Ή ? ? ? κ°μ ? ?κ°? 0?΄λ©?
	                    queue.add(nextV);
	                }
	            }
	        }
	    }
}
