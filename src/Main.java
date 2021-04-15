class Human{
    int age;
    int height;
    float weight;
    String name;
    String gender;

    public Human(int age, int height, float weight, String name, String gender) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.name = name;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public boolean isMale(){
        if( gender.equals("Male")){
            return true;
        }
        return false;
    }
}

class Rectangle{
    int length;
    int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int area(){
        return length * width;
    }

    public int circuit(){
        return length * 2 + width * 2;
    }

    public double diagonal(){
        return Math.sqrt(length * length + width * width);
    }
}

class ArrayFactory{
    int x;

    public ArrayFactory(int x) {
        this.x = x;
    }

    public int[] oneDimension(){
        return new int[x];
    }

    public  int[][] twoDimension(){
        return new int[x][x];
    }

    public static int[] tableInt(int y){
        int size = 0;
        int tmp = y;
        while(y > 0){
            y /= 10;
            size++;
        }
        int[] table = new int[size];
        for(int i = 0; i < size; i++){
            table[i] = tmp % 10;
            tmp /= 10;
        }
        return table;
    }

    public static String reverseString(String string){
        String reverse = new String();
        for(int i = string.length() - 1; i >= 0; i--){
            reverse += string.toCharArray()[i];
        }
        return reverse;
    }

    public int[] toBinary(){
        int size = 32;

        for(int i = 32; i >= 0; i--){

            if(Math.pow(2,i) <= x){
                size = i;
                break;
            }
        }

        int[] binary = new int[size + 1];
        int tmp = x;

         for(int i = 0; i < size + 1; i++){
             if(Math.pow(2, size - i) <= tmp){
                 binary[i] = 1;
                 tmp -= Math.pow(2, size - i);
             }
             else{
                 binary[i] = 0;
             }
         }

        return binary;
    }

    public static boolean isPalindrome(String string){
        char[] table = new char[string.length()];
        table = string.toCharArray();
        for(int i = 0; i < string.length() / 2 + 1; i++){
            if(table[i] != table[string.length() - i - 1]){
                return false;
            }
        }
        return true;
    }

    public int[][] ones(){
        int[][] table = new int[x][x];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < x; j++){
                if(i == j){
                    table[i][j] = 1;
                }
                else{
                    table[i][j] = 0;
                }
            }
        }
        return table;
    }
}

public class Main {
    public static void main(String[] args){
        Human human = new Human(10,134,45,"Mateusz","Mlle");
        System.out.println(human.isMale());

        Rectangle rectangle = new Rectangle(3, 46);
        System.out.println(rectangle.diagonal());

        System.out.println(ArrayFactory.tableInt(123)[0]);
        System.out.println(ArrayFactory.tableInt(123)[1]);
        System.out.println(ArrayFactory.tableInt(123)[2]);

        System.out.println(ArrayFactory.reverseString("dog"));

        ArrayFactory arrayFactory = new ArrayFactory(8);
        /*
        int tablex[] = new int[8];
        tablex =  arrayFactory.toBinary();
        for(int i = 0; i < 8; i++){
            System.out.println(tablex[i]);
        }*/
        System.out.println(ArrayFactory.isPalindrome("kajaki"));

        int[][] tmp_table = new int[8][8];
        tmp_table = arrayFactory.ones();
        for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    System.out.print(tmp_table[i][j]);
                }
            System.out.println(" ");
        }

    }
}
