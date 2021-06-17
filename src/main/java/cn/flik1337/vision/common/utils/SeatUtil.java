package cn.flik1337.vision.common.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;

@Component
public class SeatUtil {
    private static final String SEPT = ",";
    private static final String NULL_SYMBOL = "_";
    private static final String SEAT_SYMBOL = "a";

    private static final int STATUS_AVA = 0; // 可购买
    private static final int STATUS_LOCK = 1; // 被锁定
    private static final int STATUS_SOLD = 2; // 被买

    private static final int IS_SEAT = 1; // 如果是a，则表示是座位，设置为1
    private static final int NOT_SEAT = 0;

    public static int[][] calcSeatInfo(String seatPattern){
        String[] rows = seatPattern.split(SEPT);
        int rowLength = rows.length;

        int columnLength = rows[0].length();

        int[][] seats = new int[rowLength][columnLength];

        for (int row = 0 ; row < rowLength ; row++){
            for (int column = 0 ; column < columnLength ; column++){
                boolean isSeat = SEAT_SYMBOL.equals(rows[row].substring(column,column+1));
                seats[row][column] = isSeat ? IS_SEAT : NOT_SEAT;

            }

        }
        return seats;
    }

    public static int[][] calcEmptySeatInfo(String seatPattern){
        String[] rows = seatPattern.split(SEPT);
        int rowLength = rows.length;

        int columnLength = rows[0].length();

        int[][] seats = new int[rowLength][columnLength];

        for (int row = 0 ; row < rowLength ; row++){
            for (int column = 0 ; column < columnLength ; column++){
                seats[row][column] = 0;
            }
        }
        return seats;
    }

    /**
    * @Description: 给定选择的index 返回所在几排几号
    * @Param:
    * @Date: 2021/6/3 12:34:21
    */

    public static HashMap<String,Integer> calcXY(int row,int column,int[][] seats){
         HashMap<String,Integer> seat = new HashMap<>();
        int columnCount = 1;
        int rowCount = 1;

        int rowLength  = seats[row].length;
        for (int index = rowLength-1; index > column; index--) {
            int element = seats[row][index];
            if(element == IS_SEAT){
                columnCount++;
            }
        }
        // 竖向查找
        for (int index = 0;index < row ;index++){

            int[] line = seats[index];
            boolean isEmptyLine = isEmptyLine(line);
            if (!isEmptyLine){
                rowCount ++;
            }


        }
        seat.put("row",rowCount);
        seat.put("column",columnCount);
        return seat;
    }
    public static boolean isEmptyLine(int[] line){
        for (int j : line) {
            if (j == IS_SEAT) {
                return false;
            }
        }
        return true;
    }
    public static HashMap<String,Integer> calcReverseXY(int row,int column,int[][] seats){
        // 只有一整行是_,此行才不算为row
        // 所以先遍历所有行，看有没有不算做row的
        HashMap<String,Integer> seat = new HashMap<>();
        int rowCount = 0;
        int rowIndex = -1;
        for (int i = 0 ; i < seats.length ; i++){
            int[] line = seats[i];
            for (int j = 0;j < line.length ; j++){
                if (line[j] == IS_SEAT){
                    rowCount ++;
                    break;
                }
            }
            if(rowCount ==  row){
                rowIndex = i;
                break;
            }
        }
        int[] line = seats[rowIndex];
        int rowLength = line.length;
        int columnIndex = -1;
        int columnCount = 0;

        for (int i = rowLength-1;i > 0 && columnIndex < column; --i ){
            if (line[i] == IS_SEAT){
                columnIndex ++;
            }
        }
        for (int i = rowLength-1; i >= 0; i--) {
            if(line[i] == 1){
                columnCount ++;
            }
            if(columnCount == column){
                columnIndex = i;
                break;
            }
        }

        seat.put("row",rowIndex);
        seat.put("column",columnIndex);

        return seat;
    }

    public static void main(String[] args) {

            int[][] seats = SeatUtil.calcSeatInfo("__aaa_aaaaa_,____________,aaaaaaaaaaaa,aaaaaa_aaaaa,__aaa_aaaaa_,aaaaaaaaaaaa,aaaaaa_aaaaa");

            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    System.out.print(seats[i][j]);
                }
                System.out.println();
            }
            HashMap<String,Integer> seat1= calcXY(2,5,seats);
            System.out.println(seat1);
            HashMap<String,Integer> seat2= calcReverseXY(2,7,seats);
            System.out.println(seat2);
        }


}
