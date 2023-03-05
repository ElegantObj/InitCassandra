package org.example.initcassandra.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;

public class CassandraSession {
    public static CqlSession session;

    public CassandraSession(CqlSession sessionCql){
        session = sessionCql;
    }
}
