package com.yh.uuid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IdIndex {

    @RequestMapping(value = "getId", method = RequestMethod.GET)
    @ResponseBody
    public String getId() {
        String id = SnowflakeIdWorker.getId();
        return id;
    }
}
