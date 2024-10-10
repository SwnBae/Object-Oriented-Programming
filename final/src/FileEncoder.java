import java.io.*;

public class FileEncoder {
    private CircularArray array;

    public FileEncoder(CircularArray array) {
        this.array = array;
    }

    // 4.1
    public String encodeString(String s) {
        array.reset();
        if (s.length() <= 0) {
            return null;
        }
        else {
            // 나머지 코드 작성
            String news = "";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=' '&&s.charAt(i)!='\t'&&s.charAt(i)!='\n'){
                    news+=(char)(s.charAt(i)+array.next());
                }
                else {
                    news+=(char)s.charAt(i);
                }
            }
            return news;
        }
    }

    // 4.2
    public boolean encodeFile(String filename, String encfilename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            // 중간 코드 작성
            String s = "";
            while (line != null){
                s+=line;
                line = br.readLine();
            }
            System.out.println(encodeString(s));
            br.close();
            return true;
        }
        // 파일 없음 예외 처리 코드 작성
        catch (FileNotFoundException e){
            System.out.printf("%s 파일이 없습니다.\n",filename);
        }
        catch (Exception e) {
            System.out.printf("%s 파일을 암호화할 때 오류 발생\n", filename);
        }
        return false;
    }

    // 4.3
    public String decodeString(String s) {
        array.reset();
        if (s.length() <= 0) {
            return null;
        }
        else {
            // 나머지 코드 작성
            String news = "";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=' '&&s.charAt(i)!='\t'&&s.charAt(i)!='\n'){
                    news+=(char)(s.charAt(i)-array.next());
                }
                else {
                    news+=(char)s.charAt(i);
                }
            }
            return news;
        }
    }

    // 4.4
    public boolean decodeFile(String filename, String decfilename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            // 중간 코드 작성
            String s = "";
            while (line != null){
                s+=line;
                line = br.readLine();
            }
            System.out.println(decodeString(s));
            br.close();
            return true;
        }
        // 파일 없음 예외 처리 코드 작성
        catch (FileNotFoundException e){
            System.out.printf("%s 파일이 없습니다.\n",filename);
        }
        catch (Exception e) {
            System.out.printf("%s 파일을 복호화할 때 오류 발생\n", filename);
        }
        return false;
    }
}
