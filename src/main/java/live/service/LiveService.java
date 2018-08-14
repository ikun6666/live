package live.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import live.dao.LiveRedisDao;
import live.model.LiveRedis;

@Service
public class LiveService {

	@Autowired
	LiveRedisDao liveRedisDao;
	
	public List<LiveRedis> getAll(){
		List<LiveRedis> users=liveRedisDao.getAll();
		return users;
	} 
	
	public void save(LiveRedis live){
		liveRedisDao.put(live.getKeyName(), live, -1);
	}
}
