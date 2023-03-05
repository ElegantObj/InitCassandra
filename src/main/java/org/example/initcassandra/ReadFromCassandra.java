package org.example.initcassandra;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import org.example.initcassandra.cassandra.CassandraConnect;
import org.example.initcassandra.cassandra.CassandraConnector;
import org.example.initcassandra.cassandra.CassandraSession;

public class ReadFromCassandra {
    private final String keyspace;
    private final String table;
    //private final String firstKey;

    //private final CassandraConnect session;

    public ReadFromCassandra(//CassandraConnect session,
                             String keyspace, String table){
        //this.session = session;
        this.keyspace = keyspace;
        this.table = table;
        //this.firstKey = firstKey;
    }

    public String id(String firstKey){
        String query = String.format("SELECT * FROM %s.%s WHERE chat_id = '%s';", this.keyspace, this.table, firstKey);
        System.out.println("query = " + query);

        ResultSet result = CassandraSession.session.execute(query);
        String chatId = result.all().get(0).getString("endpoint");

        return chatId;
    }

}
