package smoketest;

public class Ornek {

    public static void main(String args[]) {

////3.soru
        int number = 1346;
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        System.out.println(sum);
        ////2.soru
        int a = 0;  //birinci
        int b = 1;   //ikinci
        System.out.println(a + "\n" + b);
        for (int i = 0; i <= 10; i++) {   //0+1//1+1//2+1//3+2//5+3//8+5//13
            int c = a + b;   //ucuncu
            a = b;
            b = c;
            System.out.println(c + " +");
        }
        System.out.println(getword("aaabb"));


    }
    ///////////1.soru
    public static  String getword(String word) {

        String bos="";
        int count=0;
        for (int i = 0; i <word.length()-1 ; i++) {
            if(word.charAt(i)==word.charAt(i+1)){
                count++;
                continue;
            }else{
                bos=bos+word.charAt(i)+count;
            }
            count=0;

        }
        bos=bos+word.charAt(word.length()-1);
        return bos;

    }

    }
