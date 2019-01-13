package com.litbo.hospital.beneficial.dao.provider;

public class AccountProvider {
    public String listCbAccount(){

        String sql = "SELECT\n" +
                "dbo.b_account.km_name,\n" +
                "dbo.b_account.km_num\n" +
                "\n" +
                "FROM\n" +
                "dbo.b_account\n" +
                "WHERE\n" +
                "(dbo.b_account.km_type = 1 OR\n" +
                "dbo.b_account.km_type = 2) and\n" +
                "(dbo.b_account.km_cjdm = 3 OR \n" +
                "dbo.b_account.km_cjdm = 4 OR \n" +
                " dbo.b_account.km_cjdm = 5)\n";
        return sql;
    }

    public String listSrAccount(){

        String sql = "SELECT\n" +
                "dbo.b_account.km_name,\n" +
                "dbo.b_account.km_num\n" +
                "\n" +
                "FROM\n" +
                "dbo.b_account\n" +
                "WHERE\n" +
                "dbo.b_account.km_type = 3 and\n"+
                "(dbo.b_account.km_cjdm = 4 OR \n" +
                " dbo.b_account.km_cjdm = 5)\n";
        return sql;
    }
}
