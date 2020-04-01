package main;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import control.CalculateImp;
import control.CompareAnswer;
import control.Create_title;
import control.ReadTxt;
import control.WriteTxt;
import view.Jtable;
import control.*;

public class major {
    public static void main(String[] args) throws IOException {
        CalculateImp c = new CalculateImp();
        Create_title c2 = new  Create_title();
        WriteTxt wt = new WriteTxt();
        ReadTxt rt = new ReadTxt();
        CompareAnswer ca = new CompareAnswer();
        Vector title1 = new Vector();

        String title_path = "Exercises.txt";
        String result_path = "Answers.txt";
        double[] aw;

        HashSet set = new HashSet();

        ServerImp serverImp = new ServerImp();
        for(int i=0;i<10000;i++) {
            String title =  c2.create_title(10,3);
            System.out.println("我是title"+title);
            double relust = Double.parseDouble(c.calculate(title.toCharArray()));
            System.out.println("我是result"+relust);
            System.out.println("我是"+i);
            if(relust<0.0) {
               //出现负数去除
                if(i!=0)
                i--;

                System.out.println("出现负数");

                continue;
          }

           if(!serverImp.removeRepeat(title,set)){//去除重复的函数，并把结果存储在set中
              i--;
                }
        }
        System.out.println("+++++++++++++++++++"+set.size());
        Iterator iterator = set.iterator();
        int j = 0;
        while (iterator.hasNext()){
            String title3 = (String)iterator.next();
            title1.add(title3);
            System.out.println("第" + String.valueOf(j+1) + "道题目:" + title3 + " =");
            wt.WriteTxt("第" + String.valueOf(j+1) + "道题目：" + title3 + " =", title_path);
            wt.WriteTxt("第" + String.valueOf(j+1) + "道题的答案：" + c.calculate(title3.toCharArray()),result_path);
            j++;
            System.out.println("我是j"+j);
        }



        String[] title3 = new String[title1.size()];
        for(int i = 0;i<title1.size();i++){
            title3[i] = (String)title1.get(i);
        }
        double[] rs = rt.readTxt("Answers.txt");   //答案文件

        Jtable jTable_01 = new Jtable(title3,rs);
        jTable_01.setVisible(true);


    }
}
