package com.archit.demo;

import java.sql.Connection;
import java.util.List;

/*
* 1. If conn available then return
* 2. If cur == max, then wait();
* 3. if curActive cons < max
*   create conm
*   add to pool
*   return
* 4. When connection is freed, put it back in the pool
* 5.  if (#active > min) then kill conn
* */
public class ConnectionPooling {

  int maxConnections;
  int minConnections;
  int activeConnections;
  List<Connection> connections;

//  public ConnectionPooling() {
//    this.maxConnections = 10;
//    this.connections = new ArrayList<>(this.maxConnections);
//    for (int i = 0; i < minConnections; i++) {
//      this.connections.add(new Connection(i));
//    }
//  }


  public static void main(String[] args) {
//    try(Connection con = getConnection()) {
//
//    }
  }

//  private synchronized static Connection getConnection() {
//    //check if actvie < max then return
//    //else
//    if (this.connections.size() < maxThreshold) {
//      Connection connection = new Connection();
//      this.connections.add(connection);
//      return connection;
//    } else {
//      int n = this.connections.size();
//      for (int i = 0; i < n; i++) {
//        if (this.connections.get(i).state != TAKEN) {
//          updateState(i);
//          return this.connections.get(i);
//        }
//      }
//      wait();
//      return getConnection();
//  }
//
//
//  static class Connection implements java.sql.Connection {
//    //override close() so that the connection does not die and goes back to the pool
//    }
//  }
}
