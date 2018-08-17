package demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @ApiOperation("查询全部记录")
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public List<Book> getList(){
        List<Book> list=this.bookService.getList();
        return list;
    }

    /*@ApiOperation("查询所有")
    @RequestMapping(value = "/selectList",method = RequestMethod.GET)
    public  List<Book> selectList(){
        List<Book> list = bookService.selectList();
        return list;
    }*/
  /*  @ApiOperation("查询所有")
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public List<Book> selectAll() {
        return bookServiceImp.selectAll();
    }
*/
    @ApiOperation("查询一条记录")
    @RequestMapping(value = "/getBookOne/{id}",method = RequestMethod.GET)
        public Book getBookOne(@ApiParam("ID") @PathVariable Integer id){
        Book book=this.bookService.getBookOne(id);
        return book;
    }

    @ApiOperation("添加一条记录")
    @RequestMapping(value = "/addBook",method = RequestMethod.POST)
    public String addBook(@ModelAttribute Book book){
        Book b = new Book();
        b.setId(book.getId());
        b.setName(book.getName());
        b.setPrice(book.getPrice());
        this.bookService.addBook(b);
        return "success";
    }

    @ApiOperation("根据ID修改一条记录")
    @RequestMapping(value = "/updateBook/{id}",method = RequestMethod.PUT)
    public String updateBook(@ApiParam("被修改的ID") @PathVariable Integer id, @RequestBody Book book){
        Book b=new Book();
        b.setId(id);
        b.setName(book.getName());
        b.setPrice(book.getPrice());
        this.bookService.updateBook(b);
        return "success";
    }

    @ApiOperation("根据ID删除一条记录")
    @RequestMapping(value = "/deleteBook/{id}",method = RequestMethod.DELETE)
    public String deleteBook(@ApiParam("被删除的ID") @PathVariable Integer id){
        this.bookService.deleteBookById(id);
        return "success";
    }

 /*   @ApiOperation("查询")
    @GetMapping("/get")
    public List<Book> getList1(){

        *//*EntityWrapper<Book> entityWrapper = new EntityWrapper<>();
        entityWrapper.where("id={}",id);*//*
        List<Book> list = bookService.selectListUser();
        return  list;
    }*/




}
