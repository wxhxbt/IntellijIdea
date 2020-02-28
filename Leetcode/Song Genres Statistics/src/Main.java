import java.util.*;

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        Map<String, List<String>> songGenres = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));
        // songGenres.put("Rock", Arrays.asList(new String[]{"nsong1", "nsong3"}));
        // songGenres.put("Dubstep", Arrays.asList(new String[]{"nsong7"}));
        // songGenres.put("Techno", Arrays.asList(new String[]{"nsong2", "nsong4"}));
        // songGenres.put("Pop", Arrays.asList(new String[]{"nsong5", "nsong6"}));
        // songGenres.put("Jazz", Arrays.asList(new String[]{"nsong8", "nsong9"}));
        Map<String, List<String>> res = new HashMap<>();
        res = favoriteGenres(userSongs, songGenres);
        for(String user : res.keySet()){
            System.out.println(user+": "+res.get(user));
        }

    }
    private static Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres){
        Map<String, List<String>> res = new HashMap<>();
        for(String user : userSongs.keySet()){
            if(songGenres.size() == 0 || songGenres == null){
                res.put(user, new ArrayList<>());
                continue;
            }
            int max = Integer.MIN_VALUE;
            List<String> genres = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            Map<String, Integer> count = new HashMap<>();
            for(String sg : songGenres.keySet()){
                count.put(sg, 0);
                List<String> songs = songGenres.get(sg);
                if(songs.size() > 0)
                    for(String song : songs)
                        map.put(song, sg);
            }
            for(String song : userSongs.get(user)){
                String genre = map.get(song);   //null
                if(genre != null)
                    count.put(genre, count.get(genre) + 1);
            }
            for(String genre : count.keySet()){
                if(count.get(genre) > max && count.get(genre) != 0){
                    max = count.get(genre);
                    genres.clear();
                    genres.add(genre);
                }
                else if(count.get(genre) == max)
                    genres.add(genre);
            }
            res.put(user, genres);
        }
        return res;
    }
}