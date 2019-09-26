package hr01.controller.test;

import hr01.domain.test.Author;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "测试一下swagger")
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	Author author;

	@GetMapping("/hello")
	String hello(Model model) {
		Map<String,Object> map=model.asMap();
	    Map<String,String> authorInfo= (Map<String, String>) map.get("authorInfo");
		return "你好，"+authorInfo.get("name")+"!  "+authorInfo.toString();
	}

	@ApiOperation(value = "打个招呼",notes = "地址加上名字，say hello to app")
	@ApiResponse(message = "访问成功",code = 200)
	@ApiImplicitParam(value= "name",type = "path",required = false,name = "你的名字")
	@GetMapping("/hello/{name}")
	String sayHi(@PathVariable(value = "name") String name) {
		
		return "Hi,"+name+" ,你好吗！";
	}

	@ApiOperation(value = "修改作者",notes="修改作者信息")
	@PostMapping("/author")
	Author updateAuthor(@RequestBody Author author){
		return author;
	}


	@ApiOperation(value = "获取作者信息")
	@GetMapping("/getAuthor")
	Author getAuthor(){
		return this.author;
	}

}
