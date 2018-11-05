package ch;

import ch.metamodel.tables.daos.TestDao;
import ch.metamodel.tables.pojos.Test;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.jooq.impl.*;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.shaded.com.google.common.collect.Lists;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PostgreSQLContainer postgres = new PostgreSQLContainer();
        postgres.start();

        Flyway flyway = new Flyway();
        flyway.setDataSource(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());
        flyway.migrate();

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(postgres.getJdbcUrl());
        hikariConfig.setUsername(postgres.getUsername());
        hikariConfig.setPassword(postgres.getPassword());
        DataSource connectionPool = new HikariDataSource(hikariConfig);

        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.setExecuteListenerProvider(new DefaultExecuteListenerProvider(new SqlLogger()));
        configuration.setConnectionProvider(new DataSourceConnectionProvider(connectionPool));

        TestDao dao = new TestDao(configuration);

        Test test1 = new Test(1, LocalDateTime.now());
        Test test2 = new Test(2, LocalDateTime.now());

        List<Test> tests = Lists.newArrayList(test1, test2);

        dao.insert(tests);
    }
}
