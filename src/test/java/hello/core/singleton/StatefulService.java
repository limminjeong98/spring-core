package hello.core.singleton;

public class StatefulService {

    // Ctrl Shift T해서 테스트 클래스 생성

    /**
     * 싱글톤 사용하면 오류
    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기서 문제
    }

     */
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price;
    }

    /**
     * 싱글톤 사용하면 오류
    public int getPrice() {
        return price;
    }
     */

}
