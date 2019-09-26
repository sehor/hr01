package hr01.security.user;

import hr01.security.menu.Menu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "swagger测试")
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService service;

    @ApiOperation(value = "example", notes = "this is a example")
    @ApiResponse(message = "访问成功", code = 200)
    @ApiImplicitParam(value = "str", type = "path", required = false, name = "path variable")
    @GetMapping("/example/{str}")
    public String example(@PathVariable(value = "str") String str) {
        return "你好，" + str;
    }

    @PostMapping("/add")
    public User add(@RequestBody User user){

         return service.addUser(user);
    }

    @GetMapping("/get/{username}")
    public User getUser(@PathVariable(value = "username") String username){
      return service.getUser(username);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
     return service.updateUser(user);
    }


    @DeleteMapping("/delete/{id}")
   public String deleteUser(@PathVariable("id") Integer id){

      service.deleteUser(id);
      return "delete user by id :" +id;
    }


    @GetMapping("/getMenus/{userId}")
    public List<Menu> getMenusByUsrId(@PathVariable("userId") Integer userId){
        return service.getUsrMenusByUserId(userId);
    }



}