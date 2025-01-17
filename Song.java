public class Song {
    private String songName;
    private String artistName;
    private String date;
    private int count;
    Song(String songName, String artistName, String date, int count){
        this.songName = songName;
        this.artistName = artistName;
        this.date = date;
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public String getSongName(){
        return songName;
    }

    public String getArtistName(){
        return artistName;
    }

    public String getDate(){
        return date;
    }

    public void setCount(int count){
        this.count = count;
    }
}
