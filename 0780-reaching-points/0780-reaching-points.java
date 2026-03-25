class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx>=sx && ty>=sy){
            if(tx>ty){
                if(tx==sx) return (ty-sy)%sx==0;
                else if(ty==sy)  return (tx-sx)%sy==0;
                tx=tx%ty;
            }
            else{
                if(tx==sx) return (ty-sy)%sx==0;
                else if(ty==sy)  return (tx-sx)%sy==0;
                ty=ty%tx;
            }
        }
        return false;
    }
}