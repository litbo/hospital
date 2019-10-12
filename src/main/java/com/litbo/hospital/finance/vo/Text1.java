package com.litbo.hospital.finance.vo;


public class Text1 {
    public double l = -1;
    public double r = 10000;
    public int n;
    public double a[] = new double[1000];
    public double playCoin(double r){
        double sum=0;
        for(int i=0;i<=n;i++)
        {
            sum+=a[i]/Math.pow(1+r,i-1);
        }
        return sum;
    }


    /*public static void main(String[] args) {
        Text1 game = new Text1();
        Scanner sc=new Scanner(System.in);
        game.n=sc.nextInt();
        double ans,mid;
//  doubl game.a[] = new double [1000];
        for(int i=1;i<=game.n;i++)
        {
            double  y=sc.nextDouble();
            game.a[i]=y;
        }
        for(int i=1;i<=1000;++i)
        {
            mid=(game.l+game.r)/2.0;
            if(game.playCoin(mid)<0)
                game.r=mid;
            else
                game.l=mid;
        }
        System.out.println((game.l+game.r)/2.0);
    }*/


    public static Double getIrr(int n , double[] a) {
        Text1 game = new Text1();
        game.n=n;
        double ans,mid;
//  doubl game.a[] = new double [1000];
        game.a = a;
        for(int i=1;i<=1000;++i)
        {
            mid=(game.l+game.r)/2.0;
            if(game.playCoin(mid)<0)
                game.r=mid;
            else
                game.l=mid;
        }
        return (game.l+game.r)/2.0;
    }

    public static void main(String[] args) {
        double[] a = new double[1000];
        a[0] = -25000;
        a[1] = 13000;
        a[2] = 13000;
        a[3] = 11000;
        a[4] = 13000;
        a[5] = 13000;

                //[-25000,13000,13000,11000,13000,13000];
        System.out.println(getIrr(6, a));
    }
}