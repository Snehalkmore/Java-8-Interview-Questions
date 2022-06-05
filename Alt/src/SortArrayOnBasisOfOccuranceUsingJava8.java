import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//Arrange based on No of occurrence If 2 or more element has same number of occurance then it has to sorted ascending
//i/p: 5,2,8,8,5,5,8,1,9,0,1,1,0,1 
//o/p: 2 9 0 0 5 5 5 8 8 8 1 1 1 1
public class SortArrayOnBasisOfOccuranceUsingJava8 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(5,2,8,8,5,5,8,1,9,0,1,1,0,1 ));
		
		Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		//map.entrySet().forEach(e->{ System.out.println(e.getKey() +" "+e.getValue());});
		 
		Iterator<Entry<Integer, Long>> it= map.entrySet().iterator();
		
		List<Long> valueList=new ArrayList<Long>();
		for(Integer i : map.keySet()) {
			valueList.add(map.get(i));	 
		}
		Set<Entry<Integer,Long>> set=map.entrySet();
        List<Entry<Integer, Long>> list2 = new ArrayList<Entry<Integer, Long>>(set);
        Collections.sort( list2, new Comparator<Map.Entry<Integer, Long>>()
        {
            public int compare( Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        });
        Collections.reverse(list2);
        for(Map.Entry<Integer, Long> entry:list2){
        	 Long val = entry.getValue();
             while(val!=0){
             System.out.println(entry.getKey());
             val--;          
             }
        }
		
		
		
	}

}
