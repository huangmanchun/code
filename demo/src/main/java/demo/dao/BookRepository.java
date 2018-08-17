package demo.dao;

import demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    //JpaRepository是一个泛型仓库接口，有两个参数，一个是仓库操作的领域对象类型，另一个是其ID属性的类型


    public List<Book> findAll();
}
