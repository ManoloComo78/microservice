package com.manolovizzini.demo.microservice.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
public abstract class CommonPaths {

    @Autowired
    protected Environment env;
}
