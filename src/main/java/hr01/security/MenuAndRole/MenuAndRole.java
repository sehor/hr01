package hr01.security.MenuAndRole;
import io.swagger.annotations.ApiModel;import io.swagger.annotations.ApiModelProperty;import org.springframework.stereotype.Component;import javax.persistence.*;@Entity
@Table(name = "t_MenuAndRole")
@Component
@ApiModel(value="",description="")
public class MenuAndRole {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@ApiModelProperty(value = "")
private Integer id;

@Column()
@ApiModelProperty(value = "")
private Integer menuId;

@Column()
@ApiModelProperty(value = "")
private Integer roleId;


public void setId(Integer id){
this.id=id ;
 }
public Integer getId(){
return this.id ;
 }
public void setMenuId(Integer menuId){
this.menuId=menuId ;
 }
public Integer getMenuId(){
return this.menuId ;
 }
public void setRoleId(Integer roleId){
this.roleId=roleId ;
 }
public Integer getRoleId(){
return this.roleId ;
 }
}