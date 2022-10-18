package com.manolovizzini.demo.microservice.common;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
public abstract class CommonUtils extends CommonPaths {
    protected String removeBrackets(String value) {
        return value.replaceAll("\\[(.*?)\\]", "$1");
    }
}


