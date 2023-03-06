package com.example.export;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Async
//@EnableAsync
@Component
@Getter
@Setter
@ConfigurationProperties("logging")
public class Log {

	//统一用这个logger记录日志，方便以后修改
	public final static Logger logger = LoggerFactory.getLogger(Log.class);


}
