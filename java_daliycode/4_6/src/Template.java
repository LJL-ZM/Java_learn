//public class Template<T extends Comparable<T>> {
//    public T maxOf(T[] array){
//        if(array == null){
//            return null;
//        }
//        T max = array[0];
//        for(T cur : array){
//            if(cur.compareTo(max) > 0){
//                max = cur;
//            }
//        }
//        return max;
//    }
//    public static void main(String[] args){
//        Template<Integer> template = new Template<>();
//        Integer[] integers = {1, 0, 9, 10, 99};
//        Integer max = template.maxOf(integers);
//        System.out.println(max);
//    }
//}
public class Template{
    public static <T extends Comparable<T>> T maxOf(T[] array){
        if(array == null){
            return null;
        }
        T max = array[0];
        for(T cur : array){
            if(cur.compareTo(max) > 0){
                max = cur;
            }
        }
        return max;
    }
    public static void main(String[] args){
        //Templat template = new Template();
        Integer[] integers = {1, 0, 9, 10, 99};
        Integer max = Template.maxOf(integers);
        System.out.println(max);
    }
}