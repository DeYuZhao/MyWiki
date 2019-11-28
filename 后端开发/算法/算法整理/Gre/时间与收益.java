package Gre;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zhaodeyu
 * @classname Gre.时间与收益
 * @description TODO
 * @date 2019-11-28 11:00
 */
public class 时间与收益 {
    static class Job {

        int id, dead, pro;

        Job(int id, int dead, int pro) {

            this.id=id;
            this.dead=dead;
            this.pro=pro;
        }
    }

    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        while(t-->0) {

            int n=sc.nextInt();

            Job[] job=new Job[n];

            for(int i=0; i<n; i++) {

                int x=sc.nextInt();
                int y=sc.nextInt();
                int z=sc.nextInt();

                job[i]=new Job(x, y, z);
            }

            Arrays.sort(job, new Comparator<Job>(){

                public int compare(Job j1, Job j2) {

                    return (j2.pro-j1.pro);
                }
            });

            boolean[] slot=new boolean[n];
            int[] res=new int[n];
            Arrays.fill(slot, false);

            int ct=0, prof=0;
            for(int i=0; i<n; i++) {

                for(int j=Math.min(job[i].dead, n)-1; j>=0; j--) {

                    if(!slot[j]) {

                        slot[j]=true;
                        res[j]=i;
                        break;
                    }
                }
            }

            for(int i=0; i<n; i++) {

                if(slot[i]) {

                    ct++;
                    prof += job[res[i]].pro;
                }
            }

            System.out.println(ct +" "+ prof);
        }
    }
}
