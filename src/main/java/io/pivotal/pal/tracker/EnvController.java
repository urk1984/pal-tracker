package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memory_limit;
    private String cf_instance_index;
    private String cf_instance_addr;

    public EnvController (@Value ("${PORT}") String port,@Value ("${MEMORY_LIMIT}") String memory_limit,
                          @Value ("${CF_INSTANCE_INDEX}") String cf_instance_index,@Value ("${CF_INSTANCE_ADDR}") String cf_instance_addr){

        this.port = port;
        this.memory_limit = memory_limit;
        this.cf_instance_index = cf_instance_index;
        this.cf_instance_addr = cf_instance_addr;

    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String,String> envMap=new HashMap();
        envMap.put("PORT",port);
        envMap.put("MEMORY_LIMIT",memory_limit);
        envMap.put("CF_INSTANCE_INDEX",cf_instance_index);
        envMap.put("CF_INSTANCE_ADDR",cf_instance_addr);
        return envMap;
    }
}
