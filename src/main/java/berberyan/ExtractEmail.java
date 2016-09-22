package berberyan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractEmail 
{
    public static List<String> getDomains(String emails){
    		if(emails.isEmpty()){
    			return new ArrayList<String>();
    		}
    		
    		return Arrays
    				.stream(emails.trim().split(", "))
    				.filter(ValidateEmail::isValid)
    				.map(n->n.substring(n.indexOf("@"), n.length()))
    				.distinct()
    				.sorted()
    				.collect(Collectors.toList());
    }
}
