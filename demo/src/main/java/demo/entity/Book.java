package demo.entity;

import org.springframework.stereotype.Component;
import sun.awt.image.IntegerComponentRaster;

import javax.persistence.*;

@Component
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue //用于标注主键生成策略(strategy= GenerationType.[AUTO、identity、SEQUENCE、TABLE])
    private Integer id;
    private String name;
    private Double price;

    public Book(){

    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    @Override
    public String toString() { return "Book{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + '}';
    }
}
