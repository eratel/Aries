package com.abhsy.aries.config;


import com.abhsy.aries.constant.AriesConstant;
import org.springframework.context.annotation.Import;

@Import({FeignInterceptorConfig.class})
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