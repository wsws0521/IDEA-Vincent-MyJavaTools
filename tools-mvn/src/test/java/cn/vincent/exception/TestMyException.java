package cn.vincent.exception;

public class TestMyException {
    public static void main(String[] args) {
        try{
            throw new MyException("name:{0},age:{1}", "vincent", 30);
        }catch (Exception e){
            e.printStackTrace();
        }

        throw new MyException("name:{0},age:{1}");
    }
}
