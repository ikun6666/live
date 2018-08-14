package live;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import live.dao.RedisConfig;
import live.dao.UserRedisDao;
import live.model.UserRedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RedisConfig.class,UserRedisDao.class})
public class UserRedisTest {

	@Autowired
	UserRedisDao userRedisDao;
	
/*	@Test
	public void testPut(){
		UserRedis user=new UserRedis();
		user.setName("肖半仙");
		user.setPassword("123465");
		userRedisDao.put(user.getName(), user, -1);
	}*/
	
	@Test
	public void testFindAll(){
		UserRedis user=new UserRedis();
		List<UserRedis> users=userRedisDao.getAll();
		System.out.println(users.get(0).getName()+" 密码："+users.get(0).getPassword());
	}
}
