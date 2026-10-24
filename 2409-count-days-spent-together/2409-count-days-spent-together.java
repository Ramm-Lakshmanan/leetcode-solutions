class Solution {
    int[] req=new int[]{0, 31, 59, 90, 120, 151, 181 , 212, 243, 273, 304, 334};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aa=req[Integer.parseInt(arriveAlice.substring(0,2))-1]+Integer.parseInt(arriveAlice.substring(3,5));

        int la=req[Integer.parseInt(leaveAlice.substring(0,2))-1]+Integer.parseInt(leaveAlice.substring(3,5));

        int ab=req[Integer.parseInt(arriveBob.substring(0,2))-1]+Integer.parseInt(arriveBob.substring(3,5));

        int lb=req[Integer.parseInt(leaveBob.substring(0,2))-1]+Integer.parseInt(leaveBob.substring(3,5));

        System.out.println(aa+" "+la+" "+ab+" "+lb);
        int res=Math.min(la,lb)-Math.max(aa,ab)+1;
        if(res<0) return 0;
        else return res;
    }
}