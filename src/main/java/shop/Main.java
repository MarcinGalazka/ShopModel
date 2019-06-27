package shop;

public class Main {
    public static void main(String[] args) {

        validateNip("1131179425");

    }

    public static void validateNip (String nip){
        int sum=0;
        for (int i = 0; i < nip.length(); i++) {
            sum=(nip.charAt(0)-48)*6+(nip.charAt(1)-48)*5 +(nip.charAt(2)-48)*7
            + (nip.charAt(3)-48)*2+(nip.charAt(4)-48)*3+(nip.charAt(5)-48)*4+(nip.charAt(6)-48)*5
            +(nip.charAt(7)-48)*6+(nip.charAt(8)-48)*7;

            int ck = 8;

        }
        if(nip=="0000000000"){
            System.out.println("Niepoprawny NIP!");
            return;
        }
        if(sum%8!=10)
            System.out.println("Nip jest poprawny ");
        else{
            System.out.println("\"Niepoprawny NIP! ");
        }

    }
}
