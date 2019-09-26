package hr01.core.employee;
import io.swagger.annotations.ApiModel;import io.swagger.annotations.ApiModelProperty;import org.springframework.stereotype.Component;import javax.persistence.*;@Entity
@Component
@ApiModel(value="",description="")
public class Employee {
@Column()
@ApiModelProperty(value = "")
private String name;

@Column()
@ApiModelProperty(value = "")
private int age;

@Column()
@ApiModelProperty(value = "")
private float salary;

@Column()
@ApiModelProperty(value = "")
protected String department;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@ApiModelProperty(value = "")
private Long id;


public void setName(String name){
this.name=name ;
 }
public String getName(){
return this.name ;
 }
public void setAge(int age){
this.age=age ;
 }
public int getAge(){
return this.age ;
 }
public void setSalary(float salary){
this.salary=salary ;
 }
public float getSalary(){
return this.salary ;
 }
public void setDepartment(String department){
this.department=department ;
 }
public String getDepartment(){
return this.department ;
 }
public void setId(Long id){
this.id=id ;
 }
public Long getId(){
return this.id ;
 }
}