import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main {
    static int n;
    static int m;
    static boolean visited[];
    static int result[];
    static BufferedReader br;
    static BufferedWriter bw;
    static int input[];

    public static void main(String[] args) throws NumberFormatException, IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // n, m입력
        String [] nm  = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        // 수열입력
        String [] ar = br.readLine().split(" ");
        input = new int[n];
        for (int i = 0; i < n; i++){
            input[i] = Integer.parseInt(ar[i]);
        }

        // 수열 오름차순정렬
        Arrays.sort(input);

        visited = new boolean[n]; // 방문체크
        result = new int[m]; // 출력할 결과

        dfs(0);

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int depth) throws IOException{
        if(depth == m){ // 깊이가 m에 도달했으면 결과 출력
            for(int i = 0; i < m; i++){
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int j = 0; j < n; j++){
            if(visited[j] == false){ // 재귀로 인해 다시 visited[i]를 만났을 때 false이면 다음 반복문으로 넘어감
                visited[j] = true;
                result[depth] = input[j];
                dfs(depth + 1);
                visited[j] = false; // 결과를 출력하고 되돌아 왔으면 다음 반복문을 위해 false로 초기화
            }
        }

    }

}
