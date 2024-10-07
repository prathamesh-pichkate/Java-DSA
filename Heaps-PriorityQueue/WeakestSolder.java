import java.util.PriorityQueue;

public class WeakestSolder {
    static class Row implements Comparable<Row>{
        int soldier;
        int idx;
        public Row(int s,int i){
            this.soldier=s;
            this.idx=i;
        } 

        @Override
        public int compareTo(Row r){
            if(this.soldier == r.soldier){
                return this.idx - r.idx;
            }else{
                return this.soldier - r.soldier;
            }
        }
    }
    
    public static void main(String[] args) {
        int soldier[][] = {{1,0,0,0},
                           {1,1,1,1},
                           {1,0,0,0},
                           {1,0,0,0}};
         
                           int k =2;
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i=0;i<soldier.length;i++){
            int count = 0;
            for(int j=0;j<soldier[0].length;j++){
                count += soldier[i][j] == 1 ? 1:0;
            }
            pq.add(new Row(count, i));
        }

        for(int i=0;i<k;i++){
            System.out.println("row" + pq.remove().idx);
        }
    }
}
