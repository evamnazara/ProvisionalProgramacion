package junio;

public class cosas {
    public static void main(String[] args) {
        int a = 0;

        switch (a + 1) {
            case 0:
                a = 2;
            case 1:
                a = 3;
            case 2:
                a++;
                break;
            case 3:
                a--;
                break;
        }

        System.out.println(a);

    }

}
