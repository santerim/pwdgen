package pwdgen;

/* Generates a string or given length consisting of
printable ASCII table characters (32 to 126)
 */
public class PasswordGenerator {

    String pwd;
    int character;

    public PasswordGenerator() {
        this.pwd = "";
        this.character = 0;
    }

    public String Generate(int pwdLength) {
        if (pwd.length() > 0) {
            pwd = "";
        }

        for (int i = 0; i < pwdLength; i++) {
            character = (int) Math.floor(Math.random() * 93) + 32;
            pwd += (char) character;
        }
        return pwd;
    }
}
