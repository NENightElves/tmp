

class Solution {

    int[][] a;
    int[] m;
    int[] n;
    int[] p;
    int np,nm,nn;

    public boolean isLearnt(int x)
    {
        int i;
        for(i=0;i<nm;i++)
        {
            if (m[i]==x) return true;
        }
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int i,j;

        a=new int[numCourses][numCourses];
        m=new int[numCourses];
        n=new int[numCourses];
        p=new int[numCourses];
        np=0;
        nm=0;
        nn=0;

        for(i=0;i<numCourses;i++)
            for(j=0;j<numCourses;j++)
                a[i][j]=0;
        for(i=0;i<prerequisites.length;i++)
            a[prerequisites[i][0]][prerequisites[i][1]]=1;
        
        while(true)
        {
            for(i=0;i<numCourses;i++)
            {
                if (!isLearnt(i)) break;
            }
            if (i==numCourses) break;

            n[nn++]=i;
            p[np++]=i;

            while(np>0)
            {
                for(i=0;i<numCourses;i++)
                {
                    if (isLearnt(i)) a[p[np-1]][i]=0;
                    if (a[p[np-1]][i]==1) break;
                }
                if (i==numCourses)
                {
                    m[nm++]=p[np-1];
                    np--;
                    nn--;
                    // a[p[np-1]][n[nn]]=0;
                    continue;
                }
                for(j=0;j<nn;j++)
                {
                    if (n[j]==i) return new int[0];
                }
                n[nn++]=i;
                p[np++]=i;
            }
        }

        return m;
    }
}

public class Main
{
    public static void main(String[] args) {
        new Solution().findOrder(3, new int[][]{{0,1},{0,2},{1,2}});
    }
}