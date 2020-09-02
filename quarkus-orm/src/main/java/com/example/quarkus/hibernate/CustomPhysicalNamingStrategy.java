package com.example.quarkus.hibernate;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * 表名/列名映射策略（驼峰转下划线）
 * @author KyleWang
 * @date 2020/09/02
 */
public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalCatalogName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalColumnName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalSchemaName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalSequenceName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalTableName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertToSnakeCase(identifier);
    }

    /**
     * 将驼峰转为下划线分割
     */
    private Identifier convertToSnakeCase(final Identifier identifier) {
        if (identifier == null) {
            return identifier;
        }
        String name = identifier.getText();
        String snakeName = name.replaceAll("([a-z]+)([A-Z]+)", "$1\\_$2").toLowerCase();
        if (!snakeName.equals(name)) {
            return new Identifier(snakeName, identifier.isQuoted());
        } else {
            return identifier;
        }
    }
}
