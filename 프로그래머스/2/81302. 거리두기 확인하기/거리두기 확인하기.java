import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean isDistanceOK;
    
    static void checkDistance(int x, int y, String[] place, boolean[][] visitedApplicant) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        boolean[][] visit = new boolean[place.length][place[0].length()];
        visit[y][x] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= place[0].length() || ny < 0 || ny >= place.length || visit[ny][nx] || place[ny].charAt(nx) == 'X') {
                    continue;
                }
                if (visitedApplicant[ny][nx]) {
                    continue;
                }
                if (place[ny].charAt(nx) == 'P') {
                    if (now[2]+1 <= 2) {
                        isDistanceOK = false;
                        return;
                    }
                }
                visit[ny][nx] = true;
                q.add(new int[]{nx, ny, now[2]+1});
            }
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        // 응시자가 있는 위치에서 bfs를 돌며 다른 응시자와의 거리를 파악
        // 한 명이라도 바로 거리두기를 지키지 않았으면 바로 끝내고 0
        for (int i=0;i<places.length;i++) {
            boolean[][] visit = new boolean[places.length][places[0].length];
            for (int j=0;j<places[i].length;j++) {
                for (int k=0;k<places[i][j].length();k++) {
                    isDistanceOK = true;
                    if (places[i][j].charAt(k) == 'P') {
                        checkDistance(k, j, places[i], visit);
                        if (!isDistanceOK) {
                            answer[i] = 0;
                            break;
                        }
                        visit[j][k] = true;
                    }
                }
                if (!isDistanceOK) {
                    break;
                }
            }
            if (isDistanceOK) {
                answer[i] = 1;
            }
        }

        return answer;
    }
}