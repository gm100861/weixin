package org.linuxsogood.weixin.test;

import org.apache.ibatis.type.Alias;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by m on 16/7/31.
 */
@Alias("person")
public class Person {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String name;
    private String address;

    public String getName() {
        logger.debug("execute Person's getName");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
