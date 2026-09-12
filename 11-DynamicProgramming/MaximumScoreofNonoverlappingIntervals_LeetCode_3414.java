class Solution {
    static class Interval {
        int l,r,w,idx;
        Interval(int l,int r,int w,int idx) {
            this.l=l;
            this.r=r;
            this.w=w;
            this.idx=idx;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n=intervals.size();
        Interval[] a=new Interval[n];

        for(int i=0;i<n;i++) {
            List<Integer> x=intervals.get(i);
            a[i]=new Interval(x.get(0),x.get(1),x.get(2),i);
        }

        Arrays.sort(a,(x,y)->{
            if(x.r!=y.r) return Integer.compare(x.r,y.r);
            return Integer.compare(x.idx,y.idx);
        });

        int[] end=new int[n];
        for(int i=0;i<n;i++) end[i]=a[i].r;

        int[] prev=new int[n];
        for(int i=0;i<n;i++) prev[i]=lowerBound(end,a[i].l);

        long[][] prefScore=new long[5][n+1];
        int[][][] prefAns=new int[5][n+1][];

        for(int k=0;k<=4;k++) Arrays.fill(prefScore[k],Long.MIN_VALUE);
        Arrays.fill(prefScore[0],0L);

        for(int i=1;i<=n;i++) {
            Interval cur=a[i-1];

            for(int k=0;k<=4;k++) {
                prefScore[k][i]=prefScore[k][i-1];
                if(prefAns[k][i-1]!=null)
                    prefAns[k][i]=prefAns[k][i-1].clone();
            }

            for(int k=1;k<=4;k++) {
                int p=prev[i-1];
                if(prefScore[k-1][p]==Long.MIN_VALUE) continue;

                long score=prefScore[k-1][p]+cur.w;
                int[] candidate=appendAndSort(prefAns[k-1][p],cur.idx);

                if(score>prefScore[k][i]) {
                    prefScore[k][i]=score;
                    prefAns[k][i]=candidate;
                } else if(score==prefScore[k][i] &&
                          lexicographicallySmaller(candidate,prefAns[k][i])) {
                    prefAns[k][i]=candidate;
                }
            }
        }

        long bestScore=Long.MIN_VALUE;
        int[] answer=new int[0];

        for(int k=0;k<=4;k++) {
            long score=prefScore[k][n];
            int[] candidate=prefAns[k][n];
            if(candidate==null) candidate=new int[0];

            if(score>bestScore) {
                bestScore=score;
                answer=candidate;
            } else if(score==bestScore &&
                      lexicographicallySmaller(candidate,answer)) {
                answer=candidate;
            }
        }

        return answer;
    }

    private int lowerBound(int[] end,int target) {
        int lo=0,hi=end.length;

        while(lo<hi) {
            int mid=lo+(hi-lo)/2;
            if(end[mid]<target) lo=mid+1;
            else hi=mid;
        }

        return lo;
    }

    private int[] appendAndSort(int[] arr,int idx) {
        int len=arr==null?0:arr.length;
        int[] result=new int[len+1];

        if(arr!=null) System.arraycopy(arr,0,result,0,len);
        result[len]=idx;
        Arrays.sort(result);

        return result;
    }

    private boolean lexicographicallySmaller(int[] a,int[] b) {
        if(b==null) return true;

        int len=Math.min(a.length,b.length);

        for(int i=0;i<len;i++) {
            if(a[i]!=b[i]) return a[i]<b[i];
        }

        return a.length<b.length;
    }
}