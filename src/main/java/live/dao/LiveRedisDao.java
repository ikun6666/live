package live.dao;

import org.springframework.web.bind.annotation.RestController;

import live.model.LiveRedis;

@RestController
public class LiveRedisDao extends IRedisDao<LiveRedis>{

	private static final String REDIS_KEY="live.model.LiveRedis";

	@SuppressWarnings("static-access")
	@Override
	protected String getRedisKey() {
		return this.REDIS_KEY;
	}
	
}
