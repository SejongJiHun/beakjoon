import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class P15655 {
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

        //visited = new boolean[n]; // 방문체크
        result = new int[m]; // 출력할 결과

        dfs(0,0);

        bw.flush();
        br.close();
        bw.close();
    }

    // start 파라미터를 통해 반복문의 시작점을 설정
    static void dfs(int start, int depth) throws IOException{
        if(depth == m){ // 깊이가 m에 도달했으면 결과 출력
            for(int i = 0; i < m; i++){
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int j = start; j < n; j++){     // 만약 start가 n - 1, 즉 마지막에 도달하면 dfs(n, ?)을 하게 되고
            result[depth] = input[j];       // depth가 m이 되어 출력하기 전에 반복문이 종료되고 반환된다.
            dfs(j + 1,depth + 1);// 이로 인해 실제 result에 저장은 되나 출력은 안된다.
        }

    }

}
