package lv2;

import java.util.*;
import java.util.stream.*;



/**
 * 교점에 별 만들기
 */
public class Lessons87377 {
    public String[] solution(int[][] line) {
        ArrayList < ArrayList<Long> > pointsList = calcIntersection(line);
        //x,y최대 최솟값 계산해서 2차원 배열 생성
       long maxX = pointsList.stream().mapToLong(point -> point.get(0)).max().orElse(0);
       long minX = pointsList.stream().mapToLong(point -> point.get(0)).min().orElse(0);

       long maxY = pointsList.stream().mapToLong(point -> point.get(1)).max().orElse(0);
       long minY = pointsList.stream().mapToLong(point -> point.get(1)).min().orElse(0);

       char[][] arr = new char[(int)(maxY -minY + 1)][(int)(maxX - minX +1)];
       for (char[] row : arr) {
            Arrays.fill(row, '.');
       }

       pointsList.forEach(point->{
            int x = (int) (point.get(0) -minX);
            int y = (int) (maxY - point.get(1) );
            arr[y][x] = '*';
       });
            
        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }


   public ArrayList <ArrayList<Long> > calcIntersection (int[][] line) {
       int det = 0;
       ArrayList <ArrayList<Long> > pointsList = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
               det =  (line[i][0] * line[j][1]) - (line[i][1] * line[j][0]);
               if (det ==0) continue; // 평행인 경우 컨티뉴
               double x  = (double) (line[i][1] * line[j][2] -line[i][2] * line[j][1] )/ det; // 교점의 x좌표
               double y  = (double) (line[i][2] * line[j][0]  -line[i][0] * line[j][2])/ det; // 교점의 y좌표

               if ( x%1 == 0 && y%1 ==0 ) { //교점 둘다 정수 좌표일때만 저장 
                    ArrayList<Long> points = new ArrayList<>();
                    points.add((long)x);
                    points.add((long)y);
                    pointsList.add(points);
               }
               
            }
        }


    return pointsList;
   }
    
}
