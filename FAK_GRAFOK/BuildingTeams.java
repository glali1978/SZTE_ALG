import java.util.*;

public class BuildingTeams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bemenet beolvasása
        int n = sc.nextInt(); // Diákok száma
        int m = sc.nextInt(); // Barátságok száma
        List<List<Integer>> graf = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graf.add(new ArrayList<>());
        }

        // Gráf építése
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graf.get(a).add(b);
            graf.get(b).add(a);
        }

        // Csapatok inicializálása (0: nincs csapatban, 1: első csapat, 2: második csapat)
        int[] csapat = new int[n + 1];

        // BFS függvény a csapatok szétosztására
        boolean lehetseges = true;

        for (int i = 1; i <= n; i++) {
            if (csapat[i] == 0) { // Ha még nincs csapatban
                if (!bfs(i, graf, csapat)) {
                    lehetseges = false;
                    break;
                }
            }
        }

        // Eredmény kiírása
        if (!lehetseges) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.print(csapat[i] + " ");
            }
        }
    }

    // BFS széleségi keresés megvalósítása
    private static boolean bfs(int kezd, List<List<Integer>> graf, int[] csapat) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kezd);
        csapat[kezd] = 1; // Kezdjük az első csapattal

        while (!queue.isEmpty()) {
            int jelenlegi = queue.poll();
            int jelenlegiCsapat = csapat[jelenlegi];

            for (int szomszed : graf.get(jelenlegi)) {
                if (csapat[szomszed] == 0) {
                    csapat[szomszed] = 3 - jelenlegiCsapat; // Atvaltas (1 -> 2, 2 -> 1)
                    queue.add(szomszed);
                } else if (csapat[szomszed] == jelenlegiCsapat) {
                    return false; // Konfliktus: ugyanabban a csapatban van két barát
                }
            }
        }

        return true;
    }
}