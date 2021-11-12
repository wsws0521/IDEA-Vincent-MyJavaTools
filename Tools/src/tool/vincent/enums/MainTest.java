package tool.vincent.enums;

public class MainTest {
    public static void main(String[] args) {
//        ShelvesStatus statusEnum = ShelvesStatus.valueOf("0");
        ShelvesStatus statusEnum = ShelvesStatus.getEnumByType(0);
        switch (statusEnum){
            case PutOn:
                System.out.println("xxx已上架");
                break;
            case NotPutOn:
                System.out.println("xxx未上架");
                break;
            default:
                System.out.println("default");
        }
    }
}
