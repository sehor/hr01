package hr01.core.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> ,BookDataHelper{

    List<Book> findBooksByNameLike(String nameLike);

    List<Book> findBooksByPriceGreaterThan(float price);

    @Query(value = "select * from t_book where id=(select max(id) from t_book)",nativeQuery = true)
    Book getMaxBook();

    @Query(value = "from Book as b where b.id>:id and b.author=:author")
    List<Book> findBooksByIdAndAuthor(@Param("author") String author,@Param("id") Integer id);

    @Query(value = "from Book as b  where b.author like %?1%")
    List<Book> findBooksByAuthorLike(String author);

}
