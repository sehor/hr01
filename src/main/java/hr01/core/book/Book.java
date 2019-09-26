package hr01.core.book;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_name")
    private String name;

    private String author;

    private float price;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString(){
        return  "Id: "+getId()+"\r\n"
                +"name: "+getName()+"\r\n"
                +"author: "+getAuthor()+"\r\n"
                +"price: "+getPrice()+"\r\n"
                +"description: "+getDescription()+"\r\n";
    }

    public void print(){
        System.out.println(toString());
    }


}
