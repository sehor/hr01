package hr01.security.userAndRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Api(tags = "UserAndRole 接口测试")
@RestController
@RequestMapping("/UserAndRole")
public class UserAndRoleController {
@Autowired
UserAndRoleService service;

@ApiOperation(value = "example",notes = "this is a example")
@ApiResponse(message = "访问成功",code = 200)
@ApiImplicitParam(value= "str",type = "path",required = false,name = "path variable")
@GetMapping("/example/{str}")
public String example(@PathVariable(value = "str") String str) { 
 return "你好，"+ str;
 }
    @PostMapping("/add")
    public UserAndRole add(@RequestBody UserAndRole userAndRole){

         return service.addUserAndRole(userAndRole);
    }
    @GetMapping("/get/{id}")
    public UserAndRole getUserAndRole(@PathVariable(value = "id") Integer id){
      return service.getUserAndRole(id);
    }
   @PutMapping("/update")
    public UserAndRole update(@RequestBody UserAndRole userAndRole){
     return service.updateUserAndRole(userAndRole);
    }
    @DeleteMapping("/delete/{id}")
   public String delete(@PathVariable("id") Integer id){

      service.deleteUserAndRole(id);
      return "delete userAndRole by id :" +id;
    }
}