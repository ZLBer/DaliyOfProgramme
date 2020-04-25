package leetcode.leetcode1_499;

import java.util.*;

public class leet460 {

    //mine  priority+map
 /*   class LFUCache {
        int size=0;
        int capacity;
        Map<Integer,Entry> map=new HashMap<>();
        PriorityQueue<Entry> priorityQueue=new PriorityQueue<>((a,b)->a.freq!=b.freq?a.freq-b.freq:a.time-b.time);
        int time=0;
        public LFUCache(int capacity) {
          this.capacity=capacity;
        }

        public int get(int key) {
          time++;
          Entry entry=map.get(key);
          if(entry==null) return -1;
          else {
              priorityQueue.remove(entry);
              entry.time=time;
              entry.freq++;
              priorityQueue.add(entry);
              return entry.val;
          }
        }

        public void put(int key, int value) {
         time++;
         Entry entry=map.get(key);
         if(entry!=null){ //之前存在这个key
             priorityQueue.remove(entry);
             entry.val=value;
             entry.time=time;
             entry.freq++;
             priorityQueue.add(entry);
         }else {
             Entry newEntry=new Entry(key,value,1,time);
             if(size<capacity){//不需要剔除
                 size++;
                 map.put(key,newEntry);
                 priorityQueue.add(newEntry);
             }else {//剔除最老的节点
                 Entry old=priorityQueue.poll();
                 if(old==null) return;
                 map.remove(old.key);
                 map.put(key,newEntry);
                 priorityQueue.add(newEntry);
             }
         }
        }

        class Entry{
            int key;
            int val;
            int freq;
            int time;
            public Entry(int key, int val, int freq,int time) {
                this.key = key;
                this.val = val;
                this.freq = freq;
                this.time = time;
            }
        }
    }*/



    class LFUCache {
        class Entry{
            int key;
            int val;
            int freq;
            public Entry(int key, int val, int freq) {
                this.key = key;
                this.val = val;
                this.freq = freq;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Entry entry = (Entry) o;
                return key == entry.key;
            }

            @Override
            public int hashCode() {
                return Objects.hash(key);
            }
        }
        int size=0;
        int capacity;
        int minFreq=Integer.MAX_VALUE;
        Map<Integer,Entry>map=new HashMap<>();
        Map<Integer, LinkedHashSet> freqQueue=new HashMap<>();
        public LFUCache(int capacity) {
       this.capacity=capacity;
        }

        public int get(int key) {
            Entry entry=map.get(key);
            if(entry==null){
                return -1;
            }else {
                addFreq(entry);
                return entry.val;
            }
        }
        void addFreq(Entry entry){
            LinkedHashSet linkedHashSet=freqQueue.get(entry.freq);
            linkedHashSet.remove(entry);
            if(linkedHashSet.size()==0&&minFreq==entry.freq){
                minFreq++;
            }
            entry.freq++;
            LinkedHashSet nextLinkedHashSet=freqQueue.get(entry.freq);
            if(nextLinkedHashSet==null){
                nextLinkedHashSet=new LinkedHashSet();
                freqQueue.put(entry.freq,nextLinkedHashSet);
            }
            nextLinkedHashSet.add(entry);
        }

        public void put(int key, int value) {
            if(capacity==0) return;
          Entry entry=map.get(key);
          if(entry!=null){
              entry.val=value;
              addFreq(entry);
          }else {
             Entry newEntry= new Entry(key,value,1);

              if(size<capacity){
                  size++;
                  //System.out.println("new"+newEntry.key);
              }else {
                  LinkedHashSet<Entry> linkedHashSet=freqQueue.get(minFreq);
                  Entry oldEntry= linkedHashSet.iterator().next();
                 map.remove(oldEntry.key);
                  linkedHashSet.remove(oldEntry);
                 // System.out.println("del"+oldEntry.key+" "+newEntry.key);

              }
              minFreq=1;

              addEntry(newEntry);
          }
        }

        void addEntry(Entry entry){
            map.put(entry.key,entry);

            LinkedHashSet<Entry> linkedHashSet=freqQueue.get(entry.freq);

            if(linkedHashSet==null){
                linkedHashSet=new LinkedHashSet<>();
                freqQueue.put(entry.freq,linkedHashSet);
            }
            linkedHashSet.add(entry);
        }
    }
}
