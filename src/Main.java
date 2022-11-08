import java.io.IOException;
import java.util.Scanner;

public class Main {
    Roman roman;
    static String str;
    static  boolean isRoman = false;

    public static String calc(String input) throws Exception {

        String[] m = input.split(" ");
        if (m.length < 3){
            throw new Exception("sadsa");
        }
        isRoman = romanian(m[0], m[2]);

            if (isRoman == true){
                int a = Roman.valueOf(m[0]).getMeaning();
                int b = Roman.valueOf(m[2]).getMeaning();
                char c = m[1].charAt(0);
                int d = operation(a, b, c);
                str = arabicToRoman(d);

            } else if (Integer.parseInt(m[0]) <= 9 && Integer.parseInt(m[0]) >= 0 && Integer.parseInt(m[2]) <= 9 && Integer.parseInt(m[2]) >= 0 ) {
                int a = Integer.parseInt(m[0]);
                int b = Integer.parseInt(m[2]);
                char c = m[1].charAt(0);
                int d = operation(a, b, c);
                str = Integer.toString(d);

            }else {
                throw new Exception();
            }


        return str;

    }
    static int operation (int x, int y, char z) throws Exception {
        int result = 0;
        if(y == 0 && z == '/'){
            throw new IOException();
        }
        switch (z) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                result = x / y;
                break;
            default:
                throw new Exception();
        }return result;

    }

    static boolean romanian (String rom1, String rom2) throws Exception {
        for (Roman f: Roman.values()){
            for (Roman s: Roman.values()){
                if (f.name().equals(rom1) && s.name().equals(rom2)) {
                    isRoman = true;
                }// else if (f.name().equals(rom1) == true && s.name().equals(rom2) == false) {
                  //  throw new Exception();
               // } else if (f.name().equals(rom1) == false && s.name().equals(rom2) == true) {
               //     throw new Exception();
               // }
            }
        }
        return isRoman;
    }

    static String arabicToRoman(int in) throws Exception {
        String a = "";
        int i = 0;
        if(in/10 == 4){
            a = a + "XL";
        } else if (in/10 < 4 && in/10 > 0) {
            while(i != in/10){
                a = a + "X";
                i++;
            }
        } else if (in/10 == 5) {
            a = a + "L";
        } else if (in/10 > 5) {
            a = a + "L";
            i = 5;
            while (i != in/10){
                a = a + "X";
                i++;
            }
        }
        if (in%10 != 0){
            for(Roman f: Roman.values()){
                if(f.getMeaning() == in%10){
                    a = a + f.name();
                }
            }
        }
        if (a == ""){
            throw new Exception();
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("введите выражение");
        Scanner s = new Scanner(System.in);
        String st = s.nextLine();
        System.out.println(calc(st));

    }

    
}