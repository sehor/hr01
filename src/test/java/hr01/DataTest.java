package hr01;

import hr01.core.book.Book;
import hr01.core.book.BookRepository;
import hr01.security.user.User;
import hr01.security.userAndRole.UserAndRole;
import hr01.security.userAndRole.UserAndRoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTest {

    @Autowired
    BookRepository repository;

    @Autowired
    UserAndRoleRepository urRepository;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test01(){
/*        Book book1=new Book();
        book1.setName("book-name-test01");
        book1.setAuthor("book-author-test01");
        book1.setPrice(56.50f);
        book1.setDescription("this a good book!");*/

       // repository.save(book1);

      // repository.findAll().stream().forEach(book -> System.out.println(book.toString()));

/*       System.out.print("作者模糊：");
       repository.findBooksByAuthorLike("罗").stream().forEach(book -> book.print());

        System.out.print("名字模糊：");
        repository.findBooksByNameLike("%游%").stream().forEach(book -> book.print());

        System.out.print("最大Id：");
       repository.getMaxBook().print();

       System.out.print("作者和id（>）：");
       repository.findBooksByIdAndAuthor("曹雪芹",1).stream().forEach(book -> book.print());*/

        //urRepository.findById(1).get();
       /* long start=Instant.now().toEpochMilli();

        int i=0;

        while(true){

            i++;
            urRepository.findAll();
            long end=Instant.now().toEpochMilli();
            if(end-start>1000) break;
        }

        System.out.println("1 秒 "+i+" 次");*/

        ValueOperations<String,String> strOps=stringRedisTemplate.opsForValue();
        strOps.set("testInSpring","valueOpes");
        System.out.println(strOps.get("testInSpring"));

        Book book=new Book();
        book.setName("射雕英雄传");
        book.setAuthor("金庸");
        book.setPrice(23.44f);
        book.setDescription("a famous and good book!");
        book.setId(10000);
        ValueOperations operations=redisTemplate.opsForValue();
        operations.set("book1",book);

        User user=new User();
        user.setEmail("user@email.com");
        user.setUsername("username01");
        user.setPassword("pw1234");

        operations.set("user01",user);

        System.out.println(operations.get("book1").toString());
        System.out.println(operations.get("user01").toString());

    }
}
