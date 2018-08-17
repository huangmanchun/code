package demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import demo.entity.Book;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book>{

    //查询所有记录
    @Select("select * from book")
    public List<Book> getList();

    //查询单条记录
    @Select("select * from book where id = #{id}")
    public Book getBookOne(Integer id);

    //添加一条记录
    @Insert("insert into book(id,name,price) values ( #{id},#{name},#{price})")
    public void addBook(Book book);

    //修改一条记录
    @Update("update book set name = #{name}, price = #{price} where id=#{id}" )
    public void updateBook(Book book);

    //删除一条记录
    @Delete("delete from book where id = #{id}")
    public  void deleteBookById(Integer id);


    List<Book> selectAll();

}
