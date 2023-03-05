package org.example.initcassandra;

import org.example.initcassandra.cassandra.CassandraConnect;
import org.example.initcassandra.cassandra.CassandraConnector;
import org.example.initcassandra.cassandra.CassandraSession;

public class Main {
    public static void main( String[] args ) throws Exception {
        CassandraConnect cassandraConnect = new CassandraConnector("localhost", 9042, "datacenter1");
        cassandraConnect.init();

        //Где хранить сессию и как ее правильно передавать в другие объекты ?

        new CassandraSession(cassandraConnect.session());

        ReadFromCassandra read = new ReadFromCassandra(//cassandraConnect,
                "chatconnectors", "genesys_interactions");
        String id = read.id("1q2w3e");
        System.out.println(id);
    }
}
