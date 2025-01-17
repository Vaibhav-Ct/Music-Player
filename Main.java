import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args){
        ExceptionHandeling exception = new ExceptionHandeling();
        Playlist playlist = new Playlist();
        Scanner ip = new Scanner(System.in);
        Data.addSongsToPlaylist(playlist);  // Preload songs using Data class


        System.out.println("Welcome to Music Player!");
        System.out.println("================================");
        System.out.println("Please choose an option from the menu below:");

        int option = 0;

        while(true){
            System.out.println("\n\n\n****** MENU *****:");
            System.out.println("-1. Exit Music Player");
            System.out.println(" 1. Add Song (Date will be today's by default)");
            System.out.println(" 2. Add Song with specific Date");
            System.out.println(" 3. Play Song by Song Name");
            System.out.println(" 4. Play Song by Artist Name");
            System.out.println(" 5. Play Song by Song Name and Artist Name");
            System.out.println(" 6. Retrieve all Songs of given Artist");
            System.out.println(" 7. Return top N Songs Till Date");
            System.out.println(" 8. Return top N Songs of a given Artist");
            System.out.println(" 9. Return top N Songs of a given Date");
            System.out.println(" 10. Return all Songs played in less than N days");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            option = ip.nextInt();
            String songName = "";
            String artistName = "";
            String date = "";
            int count = 0;
            String result = "";
            ArrayList<String> list;

            switch (option){
                case -1:
                    // To exit out of Music Player
                    System.out.println("Exited!!! ---> Happy Coding");
                    break;
                case 1:
                    // Add Song without Date by default it will take today's date
                    System.out.println("Enter Song Name: ");
                    ip.nextLine();
                    songName = ip.nextLine();
                    System.out.println("Enter Artist Name: ");
                    artistName = ip.nextLine();
                    LocalDate dt = LocalDate.now();
                    date = dt.toString();
                    playlist.addSong(songName, artistName, date, 0);
                    System.out.printf("\nSong Details= {Song Name: %s, Artist Name: %s, Date: %s}",songName,artistName,date);
                    System.out.println("\nBravo Song Added Successfully!!!");
                    break;
                case 2:
                    // Add Song with Date
                    System.out.println("Enter Song Name: ");
                    ip.nextLine();
                    songName = ip.nextLine();
                    System.out.println("Enter Artist Name: ");
                    artistName = ip.nextLine();
                    // Enter Valid Date
                    date = exception.getValidDate(ip);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date1 = LocalDate.now();
                    LocalDate date2 = LocalDate.parse(date, formatter);
                    while(date1.isBefore(date2)){
                        System.out.println("Today's date is: " + date1);
                        System.out.println("You Entered Future date, Please try again!!!");
                        date = exception.getValidDate(ip);
                        date2 = LocalDate.parse(date, formatter);
                    }
                    playlist.addSong(songName, artistName, date, 0);
                    System.out.printf("\nSong Details= {Song Name: %s, Artist Name: %s, Date: %s}",songName,artistName,date);
                    System.out.println("\nBravo Song Added Successfully!!!");
                    break;
                case 3:
                    // Play Song by Song Name
                    System.out.println("Enter Song Name: ");
                    ip.nextLine();
                    songName = ip.nextLine();
                    result = playlist.playSongBySongName(songName);
                    if(result==null){
                        System.out.println("\nWe couldn't find the song \"" + songName + "\".");
                    }
                    else System.out.println("\nPlaying: ^-^ " + result + " ^_^");
                    break;
                case 4:
                    // Play Song by Artist Name
                    System.out.println("Enter Artist Name: ");
                    ip.nextLine();
                    artistName = ip.nextLine();
                    result = playlist.playSongByArtistName(artistName);
                    if(result==null){
                        System.out.println("\nWe couldn't find the Artist of Name \"" + artistName+ "\".");
                    }
                    else System.out.println("\nPlaying: ^-^ " + result + " ^_^");
                    break;
                case 5:
                    // Play Song by Song Name and Artist Name
                    System.out.println("Enter Song Name: ");
                    ip.nextLine();
                    songName = ip.nextLine();
                    System.out.println("Enter Artist Name: ");
                    artistName = ip.nextLine();
                    result = playlist.playSong(songName, artistName);
                    if(result==null){
                        System.out.println("\nWe couldn't find either searched Artist of Name \"" + artistName+ "\" or searched song \"" + songName + "\".");
                    }
                    else System.out.println("\nPlaying: ^-^ " + result + " ^_^");
                    break;
                case 6:
                    // Retrieve all Songs of given Artist Name
                    System.out.println("Enter Artist Name: ");
                    ip.nextLine();
                    artistName = ip.nextLine();
                    list = playlist.retrieveSongsOfArtist(artistName);
                    if(list.isEmpty()){
                        System.out.println("\nWe couldn't find the Artist of Name \"" + artistName+ "\".");
                        break;
                    }
                    System.out.println("\nSong List: ");
                    for(String song: list){
                        System.out.println((song));
                    }
                    break;
                case 7:
                    // Return top N Songs Till Date
                    System.out.println("Enter N Value: ");
                    count = ip.nextInt();
                    list = playlist.topNSongs(count);
                    System.out.println("\nSong List: ");
                    for(String song: list){
                        System.out.println((song));
                    }
                    break;
                case 8:
                    // Return top N songs of given Artist
                    System.out.println("Enter N Value: ");
                    count = ip.nextInt();
                    System.out.println("Enter Artist Name: ");
                    ip.nextLine();
                    artistName = ip.nextLine();
                    list = playlist.topNSongsOfArtist(count, artistName);
                    if(list.isEmpty()){
                        System.out.println("\nWe couldn't find the Artist of Name \"" + artistName+ "\".");
                        break;
                    }
                    System.out.println("\nSong List: ");
                    for(String song: list){
                        System.out.println((song));
                    }
                    break;
                case 9:
                    // Return top N songs of given Date
                    System.out.println("Enter N Value: ");
                    count = ip.nextInt();
                    // Enter Valid Date
                    ip.nextLine();
                    date = exception.getValidDate(ip);
                    list = playlist.topNSongsOfGivenDate(count, date);
                    if(list.isEmpty()) {
                        System.out.println("\nSorry, No Songs Found On Given Date");
                        break;
                    }
                    System.out.println("\nSong List: ");
                    for(String song: list){
                        System.out.println((song));
                    }
                    break;
                case 10:
                    // Return all Songs played by less than N days;
                    System.out.println("Enter Days: ");
                    count = ip.nextInt();
                    list = playlist.songsPlayedLessThanDays(count);
                    System.out.println("\nSong List: ");
                    for(String song: list){
                        System.out.println((song));
                    }
                    break;
                default:
                    System.out.println(("Please Hit Valid Key"));
                    break;
            }
            if(option==-1) break;
        }
    }
}

