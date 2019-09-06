import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 十万个数据里选出重复次数最多的十组
 *利用小根堆
 *
 */
public class MinData {

    public static void main(String[] args) {

        //把100000个随机数放进ArrayList类型的容器
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 1; i < 34; i++) {
            int val = random.nextInt(33);
            arraylist.add(val);
        }
		/*arraylist.add(1);
		arraylist.add(1);*/

        /*
         * 统计 借助HashMap
         */
        //创建一个hashmap对象，（我们需要记录数以及他的出现次数）
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        //迭代器迭代arraylist，记录每个值出现的次数
        Iterator<Integer> iterator = arraylist.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            //如果没找到Key，证明这个值没有出现，就给value（重复次数）赋值0
            if (!hashmap.containsKey(integer)) {
                hashmap.put(integer, 0);
            }
            //记录数据
            hashmap.put(integer, hashmap.get(integer) + 1);
        }


        //重写比较器，目的是为了比较的hashmap中的value
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();//o2-o1
            }
        };

        //创建一个优先级队列的对象。自定义构造函数，则比较器需要重写（根据需求写大小跟堆），堆大小设为7
        PriorityQueue<Map.Entry<Integer, Integer>> priorityqueue1 = new PriorityQueue<Map.Entry<Integer, Integer>>(10000, comparator);
        //迭代器迭代hashmap
        Iterator<Map.Entry<Integer, Integer>> iterator1 = hashmap.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator1.next();
            //得到遍历时每一次的value值
            int newValue = next.getValue();
            //如果优先级队列里的数据长度小于10，就往进添加
            if (priorityqueue1.size() < 7) {
                priorityqueue1.add(next);
                //如果数据超过10，比较队顶的元素和要进入的元素
            } else {
                //如果要进入的元素大于堆顶的元素，就移除队顶本来的元素，加入新的元素，实现根堆里的数是最大的10个数
                if (priorityqueue1.peek().getValue() < newValue) {//>
                    priorityqueue1.remove();
                    priorityqueue1.add(next);
                }
            }

        }
        /*
         * 迭代器遍历优先级队列，得出结果
         */
        Iterator<Map.Entry<Integer, Integer>> iterator2 = priorityqueue1.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator2.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            System.out.println("数字：" + key + "  重复次数：" + value + "  ");
        }
    }

}