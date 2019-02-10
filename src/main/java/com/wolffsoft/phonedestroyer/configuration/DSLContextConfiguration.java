package com.wolffsoft.phonedestroyer.configuration;

import org.jooq.*;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DSLContextConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(@Qualifier("dataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    private final RecordMapperProvider recordMapperProvider = DSLContextConfiguration::provideRecordMapper;

    @Primary
    @Bean
    public DSLContext dslContext(@Qualifier("dataSource") DataSource dataSource) {
        Settings settings = new Settings();
        settings.setRenderNameStyle(RenderNameStyle.LOWER);
        settings.setRenderSchema(true);
        return DSL.using(new DefaultConfiguration()
                .set(dataSource)
                .set(recordMapperProvider)
                .set(settings)
                .set(SQLDialect.MYSQL)
        );
    }

    @SuppressWarnings("unchecked")
    private static <R extends Record, E> RecordMapper<R, E> provideRecordMapper(
            final RecordType<R> recordType,
            final Class<? extends E> targetType) {

        throw new IllegalArgumentException("Mapper for type " + targetType.getName() + " is not found");
    }
}
