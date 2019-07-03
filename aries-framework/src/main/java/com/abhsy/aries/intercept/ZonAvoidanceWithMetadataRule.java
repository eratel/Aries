package com.abhsy.aries.intercept;

import com.abhsy.aries.config.FeignInterceptorConfig;
import com.abhsy.aries.constant.AriesConstant;
import com.google.common.base.Optional;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.cloud.netflix.ribbon.ServerIntrospector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZonAvoidanceWithMetadataRule extends ZoneAvoidanceRule {

    private ServerIntrospector serverIntrospector;

    public ServerIntrospector getServerIntrospector() {
        return serverIntrospector;
    }

    public void setServerIntrospector(ServerIntrospector serverIntrospector) {
        this.serverIntrospector = serverIntrospector;
    }

    @Override
    public Server choose(Object key) {
        ILoadBalancer lb = getLoadBalancer();
        List<Server> matchServers = new ArrayList<>();
        String requestHostName = FeignInterceptorConfig.CONTEXT.get();
        if (requestHostName.equals(AriesConstant.ALLSERVER)) {
            matchServers = lb.getAllServers();
        } else {
            List<Server> defaultServers = new ArrayList<>();
            for (Server server : lb.getAllServers()) {
                Map<String, String> map = serverIntrospector.getMetadata(server);
                String strategyVersion = map.get(AriesConstant.STRATEGYVERSION);
                if (strategyVersion != null && strategyVersion.equals(requestHostName)) {
                    matchServers.add(server);
                } else if (strategyVersion == null || strategyVersion.trim().isEmpty() || strategyVersion.equals(AriesConstant.DEFAULT)) {
                    defaultServers.add(server);
                }
            }
            if (matchServers.isEmpty()) {
                matchServers = defaultServers;
            }
        }
        Optional<Server> server = getPredicate().chooseRoundRobinAfterFiltering(matchServers, key);
        if (server.isPresent()) {
            return server.get();
        } else {
            return null;
        }
    }
}
