/**
 * Created By xfj on 2018/10/27
 */

import java.util.*;
import java.util.stream.Collectors;

public class poj1050 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int arraySize;
        String str = sc.nextLine();
        arraySize = Integer.parseInt(str);
        List<String> collect = new ArrayList<String>();
        int[][] data = new int[arraySize][arraySize];
        while (sc.hasNextLine()) {
            str = sc.nextLine();
            if(str.trim().isEmpty()&&!sc.hasNextLine()){break;}
            String[] split = str.split(" ");
            collect.addAll(Arrays.stream(split).filter(s -> !s.equals("")).collect(Collectors.toList()));
            if(collect.size()==arraySize*arraySize){break;}
        }
        assert (collect.size() == arraySize * arraySize);
        for (int i = 0; i < collect.size(); i++) {
            int col = i / arraySize;
            int row = i % arraySize;
            data[col][row] = Integer.parseInt(collect.get(i));
        }
        System.out.println(Calculate.solve(data,arraySize));
    }
}
