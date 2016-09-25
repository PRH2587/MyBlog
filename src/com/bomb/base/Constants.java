package com.bomb.base;

public class Constants {

    public class Gender
    {
        /**
         * �?
         */
        public static final short GENDER_MALE = 1;
        
        /**
         * �?
         */
        public static final short GENDER_FEMALE = 2;
    }
    
    public class AccountType{
        /**
         * 客户账号
         */
        public static final int ACCOUNT_TYPE_CUSTOMER = 100;
        
        /**
         * 管理员账�?
         */
        public static final int ACCOUNT_TYPE_ADMIN = 200;
        
    }
    
    /**
     * 当前用户
     */
    public static final String CURRENT_USER = "LOGIN_USER";
    
    /**
     * 中断异常提示
     */
    public final static String INTERRUPT_EXCEPTION_ERRO_MSG = "Internal Server Error!";
    
}
