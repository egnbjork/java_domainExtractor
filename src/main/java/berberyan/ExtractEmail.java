package berberyan;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    				.collect(toList());
    }
}
