package usersmanage;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javier.usersmanage.domain.User;
import com.javier.usersmanage.persistence.Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/servlet-context-test.xml" })
public class Tests {

	@Resource
	private Dao dao;

	List<User> users;

	User user;

	private static final int USERSBD = 8;

	@Before
	public void setUp() {	
		user = new User();
		user.setId(8);
		user.setName("Albert");
		user.setLastname("Einstein");
		user.setEnable(true);
		user.setEmail("alb.ein@scientific.com");
	}

	@Test
	public void testBBDD() {
		users = dao.findAll();
		Assert.assertTrue("Comprobar que en la base de datos hay 8 usuarios",
				users.size() == USERSBD);
	}
	
	@Test
	public void testUserById() {

		int uid = 0;
		
		User userAux = dao.userById(uid);
		
		users = dao.findAll();
		
		Assert.assertTrue("Comprueba que coincide id.",
				users.get(uid).getId() == userAux.getId());
		Assert.assertTrue("Comprueba que coincide el nombre.",
				users.get(uid).getName() == userAux.getName());
		Assert.assertTrue("Comprueba que coincide el apellido.",
				users.get(uid).getLastname() == userAux.getLastname());
		Assert.assertTrue("Comprueba que coincide el estado.",
				users.get(uid).isEnable() == userAux.isEnable());
		Assert.assertTrue("Comprueba que coincide el email.",
				users.get(uid).getEmail() == userAux.getEmail());

	}

	@Test
	public void testInsert() {

		dao.insertUser(user);
		users = dao.findAll();
		Assert.assertTrue("Comprueba que hay un user mas",
				users.size() == USERSBD + 1);

		User userAux = users.get(USERSBD);

		Assert.assertTrue("Comprueba que coincide id.",
				user.getId() == userAux.getId());
		Assert.assertTrue("Comprueba que coincide el nombre.",
				user.getName() == userAux.getName());
		Assert.assertTrue("Comprueba que coincide el apellido.",
				user.getLastname() == userAux.getLastname());
		Assert.assertTrue("Comprueba que coincide el estado.",
				user.isEnable() == userAux.isEnable());
		Assert.assertTrue("Comprueba que coincide el email.",
				user.getEmail() == userAux.getEmail());

		dao.deleteUser(userAux);
	}
	
	@Test
	public void testUpdate() {

		int uid = 5;
		
		User user = dao.userById(uid);
		
		User userToUpdate = new User();
		
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setEnable(!user.isEnable());
		userToUpdate.setId(user.getId());
		userToUpdate.setLastname(user.getLastname());
		userToUpdate.setName(user.getName());
		
		dao.updateUser(userToUpdate);
		
		User userUpdated = dao.userById(uid);

		Assert.assertTrue("Comprueba que coincide id.",
				user.getId() == userUpdated.getId());
		Assert.assertTrue("Comprueba que coincide el nombre.",
				user.getName() == userUpdated.getName());
		Assert.assertTrue("Comprueba que coincide el apellido.",
				user.getLastname() == userUpdated.getLastname());
		Assert.assertTrue("Comprueba que no coincide el estado.",
				user.isEnable() != userUpdated.isEnable());
		Assert.assertTrue("Comprueba que coincide el email.",
				user.getEmail() == userUpdated.getEmail());
		
		dao.updateUser(user);

	}

	@Test
	public void testDelete() {

		dao.insertUser(user);

		users = dao.findAll();
		Assert.assertTrue("Comprueba que hay un user mas.",
				users.size() == USERSBD + 1);

		dao.deleteUser(user);

		users = dao.findAll();
		Assert.assertTrue("Comprueba que vuelve a haber los users iniciales.",
				users.size() == USERSBD);
	}
}
