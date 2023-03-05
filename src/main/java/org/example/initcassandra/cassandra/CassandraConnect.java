package org.example.initcassandra.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;

public interface CassandraConnect {
    void init();
    CqlSession session();
}
