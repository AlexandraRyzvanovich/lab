package com.epam.esm.dao.connection;

import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final int POOL_SIZE = 5;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE);
    private Queue<Connection> availableConnections;
    private Queue<Connection> connectionsInUse;

    private static AtomicReference<ConnectionPool> instance;
    private static ReentrantLock connectionsLock = new ReentrantLock();

    private ConnectionPool() {
        availableConnections = new ArrayDeque<>() ;
        connectionsInUse = new ArrayDeque<>();
        create();
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            connectionsLock.lock();
            try {
                if (instance == null) {
                    instance = new AtomicReference<>(new ConnectionPool());
                }
            } finally {
                connectionsLock.unlock();
            }
        }
        return instance.get();
    }

    public void returnConnection(Connection proxyConnection) {
        connectionsLock.lock();
        try {
            if (connectionsInUse.contains(proxyConnection)) {
                availableConnections.offer(proxyConnection);
            }
        } finally {
            connectionsLock.unlock();
        }
    }

    public Connection getConnection() {
        try {
            semaphore.acquire();
            connectionsLock.lock();
            Connection connection = availableConnections.poll();
            connectionsInUse.add(connection);
            return connection;
        } catch (InterruptedException e) {
            throw new ClassCastException("Get connection failed");
        } finally {
            semaphore.release();
            connectionsLock.unlock();
        }
    }

    private void create() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        for(int i = 0; i < POOL_SIZE; i ++ ) {
            Connection connection = connectionFactory.create(this);
            availableConnections.add(connection);
        }
    }
}

