public class FirstE{
    public static int firstE(String str){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'e' || str.charAt(i) == 'E'){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(firstE("fire"));
        System.out.println(firstE("dog"));
    }

}