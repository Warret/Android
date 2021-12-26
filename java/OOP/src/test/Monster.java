package test;

public class Monster {
    int eyes;
    int legs;
    int hands;

    public Monster() {
        eyes = 2;
        legs = 2;
        hands = 2;
    }
    public Monster(int eyes) {
        this.eyes = eyes;
        legs = 2;
        hands = 2;
    }
    public Monster(int eyes, int legs) {
        this.eyes = eyes;
        this.legs = legs;
        hands = 2;
    }
    public Monster(int eyes, int legs, int hands) {
        this.eyes = eyes;
        this.legs = legs;
        this.hands = hands;
    }
    void voice (){
        System.out.println("Голос");
    }
    void voice (int a){
        for(int i =0; i<a;i++){
            System.out.println("Голос");
        }
    }
    void voice (int a, String b){
        for(int i =0; i<a;i++){
            System.out.println(b + " ");
        }
    }
}
