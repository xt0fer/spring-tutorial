package teach.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BusinessService {

    @Autowired
    @Qualifier("production")
    private DatabaseManager databaseManager;

    public void doSomeLogic() {
        databaseManager.doSomeQueries();
    }
}
