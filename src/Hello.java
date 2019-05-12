import java.util.UUID;

public class Hello {
    public static void main(String a[]){
        System.out.println("Hello");
        UUID gfg = UUID.fromString("e52232e1-0ded-4587-999f-4dd135a4a94f");
        System.out.println("UUID is: " + gfg);
        for(int i=0 ; i <= 10; i++ ){
            System.out.println("I "+i);
        }
    }
}
