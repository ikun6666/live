package live.dao;

import org.springframework.stereotype.Repository;

import live.model.UserRedis;

@Repository
public class UserRedisDao extends IRedisDao<UserRedis> {

	private static final String REDIS_KEY = "live.model.UserRedis";

	@SuppressWarnings("static-access")
	@Override
	protected String getRedisKey() {
		return REDIS_KEY;
	}

}
