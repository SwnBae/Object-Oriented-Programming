public class MusicCD extends Item {
    private String singer;
    private String[] tracks;

    public MusicCD(String name, int price, boolean inStock, String singer, String trackList) {
        super(name, price, "MusicCD", inStock);
        this.singer = singer;
        getTrack(trackList);
    }

    public void getTrack(String s) {
        int count = 0;
        int countNum = 0;
        String track = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\"') {
                count++;
            }
            if (count == 2) {
                countNum++;
                count = 0;
            }
        }
        tracks = new String[countNum];
        int countTrack = 0;
        int first = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\"') {
                count++;
                if(first == 0){
                    first = 1;
                }
            }
            if (count == 2) {
                tracks[countTrack] = track;
                count = 0;
                countTrack++;
                first = 0;
            } else if (first == 1) {
                first = 2;
            } else {
                track += s.charAt(i);
            }
        }
    }

    public String getDescription() {
        String tL = "";
        for (int i = 0; i < tracks.length; i++) {
            tL += tracks[i] + "\n";
        }
        return "Singer: " + singer + "\nTrack List: \n" + tL + "\n";
    }
}
