package com.manolovizzini.demo.microservice.service;

import com.manolovizzini.demo.microservice.common.CommonUtils;


/**
 * @author mviz - 13/10/2022
 * @version 1.0-SNAPSHOT
 * <p>
 */
public abstract class CommonServiceImpl extends CommonUtils implements CommonService {
    @Override
    public String getSystemLanguage() {
        return env.getProperty("system.languageTag");
    }

    @Override
    public String getSystemCounter() {
        return env.getProperty("system.counter");
    }
}
