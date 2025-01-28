import java.util.*;
class Solution {
    public static class Movie {
        int idx;
        int play;

        public Movie(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> mapToGenres = new ArrayList<>();
        for (String item : map.keySet()) {
            mapToGenres.add(item);
        }
        mapToGenres.sort((o1, o2) -> map.get(o2) - map.get(o1));

        for (String item : mapToGenres) {
            ArrayList<Movie> movies = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (item.equals(genres[i])) {
                    movies.add(new Movie(i, plays[i]));
                }
            }
            movies.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    if (o1.play == o2.play) {
                        return o1.idx - o2.idx;
                    }
                    return o2.play - o1.play;
                }
            });

            answer.add(movies.get(0).idx);
            if (movies.size() != 1) {
                answer.add(movies.get(1).idx);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}