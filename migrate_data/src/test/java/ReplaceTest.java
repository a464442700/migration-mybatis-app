public class ReplaceTest {
    public static void main(String[] args) {
        String s="end cux_table_pub ;\r\n" +
                "\r\n" +
                "CREATE OR REPLACE EDITIONABLE PACKAGE BODY \"APPS\".\"CUX_TABLE_PUB\" is";

        System.out.println(s);
        String regex = "\r\n(?=CREATE OR REPLACE EDITIONABLE PACKAGE BODY)";
        String replacement = "/\r\n";
        System.out.println(s.replaceAll(regex, replacement));
    }
}