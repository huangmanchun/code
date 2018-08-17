package demo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.dao.BookRepository;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service
public class BookService {

    @Resource
    private BookMapper bookMapper;

    @Autowired
    private BookRepository bookRepository;


    //查询所有记录
    public List<Book> getList(){
        List<Book> list=this.bookMapper.getList();
        return list;
    }
    //查询一条记录
    public Book getBookOne(Integer id){
        return this.bookMapper.getBookOne(id);
    }
    //添加一条记录
    public void addBook(Book book){
        this.bookMapper.addBook(book);
    }
    //修改一条记录
    public void updateBook(Book book){
        this.bookMapper.updateBook(book);
    }
    //删除一条记录
    public void deleteBookById(Integer id){
        this.bookMapper.deleteBookById(id);
    }

    /*public List<Book> selectList(Wrapper<Book> entity){
        return bookDao.selectList(entity);
    }
*/
    /*public List<Book> selectListUser(){
        List<Book> userList = bookMapper.selectList(new EntityWrapper<Book>().where("name","zhangsan"));
        return userList;
        //return userMapper.selectList(entity);
    }*/

   /* // 初始化 影响行数
    int result = 0;
    // 初始化 Book 对象
    Book book = new Book();
    // 插入 Book (插入成功会自动回写主键到实体类)
    public Integer addBook1(Book book){
        book.setName("Tom");
        book.setPrice(60.7);
        result = bookMapper.insert(book);
        return result;
    }
    //更新Book
    public


// 更新 User
user.setAge(18);
    result = userMapper.updateById(user);

    // 查询 User
    User exampleUser = userMapper.selectById(user.getId());

    // 查询姓名为‘张三’的所有用户记录
    List<User> userList = userMapper.selectList(
            new EntityWrapper<User>().eq("name", "张三")
    );

// 删除 User
    result = userMapper.deleteById(user.getId());*/
}
