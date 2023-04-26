public class ReplaceTestA {

    public static void main(String[] args) {
        String s = "a\r\n" +
                "\r\n" + "b";


        System.out.println(s);
        String regex = "\r\n(?=b)";
        String replacement = "/\r\n";
        System.out.println(s.replaceAll(regex, replacement));
    }

}
