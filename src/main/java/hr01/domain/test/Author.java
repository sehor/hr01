package hr01.domain.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "me")
@ApiModel(value = "作者实体类（随便修改）",description = "作者的一些信息")
public class Author {
    @ApiModelProperty("作者名字")
    private String name;

    @ApiModelProperty(value = "作者的国家")
    private String country;

    @ApiModelProperty(value = "作者的地址")
    private String address;

    @ApiModelProperty(value = "一些爱好")
    private List<String> favorites =new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString(){
        String separator=System.getProperty("line.separator");
        StringBuilder builder=new StringBuilder();
        builder.append("name:"+this.name+"\n");
        builder.append("country:"+this.country+"\n");
        builder.append("address:"+this.address+"\n");
        builder.append("favorites: "+ Arrays.toString(this.favorites.toArray()));
        System.out.println("separator:"+separator);
        return builder.toString();
    }
}
