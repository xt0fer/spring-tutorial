package teach.annot;

import org.springframework.beans.factory.annotation.Required;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DatabaseManager {

    private String host;
    private Integer port;

    private String databaseName;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    @Required
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public void doSomeQueries() {
        System.out.println("Querying database '" + databaseName + "' and returning result");
    }

    @PostConstruct
    public void init() {
        // TODO: Open a connection to the database
        System.out.println("Opening a connection to the database '" + databaseName + "'");
    }

    @PreDestroy
    public void destroy() {
        // TODO: Close the connection
        System.out.println("Closing the connection to the database '" + databaseName + "'");
    }
}
