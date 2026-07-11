class DSU{
    int[] rank,par;

    public DSU(int n){
        rank=new int[n+1];
        par=new int[n+1];
        for(int i=0;i<=n;i++){
            par[i]=i;
        }
    }

    public int findUPar(int x){
        if(x==par[x]) return x;
        return par[x]=findUPar(par[x]);
    }

    public boolean unionByRank(int u,int v){
        int ulp_u=findUPar(u),ulp_v=findUPar(v);

        if(ulp_u==ulp_v) return false;

        if(rank[ulp_u]>rank[ulp_v]){
            rank[ulp_u]++;
            par[ulp_v]=ulp_u;
        }
        else{
            rank[ulp_v]++;
            par[ulp_u]=ulp_v;
        }

        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU dsu=new DSU(n);
        int[] ans=new int[2];

        for(int i=0;i<n;i++){
            boolean res=dsu.unionByRank(edges[i][0],edges[i][1]);
            if(!res) ans=edges[i];
        }

        return ans;
    }
}