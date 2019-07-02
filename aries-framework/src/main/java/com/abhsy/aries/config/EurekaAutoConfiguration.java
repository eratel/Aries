package com.abhsy.aries.config;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 *
 * @author Haojun Ren
 * @version 1.0
 */

import com.abhsy.aries.constant.AriesConstant;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaAutoConfiguration {
    static {
        String logoShown = System.getProperty("aries.logo.shown", "true");
        if (Boolean.valueOf(logoShown)) {
            System.out.println("");
            System.out.println("  ,---.         ,--.");
            System.out.println(" /  O  \\ ,--.--.`--' ,---.  ,---. ");
            System.out.println(" |  .-.  ||  .--',--.| .-. :(  .-'");
            System.out.println(" |  .-.  ||  .--',--.| .-. :(  .-'");
            System.out.println(" |  | |  ||  |   |  |   --..-'  `) ");
            System.out.println(" `--' `--'`--'   `--' `----'`----'");
            System.out.println(AriesConstant.framworkName + " - " + "start plugin" + "  v" + AriesConstant.ARIES_VERSION);
            System.out.println("");
        }
    }
}