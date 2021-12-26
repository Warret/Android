public class Array {
    public static void main(String[] args) {
       int[] OneArray = new int[10];
        for (int i = 0; i<OneArray.length;i++){
            OneArray[i]=i;
        }
        int[] TwoArray= new int[OneArray.length];


        for (int i = 0, j = OneArray.length - 1; i<OneArray.length;i++, j--){
            TwoArray[j] = OneArray[i];
        }

        for (int i : TwoArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        String mouth [] ={"Сентябрь",
                "Октябрь",
                "Ноябрь",
                "Декабрь",
                "Январь",
                "Февраль",
                "Март",
                "Апрель",
                "Май ",
                "Июнь",
                "Июль",
                "Август"};

        String result = "";
        for (int i =0; i< mouth.length; i++){
            result += mouth[i];
            if (i == mouth.length - 1){
                result += ".";
            }else {
                result += ", ";
            }

        }
        System.out.println(result);

        String a = "AAA";
        String b = "AAA";
        if (a.equals(b)){ //equals - сравнивает строки
            System.out.println("Равны");
        }else System.out.println("Не равны");
    }
}
