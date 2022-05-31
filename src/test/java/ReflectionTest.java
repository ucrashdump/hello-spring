import java.util.HashMap;
import java.util.Map;

public class ReflectionTest {
    //Inflearn 고장으로 인해서 Reflection을 잠깐 참고.
    //Reflection 예제 Junit 같은 경우가 Reflection 사용하는 예제
    //Spring 에서는 Dependency Injection 등애 사용함.
    //@Before이나 @Test @Autowired 등등
    /**
     * Class <?>
     *     Class를 얻는 방법:
     *     1. Object.getClass();
     *
     *
     */
    private void test (){
        String stringObject = "some-string";
        Car car = new Car();
        Map<String, Integer> map = new HashMap<>();

        Class<String> stringClass = (Class<String>) stringObject.getClass();
        Class<Car> carClass = (Class<Car>) car.getClass();
        Class<?> mapClass = map.getClass(); // Map 인터페이스가 아닌 HashMap 클래스를 나타냄. 변수의 런타임 타입이기 때문.
        boolean condition = true;//원시타입은 클래스가 아니다. codition.getClass(); // compilation error


    }
    class Car {
        class Engine{ //static class Engine 인데 static 이 11언어에서는 inner class에서 지원이 안됨

        }
    }
    /**
     * 2.
     * Car.class; 를 통해서 얻을 수 있음
     * 이때는 원시 타입또한
     * Ckass booleanType = boolean.class; 를 통해서 얻을 수 있음.
     */
    /**
     * Class.forName(...) 동적으로 클래스를 얻음
     * 그러나 이 방식 또한 원시타입은 클래스를 얻을 수 없음. 런타임 오류
     * 심지어 전달할 클래스가 존재하지 않을 경우도 있다.
     * 가장 덜 안전한 방식인데 이 방식으로 해야하는 경우가 있다.
     * 인스턴스 생성 또는 만들려는 타입을 xml 같은 사용자 정의 파일을 통할 때
     * <bean id="vehicle" class="vehicles.Motorcycle">
     *     <property name="numberOfWheels" value="2"/>
     * </bean>
     */
    private void test3 () throws ClassNotFoundException {
        Class<?>  stringType = Class.forName("java.lang.String");
        Class<?> engineType = Class.forName("vehicles.Car$Engine");
    }
}
