package leetcode;

public class leet1622$ {
   //TLE
/*      class Fancy {
      List<int[]> list=new ArrayList<>();
      List<Integer> nums = new ArrayList<>();
      Map<Integer,Integer> map = new HashMap<>();
         public Fancy() {

        }

        public void append(int val) {
         map.put(nums.size(),list.size());
         nums.add(val);
        }

        public void addAll(int inc) {
         list.add(new int[]{nums.size()-1,inc});
        }

        public void multAll(int m) {
        list.add(new int[]{nums.size()-1,m+200});
        }
      int mod = (int )1e9+7;
        public int getIndex(int idx) {
             if(idx>=nums.size()) return -1;
          long num=nums.get(idx);
            for (int i = map.get(idx) ; i <list.size(); i++) {
              int []p=list.get(i);

               if(p[1]<200){
                num+=p[1];
                num%=mod;
               }else {
                 num*=(p[1]-200);
                 num%=mod;
               }
            }
            return (int)num;
        }
    }*/

//这个版本的理论是可以的 ，但会超范围
    //这种前缀真的太难想了
    class Fancy {
        private static final int MOD = 1000000007;
        private static final int SIZE = 100001;

        private int[] seq = new int[SIZE];
        private long[] add = new long[SIZE];
        private long[] mult = new long[SIZE];
        private int count = 0;

        public Fancy() {
            add[0] = 0;
            mult[0] = 1;
        }

        public void append(int val) {
            seq[count] = val;
            add[count + 1] = add[count];
            mult[count + 1] = mult[count];
            count++;
        }

        public void addAll(int inc) {
            add[count] += inc;
        }

        public void multAll(int m) {
            mult[count] *= m;
            add[count] *= m;
        }

        public int getIndex(int idx) {
            int id = idx % MOD;
            if (id >= count) { return -1; }
            long m = mult[count] / mult[id];
            long inc = add[count] - add[id] * m;
            return (int)((seq[id] * m + inc) % MOD);
        }
    }
  /*  class Fancy {
        public static final BigInteger MOD = BigInteger.valueOf((int)(1e9 + 7));
        private List<BigInteger> ans = new ArrayList<>();
        private List<BigInteger> mult = new ArrayList<>();
        private List<BigInteger> added = new ArrayList<>();

        public Fancy() {
            mult.add(BigInteger.ONE);
            added.add(BigInteger.ZERO);
        }

        public void append(int val) {
            ans.add(BigInteger.valueOf(val));
            mult.add(mult.get(mult.size() - 1));
            added.add(added.get(added.size() - 1));
        }

        public void addAll(int inc) {
            BigInteger last = added.get(added.size() - 1);
            added.remove(added.size() - 1);
            added.add(last.add(BigInteger.valueOf(inc)).mod(MOD));
        }

        public void multAll(int m) {
            BigInteger lastAdded = added.get(added.size() - 1);
            BigInteger lastMultiplied = mult.get(mult.size() - 1);
            added.remove(added.size() - 1);
            added.add(lastAdded.multiply(BigInteger.valueOf(m)).mod(MOD));
            mult.remove(mult.size() - 1);
            mult.add(lastMultiplied.multiply(BigInteger.valueOf(m)).mod(MOD));
        }

        public int getIndex(int idx) {
            if (idx >= ans.size()) {
                return -1;
            }
            BigInteger quotient = mult.get(mult.size() - 1);
            BigInteger dividend = mult.get(idx);
            BigInteger factor = quotient.multiply(dividend.modInverse(MOD)).mod(MOD);
            BigInteger inc = added.get(added.size() - 1).subtract(added.get(idx).multiply(factor).mod(MOD));
            return ans.get(idx).multiply(factor).mod(MOD).add(inc).mod(MOD).intValue();
        }
    }*/
}
