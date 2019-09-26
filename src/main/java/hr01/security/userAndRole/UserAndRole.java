package hr01.security.userAndRole;
import io.swagger.annotations.ApiModel;import io.swagger.annotations.ApiModelProperty;import org.springframework.stereotype.Component;import javax.persistence.*;@Entity
@Table(name = "t_UserAndRole")
@Component
@ApiModel(value="",description="")
public class UserAndRole {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@ApiModelProperty(value = "")
private Integer id;

@Column()
@ApiModelProperty(value = "")
private Integer userId;

@Column()
@ApiModelProperty(value = "")
private Integer roleId;


public void setId(Integer id){
this.id=id ;
 }
public Integer getId(){
return this.id ;
 }
public void setUserId(Integer userId){
this.userId=userId ;
 }
public Integer getUserId(){
return this.userId ;
 }
public void setRoleId(Integer roleId){
this.roleId=roleId ;
 }
public Integer getRoleId(){
return this.roleId ;
 }
}