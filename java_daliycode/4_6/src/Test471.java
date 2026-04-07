//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;
//
//public class Test471 {
//    public static List<Character> func(String str1, String str2){
//        List<Character> list = new ArrayList<>();
//        for(int i = 0; i < str1.length(); i++){
//            Character ch = str1.charAt(i);
//            if(!str2.contains(ch + "")){
//                list.add(ch);
//            }
//        }
//        return list;
//    }
//    public static void main(String[] args){
//        String str1 = "yanxvbo shi da sha ber";
//        String str2 = "que shi";
//        List<Character> list = func(str1, str2);
//        Iterator<Character> it1 = list.iterator();
//        ListIterator<Character> it2 = list.listIterator(list.size());
//        while(it1.hasNext()){
//            System.out.print(it1.next() + " ");
//        }
//        System.out.println();
//        while(it2.hasPrevious()){
//            System.out.print(it2.previous() + " ");
//        }
//        System.out.println();
//        System.out.println(list);
//    }
//}



