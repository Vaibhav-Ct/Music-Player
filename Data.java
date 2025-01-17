import java.util.ArrayList;
import java.util.List;

public class Data {

    // Method to initialize and return a list of songs
    public static List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();

        songs.add(new Song("Shape of You", "Ed Sheeran", "2017-01-06", 120));
        songs.add(new Song("Blinding Lights", "The Weeknd", "2019-11-29", 98));
        songs.add(new Song("Someone Like You", "Adele", "2011-01-24", 150));
        songs.add(new Song("Bohemian Rhapsody", "Queen", "1975-10-31", 200));
        songs.add(new Song("Smells Like Teen Spirit", "Nirvana", "1991-09-10", 180));
        songs.add(new Song("Thinking Out Loud", "Ed Sheeran", "2014-09-24", 110));
        songs.add(new Song("Rolling in the Deep", "Adele", "2010-11-29", 145));
        songs.add(new Song("Lose Yourself", "Eminem", "2002-10-28", 210));
        songs.add(new Song("Stairway to Heaven", "Led Zeppelin", "1971-11-08", 170));
        songs.add(new Song("Hello", "Adele", "2015-10-23", 135));
        songs.add(new Song("Uptown Funk", "Mark Ronson", "2014-11-10", 95));
        songs.add(new Song("Billie Jean", "Michael Jackson", "1983-01-02", 190));
        songs.add(new Song("Hotel California", "Eagles", "1976-02-22", 175));
        songs.add(new Song("Perfect", "Ed Sheeran", "2017-09-26", 125));
        songs.add(new Song("Hallelujah", "Leonard Cohen", "1984-12-01", 85));
        songs.add(new Song("Let It Be", "The Beatles", "1970-03-06", 165));
        songs.add(new Song("Bad Guy", "Billie Eilish", "2019-03-29", 105));
        songs.add(new Song("Imagine", "John Lennon", "1971-10-11", 150));
        songs.add(new Song("Old Town Road", "Lil Nas X", "2019-12-03", 70));
        songs.add(new Song("Dynamite", "BTS", "2020-08-21", 130));

        songs.add(new Song("Yesterday", "The Beatles", "1965-08-26", 185));
        songs.add(new Song("Born to Run", "Bruce Springsteen", "1975-08-25", 160));
        songs.add(new Song("Shallow", "Lady Gaga", "2018-10-05", 115));
        songs.add(new Song("Hurt", "Johnny Cash", "2002-03-05", 140));
        songs.add(new Song("All of Me", "John Legend", "2013-08-12", 125));
        songs.add(new Song("Despacito", "Luis Fonsi", "2017-01-13", 220));
        songs.add(new Song("Radioactive", "Imagine Dragons", "2012-10-29", 190));
        songs.add(new Song("Poker Face", "Lady Gaga", "2008-09-26", 135));
        songs.add(new Song("Take Me to Church", "Hozier", "2013-09-13", 155));
        songs.add(new Song("Counting Stars", "OneRepublic", "2013-06-14", 145));
        songs.add(new Song("Happy", "Pharrell Williams", "2013-11-21", 120));
        songs.add(new Song("Seven Nation Army", "The White Stripes", "2003-02-17", 175));
        songs.add(new Song("Hey Jude", "The Beatles", "1968-08-26", 200));
        songs.add(new Song("Boulevard of Broken Dreams", "Green Day", "2004-11-29", 150));
        songs.add(new Song("Viva La Vida", "Coldplay", "2008-05-25", 160));
        songs.add(new Song("Shake It Off", "Taylor Swift", "2014-08-18", 140));
        songs.add(new Song("Wonderwall", "Oasis", "1995-10-02", 170));
        songs.add(new Song("Chandelier", "Sia", "2014-03-17", 130));
        songs.add(new Song("Royals", "Lorde", "2013-08-20", 110));
        songs.add(new Song("Havana", "Camila Cabello", "2017-08-03", 105));

        songs.add(new Song("Closer", "The Chainsmokers", "2016-07-29", 210));
        songs.add(new Song("Believer", "Imagine Dragons", "2017-02-01", 190));
        songs.add(new Song("See You Again", "Wiz Khalifa", "2015-03-10", 225));
        songs.add(new Song("Levitating", "Dua Lipa", "2020-03-27", 160));
        songs.add(new Song("Sunflower", "Post Malone", "2018-10-18", 170));
        songs.add(new Song("Circles", "Post Malone", "2019-08-30", 180));
        songs.add(new Song("Memories", "Maroon 5", "2019-09-20", 150));
        songs.add(new Song("Cheap Thrills", "Sia", "2016-02-11", 140));
        songs.add(new Song("Wrecking Ball", "Miley Cyrus", "2013-08-25", 130));
        songs.add(new Song("Bad Habits", "Ed Sheeran", "2021-06-25", 175));
        songs.add(new Song("Roar", "Katy Perry", "2013-08-10", 145));
        songs.add(new Song("Love Yourself", "Justin Bieber", "2015-11-09", 200));
        songs.add(new Song("Can't Stop the Feeling!", "Justin Timberlake", "2016-05-06", 160));
        songs.add(new Song("We Found Love", "Rihanna", "2011-09-22", 195));
        songs.add(new Song("Call Me Maybe", "Carly Rae Jepsen", "2011-09-20", 185));
        songs.add(new Song("Grenade", "Bruno Mars", "2010-09-28", 175));
        songs.add(new Song("Sugar", "Maroon 5", "2014-11-10", 165));
        songs.add(new Song("What Makes You Beautiful", "One Direction", "2011-09-11", 190));
        songs.add(new Song("Counting Stars", "OneRepublic", "2013-06-14", 145));
        songs.add(new Song("Party Rock Anthem", "LMFAO", "2011-01-25", 180));

        return songs;
    }

    // Method to add all songs to a given playlist
    public static void addSongsToPlaylist(Playlist playlist) {
        List<Song> songs = getSongs();
        for (Song song : songs) {
            playlist.addSong(song.getSongName(),song.getArtistName(),song.getDate(),song.getCount());
        }
    }
}
