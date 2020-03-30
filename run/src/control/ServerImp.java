package control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerImp {
    boolean flag = true;
    public boolean removeRepeat(String title, HashSet set) {
        if(title.length()>5){
            set.add(title);
        }
        if (title.charAt(0) == '(') {
            if (title.length() == 5) {//只有出现两个数字相加的时候才允许运行
                add(title, set, true);
                System.out.println("didid");
            }

        } else if (title.length() == 3) {
            add(title, set, false);
            System.out.println("lal");
        }


        return  flag;
    }

    public static void main(String[] args) {
        ServerImp serverImp = new ServerImp();
        HashSet set = new HashSet();
        boolean flag = serverImp.removeRepeat("1+2", set);
        flag = serverImp.removeRepeat("2+1", set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println(flag);
        }

    }

    void add(String title, HashSet set, boolean flag) {//用于两个数相加的情况
        String a = null;
        String b = null;
        String c = null;
        if (flag) {
            a = String.valueOf(title.charAt(1));
            c = String.valueOf(title.charAt(2));
            b = String.valueOf(title.charAt(3));
        } else {
            a = String.valueOf(title.charAt(0));
            c = String.valueOf(title.charAt(1));
            b = String.valueOf(title.charAt(2));
        }

        String temp = b + c + a;
        if (set.add(temp)) {
            set.remove(temp);
            set.add(a + c + b);
            this.flag = true;
        } else {
            this.flag = false;
            System.out.println("出现重复");
        }
    }
}
