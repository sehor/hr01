package hr01.security.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Role 接口测试")
@RestController
@RequestMapping("/Role")
public class RoleController {
@Autowired
RoleService service;

@ApiOperation(value = "example",notes = "this is a example")
@ApiResponse(message = "访问成功",code = 200)
@ApiImplicitParam(value= "str",type = "path",required = false,name = "path variable")
@GetMapping("/example/{str}")
public String example(@PathVariable(value = "str") String str) { 
 return "你好，"+ str;
 }
    @PostMapping("/add")
    public Role add(@RequestBody Role role){

         return service.addRole(role);
    }
    @GetMapping("/get/{id}")
    public Role getRole(@PathVariable(value = "id") Integer id){
      return service.getRole(id);
    }
   @PutMapping("/update")
    public Role update(@RequestBody Role role){
     return service.updateRole(role);
    }
    @DeleteMapping("/delete/{id}")
   public String delete(@PathVariable("id") Integer id){

      service.deleteRole(id);
      return "delete role by id :" +id;
    }

    @GetMapping("/getByUserId/{userId}")
    public List<Role> getByUserId(@PathVariable("userId") Integer userId){
     return service.findRolesByUserId(userId);
    }
}