package gson;

import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class GsonTest {

	public static void fun(String hson) {
		Gson gson = new Gson() ;
		
	}
	
	public static void main(String[] args) {
		String json = "{\"resource\":[{\"rtdModule\":{\"moduleSerialNum\":1023100,\"rtdSerialNum\":10231,\"moduleNum\":0,\"netType\":\"TD-SCDMA\"},\"testCard\":{\"MSISDN\":\"13503098417\",\"cardType\":\"1\",\"IMSI\":\"809460003005417408\"},\"systemId\":1}],\"resultCode\":\"1\",\"resultMessage\":\"测试项27匹配资源成功!\"}" ;
		Gson gson = new Gson() ;
		MatchResource r = gson.fromJson(json, MatchResource.class) ;
		System.out.println(r.resource.get(0).getTestCard().MSISDN);
		/*System.out.println(p.hobbies.get(1).name);
		List<People> list = new ArrayList<People>() ;
		List<Hobby> hobbies = new ArrayList<Hobby>() ;
		hobbies.add(new Hobby("football")) ;
		list.add(new People("hzj" , "21" ,  hobbies)) ;
		JsonElement element = gson.toJsonTree(list) ;
		System.out.println(gson.toJson(list)) ;
		System.out.println(gson.toJson(element)) ;
		List<People> p2 = gson.fromJson(gson.toJson(list), new TypeToken<List<People>>() {  
        }.getType()); 
		System.out.println(p2.get(0).name);*/
	}
	
	
	
}
