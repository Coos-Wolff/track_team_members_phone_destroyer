package com.wolffsoft.phonedestroyer.model.configuration;

import org.flywaydb.core.Flyway;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jooq.*;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.junit.Before;

import javax.sql.DataSource;
import java.io.InputStreamReader;

import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class AbstractTestRepository<RepositoryType> {

    protected RepositoryType repository;
    private DataSource dataSource;
    private Settings settings;
    private Jdbi jdbi;

    protected abstract RepositoryType createRepository(DSLContext dslContext);

    @Before
    public void setupFlyway() throws Exception {
        dataSource = createDatasource();
        settings = createSettings();
        DSLContext dslContext = createDslContext();
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("/db/data")
                .load();
        flyway.migrate();

        jdbi = Jdbi.create(dataSource);
        runDbScript("/db/table/create_tables.sql");
        runDbScript("/db/data/event_data.sql");
        runDbScript("/db/data/team_member_data.sql");
        runDbScript("/db/data/event_team_member_data.sql");

        repository = createRepository(dslContext);
    }

    private DSLContext createDslContext() {
        return DSL.using(new DefaultConfiguration()
                .set(dataSource)
                .set(settings)
                .set(testRecordMapperProvider)
                .set(SQLDialect.MYSQL));
    }

    private Settings createSettings() {
        Settings settings = new Settings();
        settings.setRenderNameStyle(RenderNameStyle.LOWER);
        settings.setRenderSchema(true);
        return settings;
    }

    private DataSource createDatasource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUser("SA");
        dataSource.setPassword("");
        dataSource.setURL("jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_DELAY=-1L;");
        return dataSource;
    }

    private void runDbScript(final String scriptPath) throws Exception {
        try (InputStreamReader reader = new InputStreamReader(AbstractTestRepository.class.getResourceAsStream(scriptPath),
                UTF_8); Handle h = jdbi.open()) {
            RunScript.execute(h.getConnection(), reader);
        }
    }

    private final RecordMapperProvider testRecordMapperProvider = AbstractTestRepository::testProvideRecordMapper;

    @SuppressWarnings("unchecked")
    private static <R extends Record, E> RecordMapper<R, E> testProvideRecordMapper(final RecordType<R> recordType,
                                                                                    final Class<? extends E> targetType) {

        throw new IllegalArgumentException("Mapper for type " + targetType.getName() + " is not found");
    }
}
