public class StringBreakupComparison {

    public static String minStr(String str1, String str2) {
        if (str1.compareTo(str2) < str2.compareTo(str1))
            return str1;
        return str2;
    }

    public static void main(String[] args) {
        String str = "Zhrx.aghkio.Gko123";
        String[] list = new String[3];
        String s1, s2, s3;
        int position = str.indexOf('.');
        int lastPosition = 0;
        System.out.println("string: [" + str + "]");
        for (int i = 0; position != -1;i++) {
            String subStr = str.substring(lastPosition, position);
            list[i] = subStr;
            lastPosition = position+1;
            position = str.indexOf('.', lastPosition);
            System.out.println("s" + i + ": [" + list[i] + "]");
            if (position == -1) {
                list[i + 1] = str.substring(lastPosition);
                System.out.println("s" + (i+1) + ": [" + list[i + 1] + "]");
            }
        }
        s1 = list[0];
        s2 = list[1];
        s3 = list[2];
        System.out.println("minStr(s1,s2): [" + minStr(s1,s2) + "]");
        System.out.println("minStr(s1,s2), s3): [" + minStr(minStr(s1,s2), s3) + "]");
    }
}

/*
Output:
string: [Zhrx.aghkio.Gko123]
s0: [Zhrx]
s1: [aghkio]
s2: [Gko123]
minStr(s1,s2): [Zhrx]
minStr(s1,s2), s3): [Gko123]
 */