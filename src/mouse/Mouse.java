package mouse;

import java.util.Random;

public class Mouse {

    static int totaldrown=0;
    static int totalescape=0;
    static int totalstarve=0;

    public static void printArray (int[][] A){
        int x = A.length;
        int y = A[0].length;

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(A[i][j]<10 && A[i][j]!=-1){
                    System.out.print(" ");
                }
                if(A[i][j]==0) {
                    System.out.print("     ");
                }
                else {
                    System.out.print("    " + A[i][j]);
                }
            }
            System.out.println(); System.out.println();
        }
        System.out.println(); System.out.println();
    }
    public static void createBorder (int[][] A){
        int x = A.length;
        int y = A[0].length;

        for(int i=0;i<x;i++){
            A[0][i]=-1;
            A[i][0]=-1;
            A[x-1][i]=-1;
            A[i][y-1]=-1;
        }
        for(int i=0;i<y;i++){

        }
    }

    public static void createBridges(int[][] A){
        int x = A.length;
        int y = A[0].length;
        Random ran = new Random();
        int pickxran=0; int pickxran2=0; int pickyran=0; int pickyran2=0;
        int picks=0;

        while(picks==0 || picks==1){

            int pick = ran.nextInt(4);

            if(pick==0 && pickxran==0){
                int xran = ran.nextInt(x-2);
                xran = xran + 1;
                A[xran][0]=99;
                pickxran=1;
                picks++;}

            if(pick==1 && pickyran==0){
                int yran = ran.nextInt(y-2);
                yran=yran+1;
                A[0][yran]=99;
                pickyran=1;
                picks++;}

            if(pick==2 && pickxran2==0){
                int xran2 = ran.nextInt(x-2);
                xran2=xran2+1;
                A[xran2][y-1]=99;
                pickxran2=1;
                picks++;}

            if(pick==3 && pickyran2==0){
                int yran2 = ran.nextInt(y-2);
                yran2=yran2+1;
                A[x-1][yran2]=99;
                pickyran2=1;
                picks++;}
        }
    }

    public static int placeMousey(int[][] A){
        int x = A.length;
        int y = A[0].length;
        Random ran = new Random();
        int xmousey = ran.nextInt(x-2); xmousey=xmousey+1;
        int ymousey = ran.nextInt(y-2); ymousey=ymousey+1;
        A[xmousey][ymousey]=1;
        printArray(A);
        int condition = moveMousey(A, xmousey, ymousey);
        return condition;
    }

    public static int moveMousey(int[][] A, int startx, int starty){
        int xmousey = startx;
        int ymousey = starty;
        Random ran = new Random();
        int condition=0;

        for(int i=0;i<19;i++){

            int direction = ran.nextInt(4);

            if(direction==0){
                xmousey=xmousey+1;
                if(A[xmousey][ymousey]==99){
                    condition=6;
                    A[xmousey][ymousey]=i+2;
                    System.out.println("Position of mouse: (" + xmousey + ", " + ymousey + ")");
                    break;
                }
                if(A[xmousey][ymousey]==-1){
                    condition=3;
                    A[xmousey][ymousey]=i+2;
                    System.out.println("Position of mouse: (" + xmousey + ", " + ymousey + ")");
                    break;
                }
                A[xmousey][ymousey]=i+2;
            }

            if(direction==1){
                xmousey=xmousey-1;
                if(A[xmousey][ymousey]==99){
                    condition=6;
                    A[xmousey][ymousey]=i+2;
                    System.out.println("Position of mouse: (" + xmousey + ", " + ymousey + ")");
                    break;
                }
                if(A[xmousey][ymousey]==-1){
                    condition=3;
                    A[xmousey][ymousey]=i+2;
                    System.out.println("Position of mouse: (" + xmousey + ", " + ymousey + ")");
                    break;
                }
                A[xmousey][ymousey]=i+2;
            }

            if(direction==2){
                ymousey=ymousey+1;
                if(A[xmousey][ymousey]==99){
                    condition=6;
                    A[xmousey][ymousey]=i+2;
                    System.out.println("Position of mouse: (" + xmousey + ", " + ymousey + ")");
                    break;
                }
                if(A[xmousey][ymousey]==-1){
                    condition=3;
                    A[xmousey][ymousey]=i+2;
                    System.out.println("Position of mouse: (" + xmousey + ", " + ymousey + ")");
                    break;
                }
                A[xmousey][ymousey]=i+2;
            }

            if(direction==3){
                ymousey=ymousey-1;
                if(A[xmousey][ymousey]==99){
                    condition=6;
                    A[xmousey][ymousey]=i+2;
                    System.out.println("Position of mouse: (" + xmousey + ", " + ymousey + ")");
                    break;
                }
                if(A[xmousey][ymousey]==-1){
                    condition=3;
                    A[xmousey][ymousey]=i+2;
                    System.out.println("Position of mouse: (" + xmousey + ", " + ymousey + ")");
                    break;
                }
                A[xmousey][ymousey]=i+2;
            }
        }
        return condition;
    }


    public static void main(String[] args) {

        int[][] island1 = new int[10][10];
        createBorder(island1);
        createBridges(island1);
        int condition1 = placeMousey(island1); boolean condition1met=false;
        if(condition1==3){totaldrown++; condition1met=true; System.out.println("The mouse has drowned!"); }
        if(condition1==6){totalescape++; condition1met=true; System.out.println("The mouse has escaped!"); }
        if(!condition1met){totalstarve++; System.out.println("The mouse has starved!"); }
        printArray(island1);

        int[][] island2 = new int[5][5];
        createBorder(island2);
        createBridges(island2);
        int condition2 = placeMousey(island2); boolean condition2met=false;
        if(condition2==3){totaldrown++; condition2met=true; System.out.println("The mouse has drowned!"); }
        if(condition2==6){totalescape++; condition2met=true; System.out.println("The mouse has escaped!"); }
        if(!condition2met){totalstarve++; System.out.println("The mouse has starved!"); }
        printArray(island2);

        int[][] island3 = new int[8][8];
        createBorder(island3);
        createBridges(island3);
        int condition3 = placeMousey(island3); boolean condition3met=false;
        if(condition3==3){totaldrown++; condition3met=true; System.out.println("The mouse has drowned!"); }
        if(condition3==6){totalescape++; condition3met=true; System.out.println("The mouse has escaped!"); }
        if(!condition3met){totalstarve++; System.out.println("The mouse has starved!"); }
        printArray(island3);

        int[][] island4 = new int[6][6];
        createBorder(island4);
        createBridges(island4);
        int condition4 = placeMousey(island4); boolean condition4met=false;
        if(condition4==3){totaldrown++; condition4met=true; System.out.println("The mouse has drowned!"); }
        if(condition4==6){totalescape++; condition4met=true; System.out.println("The mouse has escaped!"); }
        if(!condition4met){totalstarve++; System.out.println("The mouse has starved!"); }
        printArray(island4);

        int[][] island5 = new int[4][4];
        createBorder(island5);
        createBridges(island5);
        int condition5 = placeMousey(island5); boolean condition5met=false;
        if(condition5==3){totaldrown++; condition5met=true; System.out.println("The mouse has drowned!"); }
        if(condition5==6){totalescape++; condition5met=true; System.out.println("The mouse has escaped!"); }
        if(!condition5met){totalstarve++; System.out.println("The mouse has starved!"); }
        printArray(island5);

        System.out.println("The mouse drowned " + totaldrown + " time(s).");
        System.out.println("The mouse starved " + totalstarve + " time(s).");
        System.out.println("The mouse escaped " + totalescape + " time(s)");
    }
}
