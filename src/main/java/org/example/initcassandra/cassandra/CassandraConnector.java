package org.example.initcassandra.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;

import java.net.InetSocketAddress;

public class CassandraConnector implements CassandraConnect {
    private final String node;
    private final Integer port;
    private final String dataCenter;

    private CqlSession session;

    public CassandraConnector(String node, Integer port, String dataCenter){
        this.node = node;
        this.port = port;
        this.dataCenter = dataCenter;
    }

    public void init(){
        CqlSessionBuilder builder = CqlSession.builder();
        builder.addContactPoint(new InetSocketAddress(node, port));
        builder.withLocalDatacenter(dataCenter);

        this.session = builder.build();
    }

    public CqlSession session(){
        return this.session;
    }

    public void close(){
        this.session.close();
    }
}
