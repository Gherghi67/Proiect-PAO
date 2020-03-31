package credit;

public class CreditService {

    private static final String TAG = "CreditService";

    private static CreditService singleInstance = null;

    private CreditService() {

    }

    public static CreditService getInstance() {
        if(singleInstance == null) {
            singleInstance = new CreditService();
        }
        return singleInstance;
    }
}
