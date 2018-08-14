package live.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import live.dao.UserRedisDao;
import live.model.UserRedis;

@Service
public class UserService {

	@Autowired
	UserRedisDao userRedisDao;
	
	public List<UserRedis> getAll(){
		List<UserRedis> users=userRedisDao.getAll();
		return users;
	}
	
	public void save(UserRedis user){
		userRedisDao.put(user.getName(), user, -1);
	}
	
	public boolean isUser(UserRedis user){
		boolean isUser=true;
		UserRedis userRedis=userRedisDao.get(user.getName());
		if(userRedis==null){
			isUser=false;
		}else{
			if(!userRedis.getPassword().equals(user.getPassword())){
				isUser=false;
			}
		}
		return isUser;
	}
	
}
