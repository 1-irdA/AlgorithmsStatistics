/*
 * LaunchUnitTest.java                                      25 nov. 2020
 * L3 MIASHS option MIAGE IUT of Rodez 2020-2021
 * No copyright, no right
 */
package fr._1irda.statistics.test_framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Launch automatics unit tests of unit Class
 * where name is passed in args
 * @author Adrien GARROUSTE
 */
public class LaunchUnitTest {
    
    /** Error code number args is incorrect */
    public static final int ERR_NUMBER_ARGS = 1;
    
    /** Code exit if class cannot be instanced */
    public static final int ERR_CLASS_CANNOT_BE_INSTANCIED = 2;
    
    /**  Code exit if no class */
    public static final int ERR_UNKNOWN_CLASS = 3;
    
    /** Prefix tests methods */
    public static final String PREFIX_TEST = "test";
    
    /**
     * Load unit tests class where path is passed in args
     * and launch test protocol
     * @param args test method name
     */
    public static void main(String[] args) {
        
        if (args.length != 1) {
            System.out.println("Use : LaunchUnitTest testClassName");
            System.exit(ERR_NUMBER_ARGS);
        }
        
        Class<?> toTest = null;

        try {
            toTest = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            System.err.println(args[0] + " class not found");
            System.exit(ERR_UNKNOWN_CLASS);
        }
        
        Constructor<?> constructorWithoutParam = null;
        
        try {
            constructorWithoutParam = toTest.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        
        if (constructorWithoutParam == null) {
            System.exit(ERR_CLASS_CANNOT_BE_INSTANCIED);
        }
        
        Method beforeEach = null;
        Method afterEach = null;
        
        try {
            beforeEach = toTest.getMethod("setup");
        } catch (NoSuchMethodException e) {
            beforeEach = null;
        } catch (SecurityException e) {
            beforeEach = null;
        }
        
        try {
            afterEach = toTest.getMethod("tearDown");
        } catch (NoSuchMethodException e) {
            afterEach = null;
        } catch (SecurityException e) {
            afterEach = null;
        }
        
        /* launching tests */
        for (Method toLaunch : toTest.getDeclaredMethods()) {
            if (toLaunch.getName().startsWith(PREFIX_TEST)) {
                try {
                    /* new test instance */
                    Object test = constructorWithoutParam.newInstance();
         
                    if (beforeEach != null) {
                        beforeEach.invoke(test);
                    }
                    
                    /* invoke test method */
                    try {
                        toLaunch.invoke(test);
                    } catch (InvocationTargetException e) {
                        System.err.println("Fail of " + toLaunch + " : " 
                                           + e.getTargetException().getMessage());
                    }
                    
                    if (afterEach != null) {
                        afterEach.invoke(test);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
