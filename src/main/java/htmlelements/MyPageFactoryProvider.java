package htmlelements;

public class MyPageFactoryProvider {

    private static MyPageFactory INSTANCE;

    private MyPageFactoryProvider() {}

    public static MyPageFactory getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MyPageFactory();
        }
        return INSTANCE;
    }

}
