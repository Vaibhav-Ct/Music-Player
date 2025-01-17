import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Playlist {
    private ArrayList<Song> songs = new ArrayList<>();

    public void addSong(String songName, String artistName, String date,int count){
        Song newSong = new Song(songName, artistName, date, count);
        songs.add(newSong);
    }

    public String playSongBySongName(String songName){
        for(int i=0;i<songs.size();i++){
            Song curr = songs.get(i);

            if(songName.equalsIgnoreCase(curr.getSongName())) {
                curr.setCount(curr.getCount()+1);
                return curr.getSongName(); // return any one song, of all available songs of same name
            }
        }
        return null;
    }

    public String playSongByArtistName(String artistName){
        for(int i=0;i<songs.size();i++){
            Song curr = songs.get(i);

            if(artistName.equalsIgnoreCase(curr.getArtistName())) {
                curr.setCount(curr.getCount() + 1);
                return curr.getSongName(); // return any one song of that artist
            }
        }
        return null;
    }

    public String playSong(String songName, String artistName){
        for(int i=0;i<songs.size();i++){
            Song curr = songs.get(i);
            if(songName.equalsIgnoreCase(curr.getSongName()) && artistName.equalsIgnoreCase(curr.getArtistName())) {
                curr.setCount(curr.getCount()+1);
                return songName; // return exact song of that artist and song name
            }
        }
        return null;
    }

    public ArrayList<String> retrieveSongsOfArtist(String artistName){
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<songs.size();i++){
            Song curr = songs.get(i);
            if(artistName.equalsIgnoreCase(curr.getArtistName())) arr.add(curr.getSongName());
        }
        return arr;
    }

    public ArrayList<String> topNSongs(int count){
        TreeMap<Integer, String> dict = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<songs.size();i++){
            Song curr = songs.get(i);
            dict.put(curr.getCount(),curr.getSongName());
        }
        ArrayList<String> arr = new ArrayList<String>();
        int i = 0;
        for(String k: dict.values()){
            if(i>=count) break;
            arr.add(k);
            i++;
        }
        return arr;
    }

    public ArrayList<String> topNSongsOfArtist(int count, String artist) {
        TreeMap<Integer, String> dict = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<songs.size();i++){
            Song curr = songs.get(i);
            if(artist.equalsIgnoreCase(curr.getArtistName())) dict.put(curr.getCount(),curr.getSongName());
        }
        ArrayList<String> arr = new ArrayList<String>();
        int i = 0;
        for(String k: dict.values()){
            if(i>=count) break;
            arr.add(k);
            i++;
        }
        return arr;
    }

    public ArrayList<String> topNSongsOfGivenDate(int count, String date){
        TreeMap<Integer, String> dict = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<songs.size();i++){
            Song curr = songs.get(i);
            if (date.equals(curr.getDate())) {
                dict.put(curr.getCount(),curr.getSongName());
            }
        }
        ArrayList<String> arr = new ArrayList<>();
        int i = 0;
        for(String k: dict.values()) {
            if (i >= count) break;
            arr.add(k);
            i++;
        }
        return arr;
    }

    public ArrayList<String> songsPlayedLessThanDays(int days){
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<songs.size();i++) {
            Song curr = songs.get(i);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.now();
            LocalDate date2 = LocalDate.parse(curr.getDate(), formatter);
            long count = ChronoUnit.DAYS.between(date1, date2);
            if (count < days) {
                arr.add(curr.getSongName());
            }
        }
        return arr;
    }

}
