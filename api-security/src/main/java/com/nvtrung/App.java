package com.nvtrung;

import spark.Spark;
import con.nvtrung.datasource.GenericRepository;

public class App {
    public static void main( String[] args ) {
        String clspath = System.getenv("CLASS_PATH");
        String osname = System.getenv("OS");

        System.out.println('Classpath: ' + clspath);
        System.out.println('System: ' + osname);

        String caCertPsswd = System.getenv("CA_CERT_PSSWD");

        Spark.secure("localhost.p12", caCertPsswd, null, null);

        var repository = new GenericRepository();

        // var spaceController = new SpaceController().addRepo(repository);
        var userController = new UserController().addRepo(repository);
        // var auditController = new AuditController().addRepo(repository);
    }
}
