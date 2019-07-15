package test;


import com.ssm.domain.UserInfo;
import com.ssm.service.IProductService;
import com.ssm.service.IUserService;
import com.ssm.service.impl.UserServiceImpl;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @projectName: mrzhao_ssm
 * @className : AllTest
 * 类 的 描 述  ：测试类 ！
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AllTest {

  /*@Test
    public void testFind(){

      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      String s = encoder.encode("123");
      System.out.println(s);*/
  }

