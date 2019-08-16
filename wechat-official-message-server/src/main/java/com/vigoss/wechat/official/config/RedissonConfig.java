package com.vigoss.wechat.official.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    private String sentinelAddress="redis://172.16.4.7:6380";

    private String masterName = "mymaster";

    private String password = "Doctorwork6379";

    private Integer database = 15;

    private Integer connectTimeout = 30000;

    private Integer masterConnectionPoolSize = 100;

    private Integer masterConnectionMinimumIdleSize =10;

    private Integer retryAttempts = 2;

    private Integer retryInterval = 1000;

    @Bean
    public RedissonClient redissonClient() throws InstantiationException, IllegalAccessException, ClassNotFoundException, LinkageError {
        Config config = new Config();
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.setSerializationInclusion(Include.NON_NULL);
        om.constructType(Object.class);
        JsonJacksonCodec jacksonCodec = new JsonJacksonCodec(om);

        config.setCodec(jacksonCodec);

        config.useSentinelServers()
                .setMasterName(masterName)
                .addSentinelAddress(sentinelAddress.split(","))
                .setPassword(password)
                .setDatabase(database)
                .setConnectTimeout(connectTimeout)
                .setMasterConnectionPoolSize(masterConnectionPoolSize)
                .setMasterConnectionMinimumIdleSize(masterConnectionMinimumIdleSize)
                .setRetryAttempts(retryAttempts)
                .setRetryInterval(retryInterval);

        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

    public String getSentinelAddress() {
        return sentinelAddress;
    }

    public String getMasterName() {
        return masterName;
    }

    public String getPassword() {
        return password;
    }

    public Integer getDatabase() {
        return database;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public Integer getMasterConnectionPoolSize() {
        return masterConnectionPoolSize;
    }

    public Integer getMasterConnectionMinimumIdleSize() {
        return masterConnectionMinimumIdleSize;
    }

    public Integer getRetryAttempts() {
        return retryAttempts;
    }

    public Integer getRetryInterval() {
        return retryInterval;
    }
}
