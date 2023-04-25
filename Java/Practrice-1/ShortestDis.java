
//Que-3
//Find displacement 
public class ShortestDis {
    public static void ShortestDisplacment(String str) {
        int n = str.length();
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            char dir = str.charAt(i);
            if (dir == 'N') {
                y++;

            } else if (dir == 'S') {
                y--;
            } else if (dir == 'E') {
                x++;
            } else {
                x--;
            }
        }
        int X = x * x;
        int Y = y * y;
        // displacement= square root of (x1+x2)*2 + (y1+y2)*2
        float dis = (float) Math.sqrt((X + Y));
        System.out.println(dis);

    }

    public static void main(String args[]) {
        String str =  "WNEENESENNNNNN";
        ShortestDisplacment(str);
    }

}
