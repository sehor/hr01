package hr01.security.MenuAndRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Api(tags = "MenuAndRole 接口测试")
@RestController
@RequestMapping("/MenuAndRole")
public class MenuAndRoleController {
@Autowired
MenuAndRoleService service;

@ApiOperation(value = "example",notes = "this is a example")
@ApiResponse(message = "访问成功",code = 200)
@ApiImplicitParam(value= "str",type = "path",required = false,name = "path variable")
@GetMapping("/example/{str}")
public String example(@PathVariable(value = "str") String str) { 
 return "你好，"+ str;
 }
    @PostMapping("/add")
    public MenuAndRole add(@RequestBody MenuAndRole menuAndRole){

         return service.addMenuAndRole(menuAndRole);
    }
    @GetMapping("/get/{id}")
    public MenuAndRole getMenuAndRole(@PathVariable(value = "id") Integer id){
      return service.getMenuAndRole(id);
    }
   @PutMapping("/update")
    public MenuAndRole update(@RequestBody MenuAndRole menuAndRole){
     return service.updateMenuAndRole(menuAndRole);
    }
    @DeleteMapping("/delete/{id}")
   public String delete(@PathVariable("id") Integer id){

      service.deleteMenuAndRole(id);
      return "delete menuAndRole by id :" +id;
    }
}